package br.com.damin.springscreen.atividades.dados;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Atividade07 {
    public static void main(String[] args) {
        List<Produdo> produtos = Arrays.asList(
                new Produdo("Smartphone", 800.0, "Eletrônicos"),
                new Produdo("Notebook", 1500.0, "Eletrônicos"),
                new Produdo("Teclado", 200.0, "Eletrônicos"),
                new Produdo("Cadeira", 300.0, "Móveis"),
                new Produdo("Monitor", 900.0, "Eletrônicos"),
                new Produdo("Mesa", 700.0, "Móveis")
        );

        List<Produdo> produtoEletronico = produtos.stream()
                .filter(p -> Objects.equals(p.getCategoria(), "Eletrônicos"))
                .filter(q -> q.getPreco() < 1000)
                .sorted((p1, p2) -> Double.compare(p1.getPreco(), p2.getPreco()))
                .toList();

        produtoEletronico.forEach(System.out::println);

    }

    public static class Produdo{
        private String nome;
        private double preco;
        private String categoria;

        public Produdo(String nome, double preco, String categoria) {
            this.nome = nome;
            this.preco = preco;
            this.categoria = categoria;
        }

        public String getNome() {
            return nome;
        }

        public double getPreco() {
            return preco;
        }

        public String getCategoria() {
            return categoria;
        }

        @Override
        public String toString() {
            return "Produdo{" +
                    "nome='" + nome + '\'' +
                    ", preco=" + preco +
                    ", categoria='" + categoria + '\'' +
                    '}';
        }
    }
}
