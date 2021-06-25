package de.adesso.jani.SimpleDatabase;

import de.adesso.jani.SimpleDatabase.XStorageObjects.XConfigError;
import de.adesso.jani.SimpleDatabase.XStorageObjects.XStorage;
import de.adesso.jani.SimpleDatabase.XStorageObjects.XStorageInt;

import java.io.IOException;
import java.io.StringReader;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class XConfigFactory {

    public static String readNextTag(StringReader sr) throws IOException {

        StringBuilder tag = new StringBuilder();

        char current = ' ';

        while(sr.ready() && current != ':'){
            current = (char)sr.read();
            tag.append(current);
        }
        return tag.toString();
    }

    public static Map.Entry<String, XStorage> readIntEntry(StringReader sr) throws IOException, XConfigError {
        if(sr.read() != (int)'{')
            throw new XConfigError("Format error in database. After Tag there has to be a {");

        StringBuilder sb = new StringBuilder();

        char current = ' ';

        while(sr.ready() && current != '}'){
            current = (char) sr.read();
            sb.append(current);
        }

        String[] data = sb.toString().split(",");
        if(data.length != 2){
            throw new XConfigError("Couldnt parse data properly!");
        }

        try {
            return new AbstractMap.SimpleEntry<String, XStorage>(data[0], new XStorageInt(Integer.parseInt(data[1])));
        }catch(NumberFormatException e){
            throw new XConfigError("Expected Integer, found something else!");
        }
    }
}
