package com.project.product.security;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TokenValidator {

    public Optional<JWTObject> validate(String token){
        return  Optional.empty();
    }
}
