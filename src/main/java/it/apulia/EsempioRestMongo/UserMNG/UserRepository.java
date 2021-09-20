package it.apulia.EsempioRestMongo.UserMNG;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends MongoRepository<Utente, Long> {

    Optional<Utente> findUtenteByEmail(String email);
}
