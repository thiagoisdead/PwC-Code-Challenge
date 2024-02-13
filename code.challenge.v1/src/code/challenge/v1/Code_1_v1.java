package code.challenge.v1;

import java.util.Scanner;

public class Code_1_v1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String city = sc.nextLine(); // leitura de dados

        String[] vect = city.split(" "); // abre o vetor e separa por meio de espaços

        if (vect.length >= 2) { // verifica para evitar index out of bounds
            System.out.println(vect[0] + " , " + vect[1]);
        } else {
            System.out.println("entrada invalida");
        }

        sc.close();
    }
}