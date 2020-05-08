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

    public void inputPropertyValuesFromUser() {

        log.error("I'm getting the answers");
        properties.get(0).value = "https://api.onlinephotosubmission.com/api";
        properties.get(1).value = "thisIsAValidAPIkey";
        properties.get(2).value = "FileStorageService";
        properties.get(3).value = "true";
        properties.get(4).value = "600000";
        properties.get(5).value = "READY_FOR_DOWNLOAD";
        properties.get(6).value = "DOWNLOADED";
        properties.get(7).value = "downloaded-photos";
        properties.get(8).value = "0";
    }

    public void inputPropertyValuesFromTextDocumentOptions() {

        log.error("I'm getting the answers");
        properties.get(0).value = properties.get(0).options.get(0);
        properties.get(1).value = properties.get(1).options.get(1);
        properties.get(2).value = properties.get(2).options.get(2);
        properties.get(3).value = properties.get(3).options.get(0);
        properties.get(4).value = properties.get(4).options.get(1);
        properties.get(5).value = properties.get(5).options.get(2);
        properties.get(6).value = properties.get(6).options.get(0);
        properties.get(7).value = properties.get(7).options.get(1);
        properties.get(8).value = properties.get(8).options.get(2);
    }

    public void readValuesFromUserSystemTerminal() throws IOException {

        System.out.println("\n WELCOME TO CLOUDCARD DOWNLOADER INSTALL ASSISTANT\n\n");

        for (int i = 0; i < properties.size(); i++) {
            readUserResponse(i);


            //            if (properties.get(i).getPrompt().endsWith(":")){   //Custom field input queued by title
            //                properties.get(i).value = customChoice();
            //            }
            //            else {
            //                    String optionChoiceTemp = properties.get(i).options.get(optionChoice(i)); // String passer eliminates multiple calls to optionChoice()
            //
            //                if  (optionChoiceTemp.endsWith(":")) {           //Custom field input queued by options
            //                    properties.get(i).value = customChoice();
            //                }
            //                else {
            //                    properties.get(i).value = optionChoiceTemp; // Multiple choice field queued by default
            //                }
            //            }
        }
    }

    private void readUserResponse(int index) {

        System.out.println(properties.get(index).prompt);
        for (int i = 0; i < properties.get(index).getOptions().size(); i++) { //prints out all the options
            System.out.println((i + 1) + ")" + properties.get(index).options.get(i));
        }


        Scanner scanner = new Scanner(System.in);
        while (true) {
            String response = scanner.nextLine();
            if (properties.get(index).options.size() == 1) {
                properties.get(index).value = response;
                break;
            }
            try {
                Integer.parseInt(response);
            } catch (NumberFormatException e) {
                properties.get(index).value = response;
                break;
            }
            for (int i = 0; i < properties.get(i).options.size(); i++) {
                if (response.equals(Integer.toString(i + 1))) {
                    properties.get(index).value = properties.get(index).options.get(i);
                    break;
                }
            }
            System.out.println("Invalid input, try again: ");
        }
    }

    private String customChoice() {

        Scanner scanner = new Scanner(System.in);
        String userCustomInput = scanner.nextLine();
        System.out.println("You entered: " + userCustomInput + "\n\n"); // displays user's choice
        return userCustomInput;
    }

    private int optionChoice(int propertyIndex) throws IOException {

        for (int i = 0; i < properties.get(propertyIndex).getOptions().size(); i++) { //prints out all the options
            System.out.println((i + 1) + ")" + properties.get(propertyIndex).options.get(i));
        }
        System.out.println("Enter integer selection: "); // user makes a choice
        Scanner scanner = new Scanner(System.in);
        int selection = scanner.nextInt();
        return (selection - 1);
    }

    public void logProperties() {

        for (Property property : properties) {
            log.info(property.toString());
        }
    }

    public void readEmptyPropertiesWithOptionsFromTextFile() throws FileNotFoundException {

        log.error("I'm reading the text file with empty properties");

        // setup

        File file = new File("/Users/applemacbookpro/Desktop/properties.txt");
        Scanner scanner = new Scanner(file);
        String line = "";
        String[] splitLine; // array to hold key half and prompt half of a line
        int i = -1;


        //start reading file...
        do {
            line = scanner.nextLine();
            if (line.startsWith("-")) {
                properties.get(i).options.add(line.substring(1));
            } else {
                splitLine = line.split(Pattern.quote("|"));
                properties.add(new Property(splitLine[ 0 ], splitLine[ 1 ], "")); // add value AND prompt
                i++;
            }
        } while (scanner.hasNextLine());
    }

    public void writeFile() throws IOException {

        log.error("I'm writing the file");
        FileWriter writer = new FileWriter("/Users/applemacbookpro/Desktop/application.properties");
        for (Property property : properties) {
            writer.write(property + "\n");
        }
        writer.close();
        log.error("File writer successful");
        System.out.println("THANKS FOR USING CLOUDCARD DOWNLOADER ASSISTANT\n\n");
    }
}
