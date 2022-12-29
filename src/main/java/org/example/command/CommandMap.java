package org.example.command;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class CommandMap {
    Map<String, Command> commands;

    public CommandMap() {
        this.commands = new HashMap<>();
        this.commands.put("0", new ExitCommand());
        this.commands.put("1", new SellPneuCommand());
        this.commands.put("2", new InstallationPneuCommand());
        this.commands.put("3", new SellPneuCommand(new InstallationPneuCommand()));
        this.commands.put("4", new StatisticVenteCommand());
        this.commands.put("5", new DetailDimensionPneuCommand());
        this.commands.put("6", new InventairePneuCommand());

    }

    public boolean includes(String key) {
        return key != null && this.commands.containsKey(key);
    }
}
