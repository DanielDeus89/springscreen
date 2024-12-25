/*
Dada a lista de números inteiros a seguir,
encontre todos os números pares, eleve cada um deles ao cubo e exiba apenas os 3 maiores resultados em ordem decrescente.
 */
package br.com.damin.springscreen.atividades.estatistica.Atividade02;

import java.util.Arrays;
import java.util.List;

public class Atividade04 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(4, 7, 10, 3, 6, 15, 20, 8, 12);

        List<Integer> maioresCubos = numeros.stream()
                .filter(num -> num % 2 == 0)
                .map(num -> (int) Math.pow(num, 3))
                .sorted((a,b) -> b.compareTo(a))
                .limit(3)
                        .toList();

        System.out.println("3 maiores resultados: " + maioresCubos);

        int soma = maioresCubos.stream().reduce(0, Integer::sum);
        System.out.println("Soma dos 3 maiores: " + soma);


    }
}
