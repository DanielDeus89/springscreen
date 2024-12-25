package br.com.damin.springscreen.atividades.dados;

import java.util.Arrays;
import java.util.List;

public class Atividade09 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int soma = numeros.stream()
                .peek(num -> System.out.println("Elementos: " + num))
                .mapToInt(num -> num * 2)
                .peek(num -> System.out.println("Resultado: " + num))
                .reduce(0, (a, b) -> a + b);

        System.out.println("Soma: " + soma);
    }
}
