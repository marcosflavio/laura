package br.com.ufc.quixada.laurabot.clustering;

public class Main {
	
	public static void main(String[] args) {
		Kmeans kmeans = new Kmeans(7);
		QuestionsRepository repo = new QuestionsRepository();
		repo.init();
		repo.addAll();
		kmeans.setQuestions(repo.getQuestions());
		kmeans.init();
		kmeans.calculate();
	}
}
