//1 - Dada a lista de números inteiros a seguir, encontre o maior número dela.

package br.com.damin.springscreen.atividades.estatistica.atividade01;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Atividade01 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int max = numeros.stream()
                .max(Integer::compareTo)
                        .get();

        System.out.println(max);

    }
}
