package us.cloudcard.downloaderinstaller;

import java.util.ArrayList;
import java.util.List;

public class Property {

    String key;
    String prompt;
    String value;
    List<String> options;

    public Property(String key, String value, List<String> options) {
        this.key = key;
        this.value = value;
        this.options = options;
    }

    public Property(String key, String prompt, String value) {
        this.key = key;
        this.prompt = prompt;
        this.value = value;
        this.options = new ArrayList<>();
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getPrompt() {
        return prompt;
    }
}
//taking keys and values from the hardcoded methods
//taking keys from text
//outputting to app.prop
//now taking values from text document
//outputting to application.properties
//taking and storing and accessing