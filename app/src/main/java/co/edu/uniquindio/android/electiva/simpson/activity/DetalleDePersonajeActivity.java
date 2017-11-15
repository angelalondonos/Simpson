package co.edu.uniquindio.android.electiva.simpson.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import co.edu.uniquindio.android.electiva.simpson.R;
import co.edu.uniquindio.android.electiva.simpson.fragments.DetalleDePersonajeFragment;
import co.edu.uniquindio.android.electiva.simpson.vo.Personaje;

public class DetalleDePersonajeActivity extends AppCompatActivity {

    private DetalleDePersonajeFragment detallePersonaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_de_personaje);

        detallePersonaje = (DetalleDePersonajeFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_personaje);
        Personaje personaje = (Personaje) getIntent().getExtras().get("per");
        detallePersonaje.mostrarPersonaje(personaje);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        detallePersonaje.onActivityResult(requestCode, resultCode, data);
    }

}
