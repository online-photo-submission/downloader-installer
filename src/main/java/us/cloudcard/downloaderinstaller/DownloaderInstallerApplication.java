package us.cloudcard.downloaderinstaller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication

public class DownloaderInstallerApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(DownloaderInstallerApplication.class, args);
        new UserConfigurationService().createUserConfigFile();


    }

}