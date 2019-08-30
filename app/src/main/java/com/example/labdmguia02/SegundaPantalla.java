package com.example.labdmguia02;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.os.Bundle;
import android.view.View;

public class SegundaPantalla extends AppCompatActivity implements View.OnLongClickListener {

    ProgressBar ejemPBAR;
    Button btnProcesar;
    AutoCompleteTextView ACTAnimal;
    String [] animal={"Lechuza", "Perros", "Gatos", "Loros"};
    AutoCompleteTextView ACTLenguaje;
    String [] lenguaje={"C++", "C#", "JAVA","PHP"};
    AutoCompleteTextView ACTFruta;
    String [] fruta={"Manzana", "Naranja", "Uvas", "Mango"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle("Guia02");
        }

        ACTAnimal=findViewById(R.id.ACTAnimal);
        ACTFruta=findViewById(R.id.ACTFruta);
        ACTLenguaje=findViewById(R.id.ACTLenguaje);

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.select_dialog_item, animal);
        //ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.select_dialog_item, fruta);
        //ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.select_dialog_item, lenguaje);

        ACTAnimal.setThreshold(1);
        ACTAnimal.setAdapter(adapter);
        ejemPBAR=findViewById(R.id.ejemPBAR);
        btnProcesar=findViewById(R.id.btnProcesar);

        btnProcesar.setOnLongClickListener(this);
    }

    private void setProgressValue(final int progress){
        ejemPBAR.setProgress(progress);
        Thread  thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                setProgressValue(progress+10);
            }
        });
        thread.start();
    }

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()){
            case R.id.btnProcesar:
                setProgressValue(0);
                break;
        }
        return false;
    }
}
