package de.adesso.jani.SimpleDatabase.XStorageObjects;

import org.springframework.validation.ObjectError;

public interface XStorage {

    boolean isEmpty();
    Object getValue();
    String getTag();

}
