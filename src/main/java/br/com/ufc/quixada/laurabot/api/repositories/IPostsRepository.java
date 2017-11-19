package br.com.ufc.quixada.laurabot.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ufc.quixada.laurabot.api.model.Post;

public interface IPostsRepository extends JpaRepository<Post, Long>{
	
	@Query("SELECT p FROM Post p WHERE p.PostTypeId=:type")
	public List<Post> findPostsByType (@Param("type") Long type);
	
	@Query("SELECT p.Id FROM Post p WHERE p.Tags LIKE CONCAT('%',:tag,'%')")
	public List<Long> findPostsByTag (@Param("tag") String tag);
}