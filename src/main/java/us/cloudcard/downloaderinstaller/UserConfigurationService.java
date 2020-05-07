package us.cloudcard.downloaderinstaller;

import java.io.IOException;

public class UserConfigurationService {

    void createUserConfigFile() throws IOException {

        PropertyService propertyService = new PropertyService();

        //propertyService.loadEmptyProperties();
        propertyService.readEmptyPropertiesWithOptionsFromTextFile();
        //propertyService.inputPropertyValuesFromUser();
        //propertyService.inputPropertyValuesFromTextDocumentOptions();
        propertyService.logProperties();
        propertyService.readValuesFromUserSystemTerminal();
        propertyService.writeFile();
    }
}
