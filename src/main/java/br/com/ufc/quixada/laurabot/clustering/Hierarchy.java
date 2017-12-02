package br.com.ufc.quixada.laurabot.clustering;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.text.similarity.JaccardDistance;

import br.com.ufc.quixada.laurabot.api.model.JavaQuestion;
import br.com.ufc.quixada.laurabot.clustering.domain.HierarchicalCluster;

public class Hierarchy {
	private List<HierarchicalCluster> clusters;
	
	private List<JavaQuestion> questions;
	
	public Hierarchy(List<JavaQuestion> questions) {
		this.questions = questions;
		init();
	}
	
	public void generate() {
		while(clusters.size() > 1) {
			iterate();
		}
	}
	
	private void iterate() {
        double closest = Double.MAX_VALUE;
        HierarchicalCluster bestA = null;
        HierarchicalCluster bestB = null;

        for (int i = 0; i < clusters.size(); i++) {
            for (int j = i + 1; j < clusters.size(); j++) {
            	HierarchicalCluster cA = clusters.get(i);
            	HierarchicalCluster cB = clusters.get(j);
				Double distance = new JaccardDistance().apply(cA.getJavaQuestion().getTitle(),
						cB.getJavaQuestion().getTitle());
                if (distance < closest) {
                    closest = distance;
                    bestA = cA;
                    bestB = cB;
                }
            }
        }

        HierarchicalCluster m = bestA.merge(bestB, closest);
        clusters.add(m);
        clusters.remove(bestA);
        clusters.remove(bestB);
    }
	
	private void init() {
		this.clusters = new ArrayList<HierarchicalCluster>();
		this.questions.forEach(q -> {
			this.clusters.add(new HierarchicalCluster(q));
		});
	}
	
	private List<HierarchicalCluster> getClusters() {
		return this.clusters;
	}
	
	private HierarchicalCluster getRoot() {
		return this.clusters.get(0);
	}
}
