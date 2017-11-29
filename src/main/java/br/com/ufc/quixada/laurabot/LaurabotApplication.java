package br.com.ufc.quixada.laurabot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.ufc.quixada.laurabot.metric.services.AnswerRankService;

@SpringBootApplication
public class LaurabotApplication implements CommandLineRunner {
	
	@Autowired
	private AnswerRankService answerRankService;
	
	public static void main(String[] args) {
		SpringApplication.run(LaurabotApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		answerRankService.process();
	} 
}
