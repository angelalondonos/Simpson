package co.edu.uniquindio.android.electiva.simpson.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Date;

import co.edu.uniquindio.android.electiva.simpson.R;
import co.edu.uniquindio.android.electiva.simpson.fragments.DetalleDePersonajeFragment;
import co.edu.uniquindio.android.electiva.simpson.fragments.ListaDePersonajesFragment;
import co.edu.uniquindio.android.electiva.simpson.vo.Personaje;

public class SimpsonActivity extends AppCompatActivity implements ListaDePersonajesFragment.OnPersonajeSeleccionadoListener{

    private ArrayList<Personaje> personajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simpson);

        personajes = new ArrayList();
        personajes.add(new Personaje("Ronaldinho", new Date()));
        personajes.add(new Personaje("Albert Einstein", new Date()));
        personajes.add(new Personaje("Leonardo da Vinci", new Date()));
        personajes.add(new Personaje("Goku", new Date()));
        personajes.add(new Personaje("Alejandro Magno", new Date()));
        personajes.add(new Personaje("Ronaldinho", new Date()));
        personajes.add(new Personaje("Albert Einstein", new Date()));
        personajes.add(new Personaje("Leonardo da Vinci", new Date()));
        personajes.add(new Personaje("Goku", new Date()));
        personajes.add(new Personaje("Alejandro Magno", new Date()));

        ListaDePersonajesFragment listaDePersonajesFragment = (ListaDePersonajesFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_lista_personajes);
        listaDePersonajesFragment.setPersonajes(personajes);

    }


    /**
     * Permite determinar cual elemento del menu fue seleccionado
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return  super.onOptionsItemSelected(item);
    }

    @Override
    public void onPersonajeSeleccionado(int position) {

        boolean esFragmento = getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_personaje) != null;
        if (esFragmento) {
            ((DetalleDePersonajeFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_personaje)).mostrarPersonaje(personajes.get(position));
        } else {
            Intent i = new Intent(this, DetalleDePersonajeActivity.class);
            i.putExtra("per", personajes.get(position));
            startActivity(i);
        }

    }


}
