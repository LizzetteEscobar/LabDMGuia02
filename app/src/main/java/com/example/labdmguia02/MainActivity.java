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
        btnIniciar=findViewById(R.id.btnIniciar);

        btnIniciar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnIniciar:{
                String correo=edtCorreo.getText().toString();
                String pass=edtPass.getText().toString();
                boolean sesion = false;

                if(edtCorreo.getText().toString().isEmpty() && edtPass.getText().toString().isEmpty()){
                    Toast.makeText(this,"Los campos estan vacios", Toast.LENGTH_LONG).show();
                }else {
                    if (edtCorreo.getText().toString().isEmpty()){
                        Toast.makeText(this,"Llenar Campo Vacio", Toast.LENGTH_LONG).show();
                    }else {
                        if (edtPass.getText().toString().isEmpty()){
                            Toast.makeText(this,"Llenar Campo Vacio", Toast.LENGTH_LONG).show();
                        }else {
                            sesion = true;
                            Intent in = new Intent(this, SegundaPantalla.class);
                            startActivity(in);
                        }
                    }
                }
            }
            break;
        }
    }
}
