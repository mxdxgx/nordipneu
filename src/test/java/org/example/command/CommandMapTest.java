package org.example.command;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommandMapTest {

  private CommandMap commandMap;

  @BeforeEach
  void setUp() {
    Supplier<Map<String, Command>> supplier = () -> {
      Map<String, Command> commands = new HashMap<>();
      commands.put("1", new Command() {
        @Override
        public String getCode() {
          return "1";
        }

        @Override
        public void execute() {
        }

        @Override
        public Command getNext() {
          return null;
        }

        @Override
        public boolean hasNext() {
          return false;
        }
      });
      return commands;
    };
    commandMap = new CommandMap("testKey", supplier);
  }

  @Test
  void testIncludesValidKeyAndCommandKey() {
    assertTrue(commandMap.includes("testKey", "1"));
  }

  @Test
  void testIncludesInvalidKey() {
    assertFalse(commandMap.includes("invalidKey", "1"));
  }

  @Test
  void testIncludesInvalidCommandKey() {
    assertFalse(commandMap.includes("testKey", "invalidCommandKey"));
  }

  @Test
  void testIncludesNullKey() {
    assertFalse(commandMap.includes(null, "1"));
  }

  @Test
  void testIncludesNullCommandKey() {
    assertFalse(commandMap.includes("testKey", null));
  }
}