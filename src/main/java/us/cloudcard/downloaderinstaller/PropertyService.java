package us.cloudcard.downloaderinstaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PropertyService {

    private static final Logger log = LoggerFactory.getLogger(PropertyService.class);

    List<Property> properties = new ArrayList<>();

    public void readValuesFromUser() throws IOException {

        System.out.println("\n WELCOME TO CLOUDCARD DOWNLOADER INSTALL ASSISTANT\n\n");

        for (Property property : properties) {
            readUserResponse(property);
        }
    }

    private void readUserResponse(Property property) {

        printPrompt(property);
        Scanner scanner = new Scanner(System.in);
        property.setValue(scanner.nextLine());
    }

    private void printPrompt(Property property) {

        List<String> options = property.getOptions();
        System.out.println(property.getPrompt());
        for (int i = 0; i < options.size(); i++) { //prints out all the options
            System.out.println((i + 1) + ")" + options.get(i));
        }
    }

    public void logProperties() {

        for (Property property : properties) {
            log.info(property.toString());
        }
    }

    public void readQuestions() throws FileNotFoundException {

        log.error("I'm reading the text file with empty properties");

        // setup

        File file = new File("properties.txt");
        Scanner scanner = new Scanner(file);
        String line = "";
        String[] splitLine; // array to hold key half and prompt half of a line
        int i = -1;


        //start reading file...
        do {
            line = scanner.nextLine();
            if (line.startsWith("-")) {
                properties.get(i).getOptions().add(line.substring(1));
            } else {
                splitLine = line.split(Pattern.quote("|"));
                properties.add(new Property(splitLine[ 0 ], splitLine[ 1 ], "")); // add value AND prompt
                i++;
            }
        } while (scanner.hasNextLine());
    }

    public void writeFile() throws IOException {

        log.error("I'm writing the file");
        FileWriter writer = new FileWriter("application.properties");
        for (Property property : properties) {
            if (!property.getValue().isEmpty()) {
                writer.write(property + "\n");
            }
        }
        writer.close();
        log.error("File writer successful");
        System.out.println("THANKS FOR USING CLOUDCARD DOWNLOADER ASSISTANT\n\n");
    }
}
