package code.challenge.v1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Code_1_v3 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.printf("Insira uma das entradas permitidas: Miritiba 339, Babaçu 500 ou Cambuí 804B");
        System.out.println();

        try {
            String city = sc.nextLine(); // leitura do input
            if (!isValidInput(city)) {
                throw new InputException("Por favor, insira uma das opções permitidas.");
            }

            String[] vect = city.split(" "); // abre o vetor e separa por meio de espaços

            if (vect.length >= 2) { // verifica para evitar index out of bounds
                System.out.println("\"" + vect[0] + "\", \"" + vect[1] + "\"");
            } else {
                System.out.println("entrada invalida");
            }
            sc.close();
        } catch (InputException e) {
            System.out.println(e.getMessage());
        }       
    }

    private static boolean isValidInput(String input) {
        List<String> allowedInputs = Arrays.asList("Miritiba 339", "Babaçu 500", "Cambuí 804B");
        return allowedInputs.contains(input);
    }
	static class InputException extends Exception {
        public InputException(String message) {
            super(message);
        }
    }
}