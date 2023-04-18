package it.vincenzopicone.gestioneprenotazioni.repository;

import org.springframework.data.repository.CrudRepository;

import it.vincenzopicone.gestioneprenotazioni.model.Postazione;


public interface PostazioneDAORepo extends CrudRepository<Postazione, Long>{

}
