package it.apulia.EsempioRestMongo.UserMNG;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Utente {

	@Id
	String userId;
	String nome;
	String cognome;
	@Indexed(unique = true)
	String email;
	String password;
	List<String> contatti;

	public Utente(String nome, String cognome, String email, String password) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
	}

	public Utente(String nome, String cognome, String email, String password, List<String> contatti) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.contatti = contatti;
	}

}
