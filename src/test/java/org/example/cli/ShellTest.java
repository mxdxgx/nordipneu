package org.example.cli;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShellTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayInputStream inContent = new ByteArrayInputStream("q\n".getBytes());
  private Shell shell;

  @BeforeEach
  void setUp() throws IOException {
    System.setOut(new PrintStream(outContent));
    System.setIn(inContent);
    shell = new Shell(
        "src/test/java/org/example/cli/resources/menu.txt",
        "src/test/java/org/example/cli/resources/banner.txt",
        "mainMenu");

  }

  @Test
  void testRun() throws IOException {
    shell.run();
    assertTrue(outContent.toString().contains("Shell started"));
  }

  @Test
  void testExecuteCommand() throws IOException {
    ByteArrayInputStream commandInContent = new ByteArrayInputStream("help\n".getBytes());
    System.setIn(commandInContent);
    shell.run();
    assertTrue(outContent.toString().contains("Available commands:"));
  }

  @Test
  void testExit() {
    shell.exit();
    assertFalse(shell.isLoopThrought());
  }
}