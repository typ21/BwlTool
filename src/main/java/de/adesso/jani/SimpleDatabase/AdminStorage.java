package de.adesso.jani.SimpleDatabase;

import java.io.File;
import java.io.IOException;

public class AdminStorage {

    private static final File DATABASE_FILE = new File("/database/Admins.txt");
    private static final long offset = 0xABCDEFAB;


    static {

        boolean existing = true;

        if(!DATABASE_FILE.getParentFile().isDirectory()){
            existing = DATABASE_FILE.getParentFile().mkdirs();
        }
        if(!DATABASE_FILE.exists()){
            try {
               existing &= DATABASE_FILE.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(!existing) {
            System.out.println("Konnte Datenbank nicht erstellen - terminiere!");
            System.exit(-1);
        }
    }

    public static String getPasswordForName(String s) {
        return "";
    }

    public static boolean contains(String s) {
        return true;
    }
}
