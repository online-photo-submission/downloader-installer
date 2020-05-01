package us.cloudcard.downloaderinstaller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DownloaderInstallerApplication {

    public static void main(String[] args) throws IOException {

        SpringApplication.run(DownloaderInstallerApplication.class, args);
        new UserConfigurationService().createUserConfigFile();
    }

}
