package ec.edu.uisrael.salazarvictorexamen1.model;

import android.net.Uri;

/**
 * Created by Victor on 4/12/2017.
 */

public class producto {

    private int id;
    private String name;
    private Uri url;
    private Integer idImagen;

    public producto() {
    }

    public producto(int id, String name, Integer idImagen) {
        this.id = id;
        this.name = name;
        this.idImagen = idImagen;
    }

    public Integer getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public Uri getUrl() {
        return url;
    }

    public void setUrl(Uri url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

