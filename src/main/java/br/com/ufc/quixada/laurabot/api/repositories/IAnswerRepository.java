package br.com.ufc.quixada.laurabot.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ufc.quixada.laurabot.api.model.Answer;

@Repository
public interface IAnswerRepository extends JpaRepository<Answer, Long> {

	@Query("SELECT a FROM Answer a WHERE a.question.id = (:questionId)")
	public List<Answer> findByQuestionId(@Param("questionId") Long questionId);
}
