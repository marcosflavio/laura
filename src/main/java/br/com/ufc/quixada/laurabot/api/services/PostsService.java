package br.com.ufc.quixada.laurabot.api.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.laurabot.api.model.Post;
import br.com.ufc.quixada.laurabot.api.repositories.IPostsRepository;

@Transactional
@Service
public class PostsService {

	@Autowired
	IPostsRepository repository;

	public List<Post> findAll() {
		return repository.findAll();
	}

	public Post findOne(Long id) {
		return repository.findOne(id);
	}
	
	public List<Post> findPostsByType(Long type) {
		return repository.findPostsByType(type);
	}
	
	public List<Long> findPostsIdByTag(String tag) {
		return repository.findPostsByTag(tag);
	}
}