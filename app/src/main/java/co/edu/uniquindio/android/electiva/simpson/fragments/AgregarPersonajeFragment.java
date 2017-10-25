package co.edu.uniquindio.android.electiva.simpson.fragments;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.edu.uniquindio.android.electiva.simpson.R;

/**
 * Permite agregar personajes a la aplicacion
 * A simple {@link Fragment} subclass.
 *
 */
public class AgregarPersonajeFragment extends DialogFragment  {


    @BindView(R.id.btn_Registrar) protected Button btnAgregar;

    public AgregarPersonajeFragment() {
        // Required empty public constructor
    }

    /**
     * Muestra la vista que pertenece al fragmento
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Acá debe cargar el texto desde los recursos
        getDialog().setTitle(getResources().getString(R.string.Agregar_Personaje));
        View view=inflater.inflate(R.layout.fragment_agregar_personaje, container, false);

        ButterKnife.bind(this, view);
     return view;
    }


    /**
     * Agregar un nuevo personaje
     * @param view
     */
    @OnClick(R.id.btn_Registrar)
    public void onClick(View view) {

        //Oculta el fragmento
        dismiss();
    }
}
