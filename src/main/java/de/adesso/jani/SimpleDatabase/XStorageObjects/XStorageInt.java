package de.adesso.jani.SimpleDatabase.XStorageObjects;

public class XStorageInt implements XStorage{

    public static final String tag = "int:";

    private final int val;

    public XStorageInt(int val){
        this.val = val;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Integer getValue() {
        return val;
    }

    @Override
    public String getTag() {
        return tag;
    }
}
