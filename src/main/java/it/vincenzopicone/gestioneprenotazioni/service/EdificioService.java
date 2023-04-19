package it.vincenzopicone.gestioneprenotazioni.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import it.vincenzopicone.gestioneprenotazioni.model.Edificio;
import it.vincenzopicone.gestioneprenotazioni.repository.EdificioDAORepo;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;


@Service
public class EdificioService {

    @Autowired EdificioDAORepo repo;
	
	@Autowired @Qualifier("FakeEdificio") private ObjectProvider<Edificio> fakeEdificioProvider;
	@Autowired @Qualifier("NuovoEdificio") private ObjectProvider<Edificio> nuovoEdificioProvider;
	

	public void creaFakeEdificio() {

		Edificio E = fakeEdificioProvider.getObject();
		inserisciEdificio(E);
	}
	public void creaNuovoEdificio() {
		Edificio E = nuovoEdificioProvider.getObject();
		inserisciEdificio(E);
	}
	public void inserisciEdificio(Edificio e) {
		repo.save(e);
	}
	public Edificio getEdificio(Long id) {
		if(!repo.existsById(id)){
			throw new EntityNotFoundException("L'edificio non esiste");
		} 
		return repo.findById(id).get();
	}
	public String rimuoviEdificio(Long id) {
		if(!repo.existsById(id)){
			throw new EntityExistsException("L'edificio non esiste");
		} 
		repo.deleteById(id);
		return "Edificio cancellato";
	}
	public String aggiornaEdificio(Edificio e) {
		if(!repo.existsById(e.getId())){
			throw new EntityExistsException("L'edificio non esiste");
		} 
		repo.save(e);
		return "Edificio aggiornato";	
	}
	public Edificio findEdificioById(Long id) {
		return repo.findById(id).get();
	}
	public List<Edificio> findAllEdificio() {
		return (List<Edificio>) repo.findAll();
		
	}
}
