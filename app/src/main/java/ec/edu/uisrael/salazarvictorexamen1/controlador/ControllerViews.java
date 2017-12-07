package ec.edu.uisrael.salazarvictorexamen1.controlador;

import android.content.Intent;

import ec.edu.uisrael.salazarvictorexamen1.vista.MainActivity;
import ec.edu.uisrael.salazarvictorexamen1.vista.productList;

/**
 * Created by Victor on 30/11/2017.
 */

public class ControllerViews {
    private static Intent loginok = null;
   private static final ControllerViews adminview = new ControllerViews();

    public static ControllerViews getInstance() {
        return adminview;
    }

    private ControllerViews() {
    }

    public static Intent getViewlogin(MainActivity mainActivity, Class<productList> productListClass) {
        if (loginok == null)
            loginok = new Intent(mainActivity,productListClass);
        return loginok;
    }
}
