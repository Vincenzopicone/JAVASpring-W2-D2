package it.vincenzopicone.gestioneprenotazioni.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="utenti")
public class Utente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique= true)
	private String username;
	@Column(nullable = false)
	private String nominativo;
	@Column(nullable = false, unique= true)
	private String email;
	@OneToMany (mappedBy="utente", cascade= CascadeType.ALL)
	private List<Prenotazione> prenotazione;
	
	
	public Utente(String username, String nominativo, String email) {
		super();
		this.username = username;
		this.nominativo = nominativo;
		this.email = email;
	}
	
	

}
