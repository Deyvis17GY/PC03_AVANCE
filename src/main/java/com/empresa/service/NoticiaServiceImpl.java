package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Noticia;
import com.empresa.repository.NoticiaRepository;

@Service
public class NoticiaServiceImpl implements NoticiaService {

	@Autowired
	private NoticiaRepository repository;

	@Override
	public List<Noticia> listaNoticia() {
		return repository.findAll();
	}

	@Override
	public Noticia insertaActualizaNoticia(Noticia obj) {
		return repository.save(obj);
	}

	@Override
	public void eliminaNoticia(int id) {
		repository.deleteById(id);
	}


	@Override
	public Optional<Noticia> obtienePorId(int idNoticia) {
		return repository.findById(idNoticia);
	}




}
