package it.vincenzopicone.gestioneprenotazioni.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.vincenzopicone.gestioneprenotazioni.model.Postazione;
import it.vincenzopicone.gestioneprenotazioni.model.Prenotazione;
import it.vincenzopicone.gestioneprenotazioni.model.Utente;





@Repository
public interface PrenotazioneDAORepo extends CrudRepository<Prenotazione, Long> {
	
	//public List<Prenotazione> findById_utente (Long id);

	@Query(value="SELECT p FROM Prenotazione p INNER JOIN utente u WHERE u = :utente")
	public List<Prenotazione> listaDiUtenti(Utente utente);
	
	@Query(value = "SELECT p FROM Prenotazione p INNER JOIN utente u WHERE u = :utente AND dataprenotazione = :data")
	public List<Prenotazione> listaDiUtentiConData(Utente utente, LocalDate data);
	
	@Query(value = "SELECT p FROM Prenotazione p INNER JOIN postazione ps WHERE ps = :post AND dataprenotazione = :data")
	public List<Prenotazione> listaDiPostazioniConData(Postazione post, LocalDate data);
}
