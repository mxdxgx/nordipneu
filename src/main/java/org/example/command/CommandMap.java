package org.example.command;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import lombok.Getter;

@Getter
public class CommandMap {

  Map<String, Map<String, Command>> commands;

  public CommandMap(String key, Supplier<Map<String, Command>> supplier) {
    this.commands = new HashMap<>();
    this.commands.put(key, supplier.get());
  }

  public boolean includes(String key, String commandKey) {
    try {
      return key != null && this.commands.get(key).containsKey(commandKey);
    } catch (NullPointerException e) {
      return false;
    }
  }
}
