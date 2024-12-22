package br.com.damin.springscreen.atividades;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Atividade04 {
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("apple", "banana", "apple", "orange", "banana");

        List<String> unicas = palavras.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(unicas);

    }
}
