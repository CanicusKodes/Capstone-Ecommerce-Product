package com.project.product.security;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JWTObject {

    private String email;
    private String userId;
    private String createdAt;
    private String expiresAt;
    private List<Role> roles;
}
