package org.example.command;

import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

@NoArgsConstructor
public class SellPneuCommand extends CommandBase {

    public SellPneuCommand(Command next) {
        super.setNext(next);
    }

    @Override
    public String getCode() {
        return "1";
    }

    @Override
    public void execute() throws IOException {
        String currentUserInput;
        boolean canContinue = true;
        try {
            while (canContinue) {

                System.out.print("Veuillez entrer le type de pneu : ");

                currentUserInput = new BufferedReader(new InputStreamReader(System.in)).readLine();

                if (currentUserInput == "q") {
                    canContinue = false;

                    System.out.println("Retour au menu précédent...");

                } else {
                    boolean matchingPattern =
                            Pattern.compile("[0-9]{3}\\/[R|B][0-9]{2}\\/[0-9]{2}").matcher(currentUserInput).matches();

                    if (!matchingPattern) {

                        System.out.println("Format Invalide, format recommandé : NNN/LNN/NN");

                    }
                }
            }

        } catch (IOException exception) {
            throw exception;
        }
    }

    @Override
    public Command getNext() {
        return super.getNext();
    }
}
