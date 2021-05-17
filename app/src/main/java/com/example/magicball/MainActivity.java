package com.example.magicball;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView imageView1,imageView2;

    private ConstraintLayout layout;
    private ImageButton btn;

    private ImageButton ball;
    private TextView respuesta;
    private String [] respuestaArray = {"Es cierto", "Definitivamente es así", "Sin duda", "Sí definitivamente", "Puede confiar", "Como yo lo veo, sí", "Lo más probable", "Perspectiva buena", "Sí", "Las señales apuntan a sí", "Pregunta confusa", "Pregunte de nuevo más tarde", "Mejor no decirte ahora", "No puedo predecir ahora", "Concéntrate y pregunta de nuevo", "No cuentes con eso", "Mi respuesta es no", "Mis fuentes dicen que no", "Outlook no es tan bueno", "Muy dudoso"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bloques superior e inferior de cambio de color
        imageView1 = findViewById(R.id.image_view1);
        imageView2 = findViewById(R.id.image_view2);

        //establece el timer de cambio del fondo
        Timer timer = new Timer();
        MyTimer myTimer = new MyTimer();
        timer.schedule(myTimer, 2000, 2000);


        //se referencia la imagen
        ball=findViewById(R.id.btn);

        //se referencia el texto
        respuesta=findViewById(R.id.respuestaVista);

        //proceso
        ball.setOnClickListener(this);
        Toast.makeText(MainActivity.this, "Consulta tu Suerte", Toast.LENGTH_SHORT).show();

    }
    // fin de protected void onCreate(Bundle savedInstanceState)


    //función de cambio dinámico y aleatorio (random) del fondo en las zonas definidas
    private class MyTimer extends TimerTask {

        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Random random = new Random();
                    //set color background bloque superior
                    imageView1.setBackgroundColor(Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256)));

                    //set color background bloque inferior
                    imageView2.setBackgroundColor(Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256)));
                }
            });
        }
    }
    // fin de private class MyTimer


    @Override
        public void onClick(View v){

        //creación método switch e invocación de los elementos del array de respuestas
            switch (v.getId()){
                case R.id.btn:
                    int rand = new Random().nextInt(respuestaArray.length);
                    respuesta.setText(respuestaArray[rand]);
            }
        }
}
// fin de la public class MainActivity

