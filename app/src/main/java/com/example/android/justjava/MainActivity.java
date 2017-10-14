package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;


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
        /*
        Method will be fixed later on
         */
        int price = calculatePrice(quantity);
        String summary = createOrderSummary("Igor Farias", price);
        displayMessage(summary);
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
        } else {
            System.out.println("Can't have negative coffees");
        }
        display(quantity);

    }

    public void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(number));
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
        /*
        Method will be fixed later on
         */
        CheckBox whippedCream = (CheckBox) findViewById(R.id.checkBox);
        String topping = "";
        if (whippedCream.isChecked()) {
            topping = "yes";
        } else {
            topping = "no";
        }
        String summary = "Name: " + name + "\n" + "Add whipped cream? " + topping +  "\n" + "Quantity: " + quantity + "\n" + "Total: $" + price + "\n" + "Thank you!";
        return summary;
    }


}