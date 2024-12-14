package br.com.damin.springscreen;

import br.com.damin.springscreen.model.DadosSerie;
import br.com.damin.springscreen.service.ConsumoApi;
import br.com.damin.springscreen.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringscreenApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringscreenApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		System.out.println(json);

		ConverteDados converteDados = new ConverteDados();
		DadosSerie dados = converteDados.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}
}
