package it.vincenzopicone.gestioneprenotazioni.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import it.vincenzopicone.gestioneprenotazioni.model.Edificio;
import it.vincenzopicone.gestioneprenotazioni.model.Postazione;
import it.vincenzopicone.gestioneprenotazioni.model.TipoPostazione;
import it.vincenzopicone.gestioneprenotazioni.repository.PostazioneDAORepo;
import jakarta.persistence.EntityExistsException;
@Service
public class PostazioneService {

	@Autowired PostazioneDAORepo repo;
	
	@Autowired @Qualifier("NuovaPostazione") private ObjectProvider<Postazione> nuovaPostazioneProvider;
	@Autowired @Qualifier("ParamsPostazione") private ObjectProvider<Postazione> paramsPostazioneProvider;

	
	
	public void creaPostazione() {
		Postazione P = nuovaPostazioneProvider.getObject();
		inserisciPostazione(P);
	}
	public void paramsPostazione(String descr, TipoPostazione tipo, int numMax, Edificio edi) {
		Postazione P = paramsPostazioneProvider.getObject(descr, tipo, numMax, edi);
		inserisciPostazione(P);
	}
	
	public void inserisciPostazione(Postazione p) {
		repo.save(p);
	}
	public String rimuoviPostazione(Long id) {
		if(!repo.existsById(id)){
			throw new EntityExistsException("La prenotazione non esiste");
		} 
		repo.deleteById(id);
		return "Prenotazione cancellata";

	}
	
	public void aggiornaPostazione(Postazione p) {
		repo.save(p);
		
	}
	public Postazione findPostazioneById(Long id) {
		return repo.findById(id).get();
	}
	public List<Postazione> findAllPostazione() {
		return (List<Postazione>) repo.findAll();
		
	}
	
}
