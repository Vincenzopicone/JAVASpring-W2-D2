package it.vincenzopicone.gestioneprenotazioni.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;

import it.vincenzopicone.gestioneprenotazioni.model.Utente;


@Configuration
public class UtenteConfiguration {
	@Bean("FakeUtente")
	@Scope("prototype")
	public Utente fakeUtente() {
		Faker fake = Faker.instance(new Locale("it_IT"));
		Utente U = new Utente();
		U.setNominativo(fake.name().fullName());
		U.setUsername(U.getNominativo() + fake.number().randomDigit());
		U.setEmail(U.getNominativo() + "@example.com");
		return U;
	}
	
	@Bean("CustomUtente")
	@Scope("prototype")
	public Utente customUtente () {
		return new Utente();
	}
	
	@Bean("ParamsUtente")
	@Scope("prototype")
	public Utente paramsUser (String user, String nomin, String email) {
		return new Utente(user, nomin, email);
	}
	

}
