package com.cs4.clothes.security.userpincal;

import com.cs4.clothes.model.Cart;
import com.cs4.clothes.model.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserPrinciple implements UserDetails {
    private Long id;
    private String name;
    private String username;
    private String email;

    @JsonIgnore
    private String password;
    private String avatar;
    private boolean enabled = false;
    private boolean locked = false;
    private Cart cart;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<? extends GrantedAuthority> roles) {
        this.roles = roles;
    }

    public UserPrinciple(Long id, String name, String username, String email, String password, String avatar, boolean enabled, boolean locked, Cart cart, Collection<? extends GrantedAuthority> roles) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.enabled = enabled;
        this.locked = locked;
        this.cart = cart;
        this.roles = roles;
    }

    public UserPrinciple(Long id, String name, String username, String email, String password, String avatar, boolean enabled, boolean locked, Collection<? extends GrantedAuthority> roles) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.enabled = enabled;
        this.locked = locked;
        this.roles = roles;
    }

    private Collection<? extends GrantedAuthority> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    public UserPrinciple() {
    }

    public UserPrinciple(Long id, String name, String username, String email, String password, String avatar, Collection<? extends GrantedAuthority> roles, Cart cart) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.roles = roles;
        this.cart = cart;

    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public static UserPrinciple build(Users users) {
        List<GrantedAuthority> authorities = users.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());
        return new UserPrinciple(
                users.getId(),
                users.getName(),
                users.getUsername(),
                users.getEmail(),
                users.getPassword(),
                users.getAvatar(),
                authorities,
                users.getCart()
        );
    }

    public String getAvatar() {
        return avatar;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
