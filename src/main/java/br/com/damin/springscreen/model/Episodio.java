package br.com.damin.springscreen.model;

import java.time.LocalDate;

public class Episodio {
    private int temporada;
    private String titulo;
    private int numeroEpisodio;
    private double avaliacao;
    private LocalDate dataLancamento;

    public Episodio(Integer numeroTemporada, DadosEpisodio dadosEpisodio) {
        try{
            this.temporada = numeroTemporada;

        }catch(NullPointerException e){
            this.temporada = 0;
        }

        this.titulo = dadosEpisodio.titulo();
        this.numeroEpisodio = dadosEpisodio.numeroEpisodio();

        try{
            this.avaliacao = Double.parseDouble(dadosEpisodio.avaliacao());
        }catch(Exception e){
            this.avaliacao = 0.0;
        }

        this.dataLancamento = LocalDate.parse(dadosEpisodio.dataLancamento());
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(int numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    @Override
    public String toString() {
        return "Episodio{" +
                "temporada=" + temporada +
                ", titulo='" + titulo + '\'' +
                ", numeroEpisodio=" + numeroEpisodio +
                ", avaliacao=" + avaliacao +
                ", dataLancamento=" + dataLancamento +
                '}';
    }
}
