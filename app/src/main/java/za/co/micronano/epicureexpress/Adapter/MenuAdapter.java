package za.co.micronano.epicureexpress.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import za.co.micronano.epicureexpress.MenuItem;
import za.co.micronano.epicureexpress.R;

/**
 * This adapter binds the menu items to the RecyclerView.
 * @author takatsomolekane
 */
public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private List<MenuItem> menuItems;
    private OnItemClickListener listener;


    public interface OnItemClickListener {
        void onAddToCartClick(MenuItem item);
    }

    public MenuAdapter(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_menu,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MenuItem item = menuItems.get(position);
        holder.itemName.setText(item.getName());
        holder.itemDescription.setText(item.getDescription());
        holder.itemPrice.setText(String.format("R%.2f", item.getPrice()));
        holder.itemImage.setImageResource(item.getImageResId());

        switch (item.getName()) {
            case "Burger":
                holder.itemImage.setImageResource(R.drawable.ic_launcher_foreground);
                break;
            case "Pizza":
                holder.itemImage.setImageResource(R.drawable.ic_launcher_foreground);
                break;
            case "Pasta":
                holder.itemImage.setImageResource(R.drawable.ic_launcher_foreground);
                break;
            case "Salad":
                holder.itemImage.setImageResource(R.drawable.ic_launcher_foreground);
                break;
            default:
                holder.itemImage.setImageResource(R.drawable.ic_launcher_foreground);
        }

        holder.btnAddToCart.setOnClickListener(v->{
            if (listener != null){
                listener.onAddToCartClick(item);
            }
        });

    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView itemImage;
        public TextView itemName;
        public TextView itemDescription;
        public TextView itemPrice;
        public Button btnAddToCart;

        public ViewHolder(View itemView){
            super(itemView);
            itemImage = itemView.findViewById(R.id.itemImage);
            itemName = itemView.findViewById(R.id.itemName);
            itemDescription = itemView.findViewById(R.id.itemDescription);
            itemPrice = itemView.findViewById(R.id.itemPrice);
            btnAddToCart = itemView.findViewById(R.id.btnAddToCart);
        }
    }
}
