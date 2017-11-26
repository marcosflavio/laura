package br.com.ufc.quixada.laurabot;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LaurabotApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(LaurabotApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}
}
