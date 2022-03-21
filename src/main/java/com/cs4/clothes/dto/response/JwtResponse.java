package com.cs4.clothes.dto.response;

import com.cs4.clothes.model.Cart;
import com.cs4.clothes.model.CartDetail;
import com.cs4.clothes.model.Category;
import com.cs4.clothes.model.Product;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

public class JwtResponse {
    private String username;
    String token;
    private String type = "Bearer";
    private String name;
    private String avatar;
    private Cart cart;
    private List<CartDetail> cartDetailList;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<CartDetail> getCartDetailList() {
        return cartDetailList;
    }

    public void setCartDetailList(List<CartDetail> cartDetailList) {
        this.cartDetailList = cartDetailList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public JwtResponse(String token, String type, String name, String avatar, Collection<? extends GrantedAuthority> roles,String username,Cart cart,List<CartDetail> cartDetailList) {
        this.token = token;
        this.type = type;
        this.name = name;
        this.avatar = avatar;
        this.cart = cart;
        this.cartDetailList = cartDetailList;
        this.roles = roles;
        this.username=username;
    }
    public JwtResponse(String token, String name, String avatar, Collection<? extends GrantedAuthority> authorities, List<CartDetail> cartDetailList, String username,Cart cart) {
        this.token = token;
        this.name = name;
        this.avatar = avatar;
        this.roles = authorities;
        this.cartDetailList = cartDetailList;
        this.username = username;
        this.cart= cart;
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



    public JwtResponse(String token, String name, String avatar, Collection<? extends GrantedAuthority> authorities,String username) {
        this.token = token;
        this.name = name;
        this.avatar = avatar;
        this.roles = authorities;

        this.username = username;

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
