/*
Dada a lista de números inteiros a seguir,
encontre todos os números divisíveis por 4 e calcule a soma do quadrado desses números.

Exiba os números divisíveis por 4 em ordem decrescente antes de calcular a soma dos quadrados.
 */

package br.com.damin.springscreen.atividades.estatistica.atividade03;

import java.util.Arrays;
import java.util.List;

public class Atividade02 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(4, 16, 7, 12, 8, 25, 20, 10, 28);

        List<Integer> divPor4 = numeros.stream()
                .filter(n -> n % 4 == 0)
                .sorted((a,b) -> b-a)
                .toList();

        int quadrado = divPor4.stream()
                .mapToInt(n -> n*n)
                                .reduce(0, Integer::sum);

        System.out.println("Números divisíveis por 4 (ordem decrescente): " + divPor4);
        System.out.println(quadrado);

    }
}
