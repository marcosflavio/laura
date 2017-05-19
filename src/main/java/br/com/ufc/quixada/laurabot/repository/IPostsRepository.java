package br.com.ufc.quixada.laurabot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ufc.quixada.laurabot.model.PostsEntity;

public interface IPostsRepository extends JpaRepository<PostsEntity, Long>{
	
	@Query("SELECT p FROM PostsEntity p WHERE p.PostTypeId=:type and p.Tags LIKE CONCAT ('%', :tag, '%')")
	public List<PostsEntity> findPostsByType (@Param("type") Long type, @Param(value = "tag") String tag);
}