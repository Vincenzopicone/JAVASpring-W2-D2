package it.vincenzopicone.gestioneprenotazioni.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="prenotazioni")
public class Prenotazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Utente utente;
	@ManyToOne
	private Postazione postazione;
	@Column(nullable=false)
	private LocalDate dataprenotazione;
	
	
	
	public Prenotazione(Utente utente, Postazione postazione, LocalDate data) {
		super();
		this.utente = utente;
		this.postazione = postazione;
		this.dataprenotazione = data;
	}
	
	

}
