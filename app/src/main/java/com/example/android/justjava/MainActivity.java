package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quantity = 0;
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice(quantity);
        String summary = createOrderSummary("Igor Farias", price);
        displayMessage(summary);
    }


    /**
     * This method is called each time the plus button is pressed and increases the quantity by one
     */
    public void increment(View view) {
        quantity++;
    }

    /**
     * This method is called each time the minus button is pressed and decreases the quantity by one
     */
    public void decrement(View view) {
        if (quantity > 0) {
            quantity--;
        } else {
            System.out.println("Can't have negative coffees");
        }

    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(message);
    }

    /**
     * Calculates the price of the order
     * @param number is the quantity of coffees
     * @return total value of the order
     */
    private int calculatePrice(int number) {
        return number * 3;
    }

    /**
     * Creates order summary
     * @param name of the customer
     * @param price of the order
     * @return summary
     */
    private String createOrderSummary(String name, int price) {
        String summary = "Name: " + name + "\n" + "Quantity: " + quantity + "\n" + "Total: $" + price + "\n" + "Thank you!";
        return summary;
    }
}