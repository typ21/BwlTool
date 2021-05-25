package de.adesso.jani.SimpleDatabase.XStorageObjects;

import de.adesso.jani.SimpleDatabase.XConfig;

public class XStorageConf implements XStorage{

    public static final String tag = "sub:";

    private final XConfig val;

    public XStorageConf(XConfig val){
        this.val = val;
    }

    @Override
    public boolean isEmpty() {
        return val == null;
    }

    @Override
    public XConfig getValue() {
        return val;
    }

    @Override
    public String getTag() {
        return tag;
    }
}
