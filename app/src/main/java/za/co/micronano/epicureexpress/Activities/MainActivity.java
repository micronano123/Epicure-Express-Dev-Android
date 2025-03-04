package za.co.micronano.epicureexpress.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import za.co.micronano.epicureexpress.Adapter.MenuAdapter;
import za.co.micronano.epicureexpress.Cart;
import za.co.micronano.epicureexpress.MenuItem;
import za.co.micronano.epicureexpress.R;

/**
 * MainActivity.java
 *
 */
public class MainActivity extends AppCompatActivity implements MenuAdapter.OnItemClickListener {

    private Cart cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cart = new Cart();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Burger", "Delicious burger with all the fixings", 10.99, R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("Pizza", "Cheesy pizza with a variety of toppings", 12.99, R.drawable.ic_launcher_foreground));
        menuItems.add(new MenuItem("Salad", "Fresh and healthy salad with a variety of greens", 8.99, R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("Pasta", "Classic pasta with a variety of sauces", 11.99, R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("Sushi", "Assorted sushi rolls with a variety of choices", 14.99, R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("Steak", "Juicy steak with a variety of cuts", 16.99, R.drawable.ic_launcher_background));

        MenuAdapter adapter = new MenuAdapter(menuItems);
        recyclerView.setAdapter(adapter);

        Button btnCheckout = findViewById(R.id.btnCheckout);
        btnCheckout.setOnClickListener(v->{
            Toast.makeText(getApplicationContext(), "Checkout button clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, CheckoutActivity.class);
            intent.putParcelableArrayListExtra("cartItems", new ArrayList<>(cart.getItems()));
            startActivity(intent);
        });
    }

    public void onAddToCartClick(MenuItem item) {
        cart.addItem(item);

    }

}