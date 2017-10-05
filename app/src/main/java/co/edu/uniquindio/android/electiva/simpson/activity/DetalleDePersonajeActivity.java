package co.edu.uniquindio.android.electiva.simpson.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import co.edu.uniquindio.android.electiva.simpson.R;
import co.edu.uniquindio.android.electiva.simpson.fragments.DetalleDePersonajeFragment;
import co.edu.uniquindio.android.electiva.simpson.vo.Personaje;

public class DetalleDePersonajeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_de_personaje);

        DetalleDePersonajeFragment detallePersonaje = (DetalleDePersonajeFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_personaje);
        Personaje personaje = (Personaje) getIntent().getExtras().get("per");
        detallePersonaje.mostrarPersonaje(personaje);
    }

}
