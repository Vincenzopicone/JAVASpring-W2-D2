package it.vincenzopicone.gestioneprenotazioni.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.vincenzopicone.gestioneprenotazioni.model.Edificio;
import it.vincenzopicone.gestioneprenotazioni.service.EdificioService;

import jakarta.persistence.EntityExistsException;


@RestController
@RequestMapping("/edifici")
public class EdificioController {
	
	@Autowired EdificioService service;
	
	@GetMapping
	public ResponseEntity<List<Edificio>> getAll () {
		return new ResponseEntity<List<Edificio>>(service.findAllEdificio(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEdificio(@PathVariable Long id) {
		return new ResponseEntity<Edificio>(service.findEdificioById(id), HttpStatus.CREATED);
	}
	
	
	@PostMapping
	public ResponseEntity<?> createUtente(@RequestBody Edificio edificio){
		return new ResponseEntity<>(service.inserisciEdificio(edificio), HttpStatus.CREATED);
	
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEdificio(@PathVariable Long id) {
		return new ResponseEntity<String>(service.rimuoviEdificio(id), HttpStatus.OK);

	}
	
	@PutMapping
	public ResponseEntity<?> updateEdificio(@RequestBody Edificio edificio){
		return new ResponseEntity<>(service.aggiornaEdificio(edificio), HttpStatus.CREATED);
		
	}
	
}