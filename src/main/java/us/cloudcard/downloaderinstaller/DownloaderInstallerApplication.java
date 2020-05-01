package us.cloudcard.downloaderinstaller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DownloaderInstallerApplication {

    public static void main(String[] args) {

        SpringApplication.run(DownloaderInstallerApplication.class, args);
        new UserConfigurationService().createUserConfigFile();
    }

}
