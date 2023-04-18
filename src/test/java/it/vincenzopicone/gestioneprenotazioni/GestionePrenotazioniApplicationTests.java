package it.vincenzopicone.gestioneprenotazioni;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import it.vincenzopicone.gestioneprenotazioni.controller.PrenotazioneController;

@SpringBootTest
class GestionePrenotazioniApplicationTests {
	
	@Autowired PrenotazioneController control;

	@Test
	void checkEndpoint() {
		control.showRulesLanguages("ita");
		assertEquals("Test ok","it");
		assertEquals("Test ok","en");
	}

}
