package com.example.android.justjava;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity= 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void submitOrder(View view) {
        int price = quantity * 3;
        String priceMessage = "Total: $" + price;
        priceMessage = priceMessage + System.lineSeparator() + "Thank you!";
        displayMessage(priceMessage);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method is called each time the plus button is pressed and increases the quantity by one
     */
    public void increment(View view) {
        quantity++;
        display(quantity);
    }

    /**
     * This method is called each time the minus button is pressed and decreases the quantity by one
     */
    public void decrement(View view) {
        if (quantity > 0) {
            quantity--;
            display(quantity);
        } else {
            System.out.println("Can't have negative coffees");
        }

    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}