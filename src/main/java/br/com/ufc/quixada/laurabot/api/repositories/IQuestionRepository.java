package br.com.ufc.quixada.laurabot.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ufc.quixada.laurabot.api.model.Question;


@Repository
public interface IQuestionRepository extends JpaRepository<Question, Long>{
	
}
