package us.cloudcard.downloaderinstaller;

public class UserConfigurationService {

    void createUserConfigFile() {

        PropertyService propertyService = new PropertyService();

        propertyService.loadEmptyProperties();
        propertyService.getValuesFromUser();
        propertyService.logProperties();
        propertyService.writeFile();
    }
}
