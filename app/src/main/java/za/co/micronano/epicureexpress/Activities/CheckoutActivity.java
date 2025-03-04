package za.co.micronano.epicureexpress.Activities;

import static java.lang.String.format;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import za.co.micronano.epicureexpress.Adapter.CartAdapter;
import za.co.micronano.epicureexpress.MenuItem;
import za.co.micronano.epicureexpress.R;

public class CheckoutActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Checkout");

        List<MenuItem> cartItems = getIntent().getParcelableArrayListExtra("cartItems");

        RecyclerView recyclerView = findViewById(R.id.recyclerViewCart);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CartAdapter adapter = new CartAdapter(cartItems);
        recyclerView.setAdapter(adapter);

        double totalPrice = 0;
        assert cartItems != null;
        for (MenuItem item : cartItems) {
            totalPrice += item.getPrice() * item.getQuantity();
        }

        TextView totalPriceView = findViewById(R.id.totalPrice);
        totalPriceView.setText(format("Total: R%.2f", totalPrice));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull android.view.MenuItem item) {
        startActivity(new Intent(this, MainActivity.class));
        return super.onOptionsItemSelected(item);
    }
}