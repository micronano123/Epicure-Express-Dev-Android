package za.co.micronano.epicureexpress;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<MenuItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item){
        items.add(item);
    }

    public List<MenuItem>getItems(){
        return items;
    }

    public double getTotalPrice(){
        double total = 0;
        for(MenuItem item:items){
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
    public void clearCart(){
        items.clear();
    }
}
