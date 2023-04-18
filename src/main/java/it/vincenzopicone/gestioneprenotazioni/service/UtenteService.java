package it.vincenzopicone.gestioneprenotazioni.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import it.vincenzopicone.gestioneprenotazioni.model.Utente;
import it.vincenzopicone.gestioneprenotazioni.repository.UtenteDAORepo;


@Service
public class UtenteService {
	
	@Autowired UtenteDAORepo repo;
	
	@Autowired @Qualifier("FakeUtente") private ObjectProvider<Utente> fakeUtenteProvider;
	@Autowired @Qualifier("CustomUtente") private ObjectProvider<Utente> customUtenteProvider;
	@Autowired @Qualifier("ParamsUtente") private ObjectProvider<Utente> paramsUtenteProvider;

	public void creaFakeUtente() {
		Utente U = fakeUtenteProvider.getObject();
		inserisciUtente(U);
	}
	public void creaCustomUtente() {
		Utente U = customUtenteProvider.getObject();
		inserisciUtente(U);
	}

	public void creaParamsUtente(String user, String nomin, String email) {
		Utente U = paramsUtenteProvider.getObject(user, nomin, email);
		inserisciUtente(U);
	}
	
	public void inserisciUtente(Utente u) {
		repo.save(u);
	}
	public void rimuoviUtente(Utente u) {
		repo.delete(u);

	}
	
	public void aggiornaUtente(Utente u) {
		repo.save(u);
		
	}
	public Utente findUtenteById(Long id) {
		return repo.findById(id).get();
	}
	public List<Utente> findAllUtente() {
		return (List<Utente>) repo.findAll();
		
	}
	
}
