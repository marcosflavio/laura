package br.com.ufc.quixada.laurabot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.ufc.quixada.laurabot.api.factory.JavaQuestionFactory;


@SpringBootApplication
public class LaurabotApplication implements CommandLineRunner {
	
	@Autowired
	private JavaQuestionFactory javaQuestionFactory;
	
	public static void main(String[] args) {
		SpringApplication.run(LaurabotApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		javaQuestionFactory.bulkSetUser();
	}
}
