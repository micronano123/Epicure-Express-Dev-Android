package za.co.micronano.epicureexpress.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.util.List;

import za.co.micronano.epicureexpress.MenuItem;
import za.co.micronano.epicureexpress.R;

public class CartAdapter extends Adapter<CartAdapter.ViewHolder>
{
    private List<MenuItem> cartItems;

    public CartAdapter(List<MenuItem>cartItems){
        this.cartItems = cartItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cart, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {
        MenuItem item = cartItems.get(position);
        holder.itemName.setText(item.getName());
        holder.itemQuantity.setText("Quantity: " + item.getQuantity());
        holder.itemPrice.setText(String.format("$%.2f", item.getPrice() * item.getQuantity()));
    }


    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView itemName;
        public TextView itemQuantity;
        public TextView itemPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.itemName);
            itemQuantity = itemView.findViewById(R.id.itemQuantity);
            itemPrice = itemView.findViewById(R.id.itemPrice);
        }

    }
}
