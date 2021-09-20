package it.apulia.EsempioRestMongo.AccessManager;

import lombok.Data;

@Data
public class LoginDTO {
    String email;
    String password;
}
