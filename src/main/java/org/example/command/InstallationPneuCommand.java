package org.example.command;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InstallationPneuCommand extends CommandBase {

    public InstallationPneuCommand(Command next) {
        super.setNext(next);
    }

    @Override
    public String getCode() {
        return "2";
    }

    @Override
    public void execute() {
        System.out.println("Execution de InstallationPneuCommand....");
    }

    @Override
    public Command getNext() {
        return super.getNext();
    }
}
