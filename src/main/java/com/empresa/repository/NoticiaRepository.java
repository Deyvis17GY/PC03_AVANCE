package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.empresa.entity.Noticia;

public interface NoticiaRepository extends JpaRepository<Noticia, Integer> {

	
	
}
