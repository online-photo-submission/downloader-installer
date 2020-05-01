package us.cloudcard.downloaderinstaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PropertyService {

    private static final Logger log = LoggerFactory.getLogger(PropertyService.class);

    List<Property> properties = new ArrayList<>();

    public void loadEmptyProperties() {

        log.error("I'm loading the properties");
    }

    public void getProperties() {
        Property userProperties = new Property();
        log.error("I'm getting the answers.");
        for (int i = 0; i < 9; i++) {
            properties.add(new Property(userProperties.getKeys().get(i), userProperties.getUserValues().get(i)));
        }

    }

    public void logProperties() {

        for (Property property : properties) {
            log.info(property.toString());
        }
    }

    public void writeFile() throws IOException {
        log.error("I'm writing the file");
        Property userProperties = new Property();
        String fileContent = "";
        for (int i = 0; i < properties.size(); i++) {
            fileContent = fileContent.concat(userProperties.getKeys().get(i) + userProperties.getUserValues().get(i)) + "\n";
        }
        FileWriter writer = new FileWriter("/Users/applemacbookpro/Desktop/application.properties");
        writer.write(fileContent);
        writer.close();
    }

}
