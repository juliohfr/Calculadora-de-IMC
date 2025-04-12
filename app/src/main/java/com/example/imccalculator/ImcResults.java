package com.example.imccalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ImcResults extends Activity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("Ciclo de vida", this.getClassName() + ".onCreate() chamado.");

        this.setContentView(R.layout.imc_results);

        final String name = this.getIntent().getStringExtra("user");
        final Integer age = this.getIntent().getIntExtra("age", 0);
        final Double weight = this.getIntent().getDoubleExtra("weight", 0.0);
        final Double height = this.getIntent().getDoubleExtra("height", 0.0);

        final Double imc = weight / (height * height);
        String category = "";

        if (imc < 18.50) {
            category = "Abaixo do peso";
        } else if (imc <= 24.90) {
            category = "Saudável";
        } else if (imc <= 29.90) {
            category = "Sobrepeso";
        } else if (imc <= 34.90) {
            category = "Obesidade Grau I";
        } else if (imc <= 39.90) {
            category = "Obesidade Grau II (severa)";
        } else {
            category = "Obesidade Grau III (mórbida)";
        }
        final TextView nameText = this.findViewById(R.id.nameText);
        final TextView ageText = this.findViewById(R.id.ageText);
        final TextView weightText = this.findViewById(R.id.weightText);
        final TextView heightText = this.findViewById(R.id.heightText);
        final TextView imcText = this.findViewById(R.id.imcText);
        final TextView categoryText = this.findViewById(R.id.categoryText);

        nameText.setText(name);
        ageText.setText(age.toString());
        weightText.setText(weight.toString());
        heightText.setText(height.toString());
        imcText.setText(String.format("%.2f", imc));
        categoryText.setText(category);
    }

    private String getClassName() {
        final String className = this.getClass().getName();
        return className;
    }

    protected void onStart() {
        super.onStart();
        Log.i("Ciclo de vida", this.getClassName() + ".onStart() chamado.");
    }

    protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo de vida", this.getClassName() + ".onRestart() chamado.");
    }

    protected void onResume() {
        super.onResume();
        Log.i("Ciclo de vida", this.getClassName() + ".onResume() chamado.");
    }

    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de vida", this.getClassName() + ".onPause() chamado.");
    }

    protected void onStop() {
        super.onStop();
        Log.i("Ciclo de vida", this.getClassName() + ".onStop() chamado.");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo de vida", this.getClassName() + ".onDestroy() chamado.");
    }

    public void goBackToForm(final View view) {
        final Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intent);
        this.finish();
    }
}
