package br.com.damin.springscreen.atividades.estatistica.atividade01;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Atividade03 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(12, 7, 18, 5, 10, 3, 8, 21, 6);

       int pares =  numeros.stream()
                .filter(n -> n % 2 == 0)
               .reduce(0, Integer::sum);

       System.out.println(pares);
    }
}
