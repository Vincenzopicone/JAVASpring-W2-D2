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

import it.vincenzopicone.gestioneprenotazioni.model.Postazione;
import it.vincenzopicone.gestioneprenotazioni.model.Utente;
import it.vincenzopicone.gestioneprenotazioni.service.PostazioneService;
import it.vincenzopicone.gestioneprenotazioni.service.UtenteService;
import jakarta.persistence.EntityExistsException;


@RestController
@RequestMapping("/postazioni")
public class PostazioneController {
	
	@Autowired PostazioneService service;
	
	@GetMapping
	public ResponseEntity<List<Postazione>> getAll () {
		return new ResponseEntity<List<Postazione>>(service.findAllPostazione(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUtente(@PathVariable Long id) {
		return new ResponseEntity<Postazione>(service.findPostazioneById(id), HttpStatus.CREATED);
	}
	
	
//	@PostMapping
//	public ResponseEntity<?> createUtente(@RequestBody Postazione pos){
//		return new ResponseEntity<>(service.creaPostazione(pos), HttpStatus.CREATED);
//	
//	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUtente(@PathVariable Long id) {
		return new ResponseEntity<String>(service.rimuoviPostazione(id), HttpStatus.OK);

	}
	
//	@PutMapping
//	public ResponseEntity<?> updateUtente(@RequestBody Postazione pos){
//		return new ResponseEntity<>(service.aggiornaPostazione(pos), HttpStatus.CREATED);
//		
//	}
	
}