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

import it.vincenzopicone.gestioneprenotazioni.model.Utente;
import it.vincenzopicone.gestioneprenotazioni.service.UtenteService;
import jakarta.persistence.EntityExistsException;


@RestController
@RequestMapping("/utenti")
public class UtenteController {
	
	@Autowired UtenteService utenteService;
	
	@GetMapping
	public ResponseEntity<List<Utente>> getAll () {
		return new ResponseEntity<List<Utente>>(utenteService.findAllUtente(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUtente(@PathVariable Long id) {
		return new ResponseEntity<Utente>(utenteService.findUtenteById(id), HttpStatus.CREATED);
	}
	
	
	@PostMapping
	public ResponseEntity<?> createUtente(@RequestBody Utente utente){
		return new ResponseEntity<>(utenteService.creaParamsUtente(utente), HttpStatus.CREATED);
	
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUtente(@PathVariable Long id) {
		return new ResponseEntity<String>(utenteService.rimuoviUtente(id), HttpStatus.OK);

	}
	
	@PutMapping
	public ResponseEntity<?> updateUtente(@RequestBody Utente utente){
		return new ResponseEntity<>(utenteService.aggiornaUtente(utente), HttpStatus.CREATED);
		
	}
	
}
	
