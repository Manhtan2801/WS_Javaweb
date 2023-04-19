/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tan.object;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Acer
 */
public class CartObject implements Serializable {

    //hàng của ai
    private String customerID;
    //hàng gồm của ai (số lượng)
    private Map<String, Integer> items;

    /**
     * @return the customerID
     */
    public String getCustomerID() {
        return customerID;
    }

    /**
     * @param customerID the customerID to set
     */
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    /**
     * @return the items
     */
    public Map<String, Integer> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(Map<String, Integer> items) {
        this.items = items;
    }

    public void addItemsToCart(String title) {
        if (items == null) {
            items = new HashMap<String, Integer>();
        }
        int quantity = 1;
        if (this.items.containsKey((title))) {
            quantity = this.items.get(title) + 1;

        }
        items.put(title, quantity);

    }

    public void removeItemFromCart(String title) {
        if (items == null) {
            return;
        }
        if (items.containsKey(title)) {
            items.remove(title);
            if (items.isEmpty()) {
                items = null;
            }
        }
    }
}
