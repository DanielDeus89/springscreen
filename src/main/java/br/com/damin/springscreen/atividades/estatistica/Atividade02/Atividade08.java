/*
Dada a lista de palavras a seguir,
conte quantas palavras têm exatamente 6 letras,
liste as palavras que contêm a letra 'e' (maiúscula ou minúscula) e exiba a palavra mais curta da lista.

Exiba as palavras ordenadas em ordem alfabética inversa (de Z para A).
 */

package br.com.damin.springscreen.atividades.estatistica.Atividade02;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Atividade08 {
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("Elefante", "Casa", "Cavalo", "Mesa", "Caneta", "Escova", "Amor", "Livro");

        long palavrasCom6Letras = palavras.stream()
                .filter(p -> p.length() == 6)
                .count();

        List<String> palavrasComE = palavras.stream()
                        .filter(p -> p.toLowerCase().contains("e"))
                .collect(Collectors.toList());

        Optional<String> palavraMaisCurta = palavras.stream()
                        .min((a,b) -> a.length() - b.length());

        List<String> ordemInversa = palavras.stream()
                .sorted((a,b)-> b.compareToIgnoreCase(a))
                        .toList();

        System.out.println("Palavras com 6 letras: " + palavrasCom6Letras);
        System.out.println("Palavras que contêm a letra 'e': " + palavrasComE);
        palavraMaisCurta.ifPresent(p -> System.out.println("Palavra mais curta: " + p));
        System.out.println("Palavras em ordem alfabética inversa: " + ordemInversa);


    }
}
