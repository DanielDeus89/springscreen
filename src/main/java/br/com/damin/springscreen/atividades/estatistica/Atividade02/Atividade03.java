/*
Dada a lista de números inteiros a seguir,
encontre a soma de todos os números ímpares e, em seguida, multiplique o resultado por 2. Exiba o valor final na tela.

 */

package br.com.damin.springscreen.atividades.estatistica.Atividade02;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Atividade03 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(3, 8, 15, 10, 21, 18, 25, 14, 7);

        int impares = numeros.stream()
                .filter(num -> num % 2 != 0)
                .reduce(0,Integer::sum);

        Optional<Integer> menorImpar = numeros.stream()
                .filter(num -> num % 2 != 0)
                .min(Integer::compareTo);

        int resultado = impares * 2;
        System.out.println(impares);
        System.out.println(resultado);
        System.out.println(menorImpar);
        menorImpar.ifPresent(min -> System.out.println("Menor número ímpar: " + min));
    }
}
