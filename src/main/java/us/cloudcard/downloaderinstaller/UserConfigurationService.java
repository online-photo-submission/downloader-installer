package us.cloudcard.downloaderinstaller;

import java.io.IOException;

public class UserConfigurationService {

    void createUserConfigFile() throws IOException {

        PropertyService propertyService = new PropertyService();

        propertyService.readQuestions();
        propertyService.logProperties();
        propertyService.readValuesFromUser();
        propertyService.logProperties();
        propertyService.writeFile();
    }
}
