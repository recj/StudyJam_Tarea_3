package com.example.rodrigo.studyjam_tarea3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AplicacionAdapter.onAplicacionSelectedListener{

    RecyclerView aplicacionRecyclerView;
    AplicacionAdapter aplicacionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aplicacionRecyclerView= (RecyclerView)findViewById(R.id.recyclerMain);
        aplicacionRecyclerView.setHasFixedSize(true);
        aplicacionRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        aplicacionAdapter= new AplicacionAdapter(this,this);

        llenarDatos ();

        aplicacionRecyclerView.setAdapter(aplicacionAdapter);
    }
    private void llenarDatos() {
        List<Aplicacion> lista = new ArrayList<>();
        lista.add(new Aplicacion(R.drawable.facebook, "Facebook", getString(R.string.Descripcion_Facebook)));
        lista.add(new Aplicacion(R.drawable.painterest, "Painterest", getString(R.string.Descripcion_Painterst)));
        lista.add(new Aplicacion(R.drawable.shazam, "Shazam", getString(R.string.Descripcion_Shazam)));
        lista.add(new Aplicacion(R.drawable.skype, "Skype", getString(R.string.Descripcion_Skype)));
        lista.add(new Aplicacion(R.drawable.spotify, "Spotify", getString(R.string.Descripcion_Spotify)));
        lista.add(new Aplicacion(R.drawable.telegram, "Telegram", getString(R.string.Descripcion_Telegram)));
        lista.add(new Aplicacion(R.drawable.twiter, "Twitter", getString(R.string.Descripcion_Twitter)));
        lista.add(new Aplicacion(R.drawable.youtube, "YouTube", getString(R.string.Descripcion_Youtube)));

        aplicacionAdapter.setDataset(lista);
    }


    public void onAplicacionSelected(Aplicacion aplicacion) {
        Intent intent = new Intent(getApplicationContext(), DetalleActivity.class);
        intent.putExtra("equipo", aplicacion);
        startActivity(intent);
    }


}
