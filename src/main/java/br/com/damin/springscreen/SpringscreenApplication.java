package br.com.damin.springscreen;

import br.com.damin.springscreen.principal.Principal;
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
		Principal principal = new Principal();
		principal.exbirMenu();

	}
}
