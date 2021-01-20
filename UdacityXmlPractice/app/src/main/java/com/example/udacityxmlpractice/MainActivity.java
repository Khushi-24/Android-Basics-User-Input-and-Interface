package com.example.udacityxmlpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {

//        displayPrice(quantity*5);
       // int price = quantity * 5;
        int price = calculatePrice(quantity, 5);
        String summary = createOrderSummary(price);
        String subject = getString(R.string.order_summary_email_subject, name());
        composeEmail(subject , summary);

    }

    public void composeEmail( String subject, String summary) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
       // intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, summary);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private String createOrderSummary(int number){
        String info = getString(R.string.order_summary_name, name());
        info +="\n" + getString(R.string.order_summary_whipped_cream, checkbox());
        info +="\n" + getString(R.string.order_summary_chocolate, checkbox_choclate());
        info +="\n" + getString(R.string.order_summary_quantity, quantity) ;
        info += "\n" + getString(R.string.order_summary_price,number);
        info += "\n" + getString(R.string.thank_you);
        return info;
    }


    private boolean checkbox(){
        CheckBox whipcream = (CheckBox) findViewById(R.id.whipCream_checkbox);
        boolean checkbox_whip = whipcream.isChecked();
        return checkbox_whip;
    }

    private boolean checkbox_choclate(){
        CheckBox choclate =(CheckBox) findViewById(R.id.choclate_checkbox);
        boolean checkbox_choclate =choclate.isChecked();
        return checkbox_choclate;
    }

    private String name(){
        EditText userName = (EditText) findViewById(R.id.name);
        String displayName= userName.getText().toString();
        return displayName;
    }

    private int calculatePrice( int quantity, int pricePerCup){
        if(checkbox()== true)
        {
            pricePerCup +=1;
        }
        if(checkbox_choclate()==true)
        {
            pricePerCup +=2;
        }

        return quantity * pricePerCup;
    }


    public void increment(View view) {

        if(quantity == 100)
        {
            Toast.makeText(this, "You can't have more than 100 cups of coffes", Toast.LENGTH_SHORT).show();
            return;
        }

        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    private void displayQuantity(int i) {
        TextView t1= (TextView) findViewById(R.id.text);
        t1.setText("" + i);
    }

//    private void displayPrice(int number) {
//        TextView priceTextView = (TextView) findViewById(R.id.text2);
//        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
//    }

    public void decrement(View view) {
        if(quantity < 2)
        {
            Toast.makeText(this, "You can't have less than 1 cup of coffes", Toast.LENGTH_SHORT).show();
            return;
        }

            quantity = quantity - 1;
            displayQuantity(quantity);

    }

    /**
     * This method displays the given text on the screen.
//     */
//    private void displayMessage(String message) {
//        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_textview);
//        orderSummaryTextView.setText(message);
//    }


}