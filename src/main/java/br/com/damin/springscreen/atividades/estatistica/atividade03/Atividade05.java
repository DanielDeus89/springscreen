/*
Dada a lista de números inteiros a seguir,
encontre os números repetidos e exiba-os junto com a quantidade de vezes que cada número se repete.

Exiba os números repetidos em ordem decrescente com suas respectivas contagens.
*/

package br.com.damin.springscreen.atividades.estatistica.atividade03;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Atividade05 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(10, 15, 8, 10, 25, 8, 30, 25, 10, 8, 20);


        Map<Integer, Long> frequencias = numeros.stream()
                        .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        Map<Integer, Long> repetidosOrdenados = frequencias.entrySet().stream()
                        .filter(entry -> entry.getValue() > 1)
                                .sorted((a,b) -> b.getKey().compareTo(a.getKey()))
                                        .collect(Collectors.toMap(
                                                Map.Entry::getKey, Map.Entry::getValue,
        (e1,e2) -> e1, LinkedHashMap::new));


        repetidosOrdenados.forEach((numero,contagem) -> System.out.println("Numero: " + numero + " | Quantidade: " + contagem));
    }
}
