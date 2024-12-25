/*
Dada a lista de números inteiros a seguir,
calcule a média dos números maiores que 10 e exiba o resultado na tela.
 */

package br.com.damin.springscreen.atividades.estatistica.atividade01;

import java.util.Arrays;
import java.util.List;

public class Atividade05 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(5, 12, 8, 20, 33, 7, 15, 11, 4);

        double media = numeros.stream()
                .filter(n -> n > 10)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
        System.out.println(media);
    }
}
