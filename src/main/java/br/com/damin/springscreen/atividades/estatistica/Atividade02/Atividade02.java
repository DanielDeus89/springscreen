/*
Dada a lista de palavras (strings) abaixo, agrupe-as pelo seu tamanho.
No código a seguir, há um exemplo prático do resultado esperado.
 */

package br.com.damin.springscreen.atividades.estatistica.Atividade02;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Atividade02 {
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("java", "stream", "lambda", "code", "Daniel","Heitor");

        Map<Integer, List<String>> agrupamento = palavras.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(agrupamento);
    }
}
