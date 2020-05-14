package us.cloudcard.downloaderinstaller;

import java.util.ArrayList;
import java.util.List;

public class Property {

    private String key;
    private String prompt;
    private String value;
    private List<String> options;
    private List<String> optionLabels;

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
        this.optionLabels = new ArrayList<>();
    }

    public String getKey() {

        return key;
    }

    public void setKey(String key) {

        this.key = key;
    }

    public String getPrompt() {

        return prompt;
    }

    public void setPrompt(String prompt) {

        this.prompt = prompt;
    }

    public String getValue() {

        if (isNumber(value) && value.length() < 3) {
            int num = Integer.parseInt(value);
            if (isInOptionRange(num)) {
                return options.get(num - 1);
            }
        }

        if(value.isEmpty()) {
            return getDefaultValue();
        }

        // the value is not an option choice
        return value;
    }

    private boolean isInOptionRange(int num) {

        return num > 0 && num <= options.size();
    }

    public void setValue(String value) {

        this.value = value;
    }

    public List<String> getOptions() {

        return options;
    }

    public List<String> getOptionLabels() {
        return optionLabels;
    }

    public String getDefaultValue() {
        if(options == null || options.isEmpty()) {
            return "ERROR!";
        }

        return options.get(0);
    }

    /**
     * Check if string is a number
     *
     * @param string
     * @return true if 'string' is a number
     */
    private boolean isNumber(String string) {

        return string.matches("^\\d+$");
    }

    public String getKeyValuePair() {

        return getKey() + "=" + getValue();
    }

    @Override
    public String toString() {
        return getKeyValuePair();
    }
}
//taking keys and values from the hardcoded methods
//taking keys from text
//outputting to app.prop
//now taking values from text document
//outputting to application.properties
//taking and storing and accessing