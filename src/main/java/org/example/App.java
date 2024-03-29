package org.example;

import org.example.cli.Shell;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    public static void main(String[] args) {
        try {
            new Shell(
                        "src/main/java/org/example/cli/resources/menu.txt",
                        "src/main/java/org/example/cli/resources" + "/banner.txt",
                        "mainMenu")
                    .run();
        } catch (IOException e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, e.getMessage());
        }
    }
}
