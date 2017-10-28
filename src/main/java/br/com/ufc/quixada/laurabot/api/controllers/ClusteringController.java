package br.com.ufc.quixada.laurabot.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufc.quixada.laurabot.api.services.ClusteringService;

@RestController
@RequestMapping(value = "/laura/api")
public class ClusteringController {
	
	@Autowired
	private ClusteringService clusteringService;
	
	@RequestMapping(value = "/clustering", method = RequestMethod.GET)
	public void clustering () {
		clusteringService.clustering();
	}
	
}
