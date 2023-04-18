package it.vincenzopicone.gestioneprenotazioni.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import it.vincenzopicone.gestioneprenotazioni.model.Postazione;
import it.vincenzopicone.gestioneprenotazioni.model.Prenotazione;
import it.vincenzopicone.gestioneprenotazioni.model.Utente;
import it.vincenzopicone.gestioneprenotazioni.repository.PrenotazioneDAORepo;
import it.vincenzopicone.gestioneprenotazioni.runner.GestionePrenotazioniRun;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PrenotazioneService {
	
@Autowired PrenotazioneDAORepo repo;
	
	@Autowired @Qualifier("NuovaPrenotazione") private ObjectProvider<Prenotazione> nuovaPrenotazioneProvider;
	
	public void creaPrenotazione(Utente utente, Postazione post, LocalDate data) {
		Prenotazione P = nuovaPrenotazioneProvider.getObject(utente, post, data);
		inserisciPrenotazione(P);		
	}
	
	public void inserisciPrenotazione(Prenotazione p) {
		List<Prenotazione> listaUtenti = findByUtenteData(p.getUtente(), p.getDataprenotazione());
		List<Prenotazione> listaPostazioni = findByPostazioneData(p.getPostazione(), p.getDataprenotazione());
		if(listaUtenti.size() > 0) {
			log.info("Esiste una prenotazione per questa data");
		} else if (listaPostazioni.size() > 0) {
			log.info("La postazione non è disponibile in questa data");
		} else {
		repo.save(p);
		}
	}
	public void rimuoviPrenotazione(Prenotazione p) {
		repo.delete(p);

	}
	
	public void aggiornaPrenotazione(Prenotazione p) {
		repo.save(p);
		
	}
	public Prenotazione findPrenotazioneById(Long id) {
		return repo.findById(id).get();
	}
	public List<Prenotazione> findAllPrenotazione() {
		return (List<Prenotazione>) repo.findAll();
		
	}
	
	public List<Prenotazione> findByUtente(Utente u) {
		return (List<Prenotazione>) repo.listaDiUtenti(u);
	}
	
	public List<Prenotazione> findByUtenteData (Utente u, LocalDate data) {
		return (List<Prenotazione>) repo.listaDiUtentiConData(u, data);
	}
	
	public List<Prenotazione> findByPostazioneData (Postazione p, LocalDate data) {
		return (List<Prenotazione>) repo.listaDiPostazioniConData(p, data);
	}

}
