package br.com.ufc.quixada.laurabot.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.laurabot.api.model.Cluster;
import br.com.ufc.quixada.laurabot.api.repositories.IClusterRespository;

@Service
public class ClusterService {

	@Autowired
	private IClusterRespository repository;
	
	public void save(Cluster cluster) {
		repository.save(cluster);
	}
	
	public void save(List<Cluster> clusters) {
		repository.save(clusters);
	}
}
