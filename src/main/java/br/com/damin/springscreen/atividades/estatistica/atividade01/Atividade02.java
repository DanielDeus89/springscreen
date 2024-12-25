package br.com.damin.springscreen.atividades.estatistica.atividade01;

import java.util.Arrays;
import java.util.List;

public class Atividade02 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int min = numeros.stream()
                .min(Integer::compareTo)
                        .get();

        System.out.println(min);
    }

}
