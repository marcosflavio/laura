package br.com.ufc.quixada.laurabot.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ufc.quixada.laurabot.api.model.Question;


@Repository
public interface IQuestionRepository extends JpaRepository<Question, Long>{
	
	@Query("SELECT q FROM Question q WHERE q.postId IN (:postsId)")
	public List<Question> findByPostsId(@Param("postsId") List<Long> postsId);
}
