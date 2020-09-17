package com.imamblek.petagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList <Mascota> mascotas;
    public RecyclerView rvContactos;
    public ImageButton btnEstrella;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        androidx.appcompat.widget.Toolbar miActionBarbtn = findViewById(R.id.miActionBarbtn);
        setSupportActionBar(miActionBarbtn);

        btnEstrella = (ImageButton)  findViewById(R.id.btnEstrella);
        rvContactos = (RecyclerView) findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);

        rvContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();

        btnEstrella.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Los mejores 5 ",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, DetalleMascota.class);
                startActivity(intent);

            }
        });
    }

    private void setSupportActionBar(Toolbar miActionBarbtn) {
    }

    public void inicializarAdaptador (){
        Adaptador adaptador = new Adaptador(mascotas,this);
        rvContactos.setAdapter(adaptador);
    }


    public void inicializarListaContactos () {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.cangrejo, "Cangrejo", "0"));
        mascotas.add(new Mascota(R.drawable.delfin, "Delfin", "0"));
        mascotas.add(new Mascota(R.drawable.pulpo, "Pulpo", "0"));
        mascotas.add(new Mascota(R.drawable.estrella, "Estrella", "0"));
        mascotas.add(new Mascota(R.drawable.calamar, "Calamar", "0"));
    }


    //para llamar al menu de opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }
    //para darle vida a los menus
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

    switch (item.getItemId()){
        case R.id.mAbout:
            Intent intent = new Intent(this, ActivityAbout.class);
            startActivity(intent);
            break;
        case R.id.mSetting:
            Intent i = new Intent(this, ActivitySettings.class);
            startActivity(i);
            break;
    }

        return super.onOptionsItemSelected(item);
    }
}