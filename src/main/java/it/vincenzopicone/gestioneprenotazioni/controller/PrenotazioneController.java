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
import it.vincenzopicone.gestioneprenotazioni.service.PrenotazioneService;



@Controller
public class PrenotazioneController {
	
	@Autowired PrenotazioneService service;
	
	@GetMapping("/regole")
	public @ResponseBody String showRules () {
		return "inserisci /regole/it per la lingua italiana oppure /regole/en in inglese";
	}
	
	@GetMapping("/regole/{lang}")
	public @ResponseBody String showRulesLanguages (@PathVariable String lang) {
		String frase = null;
		System.out.println(lang);
		if(lang == "en") {
           frase = "The user cannot book two different seats on the same day." + "The station cannot be booked by two or more different users on the same day.";
		} else if (lang == "it") {
            frase = "L'utente non può prenotare due postazioni diverse lo stesso giorno."+ "La postazione non può essere prenotata da due o più utenti diversi nello stesso giorno.";
		} else {
			frase = "Lingua non supportata";
		}
		return frase;
	}
	
//	@GetMapping(value="/prenotazioni", produces= MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity <Prenotazione> prenotazioni () {
//		
//		List <Prenotazione> lista = service.findAllPrenotazione();
//		lista.
//		
//		ResponseEntity <Penotazione> resp = new ResponseEntity <Prenotazione>(lista.size(), HttpStatus.OK); 
//		return resp;
//	}

}
