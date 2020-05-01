package us.cloudcard.downloaderinstaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class PropertyService {

    private static final Logger log = LoggerFactory.getLogger(PropertyService.class);

    List<Property> properties = new ArrayList<>();

    public void loadEmptyProperties() {

        log.error("I'm loading the properties");
    }

    public void getValuesFromUser() {

        log.error("I'm getting the answers.");
        for (int i = 0; i < 10; i++) {
            properties.add(new Property("key" + i, "value" + i));
        }
    }

    public void logProperties() {

        for (Property property : properties) {
            log.info(property.toString());
        }
    }

    public void writeFile() {

        log.error("I'm writing the file");
    }

}
