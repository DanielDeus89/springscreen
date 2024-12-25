/*
Dada a lista de palavras a seguir,
conte quantas palavras têm mais de 5 letras e quantas começam com a letra 'A' (maiúscula ou minúscula).
*/

package br.com.damin.springscreen.atividades.estatistica.Atividade02;

import java.util.Arrays;
import java.util.List;


public class Atividade01 {
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("Abacaxi", "Banana", "Ameixa", "Pera", "Maçã", "Abacate", "Melancia", "Uva");

        long maisDe5Letras = palavras.stream()
                .filter(p -> p.length() > 5)
                .count();

        long comecaComA = palavras.stream()
                        .filter(p -> p.toLowerCase().startsWith("a"))
                                .count();


        System.out.println("Palavras com mais de 5 letras: " + maisDe5Letras);
        System.out.println("Palavras que começam com 'A': " + comecaComA);



    }
}
