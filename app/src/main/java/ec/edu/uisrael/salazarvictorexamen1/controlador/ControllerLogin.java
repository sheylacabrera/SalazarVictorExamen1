package ec.edu.uisrael.salazarvictorexamen1.controlador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControllerLogin {

    public boolean login (String user, String pwd ) {
        /**
         *  Valida el usuario y contraseña.
         */

        if ((user == null) || (pwd == null)) return false;
        if (pwd.equals("uisrael2017")){
                return  true;
            }
         return  false;
    }
}
