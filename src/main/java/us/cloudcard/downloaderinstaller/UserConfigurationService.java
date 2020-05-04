package us.cloudcard.downloaderinstaller;

import java.io.IOException;

public class UserConfigurationService {

    void createUserConfigFile() throws IOException {

        PropertyService propertyService = new PropertyService();

        //propertyService.loadEmptyProperties();
        propertyService.readEmptyPropertiesFromTextFile();
        propertyService.inputPropertyValuesFromUser();
        propertyService.logProperties();
        propertyService.writeFile();
    }
}
