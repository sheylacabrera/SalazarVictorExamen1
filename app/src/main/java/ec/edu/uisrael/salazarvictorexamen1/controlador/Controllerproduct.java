package ec.edu.uisrael.salazarvictorexamen1.controlador;

import java.util.ArrayList;
import java.util.List;

import ec.edu.uisrael.salazarvictorexamen1.model.producto;

/**
 * Created by Victor on 4/12/2017.
 */

public class Controllerproduct {
    private List<producto> datos = new ArrayList<>();

    private static final Controllerproduct adminproduct = new Controllerproduct();

    public static Controllerproduct getInstance() {
        return adminproduct;
    }

    private Controllerproduct() {
    }

    public  ArrayList<producto> listar(){
        return (ArrayList<producto>) datos;
    }

    public boolean  addvehiculo(producto obj) throws Exception {

        if (datos.contains(obj)) return false;
        obj.setIdProducto(datos.size()+ 1);
        datos.add(obj);
        return true;
    }



}
