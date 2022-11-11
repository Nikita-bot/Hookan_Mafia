package ru.pazdrin.store.resources.model.middlewhere;

import java.util.Arrays;
import java.util.List;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;


public class JWToken {
    public static String generateToken(Integer id, String name, Integer role){
        String token="";
        Algorithm algorithm = null;
        try {
            algorithm = Algorithm.HMAC256("CATS");
            token = JWT.create()
                .withClaim("Id", id)
                .withClaim("Name", name)
                .withClaim("Role", role)
                .sign(algorithm);
        } catch (JWTCreationException exception){
            return "Ошибка при создании токена";
        }
        return token;
    }

    public static String verifyToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256("CATS");
            JWTVerifier verifier = JWT.require(algorithm)
            .build();
            verifier.verify(token);
            return "Ok";
        }
        catch(JWTVerificationException e){
            return "Invalid token";
        }        
    }

    public static List<String> decodeToken(String token){
        Algorithm algorithm = Algorithm.HMAC256("CATS");
            JWTVerifier verifier = JWT.require(algorithm)
            .build();
        DecodedJWT jwt = verifier.verify(token);
        List<String> result = Arrays.asList(jwt.getClaim("Id").toString(),jwt.getClaim("Name").toString(),jwt.getClaim("Role").toString());
        return result;
    }
    
}
