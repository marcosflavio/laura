package br.com.ufc.quixada.laurabot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.laurabot.model.PostsEntity;
import br.com.ufc.quixada.laurabot.repository.IPostsRepository;

@Transactional
@Service
public class PostsService {

	@Autowired
	IPostsRepository repository;

	public List<PostsEntity> findAll() {
		return repository.findAll();
	}

	public PostsEntity findOne(Long id) {
		return repository.findOne(id);
	}
	
	public List<PostsEntity> findPostsByType(Long type) {
		return repository.findPostsByType(type, "c#");
	}
}