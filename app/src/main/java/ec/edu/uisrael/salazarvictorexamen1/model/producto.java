package ec.edu.uisrael.salazarvictorexamen1.model;

import android.net.Uri;

/**
 * Created by Victor on 4/12/2017.
 */

public class producto {

    private int idProducto;
    private String nombre;
    private Float pvp;

    public producto() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPvp() {
        return pvp;
    }

    public void setPvp(Float pvp) {
        this.pvp = pvp;
    }
}

