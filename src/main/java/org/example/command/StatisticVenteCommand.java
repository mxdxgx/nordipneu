package org.example.command;

public class StatisticVenteCommand extends CommandBase {

  @Override
  public String getCode() {
    return "4";
  }

  @Override
  public void execute() {
    System.out.println("Execution de StatisticVenteCommand....");
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
