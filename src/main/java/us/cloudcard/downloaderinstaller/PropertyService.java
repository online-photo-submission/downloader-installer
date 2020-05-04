package us.cloudcard.downloaderinstaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PropertyService {

    private static final Logger log = LoggerFactory.getLogger(PropertyService.class);

    List<Property> properties = new ArrayList<>();
    public void loadEmptyProperties() {
        log.error("I'm loading the properties");
        properties.add(new Property("cloudcard.api.url", ""));
        properties.add(new Property("cloudcard.api.accessToken", ""));
        properties.add(new Property("downloader.storageService", ""));
        properties.add(new Property("downloader.repeat", ""));
        properties.add(new Property("downloader.delay.milliseconds", ""));
        properties.add(new Property("downloader.fetchStatuses", ""));
        properties.add(new Property("downloader.putStatus", ""));
        properties.add(new Property("downloader.photoDirectories", ""));
        properties.add(new Property("downloader.minPhotoIdLength", ""));
    }
    public void inputPropertyValuesFromUser() {
        log.error("I'm getting the answers");
        properties.get(0).value = "https://api.onlinephotosubmission.com/api";
        properties.get(1).value = "thisIsAValidAPIkey";
        properties.get(2).value = "FileStorageService";
        properties.get(3).value = "true";
        properties.get(4).value = "600000";
        properties.get(5).value = "READY_FOR_DOWNLOAD";
        properties.get(6).value = "DOWNLOADED";
        properties.get(7).value = "downloaded-photos";
        properties.get(8).value = "0";
    }
    public void logProperties() {

        for (int i = 0; i < properties.size(); i++) {
            Property property = properties.get(i);
            log.info(property.toString());
        }
    }
    public void readEmptyPropertiesFromTextFile () throws FileNotFoundException {
        log.error("I'm reading the text file with empty properties");
        File file = new File("/Users/applemacbookpro/Desktop/properties.txt");
        Scanner scanner = new Scanner(file);
        String line = "";

        do {line = scanner.nextLine();
            properties.add(new Property(line, ""));

        } while (scanner.hasNextLine());

    }
    public void writeFile() throws IOException {
        log.error("I'm writing the file");
        FileWriter writer = new FileWriter("/Users/applemacbookpro/Desktop/application.properties");
        for (int i = 0; i < properties.size(); i++) {
            Property property = properties.get(i);
            writer.write(property + "\n");
        }
        writer.close();
    }
}
