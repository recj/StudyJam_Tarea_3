package com.example.rodrigo.studyjam_tarea3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Rodrigo on 16/10/2017.
 */

public class DetalleActivity extends AppCompatActivity{

    ImageView imagenDetalle;
    TextView nombre, descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        getSupportActionBar().setTitle("Descripción");

        imagenDetalle =(ImageView)findViewById(R.id.imagen_detalle);
        nombre= (TextView)findViewById(R.id.texto_detalle);
        descripcion = (TextView) findViewById(R.id.descripcion_detalle);

        Bundle bundle = getIntent().getExtras();
        Aplicacion aplicacion =(Aplicacion)bundle.getSerializable("equipo");

        imagenDetalle.setImageResource(aplicacion.getImagen());
        nombre.setText(aplicacion.getNombre());
        descripcion.setText(aplicacion.getDescripcion());
    }
}
