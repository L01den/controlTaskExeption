package org.example;

import java.util.Scanner;

public class App {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите фио, дату раждения, телефон без 8, и пол 'f' или 'm' ");
        String data = sc.nextLine();
        // Rodina Daria Andreevna 11.09.1999 9991111991 f

        ParsingString ps = new ParsingString();
        String line = ps.toDo(data);
        WorkingFile f = new WorkingFile();
        f.saveData(line, ps.getLastName());
    }
}
