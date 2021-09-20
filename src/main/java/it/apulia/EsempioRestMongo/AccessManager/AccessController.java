package it.apulia.EsempioRestMongo.AccessManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "accessmng")
public class AccessController {

    private final LoginService loginService;

    @Autowired
    public AccessController(LoginService loginService){
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public boolean loginPost(
            @RequestBody LoginDTO formLogin) {
        return this.loginService.verifyPasswordUtente(formLogin);
    }
}
