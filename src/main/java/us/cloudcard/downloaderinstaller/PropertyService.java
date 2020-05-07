package us.cloudcard.downloaderinstaller;

import com.sun.tools.jdeprscan.scan.Scan;
import org.graalvm.compiler.phases.graph.ScheduledNodeIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Scanner;
import java.util.*;
import java.io.BufferedReader;

public class PropertyService {

    private static final Logger log = LoggerFactory.getLogger(PropertyService.class);

    List<Property> properties = new ArrayList<>();

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

    public void inputPropertyValuesFromTextDocumentOptions() {
        log.error("I'm getting the answers");
        properties.get(0).value = properties.get(0).options.get(0);
        properties.get(1).value = properties.get(1).options.get(1);
        properties.get(2).value = properties.get(2).options.get(2);
        properties.get(3).value = properties.get(3).options.get(0);
        properties.get(4).value = properties.get(4).options.get(1);
        properties.get(5).value = properties.get(5).options.get(2);
        properties.get(6).value = properties.get(6).options.get(0);
        properties.get(7).value = properties.get(7).options.get(1);
        properties.get(8).value = properties.get(8).options.get(2);
    }

    public void readValuesFromUserSystemTerminal() throws IOException {
        System.out.println("\n WELCOME TO CLOUDCARD DOWNLOADER INSTALL ASSISTANT\n\n");
        for (int i = 0; i < properties.size(); i++) {
            properties.get(i).value = properties.get(i).options.get(optionChoice(i));
            System.out.println("User choice is: " + properties.get(i).value + "\n");
        }


    }

    private int optionChoice(int propertyIndex) throws IOException {
        System.out.println(properties.get(propertyIndex).key + "=");
        for (int i = 0; i < properties.get(propertyIndex).getOptions().size(); i++) {
            System.out.println((i + 1) + ")" + properties.get(propertyIndex).options.get(i));
        }
        System.out.println("Enter integer selection: ");
        int selection = 0;
        Scanner scanner = new Scanner(System.in);
        selection = scanner.nextInt();
//        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
//        selection = Integer.parseInt(buffReader.readLine());
        return (selection - 1);
    }

    public void logProperties() {
        for (Property property : properties) {
            log.info(property.toString());
        }
    }

    public void readEmptyPropertiesWithOptionsFromTextFile() throws FileNotFoundException {
        log.error("I'm reading the text file with empty properties");
        File file = new File("/Users/applemacbookpro/Desktop/properties.txt");
        Scanner scanner = new Scanner(file);
        String line = "";
        int i = -1;
        do {
            line = scanner.nextLine();
            if (line.startsWith("-")) {
                properties.get(i).options.add(line.substring(1));
            } else {
                properties.add(new Property(line, "", ""));
                i++;
            }
        } while (scanner.hasNextLine());
    }

    public void writeFile() throws IOException {
        System.out.println("THANKS FOR USING CLOUDCARD DOWNLOADER ASSISTANT\n\n");
        log.error("I'm writing the file");
        FileWriter writer = new FileWriter("/Users/applemacbookpro/Desktop/application.properties");
        for (Property property : properties) {
            writer.write(property + "\n");
        }
        writer.close();
        log.error("File writer successful");
    }
}
