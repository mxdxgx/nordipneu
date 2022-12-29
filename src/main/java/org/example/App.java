package org.example;

import org.example.cli.Shell;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    public static void main(String[] args) throws Exception {
        Shell shell = new Shell();
        try {
            shell.run();
        } catch (Exception e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, e.getMessage());
        }
    }
}
