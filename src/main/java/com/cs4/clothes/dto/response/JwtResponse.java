package com.cs4.clothes.dto.response;

import com.cs4.clothes.model.Cart;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtResponse {
    String token;
    private String type = "Bearer";
    private String name;
    private String avatar;
    private Cart cart;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public JwtResponse(String token, String type, String name, String avatar, Cart cart, Collection<? extends GrantedAuthority> roles) {
        this.token = token;
        this.type = type;
        this.name = name;
        this.avatar = avatar;
        this.cart = cart;
        this.roles = roles;
    }

    private Collection<? extends GrantedAuthority> roles;

    public JwtResponse() {
    }

//    public JwtResponse(String token, String type, String name, Collection<? extends GrantedAuthority> roles) {
//        this.token = token;
//        this.type = type;
//        this.name = name;
//        this.roles = roles;
//    }

    public JwtResponse(String token, String name, String avatar,Collection<? extends GrantedAuthority> authorities,Cart cart) {
        this.token = token;
        this.name = name;
        this.avatar = avatar;
        this.roles = authorities;
        this.cart = cart;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<? extends GrantedAuthority> roles) {
        this.roles = roles;
    }
}
