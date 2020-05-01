package us.cloudcard.downloaderinstaller;

import java.util.StringJoiner;

public class Property {

    String key;
    String value;

    public Property(String key, String value) {

        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {

        return new StringJoiner(", ", Property.class.getSimpleName() + "[", "]")
            .add("key='" + key + "'")
            .add("value='" + value + "'")
            .toString();
    }
}
