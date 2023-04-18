package it.vincenzopicone.gestioneprenotazioni.model;

import java.util.List;

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
@Table(name="edifici")
public class Edificio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nomeedificio;
	@Column(nullable = false)
	private String indirizzo;
	@Column(nullable = false)
	private String citta;
	
	@OneToMany(mappedBy="edificio")
	private List<Postazione> postazione;

	public Edificio(String nome_edificio, String indirizzo, String citta) {
		super();
		this.nomeedificio = nome_edificio;
		this.indirizzo = indirizzo;
		this.citta = citta;
	}
	
	

}
