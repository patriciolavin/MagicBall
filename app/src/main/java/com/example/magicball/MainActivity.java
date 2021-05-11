package com.example.magicball;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ConstraintLayout layout;
    private Button btn;

    private ImageButton ball;
    private TextView respuesta;
    private String [] respuestaArray = {"Es cierto", "Definitivamente es así", "Sin duda", "Sí definitivamente", "Puede confiar", "Como yo lo veo, sí", "Lo más probable", "Perspectiva buena", "Sí", "Las señales apuntan a sí", "Pregunta confusa", "Pregunte de nuevo más tarde", "Mejor no decirte ahora", "No puedo predecir ahora", "Concéntrate y pregunta de nuevo", "No cuentes con eso", "Mi respuesta es no", "Mis fuentes dicen que no", "Outlook no es tan bueno", "Muy dudoso"};



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*        layout=findViewById(R.id.layoutt);
        ball=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();

                int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
                layout.setBackgroundColor(color);
        }
        });*/


        //se referencia la imagen
        ball=findViewById(R.id.btn);

        //se referencia el texto
        respuesta=findViewById(R.id.respuestaVista);

        //proceso
        ball.setOnClickListener(this);
        Toast.makeText(MainActivity.this, "Consulta tu Suerte", Toast.LENGTH_SHORT).show();
    }


    @Override
        public void onClick(View v){
        //creación método switch
            switch (v.getId()){
                case R.id.btn:
                    int rand = new Random().nextInt(respuestaArray.length);
                    respuesta.setText(respuestaArray[rand]);
            }
        }
}

