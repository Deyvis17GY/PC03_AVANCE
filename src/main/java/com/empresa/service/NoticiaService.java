package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Noticia;

public interface NoticiaService {

	public abstract List<Noticia> listaNoticia();
	public abstract Noticia insertaActualizaNoticia(Noticia obj);
	public abstract Optional<Noticia> obtienePorId(int idNoticia);
	public abstract void eliminaNoticia(int id);

	
}
