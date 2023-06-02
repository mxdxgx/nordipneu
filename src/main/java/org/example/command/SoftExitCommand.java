package org.example.command;

public class SoftExitCommand extends CommandBase {
    @Override
    public String getCode() {
        return "0";
    }

    @Override
    public void execute() {
        System.out.println("Retour au menu précédent...");
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
