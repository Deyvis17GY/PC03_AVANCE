package com.empresa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Noticia;
import com.empresa.service.NoticiaService;

import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
@RestController
@RequestMapping("/rest/noticia")
public class NoticiaController {
	

	@Autowired
	private NoticiaService service;

	@GetMapping
	public ResponseEntity<List<Noticia>> lista(){
		//log.info(">>> lista ");
		return ResponseEntity.ok(service.listaNoticia());
	}
	
	@PostMapping
	public ResponseEntity<Noticia> registra(@RequestBody Noticia obj){
		//log.info(">>> registra " + obj.getIdNoticia());
		System.out.println("registra" + obj.getIdNoticia());
		return ResponseEntity.ok(service.insertaActualizaNoticia(obj));
	}
	
	@PutMapping
	public ResponseEntity<Noticia> actualiza(@RequestBody Noticia obj){
		//log.info(">>> actualiza " + obj.getIdNoticia());
		Optional<Noticia> optAlumnmo =   service.obtienePorId(obj.getIdNoticia());
		if (optAlumnmo.isPresent()) {
			return ResponseEntity.ok(service.insertaActualizaNoticia(obj));	
		}else {
			//log.error(">>> actualiza " + obj.getIdNoticia() + " no encontrado");
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Noticia> elimina(@PathVariable("id") int idNoticia){
		//log.info(">>> elimina " + idNoticia);
		Optional<Noticia> optNoticia =   service.obtienePorId(idNoticia);
		if (optNoticia.isPresent()) {
			service.eliminaNoticia(idNoticia);
			return ResponseEntity.ok(optNoticia.get());
		}else {
			//log.error(">>> elimina " + idNoticia + " no encontrado");
			return ResponseEntity.notFound().build();
		}
	}
	
}


