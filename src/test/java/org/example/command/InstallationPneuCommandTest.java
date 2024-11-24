package org.example.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class InstallationPneuCommandTest {

  @Test
  void testGetCode() {
    InstallationPneuCommand command = new InstallationPneuCommand();
    assertEquals("2", command.getCode());
  }

  @Test
  void testExecute() {
    InstallationPneuCommand command = new InstallationPneuCommand();
    // Capture the console output
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    command.execute();
    assertEquals("Execution de InstallationPneuCommand....\n", outContent.toString());
  }

  @Test
  void testGetNext() {
    Command nextCommand = new Command() {
      @Override
      public String getCode() {
        return null;
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

      @Override
      public boolean isDisableNext() {
        return false;
      }
    };
    InstallationPneuCommand command = new InstallationPneuCommand(nextCommand);
    assertEquals(nextCommand, command.getNext());
  }

  @Test
  void testHasNext() {
    InstallationPneuCommand command = new InstallationPneuCommand();
    assertFalse(command.hasNext());
  }
}