package co.edu.uniquindio.android.electiva.simpson.vo;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by angela on 26/09/17.
 */

public class Personaje implements Parcelable {

    private String id;
    private String nombre;
    private Date fecha;
    private String descripcion;
    private String urlVideo;


    public Personaje(String nombre, Date fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }


    protected Personaje(Parcel in) {
        id = in.readString();
        nombre = in.readString();
        descripcion = in.readString();
        urlVideo = in.readString();
    }

    public static final Creator<Personaje> CREATOR = new Creator<Personaje>() {
        @Override
        public Personaje createFromParcel(Parcel in) {
            return new Personaje(in);
        }

        @Override
        public Personaje[] newArray(int size) {
            return new Personaje[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(nombre);
        parcel.writeString(descripcion);
        parcel.writeString(urlVideo);
    }
}
