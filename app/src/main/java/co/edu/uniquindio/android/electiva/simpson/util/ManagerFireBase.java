package co.edu.uniquindio.android.electiva.simpson.util;

import android.support.v4.app.Fragment;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import co.edu.uniquindio.android.electiva.simpson.vo.Personaje;

import static android.content.ContentValues.TAG;

/**
 *
 * Conexion BD
 * Created by angela on 2/11/17.
 */

public class ManagerFireBase {

    private FirebaseDatabase database; //Conexion BD
    private DatabaseReference databaseRef; //Refernecia BD
    private static ManagerFireBase instancia;
    private Fragment fragment;
    private ManagerFireBase(Fragment fragment){
        database = FirebaseDatabase.getInstance();
        databaseRef = database.getReference();
        this.fragment = fragment;
    }


    public static ManagerFireBase instanciar(Fragment fragment) {
        if (instancia == null) {
            instancia = new ManagerFireBase(fragment);
        }
        return instancia;
    }

    /**
     * Registra elemeto a BD
     * @param p
     */
    public void insertarPersonaje(Personaje p){
        databaseRef.push().setValue(p);
    }

    public void escucharEventoFireBase(){

        databaseRef.addChildEventListener(new ChildEventListener()

        {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String
                    s) {
                Log.v(TAG,"agregado");
                Personaje personaje =
                        dataSnapshot.getValue(Personaje.class);
                personaje.setId(dataSnapshot.getKey());
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot,
                                       String s) {
                Log.v(TAG,"cambiado");
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Log.v(TAG,"eliminado");
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String
                    s) {
                Log.v(TAG,"moved");
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.v(TAG,"cancelar");
            }
        });
    }
}
