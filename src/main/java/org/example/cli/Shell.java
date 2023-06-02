package org.example.cli;

import lombok.Getter;
import org.example.cli.resources.printer.UserPrinter;
import org.example.command.Command;
import org.example.command.CommandFactory;
import org.example.command.CommandMap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

@Getter
public class Shell {

    private final static String SUBSHELL_EXIT_KEY = "q";
    private final String key;
    private final BufferedReader userReader = new BufferedReader(new InputStreamReader(System.in));
    private final CommandMap commandMap;
    private final UserPrinter printer;
    private String currentUserInput;
    private boolean loopThrought = true;

    public Shell(String filePath, String bannerPath, String key) throws FileNotFoundException {
        this.key = key;
        this.commandMap = new CommandMap(key, () -> {
            try {
                return CommandFactory.getCommandListFromKey(key);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        this.printer = new UserPrinter(filePath, bannerPath);
    }

    public void run() throws IOException {

        this.printer.printBanner();

        while (this.loopThrought) {
            this.printer.printMenu();
            this.currentUserInput = this.getUserReader().readLine();

            if (this.getCommandMap().includes(this.key, currentUserInput)) {
                Command currentTask = this.getCommandMap().getCommands().get(this.key).get(this.currentUserInput);
                if (currentTask != null) {
                    currentTask.execute();
                    while (currentTask.hasNext()) {
                        currentTask = currentTask.getNext();
                        currentTask.execute();
                    }
                }
            } else if (currentUserInput.equals(SUBSHELL_EXIT_KEY)) {
                this.exit();
            } else {
                this.printer.printUserError();
            }
        }
    }

    public void exit() {
        this.loopThrought = false;
    }
}
