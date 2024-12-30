package br.com.damin.springscreen.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "episodios") // Nome da tabela no banco
public class Episodio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int temporada;
    private String titulo;
    private int numeroEpisodio;
    private double avaliacao;
    private LocalDate dataLancamento;

    @ManyToOne
    @JoinColumn(name = "series_id", nullable = false) // Chave estrangeira que referencia a tabela Series
    private Series series;

    // Construtor padrão
    public Episodio() {
    }

    public Episodio(Integer numeroTemporada, DadosEpisodio dadosEpisodio, Series series) {
        try {
            this.temporada = numeroTemporada;
        } catch (NullPointerException e) {
            this.temporada = 0;
        }

        this.titulo = dadosEpisodio.titulo();
        this.numeroEpisodio = dadosEpisodio.numeroEpisodio();

        try {
            this.avaliacao = Double.parseDouble(dadosEpisodio.avaliacao());
        } catch (Exception e) {
            this.avaliacao = 0.0;
        }

        this.dataLancamento = LocalDate.parse(dadosEpisodio.dataLancamento());
        this.series = series; // Associação com a série
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
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
