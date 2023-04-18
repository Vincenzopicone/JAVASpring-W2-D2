package it.vincenzopicone.gestioneprenotazioni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import it.vincenzopicone.gestioneprenotazioni.model.Prenotazione;
import it.vincenzopicone.gestioneprenotazioni.model.Utente;
import it.vincenzopicone.gestioneprenotazioni.service.PrenotazioneService;
import it.vincenzopicone.gestioneprenotazioni.service.UtenteService;



@Controller
public class PrenotazioneController {
	
	@Autowired UtenteService service;
	
	@GetMapping("/regole")
	public @ResponseBody String showRules () {
		return "inserisci /regole/it per la lingua italiana oppure /regole/en in inglese";
	}
	
	@GetMapping("/regole/{lang}")
	public @ResponseBody String showRulesLanguages (@PathVariable String lang) {
		String frase = null;
		System.out.println(lang);
		if(lang == "en") {
           return frase = "The user cannot book two different seats on the same day." + "The station cannot be booked by two or more different users on the same day.";
		} else if (lang == "it") {
           return frase = "L'utente non può prenotare due postazioni diverse lo stesso giorno."+ "La postazione non può essere prenotata da due o più utenti diversi nello stesso giorno.";
		} else {
		   return frase = "Lingua non supportata";
		}

	}
	
	@GetMapping(value="/utenti", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <?> utenti () {
		
		List <Utente> lista = service.findAllUtente();
		
		
		return new ResponseEntity <> (lista, HttpStatus.CREATED); 
	}

}
