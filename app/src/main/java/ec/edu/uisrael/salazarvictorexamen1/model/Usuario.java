package ec.edu.uisrael.salazarvictorexamen1.model;

/**
 * Created by Victor on 22/1/2018.
 */

public class Usuario {
    private int codigo;
    private String username;
    private String password;
    private String nombre;

    public Usuario() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

