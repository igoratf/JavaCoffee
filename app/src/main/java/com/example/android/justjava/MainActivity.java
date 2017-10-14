package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity;
    CheckBox whippedCream;
    CheckBox chocolate;
    EditText customerNameEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quantity = 0;
        whippedCream = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        chocolate = (CheckBox) findViewById(R.id.chocolate_checkbox);
        customerNameEditText = (EditText) findViewById(R.id.name_field);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        /*
        Method will be fixed later on
         */
        boolean hasWhippedCream = whippedCream.isChecked();
        boolean hasChocolate = chocolate.isChecked();
        String customerName = getCustomerName();
        int price = calculatePrice(hasWhippedCream, hasChocolate, quantity);
        String summary = createOrderSummary(customerName, hasWhippedCream, hasChocolate, price);
        displayMessage(summary);
    }


    /**
     * This method is called each time the plus button is pressed and increases the quantity by one
     */
    public void increment(View view) {
        if (quantity <= 100) {
            quantity++;
        } else {
            Toast.makeText(this, "Can't have more than 100 coffees", Toast.LENGTH_SHORT).show();
        }
        display(quantity);
    }

    /**
     * This method is called each time the minus button is pressed and decreases the quantity by one
     */
    public void decrement(View view) {
        if (quantity > 0) {
            quantity--;
        } else {
            Toast.makeText(this, "Can't have negative coffees", Toast.LENGTH_SHORT).show();
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
    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate, int number) {
        int price = number * 3;
        if (hasWhippedCream) price += 1;
        if (hasChocolate) price += 2;
        return price;
    }

    /**
     * Creates order summary
     * @param name is the name of the customer
     * @param addWhippedCream checks if customer wants whipped cream topping
     * @param addChocolate checks if customer wants chocolate topping
     * @param price is the order total price
     * @return order summary
     */

    private String createOrderSummary(String name, boolean addWhippedCream, boolean addChocolate, int price) {
        /*
        Method will be fixed later on
         */
        String summary = "Name: " + name;
        summary +=     "\n" + "Add whipped cream? " + addWhippedCream;
        summary += "\n" + "Add chocolate? " + addChocolate;
        summary += "\n" + "Quantity: " + quantity;
        summary += "\n" + "Total: $" + price;
        summary += "\n" + "Thank you!";
        return summary;
    }

    /**
     * Returns customer name
     * @return customer name
     */
    private String getCustomerName() {
        return String.valueOf(customerNameEditText.getText());
    }



}