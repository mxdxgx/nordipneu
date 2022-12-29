package org.example.cli;

import lombok.Getter;
import org.example.cli.resources.printer.UserPrinter;
import org.example.command.Command;
import org.example.command.CommandMap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

@Getter
public class Shell {
    private final BufferedReader userReader = new BufferedReader(new InputStreamReader(System.in));
    private final CommandMap commandMap;
    private final UserPrinter printer;
    private String currentUserInput;

    public Shell() throws FileNotFoundException {
        this.commandMap = new CommandMap();
        this.printer = new UserPrinter();
    }

    public void run() throws IOException {

        this.printer.printBanner();

        while (true) {
            this.printer.printMenu();
            this.currentUserInput = this.getUserReader().readLine();

            if (this.getCommandMap().includes(currentUserInput)) {

                Command currentTask = this.getCommandMap().getCommands().get(this.currentUserInput);

                if (currentTask != null) {
                    currentTask.execute();
                    while (currentTask.hasNext()) {
                        currentTask = currentTask.getNext();
                        currentTask.execute();
                    }
                }

            } else {
                this.printer.printUserError();
            }
        }
    }
}
