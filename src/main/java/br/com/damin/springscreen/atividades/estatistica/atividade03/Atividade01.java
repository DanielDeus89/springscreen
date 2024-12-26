/*
Dada a lista de números inteiros a seguir,
encontre os 3 menores números e exiba-os em ordem crescente. Em seguida, calcule e exiba o produto (multiplicação) desses 3 números.

Encontre a média dos 3 menores números e exiba o resultado.
 */

package br.com.damin.springscreen.atividades.estatistica.atividade03;

import java.util.Arrays;
import java.util.List;

public class Atividade01 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(12, 7, 3, 19, 8, 25, 15, 2, 10);

        List<Integer> tresMenores = numeros.stream()
                        .sorted(Integer::compareTo)
                                .limit(3)
                                        .toList();

        int multiplica = tresMenores.stream()
                .reduce(1, (a, b) -> a * b);

        double media = tresMenores.stream()
                        .mapToInt(Integer::intValue)
                                .average()
                                        .orElse(0.0);

        System.out.println("Os 3 menores números: " + tresMenores);
        System.out.println("Produto dos 3 menores números: " + multiplica);
        System.out.println("Média dos 3 menores números: " + media);

    }
}
