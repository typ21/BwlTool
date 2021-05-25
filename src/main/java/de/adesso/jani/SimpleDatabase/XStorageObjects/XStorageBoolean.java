package de.adesso.jani.SimpleDatabase.XStorageObjects;

public class XStorageBoolean implements XStorage{

    public static final String tag = "bool:";

    private final boolean b;

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Boolean getValue() {
        return b;
    }

    @Override
    public String getTag() {
        return tag;
    }

    public XStorageBoolean(boolean b){
        this.b = b;
    }
}
