/*
Dada a lista de nomes a seguir,
conte quantos nomes têm exatamente 4 letras e exiba os nomes que terminam com a letra 'a' (maiúscula ou minúscula).
 */

package br.com.damin.springscreen.atividades.estatistica.Atividade02;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Atividade05 {
    public static void main(String[] args) {
        List<String> nomes = Arrays.asList("Ana", "Paulo", "João", "Maria", "Caia", "Fernanda", "Lara", "Mateus");

        long nomesCom4Letras = nomes.stream()
                .filter(n ->  n.length() == 4)
                .count();

        List<String> terminamComA = nomes.stream()
                        .filter(n -> n.toLowerCase().endsWith("a"))
                .toList();

        Optional<String> maiorNome = nomes.stream()
                .max((a,b) -> a.length() - b.length());

        maiorNome.ifPresent(System.out::println);
        System.out.println(nomesCom4Letras);
        System.out.println(terminamComA);
        

    }
}
