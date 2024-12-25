/*
Dada a lista de números inteiros a seguir,
encontre todos os números distintos (sem repetir),
ordene-os em ordem decrescente e exiba o resultado na tela.

java
Copiar código

 */

package br.com.damin.springscreen.atividades.estatistica.atividade01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Atividade07 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(15, 22, 15, 33, 50, 28, 50, 18, 39, 41, 22);

        List<Integer> unicos = numeros.stream()
                .distinct()
                .sorted((a,b) -> b - a)
                .collect(Collectors.toList());

        System.out.println(unicos);

        if(numeros.size() >= 4){
            System.out.println("quarto Maior: " + unicos.get(3));
        }else {
            System.out.println("Não há 4 números na lista.");
        }

    }
}
