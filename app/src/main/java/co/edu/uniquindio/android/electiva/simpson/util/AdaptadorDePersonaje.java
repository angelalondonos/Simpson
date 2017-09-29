package co.edu.uniquindio.android.electiva.simpson.util;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.simpson.R;
import co.edu.uniquindio.android.electiva.simpson.vo.Personaje;

/**
 * Created by angela on 26/09/17.
 */

public class AdaptadorDePersonaje extends RecyclerView.Adapter<AdaptadorDePersonaje.PersonajeViewHolder> {


    private ArrayList<Personaje> personajes;

    public AdaptadorDePersonaje(ArrayList<Personaje> personajes) {
        this.personajes = personajes;
    }

    @Override
    public PersonajeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.resumen_personaje, parent, false);
            PersonajeViewHolder peliculaVH = new PersonajeViewHolder(itemView);
            return peliculaVH;

    }

    @Override
    public void onBindViewHolder(PersonajeViewHolder holder, int position) {
        Personaje personaje = personajes.get(position);
        holder.binPersonaje(personaje);
    }

    @Override
    public int getItemCount() {
        return personajes.size();
    }

    public static class PersonajeViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{

        private TextView txtNombrePresonaje;
        private TextView txtFechaNacimiento;

        public PersonajeViewHolder(View itemView) {
            super(itemView);
            txtNombrePresonaje = (TextView) itemView.findViewById(R.id.nombre);
            txtFechaNacimiento = (TextView) itemView.findViewById(R.id.fecha_nacimiento);
            itemView.setOnClickListener(this);
        }
        public void binPersonaje(Personaje personaje) {
            txtNombrePresonaje.setText(personaje.getNombre());
            txtFechaNacimiento.setText(personaje.getFecha().toString());
        }

        @Override
        public void onClick(View view) {

            Log.d("TAG", "Element " + getAdapterPosition() + " clicked. "+ txtNombrePresonaje.getText());
        }


    }
}