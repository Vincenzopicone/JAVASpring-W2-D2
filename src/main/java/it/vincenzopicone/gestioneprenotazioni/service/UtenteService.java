package it.vincenzopicone.gestioneprenotazioni.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.vincenzopicone.gestioneprenotazioni.model.Utente;
import it.vincenzopicone.gestioneprenotazioni.repository.UtenteDAORepo;
import it.vincenzopicone.gestioneprenotazioni.repository.UtentePageableRepository;
import jakarta.persistence.EntityExistsException;


@Service
public class UtenteService {
	
	@Autowired UtenteDAORepo repo;
	@Autowired UtentePageableRepository repoUte;
	
	@Autowired @Qualifier("FakeUtente") private ObjectProvider<Utente> fakeUtenteProvider;
	@Autowired @Qualifier("CustomUtente") private ObjectProvider<Utente> customUtenteProvider;
	@Autowired @Qualifier("ParamsUtente") private ObjectProvider<Utente> paramsUtenteProvider;

	public Utente creaFakeUtente() {
		Utente U = fakeUtenteProvider.getObject();
		inserisciUtente(U);
		return U;
	}
	public Utente creaCustomUtente() {
		Utente U = customUtenteProvider.getObject();
		inserisciUtente(U);
		return U;
	}
	public Page<Utente> getAllUtentiPageable (Pageable pag) {
		return (Page<Utente>) repoUte.findAll(pag);	
	}

	public Utente creaParamsUtente(Utente u) {
		Utente U = paramsUtenteProvider.getObject();
		inserisciUtente(U);
		return U;
	}
	
	public Utente inserisciUtente(Utente u) {
		if(repo.existsByEmail(u.getEmail())) {
			throw new EntityExistsException("L'email esiste");
		} else {
		repo.save(u);
		}
		return u;
	}
	public String rimuoviUtente(Long id) {
		if(!repo.existsById(id)){
			throw new EntityExistsException("L'utente non esiste");
		} 
		repo.deleteById(id);
		return "User deleted";

	}
	
	public String aggiornaUtente(Utente u) {
		if(!repo.existsById(u.getId())){
			throw new EntityExistsException("L'utente non esiste");
		} 
		repo.save(u);
		return "Utente aggiornato";
		
	}
	public Utente findUtenteById(Long id) {
		return repo.findById(id).get();
	}
	public List<Utente> findAllUtente() {
		return (List<Utente>) repo.findAll();
		
	}
	
}
