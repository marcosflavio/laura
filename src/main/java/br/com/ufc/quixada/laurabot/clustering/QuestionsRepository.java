package br.com.ufc.quixada.laurabot.clustering;

import java.util.ArrayList;
import java.util.List;

public class QuestionsRepository {
	private List<Question> questions;
	Question question = new Question("Como percorrer uma string em java?", 1);
	Question question1 = new Question("Como capturar caracteres de uma string em java?", 2);
	Question question2 = new Question("Como usar as dependencias do maven", 3);
	Question question3 = new Question("Como utilizar o método toString do java?", 4);
	Question question4 = new Question("Como multiplicar uma tabela em C?", 5);
	Question question5 = new Question("Utilizando fors aninhados em C?", 6);
	Question question6 = new Question("Como criar um objeto em C#?", 7);
	Question question7 = new Question("Como pegar os atributos de um objeto em C#?", 8);
	Question question8 = new Question("Como multiplicar dois ventores em Python?", 9);
	Question question9 = new Question("Como somar dois vetores em Python?", 10);
	Question question10 = new Question("Como criar um chat em Java?", 11);

	public void init() {
		questions = new ArrayList<Question>();
	}

	public void addAll() {
		questions.add(question);
		questions.add(question1);
		questions.add(question2);
		questions.add(question3);
		questions.add(question4);
		questions.add(question5);
		questions.add(question6);
		questions.add(question7);
		questions.add(question8);
		questions.add(question9);
		questions.add(question10);
	}

	public List<Question> getQuestions() {
		return this.questions;
	}
}
