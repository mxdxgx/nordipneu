package org.example.command;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static volatile CommandFactory instance;

    public static CommandFactory getInstance() {
        synchronized (CommandFactory.class) {
            if (instance == null) {
                instance = new CommandFactory();
            }
        }
        return instance;
    }

    public Map<String, Command> getCommandListFromKey(String key) throws FileNotFoundException {
        if (key.equals("mainMenu")) {
            Map<String, Command> commands = new HashMap<>();
            commands.put("0", new ExitCommand());
            commands.put("1", new SellPneuCommand());
            commands.put("2", new InstallationPneuCommand());
            commands.put("3", new SellPneuCommand(new InstallationPneuCommand()));
            commands.put("4", new StatisticVenteCommand());
            commands.put("5", new DetailDimensionPneuCommand());
            commands.put("6", new InventairePneuCommand());
            return commands;
        }

        if (key.equals("ventePneuMenu")) {
            Map<String, Command> commands = new HashMap<>();
            commands.put("0", new ExitCommand());
            commands.put("q", new SoftExitCommand());
            return commands;
        }
        return null;
    }
}
