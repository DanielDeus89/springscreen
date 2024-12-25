package br.com.damin.springscreen.atividades.dados;

import java.util.Arrays;
import java.util.List;

public class Atividade05 {

    public static boolean ehPrimo(int numero) {
        if (numero < 1) return false;
        for (int i = 2; i < Math.sqrt(numero); i++) {
            if (numero % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
       List<List<Integer>> listaNumeros = Arrays.asList(
                Arrays.asList(1,2,3,4),
                Arrays.asList(5,6,7,8),
                Arrays.asList(9,10,11,12)
        );

       List<Integer> primos = listaNumeros.stream()
               .flatMap(List::stream)
               .filter(Atividade05::ehPrimo)
               .sorted()
               .toList();

       primos.forEach(System.out::println);

    }
}

