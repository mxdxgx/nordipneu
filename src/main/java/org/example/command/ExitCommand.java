package org.example.command;

public class ExitCommand extends CommandBase {

  @Override
  public String getCode() {
    return "0";
  }

  @Override
  public void execute() {
    System.out.println("Fermeture de l'application...");
    System.exit(0);
  }

  @Override
  public Command getNext() {
    return null;
  }

  @Override
  public boolean hasNext() {
    return false;
  }
}
