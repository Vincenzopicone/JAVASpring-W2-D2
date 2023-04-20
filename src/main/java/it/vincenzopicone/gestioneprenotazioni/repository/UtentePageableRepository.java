package it.vincenzopicone.gestioneprenotazioni.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import it.vincenzopicone.gestioneprenotazioni.model.*;

/// si possono estendere insieme sia CRUD che PaginAndSorting
public interface UtentePageableRepository extends PagingAndSortingRepository<Utente, Long> {

	
	
}
