package com.example.mybeeradvisor;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickFindBeer(View view) {
        // Get a reference to the TextView
        TextView brands = (TextView) findViewById(R.id.brands);

        // Get a reference to the Spinnder
        Spinner color = (Spinner) findViewById(R.id.color);

        // Get the selected item in the Spinner
        String beerType = String.valueOf(color.getSelectedItem());

        // Display the selected item
        brands.setText(beerType);

            // Use the BeerExpert to get a List of brands
        List<String> brandsList = expert.getBrands(beerType);

        // Build a String and display each brand on a new line
        StringBuilder brandsFormatted = new StringBuilder();
        for (String brand : brandsList) {
            brandsFormatted.append(brand).append('\n');
        }

        // Display the beers from BeerExpert.java
        brands.setText(brandsFormatted);
    }
}
