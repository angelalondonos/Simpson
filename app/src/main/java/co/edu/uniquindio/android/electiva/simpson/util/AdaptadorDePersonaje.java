package co.edu.uniquindio.android.electiva.simpson.util;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.edu.uniquindio.android.electiva.simpson.R;
import co.edu.uniquindio.android.electiva.simpson.vo.Personaje;

/**
 * Created by angela on 26/09/17.
 */

public class AdaptadorDePersonaje extends RecyclerView.Adapter<AdaptadorDePersonaje.PersonajeViewHolder> {


    private ArrayList<Personaje> personajes;
    private static OnClickAdaptadorDePersonaje listener;


    public AdaptadorDePersonaje(ArrayList<Personaje> personajes, Fragment fragment) {
        this.personajes = personajes;
        try{
            listener= (OnClickAdaptadorDePersonaje) fragment;
        }catch (ClassCastException e){
            e.printStackTrace();
        }
    }

    @Override
    public PersonajeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.resumen_personaje, parent, false);
            PersonajeViewHolder peliculaVH = new PersonajeViewHolder(itemView);
            return peliculaVH;


    }

    public interface OnClickAdaptadorDePersonaje{
        void onClickPosition(int pos);
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

        @BindView(R.id.nombre) protected TextView txtNombrePresonaje;
        @BindView(R.id.fecha_nacimiento) protected TextView txtFechaNacimiento;

        public PersonajeViewHolder(View itemView) {
            super(itemView);
           itemView.setOnClickListener(this);
            ButterKnife.bind(this, itemView);
        }

        /**
         * Permite
         * @param personaje
         */
        public void binPersonaje(Personaje personaje) {
            txtNombrePresonaje.setText(personaje.getNombre());
            txtFechaNacimiento.setText(personaje.getFecha().toString());
        }

        /**
         * Evento general de la posicion del adaptador
         * @param view
         */
        @Override
        public void onClick(View view) {

            listener.onClickPosition(getAdapterPosition());

            Log.d("TAG", "Element " + getAdapterPosition() + " clicked. "+ txtNombrePresonaje.getText());
        }



    }
}