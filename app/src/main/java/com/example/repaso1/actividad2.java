package com.example.repaso1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class actividad2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);
        Intent intent=getIntent();

        int resultadoactividad1=intent.getIntExtra("Resultado",0);

        TextView textoresultado=findViewById(R.id.textView);

        String mensaje="El resultado es "+resultadoactividad1;
        textoresultado.setText(mensaje);

    }
}