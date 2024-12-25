package br.com.damin.springscreen.atividades.dados;

import java.util.Arrays;
import java.util.List;


public class Atividade02 {
    public static void main(String[] args) {
        List<String> nomes = Arrays.asList("daniel","heitor","isis","milene");

        nomes.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
