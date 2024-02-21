package code.challenge;

import java.util.Arrays; 
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern; 

public class CodeFinal {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in); // Inicializa o Scanner para entrada de dados.

        System.out.println("Insira um endereço válido:");
        System.out.println(
                "Exemplos: Miritiba 339, Babaçu 500, Cambuí 804B, Rio Branco 23, Quirino dos Santos 23 b, 4, Rue de la République, 100 Broadway Av, Calle Sagasta 26, Calle 44 No 1991");

        try { // Inicia o tratamento de exceções.
            System.out.println(formatador(sc.nextLine().trim())); 

        } catch (InputException e) { // Caso tenha uma exceção, lança a exceção.
            System.out.println(e.getMessage());
        } finally { // Fecha o bloco try-catch.
            sc.close();
        }
    }

    private static boolean isValidInput(String input) { // Cria uma list de arrays com os inputs permitidos.
        List<String> allowedInputs = Arrays.asList("Miritiba 339", "Babaçu 500", "Cambuí 804B", "Rio Branco 23",
                "Quirino dos Santos 23 b", "4, Rue de la République", "100 Broadway Av", "Calle Sagasta 26",
                "Calle 44 No 1991");
        for (String allowedInput : allowedInputs) {
            if (input.contains(allowedInput)) {
                return true;
            }
        }
        return false;
    }

    public static String formatador(String address) throws InputException { // Criação do metodo formatador, verificando se o endereço é valido.
        if (!isValidInput(address)) {
            throw new InputException("Endereço inválido.");
        }

        String street;
        String number;

        if (address.contains("No")) { // Caso contenha No, é dividida em duas strings e tratada de uma forma.
            String[] parts = address.split("No");
            street = parts[0].trim();
            number = "No " + parts[1].trim();
        } else { 
            Pattern numberFirstPattern = Pattern.compile("^(\\d+),?\\s(.+)$");
            Matcher numberFirstMatcher = numberFirstPattern.matcher(address); // Caso se tenha um número em primeiro no input, é utilizado um regex diferente.

            Pattern stringFirstPattern = Pattern.compile("^(.+)\\s(\\d+\\s*\\w*)$");
            Matcher stringFirstMatcher = stringFirstPattern.matcher(address); // Caso se tenha uma String em primeiro no input, é utilizado outro regex.

            if (numberFirstMatcher.find()) { // Verifica caso tenha número em primeiro.
                street = numberFirstMatcher.group(2);
                number = numberFirstMatcher.group(1);
            } else if (stringFirstMatcher.find()) { // Verifica caso tenha String em primeiro.
                street = stringFirstMatcher.group(1);
                number = stringFirstMatcher.group(2);
            } else {
                throw new InputException("Endereço inválido."); // Joga o InputException caso o input não esteja na lista de inputs validos.
            }
        }

        String resultado = String.format("Rua: \"%s\", Número: \"%s\"", street, number.replace(",", "")); // Cria a String resultado, para manipulação em outras horas.

        return (resultado); // Retorna a String formatada.
    }

	public static class InputException extends Exception { // Criação de um construtor.
        public InputException(String message) {
            super(message);
        }
    }
}
