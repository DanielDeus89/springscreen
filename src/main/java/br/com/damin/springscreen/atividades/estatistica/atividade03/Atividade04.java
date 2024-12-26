/*
Dada a lista de números inteiros a seguir,
ncontre todos os números negativos e exiba o maior número negativo.
Em seguida, calcule a soma de todos os números positivos.

Encontre a média dos números positivos e exiba o resultado.
*/


package br.com.damin.springscreen.atividades.estatistica.atividade03;

import java.util.Arrays;
import java.util.List;

public class Atividade04 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(10, -3, 5, -7, 12, -1, 8, -15, 20, -10);


        int maiorNegativo  = numeros.stream()
                .filter(n -> n < 0)
                        .max(Integer::compareTo)
                                .orElse(0);

        int somaPositivos = numeros.stream()
                .filter(n -> n > 0)
                .reduce(0, Integer::sum);

        double mediaPositivos  = numeros.stream()
                        .filter(n -> n > 0)
                                .mapToInt(Integer::intValue)
                                        .average()
                                                .orElse(0);

        System.out.println("Maior número negativo: " + maiorNegativo);
        System.out.println("Soma dos números positivos: " + somaPositivos);
        System.out.println("Média dos números positivos: " + mediaPositivos);

    }
}
