package it.vincenzopicone.gestioneprenotazioni.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.vincenzopicone.gestioneprenotazioni.model.Edificio;
import it.vincenzopicone.gestioneprenotazioni.model.Postazione;
import it.vincenzopicone.gestioneprenotazioni.model.TipoPostazione;

@Configuration
public class PostazioneConfiguration {
	
	@Bean("NuovaPostazione")
	@Scope("prototype")
	public Postazione nuovaPostazione() {
		return new Postazione();
	}
	@Bean("ParamsPostazione")
	@Scope("prototype")
	public Postazione paramsPostazione(String descr, TipoPostazione tipo, 
			int numMax, Edificio edif) {
		return new Postazione(descr, tipo, numMax, edif);
	}

}
