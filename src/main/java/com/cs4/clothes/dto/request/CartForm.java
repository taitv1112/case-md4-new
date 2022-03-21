package com.cs4.clothes.dto.request;

import com.cs4.clothes.model.Cart;
import com.cs4.clothes.model.CartDetail;
import com.cs4.clothes.model.OrderDetail;

import javax.persistence.criteria.Order;
import java.util.List;

public class CartForm {
    private String username;
    private List<CartDetail> cartDetailList;
    private Cart cart;

    public CartForm(String username, Cart cart,List<CartDetail> cartDetailList) {
        this.username = username;
        this.cart = cart;
        this.cartDetailList = cartDetailList;
    }

    public String getUsername() {
        return username;
    }

    public List<CartDetail> getCartDetailList() {
        return cartDetailList;
    }

    public void setCartDetailList(List<CartDetail> cartDetailList) {
        this.cartDetailList = cartDetailList;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
