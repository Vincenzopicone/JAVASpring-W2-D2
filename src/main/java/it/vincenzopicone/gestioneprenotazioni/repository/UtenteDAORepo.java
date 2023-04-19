package it.vincenzopicone.gestioneprenotazioni.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.vincenzopicone.gestioneprenotazioni.model.Utente;


public interface UtenteDAORepo extends CrudRepository<Utente, Long> {
	public Utente findByEmail (String email);
	public boolean existsByEmail (String email);

}
