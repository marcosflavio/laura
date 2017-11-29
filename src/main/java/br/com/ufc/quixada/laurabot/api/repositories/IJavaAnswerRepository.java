package br.com.ufc.quixada.laurabot.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ufc.quixada.laurabot.api.model.JavaAnswer;

@Repository
public interface IJavaAnswerRepository extends JpaRepository<JavaAnswer, Long> {

	@Query("select j from JavaAnswer j where j.post.id = (:postId)")
	public JavaAnswer findByPostId(@Param("postId") Long postId);
}
