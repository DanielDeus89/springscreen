package br.com.damin.springscreen.atividades.estatistica;


import java.util.Arrays;
import java.util.List;

public class Atividade04 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);

       int somaQuadrados =  numeros.stream()
               .filter(e -> e % 2 == 0)
               .map(e -> e * e)
               .reduce(0, Integer::sum);

       System.out.println(somaQuadrados);



    }
}

