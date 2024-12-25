/*
Dada a lista de números inteiros a seguir,
encontre todos os números divisíveis por 3 e eleve cada um deles ao quadrado.
depois, some todos os valores resultantes e exiba o resultado na tela.
 */

package br.com.damin.springscreen.atividades.estatistica.atividade01;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Atividade08 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(5, 9, 12, 8, 15, 18, 22, 33);

         Optional<Integer> soma = numeros.stream()
                .filter(num -> num % 3 == 0)
                 .map(num -> num * num)
                 .reduce(Integer::sum);

         System.out.println(soma);

    }
}
