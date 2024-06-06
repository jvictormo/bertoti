package Factory;

import java.util.Scanner;

import Ollama.OllamaChatController;

public class Main {
    public static void main(String[] args) {
        OllamaChatController chatController = new OllamaChatController();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Chat IA! Digite 'sair' para encerrar.");

        String userInput;
        do {
            System.out.print("Você: ");
            userInput = scanner.nextLine();

            if (!userInput.equalsIgnoreCase("sair")) {
                String response = chatController.generateResponse(userInput);
                System.out.println("IA: " + response);
            }
        } while (!userInput.equalsIgnoreCase("sair"));

        System.out.println("Obrigado por usar o Chat IA!");
        scanner.close();
    }
}
