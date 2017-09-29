package co.edu.uniquindio.android.electiva.simpson.vo;


import java.util.Date;

/**
 * Created by angela on 26/09/17.
 */

public class Personaje {

    private String id;
    private String nombre;
    private Date fecha;
    private String descripcion;
    private String urlVideo;


    public Personaje(String nombre, Date fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }


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
}
