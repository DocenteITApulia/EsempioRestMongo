package it.apulia.EsempioRestMongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EsempioRestMongoApplication {

	/* ISTRUZIONI PER L'AVVVIO
	- aprire da terminale il path root ("/") nella quale è presente il progetto, verificando dunque che il file
	docker-compose.yml sia allo stesso livello della cartella src;
	- eseguire il comando docker-compose up, verificando che vada a buon fine;
	- a questo punto, aprendo in un browser l'indirizzo http://localhost:8081/ dovrebbe apparire la schermata di mongo-express
	- creare un db tramite l'apposita casella in alto a destra, specificando lo stesso nome indicato in application.properties del db
	*/
	public static void main(String[] args) {
		SpringApplication.run(EsempioRestMongoApplication.class, args);
	}

}
