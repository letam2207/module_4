package com.example.ss10_ung_dung_gio_hang.service;

import com.example.ss10_ung_dung_gio_hang.entity.Cart;
import com.example.ss10_ung_dung_gio_hang.entity.Product;

public interface ICartService {
    Cart addItem(Cart cart, Product product, int quantity);

    Cart updateItem(Cart cart, Integer productId, int quantity);

    Cart removeItem(Cart cart, Integer productId);

    double getTotalPrice(Cart cart);

    int getTotalQuantity(Cart cart);
}
