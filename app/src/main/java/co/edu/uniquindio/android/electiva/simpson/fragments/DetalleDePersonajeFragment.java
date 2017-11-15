package co.edu.uniquindio.android.electiva.simpson.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;

import java.net.MalformedURLException;
import java.net.URL;

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
    private Button btn_facebook;
    ShareDialog shareDialog;
    private Button btnCompartirTwitter;
    private TwitterLoginButton btnloginTwitter;

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
        btn_facebook= (Button) getView().findViewById(R.id.btn_facebook);
        btn_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ShareDialog.canShow(ShareLinkContent.class)) {
                    ShareLinkContent content = new ShareLinkContent.Builder()

                            .setContentUrl(Uri.parse("https://www.youtube.com/watch?v=jhUkGIsKvn0"))
                            .setQuote("Personajes")
                            .setShareHashtag(new ShareHashtag.Builder()
                                    .setHashtag("#Personajes")
                                    .build()).build();
                    shareDialog.show(content);
                }
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        shareDialog = new ShareDialog(getActivity());

        btnCompartirTwitter = (Button) getView().findViewById(R.id.btn_hacer_tuit);
        btnCompartirTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    URL url = new URL("https://www.youtube.com/watch?v=VV9IRQSxx6w");
                    TweetComposer.Builder builder = new TweetComposer.Builder(getContext())
                            .text(personaje.getNombre()).url(url);
                    builder.show();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });

        btnloginTwitter = (TwitterLoginButton) getView().findViewById(R.id.twitter_login_button);
        btnloginTwitter.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                TwitterSession session = result.data;
                btnloginTwitter.setVisibility(View.INVISIBLE);
            }
            @Override
            public void failure(TwitterException exception) {
                Log.d("TwitterKit", "Login with Twitter failure", exception);
            }
        });

        TwitterSession session = TwitterCore.getInstance().getSessionManager().getActiveSession();
        if( session != null ){
            btnloginTwitter.setVisibility(View.INVISIBLE);

        }

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.youtube.com/watch?v=hP3fmnMuZZU"));
        startActivity(intent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        btnloginTwitter.onActivityResult(requestCode, resultCode, data);
    }
}
