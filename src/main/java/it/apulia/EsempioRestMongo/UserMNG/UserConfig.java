package it.apulia.EsempioRestMongo.UserMNG;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            Utente gennaro = new Utente("Gennaro", "Bullo", "loveweedle@email.it", "il0vweedle");
            Utente tatiana = new Utente("Tatiana", "Fungirl", "t.girl@email.it", "qwerty1");


            repository.deleteAll();

            repository.saveAll(
                    List.of(gennaro,tatiana)
            );
        };

    }
}
