package br.com.damin.springscreen.principal;

import br.com.damin.springscreen.model.DadosSerie;
import br.com.damin.springscreen.model.DadosTemporada;
import br.com.damin.springscreen.service.ConsumoApi;
import br.com.damin.springscreen.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    Scanner scanner = new Scanner(System.in);

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6585022c";

    public void exbirMenu() {
        System.out.print("Digite o nome da Serie para Busca: ");
        String nomeSerie = scanner.nextLine();


        var consumoApi = new ConsumoApi();
        var json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);

        ConverteDados converteDados = new ConverteDados();
        DadosSerie dados = converteDados.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporada> temporadas = new ArrayList<>();

		for (int i = 1; i <= dados.totalTemporadas(); i++){
			json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=" + i + "&apikey=6585022c");
			DadosTemporada dadosTemporada = converteDados.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		temporadas.forEach(System.out::println);

        temporadas.forEach(t -> {
            if (t.episodios() != null) {
                t.episodios().forEach(e -> System.out.println(e.titulo()));
            } else {
                System.out.println("Nenhum episódio encontrado para a temporada " + t.numero());
            }
        });
    }
}
