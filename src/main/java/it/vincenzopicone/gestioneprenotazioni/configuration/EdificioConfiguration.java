package it.vincenzopicone.gestioneprenotazioni.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;

import it.vincenzopicone.gestioneprenotazioni.model.Edificio;


@Configuration
public class EdificioConfiguration {
	
	@Bean("NuovoEdificio")
	@Scope("prototype")
	public Edificio nuovoEdificio(String nome, String indirizzo, String città) {
		return new Edificio(nome, indirizzo, città);
	}
	
	@Bean("FakeEdificio")
	@Scope("prototype")
	public Edificio fakeEdificio() {
		Faker fake = Faker.instance(new Locale("it_IT"));
		Edificio E = new Edificio();
		
		E.setNomeedificio(fake.company().name());
		E.setIndirizzo(fake.address().streetAddress() + fake.address().streetAddressNumber());
		E.setCitta(fake.address().city());
		
		return E;
	}

}
