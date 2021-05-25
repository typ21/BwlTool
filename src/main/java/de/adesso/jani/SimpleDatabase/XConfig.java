package de.adesso.jani.SimpleDatabase;

import de.adesso.jani.SimpleDatabase.XStorageObjects.XStorage;

import java.io.File;
import java.util.HashMap;

public class XConfig {

    private final boolean isSingleton;

    private HashMap<String, XStorage> entryTree;

    private XConfig (boolean isSingleton){
        this.isSingleton = isSingleton;
    }

    public static XConfig load(File f) {
        return new XConfig(true);
    }

    public static XConfig parse(String s){
        return new XConfig(true);
    }

    public static boolean create(File f) {
        return true;
    }

    public boolean isSingleton() {
        return isSingleton;
    }
}
