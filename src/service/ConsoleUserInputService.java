package service;

import java.util.Scanner;
import interfaces.*;

public class ConsoleUserInputService implements UserInputService {
    private Scanner scanner;

    public ConsoleUserInputService() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String getUserInput() {
        return scanner.nextLine();
    }
}