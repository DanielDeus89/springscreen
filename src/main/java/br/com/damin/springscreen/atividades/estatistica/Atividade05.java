package br.com.damin.springscreen.atividades.estatistica;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Atividade05 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

       Map<Boolean, List<Integer>> particionando = numeros.stream()
               .collect(Collectors.partitioningBy(num -> num % 2 == 0));

        System.out.println("Pares: " + particionando.get(true));
        System.out.println("Impares: " + particionando.get(false));



    }
}

