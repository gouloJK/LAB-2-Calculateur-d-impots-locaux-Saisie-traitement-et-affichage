package com.example.lab_2_calculateur_d_impots_locaux_saisie_traitement_et_affichage;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    // Declaration of UI elements
    private EditText etArea, etRooms;
    private CheckBox cbSwimmingPool;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link XML <-> Java
        etArea = findViewById(R.id.et_area);
        etRooms = findViewById(R.id.et_rooms);
        cbSwimmingPool = findViewById(R.id.cb_swimming_pool);
        tvResult = findViewById(R.id.tv_result);

        // Calculate button listener
        Button btnCalculate = findViewById(R.id.btn_calculate);
        btnCalculate.setOnClickListener(v -> calculate());
    }

    private void calculate() {
        // Read input values
        double area = Double.parseDouble(etArea.getText().toString());
        int rooms = Integer.parseInt(etRooms.getText().toString());
        boolean hasSwimmingPool = cbSwimmingPool.isChecked();


        // Tax calculation
        double baseTax = area * 2;
        double additionalTax = rooms * 50 + (hasSwimmingPool ? 100 : 0);
        double totalTax = baseTax + additionalTax;

        // Display result
        tvResult.setText("Total Tax: " + totalTax + " DH");
    }
}