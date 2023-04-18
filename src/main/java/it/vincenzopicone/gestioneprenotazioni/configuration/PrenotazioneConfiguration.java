package it.vincenzopicone.gestioneprenotazioni.configuration;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.vincenzopicone.gestioneprenotazioni.model.Postazione;
import it.vincenzopicone.gestioneprenotazioni.model.Prenotazione;
import it.vincenzopicone.gestioneprenotazioni.model.Utente;

@Configuration
public class PrenotazioneConfiguration {
	
	@Bean("NuovaPrenotazione")
	@Scope("prototype")
	public Prenotazione nuovaPrenotazione(Utente utente, Postazione postazione, LocalDate data) {
		Prenotazione PR = new Prenotazione();
		PR.setUtente(utente);
		PR.setPostazione(postazione);
		PR.setDataprenotazione(data);
		return PR;
	}

}
