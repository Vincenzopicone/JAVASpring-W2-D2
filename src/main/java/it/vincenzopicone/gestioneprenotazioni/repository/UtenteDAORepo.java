package it.vincenzopicone.gestioneprenotazioni.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.vincenzopicone.gestioneprenotazioni.model.Utente;

@Repository
public interface UtenteDAORepo extends CrudRepository<Utente, Long> {

}
