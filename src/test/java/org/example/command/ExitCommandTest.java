package org.example.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class ExitCommandTest {

  @Test
  void testGetCode() {
    ExitCommand command = new ExitCommand();
    assertEquals("0", command.getCode());
  }

  @Test
  void testExecute() {
    ExitCommand command = new ExitCommand();
    // Capture the console output
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    // Use a SecurityManager to prevent System.exit from terminating the JVM
    SecurityManager originalSecurityManager = System.getSecurityManager();
    System.setSecurityManager(new SecurityManager() {
      @Override
      public void checkPermission(java.security.Permission perm) {
        // Allow other permissions
      }

      @Override
      public void checkExit(int status) {
        throw new SecurityException("System.exit attempted");
      }
    });

    try {
      command.execute();
      fail("Expected SecurityException to be thrown");
    } catch (SecurityException e) {
      assertEquals("System.exit attempted", e.getMessage());
    } finally {
      System.setSecurityManager(originalSecurityManager);
    }

    assertEquals("Fermeture de l'application...\n", outContent.toString());
  }

  @Test
  void testGetNext() {
    ExitCommand command = new ExitCommand();
    assertNull(command.getNext());
  }

  @Test
  void testHasNext() {
    ExitCommand command = new ExitCommand();
    assertFalse(command.hasNext());
  }
}