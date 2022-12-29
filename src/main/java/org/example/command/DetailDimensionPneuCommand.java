package org.example.command;

public class DetailDimensionPneuCommand implements Command {
    @Override
    public String getCode() {
        return "5";
    }

    @Override
    public void execute() {
        System.out.println("Execution de DetailDimensionPneuCommand....");
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
