package br.com.ufc.quixada.laurabot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.ufc.quixada.laurabot.api.model.JavaQuestion;
import br.com.ufc.quixada.laurabot.api.services.JavaQuestionService;
import br.com.ufc.quixada.laurabot.clustering.Hierarchy;

@SpringBootApplication
public class LaurabotApplication implements CommandLineRunner {
	
	@Autowired
	private JavaQuestionService javaQuestionService;
	
	public static void main(String[] args) {
		SpringApplication.run(LaurabotApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<JavaQuestion> questions = javaQuestionService.findAll();
		Hierarchy h = new Hierarchy(questions);
		h.generate();
	} 
}
