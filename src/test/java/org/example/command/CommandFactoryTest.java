package org.example.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.util.Map;
import org.junit.jupiter.api.Test;

class CommandFactoryTest {

  @Test
  void testGetInstance() {
    CommandFactory instance1 = CommandFactory.getInstance();
    CommandFactory instance2 = CommandFactory.getInstance();
    assertSame(instance1, instance2, "Instances should be the same");
  }

  @Test
  void testGetCommandListFromKeyMainMenu() throws FileNotFoundException {
    CommandFactory factory = CommandFactory.getInstance();
    Map<String, Command> commands = factory.getCommandListFromKey("mainMenu");
    assertNotNull(commands, "Commands should not be null");
    assertEquals(7, commands.size(), "There should be 7 commands in the main menu");
    assertTrue(commands.containsKey("0"));
    assertTrue(commands.containsKey("1"));
    assertTrue(commands.containsKey("2"));
    assertTrue(commands.containsKey("3"));
    assertTrue(commands.containsKey("4"));
    assertTrue(commands.containsKey("5"));
    assertTrue(commands.containsKey("6"));
  }

  @Test
  void testGetCommandListFromKeyVentePneuMenu() throws FileNotFoundException {
    CommandFactory factory = CommandFactory.getInstance();
    Map<String, Command> commands = factory.getCommandListFromKey("ventePneuMenu");
    assertNotNull(commands, "Commands should not be null");
    assertEquals(2, commands.size(), "There should be 2 commands in the vente pneu menu");
    assertTrue(commands.containsKey("0"));
    assertTrue(commands.containsKey("q"));
  }

  @Test
  void testGetCommandListFromKeyInvalid() throws FileNotFoundException {
    CommandFactory factory = CommandFactory.getInstance();
    Map<String, Command> commands = factory.getCommandListFromKey("invalidKey");
    assertNull(commands, "Commands should be null for an invalid key");
  }
}