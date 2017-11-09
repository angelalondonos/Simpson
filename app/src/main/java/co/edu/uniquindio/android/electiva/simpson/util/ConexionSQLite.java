package co.edu.uniquindio.android.electiva.simpson.util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import co.edu.uniquindio.android.electiva.simpson.vo.Personaje;

/**
 * Created by angela on 7/11/17.
 */

public class ConexionSQLite {

    public static final String NOMBRE_BD = "Personajes";
    public static final String NOMBRE_TABLA = "Personaje";
    public static final String CAMPOS_TABLA[] = new String[]{"_ID","NOMBRE", "FECHA", "HISTORIA", "URL"};
    private PersonajesSQLiteHelper usdbh;
    private SQLiteDatabase db;
    public ConexionSQLite(Context context, int version) {
        usdbh = new PersonajesSQLiteHelper(context, NOMBRE_BD , null, version);
        db = usdbh.getWritableDatabase();
    }
    public static String crearTabla(){
        String crearTabla = "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEX)";
        return String.format(crearTabla, NOMBRE_TABLA, CAMPOS_TABLA[0],
                CAMPOS_TABLA[1], CAMPOS_TABLA[2], CAMPOS_TABLA[3], CAMPOS_TABLA[4]);
    }


    /**
     * Método que permite obtener la información de la BD
     * @return
     */
    public ArrayList<Personaje> getInformacionBD() {
        ArrayList<Personaje> personajes = new ArrayList<>();
        Cursor c = db.query(NOMBRE_TABLA, CAMPOS_TABLA, null, null, null, null,
                null);
        if (c.moveToFirst()) {
            do {
                String _id = c.getString(0);
                String nombre = c.getString(1);
                String fecha = c.getString(2);
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd",
                        Locale.ENGLISH);
                Date date= null;
                try {
                    date = format.parse(fecha);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String historia = c.getString(3);
                personajes.add(new Personaje(_id, nombre, date, historia));
            } while (c.moveToNext());
        }
        return personajes;
    }


    public void insertarPersonaje(String... campos) {
        String insertar="INSERT INTO %s (%s,%s,%s) VALUES ( '%s', '%s', '%s' )";
        db.execSQL(String.format(insertar, NOMBRE_TABLA, CAMPOS_TABLA[1], CAMPOS_TABLA[2], CAMPOS_TABLA[3], campos[0], campos[1], campos[2]));
    }
}
