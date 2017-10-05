package co.edu.uniquindio.android.electiva.simpson.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import co.edu.uniquindio.android.electiva.simpson.R;
import co.edu.uniquindio.android.electiva.simpson.vo.Personaje;

/**
 * Maneja la informaci[on del fragmento del detalle del personaje
 * A simple {@link Fragment} subclass.
 */
public class DetalleDePersonajeFragment extends Fragment implements View.OnClickListener{

    private TextView txtNombre;
    private Personaje personaje;
    private Button btnIrVideo;


    public DetalleDePersonajeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_de_personaje, container, false);
    }


    public void mostrarPersonaje (Personaje personaje) {
        this.personaje = personaje;
        txtNombre = (TextView) getView().findViewById(R.id.titulo_de_detalle_personaje);
        txtNombre.setText(personaje.getNombre());
        btnIrVideo = (Button) getView().findViewById(R.id.btn_ir_a_trailes);
        btnIrVideo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.youtube.com/watch?v=hP3fmnMuZZU"));
        startActivity(intent);
    }
}
