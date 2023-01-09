package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WorkingFile {
    private File file;

    public void saveData(String data, String name) {
        if (notNull(data)) {
            createFile(name);
            writeFile(data);
        } else {
            System.out.println("Файл не создан");
        }
    }

    private void createFile(String name) {
        file = new File(name + ".txt");
        try {
            if (file.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean notNull(String name) {
        if (name != null) {
            return true;
        } else {
            return false;
        }
    }

    private void writeFile(String data) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(file, true);
            writer.append(data + "\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
