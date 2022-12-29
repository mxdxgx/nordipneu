package org.example.cli.resources.printer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserPrinter {

    private static final String BANNER_FILE_PATH = "src/main/java/org/example/cli/resources/banner.txt";
    private static final String MENU_FILE_PATH = "src/main/java/org/example/cli/resources/menu.txt";
    private static final String USER_INPUT_ERROR_MSG = "Erreur : ce choix n'est pas valide.";

    private final BufferedReader fileReader;
    private final BufferedReader bannerReader;
    private final List<String> menuAsList = new ArrayList<>();

    public UserPrinter() throws FileNotFoundException {
        this.fileReader = new BufferedReader(new FileReader(MENU_FILE_PATH));
        this.bannerReader = new BufferedReader(new FileReader(BANNER_FILE_PATH));
    }

    public void printBanner() throws IOException {
        String line;
        while ((line = this.bannerReader.readLine()) != null) {
            System.out.println(line);
        }
    }

    public void printMenu() throws IOException {
        if (this.menuAsList.isEmpty()) {
            String line;
            while ((line = this.fileReader.readLine()) != null) {
                System.out.println(line);
                this.menuAsList.add(line);
            }
        } else {
            this.menuAsList.forEach(System.out::println);
        }
    }

    public void printUserError() {
        System.out.println(USER_INPUT_ERROR_MSG);
    }
}
