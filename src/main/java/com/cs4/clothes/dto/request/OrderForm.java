package com.cs4.clothes.dto.request;

import com.cs4.clothes.model.CartDetail;
import com.cs4.clothes.model.Product;

import java.util.List;

public class OrderForm {
    private String username;
    private List<CartDetail> cartDetailList;
    private double total;

    public OrderForm(String username, List<CartDetail> cartDetailList, double total) {
        this.username = username;
        this.cartDetailList = cartDetailList;
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<CartDetail> getCartDetailList() {
        return cartDetailList;
    }

    public void setCartDetailList(List<CartDetail> cartDetailList) {
        this.cartDetailList = cartDetailList;
    }
}
