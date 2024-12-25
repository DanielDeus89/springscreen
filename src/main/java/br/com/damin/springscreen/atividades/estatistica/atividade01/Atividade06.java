package br.com.damin.springscreen.atividades.estatistica.atividade01;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Atividade06 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(45, 12, 33, 50, 28, 50, 18, 39, 41);

        Optional<Integer> max = numeros.stream().max(Integer::compareTo);
        System.out.println(max);

        Optional<Integer> segundoMaior = numeros.stream()
                .filter(n -> max.isPresent() && n < max.get())
                .max(Integer::compareTo);
        System.out.println(segundoMaior);

        Optional<Integer> terceiroMaior = numeros.stream()
                .filter(n -> segundoMaior.isPresent() && n < segundoMaior.get())
                .max(Integer::compareTo);

        System.out.println(terceiroMaior);
    }
}
