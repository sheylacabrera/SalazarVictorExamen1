package ec.edu.uisrael.salazarvictorexamen1.vista;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import ec.edu.uisrael.salazarvictorexamen1.R;
import ec.edu.uisrael.salazarvictorexamen1.controlador.AdapterProduct;
import ec.edu.uisrael.salazarvictorexamen1.controlador.Controllerproduct;
import ec.edu.uisrael.salazarvictorexamen1.model.producto;


public class productList extends AppCompatActivity {
    private Controllerproduct adminProduct;
    private ListView lista;
    private ImageView imagen_1;
    private TextView textView;
    private String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        email = getIntent().getExtras().getString("email");
        adminProduct = Controllerproduct.getInstance();
        AdapterProduct adaptador;
        lista = (ListView) findViewById(R.id.listView);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText(email);
        if (adminProduct.listar().size() == 0) {
            producto prdt1 = new producto(1, "producto - 1", R.drawable.imagen1);
            producto prdt2 = new producto(2, "producto - 2", R.drawable.imagen2);
            producto prdt3 = new producto(3, "producto - 3", R.drawable.imagen3);
            try {
                adminProduct.addvehiculo(prdt1);
                adminProduct.addvehiculo(prdt2);
                adminProduct.addvehiculo(prdt3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //Utilizando la vista adapter obtenemos el listado de productos
        adaptador = new AdapterProduct(this, android.R.layout.simple_list_item_2, adminProduct.listar());
        lista.setAdapter(adaptador);

    }
}
