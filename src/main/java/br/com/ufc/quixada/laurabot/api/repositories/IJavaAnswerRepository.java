package br.com.ufc.quixada.laurabot.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ufc.quixada.laurabot.api.model.JavaAnswer;

@Repository
public interface IJavaAnswerRepository extends JpaRepository<JavaAnswer, Long> {

}
