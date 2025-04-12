package com.example.imccalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("Ciclo de vida", this.getClassName() + ".onCreate() chamado.");

        this.setContentView(R.layout.activity_main);
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

    public void generateReport(final View view) {
        final EditText name = this.findViewById(R.id.nameText);
        final EditText age = this.findViewById(R.id.ageText);
        final EditText weight = this.findViewById(R.id.weightText);
        final EditText height = this.findViewById(R.id.heightText);

        if (name.getText().toString().trim().isEmpty()) {
            name.setError("Campo obrigatório!");
            return;
        }

        if (age.getText().toString().isEmpty()) {
            age.setError("Campo obrigatório!");
            return;

        } else if (Integer.parseInt(age.getText().toString()) == 0) {
            age.setError("Idade inválida!");
            return;
        }

        if (weight.getText().toString().isEmpty()) {
            weight.setError("Campo obrigatório!");
            return;

        } else if (Double.parseDouble(weight.getText().toString()) == 0.0) {
            weight.setError("Peso inválido!");
            return;
        }

        if (height.getText().toString().isEmpty()) {
            height.setError("Campo obrigatório!");
            return;

        } else if (Double.parseDouble(height.getText().toString()) == 0.0) {
            height.setError("Altura inválida!");
            return;
        }

        final Bundle params = new Bundle();
        final Intent intent = new Intent(this, ImcResults.class);

        params.putString("user", name.getText().toString());
        params.putInt("age", Integer.parseInt(age.getText().toString()));
        params.putDouble("weight", Double.parseDouble(weight.getText().toString()));
        params.putDouble("height", Double.parseDouble(height.getText().toString()));

        intent.putExtras(params);
        this.startActivity(intent);
    }
}