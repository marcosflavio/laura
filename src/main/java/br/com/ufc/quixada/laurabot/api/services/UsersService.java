package br.com.ufc.quixada.laurabot.api.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.laurabot.api.model.User;
import br.com.ufc.quixada.laurabot.api.repositories.IUsersRepository;

@Transactional
@Service
public class UsersService {
	
	@Autowired
	IUsersRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}

	public User findOne(Long id) {
		return repository.findOne(id);
	}
}
