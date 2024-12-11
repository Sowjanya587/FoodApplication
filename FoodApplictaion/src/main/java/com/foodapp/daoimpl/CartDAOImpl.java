package com.foodapp.daoimpl;

import com.foodapp.dao.CartDAO;
import com.foodapp.model.CartItem;
import java.util.HashMap;
import java.util.Map;

public class CartDAOImpl implements CartDAO {
    private Map<Integer, CartItem> items = new HashMap<>();

    @Override
    public Map<Integer, CartItem> addItem(CartItem item) {
        int itemId = item.getItemid();    
        if (items.containsKey(itemId)) {   
            CartItem existingItem = items.get(itemId);
            existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
        } else {
            items.put(itemId, item);
        }
        return items;
    }

    @Override
    public void updateItem(int itemId, int quantity) {
        if (items.containsKey(itemId)) {
            if (quantity <= 0) {
                items.remove(itemId);
            } else {
                items.get(itemId).setQuantity(quantity);
            }
        }
    }

    @Override
    public void removeItem(int itemId) {
        items.remove(itemId);
    }

    @Override
    public Map<Integer, CartItem> getItems() {
        return items;
    }
}
