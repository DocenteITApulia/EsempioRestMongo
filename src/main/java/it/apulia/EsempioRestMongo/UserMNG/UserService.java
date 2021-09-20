package it.apulia.EsempioRestMongo.UserMNG;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;

	}

	public boolean verifyEmail(String email) {
		return this.userRepository.findUtenteByEmail(email).isPresent();
	}

	public Utente getUser(String email) {
		return this.userRepository.findUtenteByEmail(email).get();
	}

	public List<String> getContacts(String email) {
		//TODO definire query nella repository ottimizzata
		return this.userRepository.findUtenteByEmail(email).get().contatti;
	}

	public boolean saveUser(UtenteDTO utente) {
		if(!this.verifyEmail(utente.getEmail())){
			Utente temp;
			if(utente.getContatti()==null)
				temp = new Utente(utente.nome,utente.cognome,utente.email,utente.password);
			else
				temp = new Utente(utente.nome,utente.cognome,utente.email,utente.password,utente.contatti);
			this.userRepository.save(temp);
			return true;
		}
		return false; //c'è già un utente
	}

	public boolean updateUser(Utente usr){
		if(!this.verifyEmail(usr.getEmail())){
			this.userRepository.save(usr);
			return true;
		}
		return false; //c'è già un utente
	}

	public void deleteUser(String email){
		if(this.verifyEmail(email)){
			this.userRepository.delete(this.getUser(email));
		}
	}



	public List<Utente> getAllUsers(){
		return this.userRepository.findAll();
	}


	/**
	 * verifica, al momento della registrazione, che le password siano equivalenti
	 * @param psw è il primo campo, quello che verrà poi salvato
	 * @param vpsw è il secondo campo, che viene confrontato con il primo
	 * @return ritorna un booleano che indica se le password siano uguali o meno
	 */
	public boolean verificaPassword(String psw, String vpsw) {
		return psw.equals(vpsw);
	}

}
