/*
Dada a lista de números inteiros a seguir,
encontre todos os números primos e, em seguida, exiba o maior número primo e a soma de todos os primos.

Encontre a quantidade de números primos na lista e exiba o resultado também.
*/

package br.com.damin.springscreen.atividades.estatistica.Atividade02;

import br.com.damin.springscreen.atividades.dados.Atividade05;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Atividade07 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 7, 10, 13, 17, 19, 22, 23, 29, 31);

        List<Integer> primos = numeros.stream()
                .filter(Atividade07::ehPrimo)
                .sorted()
                .toList();

        Optional<Integer> maiorPrimo = primos.stream()
                        .max(Integer::compareTo);

        long quantidadePrimos = primos.stream()
                        .count();


        System.out.println(quantidadePrimos);


        System.out.println(primos);
        System.out.println(maiorPrimo.get());
    }

    private static boolean ehPrimo(int numero) {
        return Atividade05.ehPrimo(numero);
    }


}
