package de.adesso.jani.SimpleDatabase;

import de.adesso.jani.SimpleDatabase.XStorageObjects.*;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class XConfig {

    private final HashMap<String, XStorage> entryTree;

    private XConfig (){
        entryTree = new HashMap<String, XStorage>();
    }

    public static XConfig load(File f) throws IOException, XConfigError {
        String text = Files.readString(f.toPath());
        return parse(text);
    }

    public static XConfig parse(String s) throws IOException, XConfigError {

        StringReader stringReader = new StringReader(s);
        XConfig config = new XConfig();

        while(stringReader.ready()){
            String tag = XConfigFactory.readNextTag(stringReader);

            Map.Entry<String, XStorage> currentEntry = null;

            switch(tag) {
                case XStorageInt.tag:
                    currentEntry = XConfigFactory.readIntEntry(stringReader);
                    break;
                case XStorageBoolean.tag:

                    break;
                case XStorageConf.tag:
                    break;
                default:
                    throw new XConfigError("One of the Tags in your config doesn't exist. Please use a valid datatype.");
            }
            if(currentEntry == null)
                throw new XConfigError("Parsing returned null");

            config.entryTree.put(currentEntry.getKey(), currentEntry.getValue());
        }

        return new XConfig();
    }

    public static boolean create(File f) {
        return true;
    }

}
