/*
Dada a lista de números inteiros a seguir,
encontre a média dos números pares e conte quantos números são múltiplos de 5.
 */

package br.com.damin.springscreen.atividades.estatistica.Atividade02;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Atividade06 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(10, 15, 8, 25, 30, 17, 6, 20, 13, 40);

        double mediaPares =  numeros.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);

        long multCinco = numeros.stream()
                .filter(n -> n % 5 == 0)
                .count();


        Optional<Integer> maiorMultCinco = numeros.stream()
                        .filter(n -> n %  5 ==0 )
                                .max(Integer::compare);

        System.out.println(multCinco);

        System.out.println(mediaPares);

        maiorMultCinco.ifPresent(System.out::println);


    }
}
