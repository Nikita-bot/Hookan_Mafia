package ru.pazdrin.store.resources.model.middlewhere;

import java.util.List;
import ru.pazdrin.store.resources.model.Repositorys.UserRepository;
import ru.pazdrin.store.resources.model.entitys.User;

public class ChekerToken extends JWToken {

    public static User check(String token){
        List<String> params = null;
        String verification = JWToken.verifyToken(token);
        if(verification.equals("Ok")){
            params = JWToken.decodeToken(token);
            UserRepository ur = new UserRepository();
            User user = ur.getUserById(Integer.parseInt(params.get(0)));

            if(user != null && user.getName().equals(params.get(1).split("\"")[1]) && user.getRole() == Integer.parseInt(params.get(2))){
                return user;
            }
            else return user = null;
        }
        else{
            return null;
        }
    }
    
}
