package org.example.command;

public class InventairePneuCommand implements Command {
    @Override
    public String getCode() {
        return "6";
    }

    @Override
    public void execute() {
        System.out.println("Execution de InventairePneuCommand....");
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
