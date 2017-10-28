package br.com.ufc.quixada.laurabot.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ufc.quixada.laurabot.api.model.User;

public interface IUsersRepository extends JpaRepository<User, Integer>{
	
	
}
