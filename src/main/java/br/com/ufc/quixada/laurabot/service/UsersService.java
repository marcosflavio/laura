package br.com.ufc.quixada.laurabot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.quixada.laurabot.model.UsersEntity;
import br.com.ufc.quixada.laurabot.repository.IUsersRepository;

@Transactional
@Service
public class UsersService {
	
	@Autowired
	IUsersRepository repository;
	
	public List<UsersEntity> findAll() {
		return repository.findAll();
	}

	public UsersEntity findOne(int id) {
		return repository.findOne(id);
	}
}
