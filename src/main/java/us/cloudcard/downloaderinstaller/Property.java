package us.cloudcard.downloaderinstaller;

import java.util.ArrayList;
import java.util.List;
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
        return key + "=" + value;
    }
}
