/*
Dada a lista de nomes abaixo, concatene-os separados por vírgula. No código a seguir, há um exemplo prático do resultado esperado.
 */
package br.com.damin.springscreen.atividades.estatistica.atividade03;

import java.util.Arrays;
import java.util.List;

public class Atividade03 {
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("java", "stream", "lambda", "code", "Daniel","Heitor");

        String resultado = String.join(", ", palavras);

        System.out.println(resultado);
    }
}

