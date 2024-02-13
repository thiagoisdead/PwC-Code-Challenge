package code.challenge.v1;

import java.util.Scanner;

public class Code_1_v2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try  {        	
        	String city = sc.nextLine(); // leitura do input
        
        if (city.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) { // verifica se existe caracteres especi
            throw new ExpecialException("A entrada não pode conter caracteres especiais");
        }

        String[] vect = city.split(" "); // abre o vetor e separa por meio de espaços

        if (vect.length >= 2) { // verifica para evitar index out of bounds
            System.out.println("\"" + vect[0] + "\", \"" + vect[1] + "\"");
        } else {
            System.out.println("entrada invalida");
        }
       } catch (ExpecialException e) {
    	   System.out.println(e.getMessage());
       }

        sc.close();
    }
}
	 class ExpecialException extends Exception { 
		public ExpecialException(String message) {
			super(message);
    }
}