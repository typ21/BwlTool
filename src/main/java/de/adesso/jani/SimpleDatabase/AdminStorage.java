package de.adesso.jani.SimpleDatabase;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AdminStorage {

    private static final File DATABASE_HEAD = new File("./database/");
    private static final char offset = 0x3E;

    private static HashMap<String, String> accounts;


    static {

        boolean existing = true;

        if(!DATABASE_HEAD.getParentFile().isDirectory()){
            existing = DATABASE_HEAD.getParentFile().mkdirs();
        }

        if(!existing) {
            System.out.println("Konnte Datenbank nicht erstellen - terminiere!");
            System.exit(-1);
        }

        try {
            accounts = readFiles();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Konnte Datenbank nicht lesen - terminiere!");
            System.exit(-1);
        }
        System.out.println("Datenbank initialisiert!");
    }

    private static HashMap<String, String> readFiles() throws IOException {

        HashMap<String, String> inter = new HashMap<String, String>();

        File[] allAccounts = DATABASE_HEAD.listFiles();

        if(allAccounts != null) {
            for (File f : allAccounts) {

                String name = f.getName();

                BufferedReader br = new BufferedReader(new FileReader(f));

                StringBuilder sb = new StringBuilder();

                br.lines().forEach(sb::append);

                accounts.put(name, sb.toString());
            }
        }

        return inter;
    }

    private static boolean writeConfig() {

        boolean generalSuccess = true;

        try {
            for(Map.Entry<String, String> current : accounts.entrySet()) {

                File currentFile = new File(DATABASE_HEAD, current.getKey());

                boolean success = true;

                if(currentFile.exists())
                    success = currentFile.delete();

                success &= currentFile.createNewFile();

                FileWriter fw = new FileWriter(currentFile);

                fw.write(current.getValue());

                fw.close();

                generalSuccess &= success;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return generalSuccess;
    }

    public static String getPasswordForName(String s) {
        return contains(s) ? accounts.get(s) : null;
    }

    public static boolean contains(String s) {
        return accounts.containsKey(s);
    }

    public static boolean addUser(String name, String pass) {

        pass = new BCryptPasswordEncoder(10).encode(pass);

        accounts.put(name, pass);

        return writeConfig();

    }
}
