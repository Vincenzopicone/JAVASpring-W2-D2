package it.vincenzopicone.gestioneprenotazioni.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.vincenzopicone.gestioneprenotazioni.model.Utente;
import it.vincenzopicone.gestioneprenotazioni.service.*;

@RestController
@RequestMapping("/utenti/pageable")
public class UtentePageableController {
	
	@Autowired UtenteService service;
	
	

	@GetMapping
	public ResponseEntity<Page<it.vincenzopicone.gestioneprenotazioni.model.Utente>> getAllPageable(Pageable pag) {
		return new ResponseEntity<Page<Utente>>(service.getAllUtentiPageable(pag), HttpStatus.OK);
	}

}
