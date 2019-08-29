package com.example.labdmguia02;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtCorreo, edtPass;
    Button btnIniciar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle("Guia02");
        }
        edtCorreo=findViewById(R.id.edtCorreo);
        edtPass=findViewById(R.id.edtPass);

        btnIniciar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnIniciar:{
                String Correo=edtCorreo.getText().toString();
                String Pass=edtPass.getText().toString();

                Intent in=new Intent(this, SegundaPantalla.class);
                in.putExtra("Correo", Correo);
                in.putExtra("Conraseña", Pass);
                startActivity(in);
            }
            break;
        }
    }
}
