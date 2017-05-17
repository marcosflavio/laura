package br.com.ufc.quixada.laurabot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ufc.quixada.laurabot.model.UsersEntity;

public interface IUsersRepository extends JpaRepository<UsersEntity, Integer>{
	
	
}
