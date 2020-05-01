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
    public Property () {

    }
    public List<String> getUserValues () {
        List<String> userValues = new ArrayList<>();
        userValues.add("https://api.onlinephotosubmission.com/api");
        userValues.add("thisIsAValidAPIkey");
        userValues.add("FileStorageService");
        userValues.add("true");
        userValues.add("600000");
        userValues.add("READY_FOR_DOWNLOAD");
        userValues.add("DOWNLOADED");
        userValues.add("downloaded-photos");
        userValues.add("0");
        return userValues;
    }
    public List<String> getKeys () {
        List<String> keys = new ArrayList<>();
        keys.add("cloudcard.api.url=");
        keys.add("cloudcard.api.accessToken=");
        keys.add("downloader.storageService=");
        keys.add("downloader.repeat=");
        keys.add("downloader.delay.milliseconds=");
        keys.add("downloader.fetchStatuses=");
        keys.add("downloader.putStatus=");
        keys.add("downloader.photoDirectories=");
        keys.add("downloader.minPhotoIdLength=");
        return keys;
    }

    @Override
    public String toString() {

        return new StringJoiner(", ", Property.class.getSimpleName() + "[", "]")
            .add("key='" + key + "'")
            .add("value='" + value + "'")
            .toString();
    }
}
