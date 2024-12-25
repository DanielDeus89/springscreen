package br.com.damin.springscreen.atividades.estatistica.atividade01;
/*
Dada a lista de números inteiros a seguir, encontre quantos números ímpares existem na lista e exiba o resultado na tela.
 */
import java.util.Arrays;
import java.util.List;

public class Atividade04 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(15, 22, 9, 18, 33, 41, 50, 17, 29);

        long impares = numeros.stream()
                .filter(n -> n % 2 != 0)
                .count();

        System.out.println(impares);

        System.out.println("Maior que 20");
        long maior20 = numeros.stream()
                .filter(n -> n > 20)
                .count();

        System.out.println(maior20);


    }
}
