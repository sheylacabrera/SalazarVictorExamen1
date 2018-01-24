package ec.edu.uisrael.salazarvictorexamen1.vista;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import ec.edu.uisrael.salazarvictorexamen1.R;
import ec.edu.uisrael.salazarvictorexamen1.controlador.AdapterProduct;
import ec.edu.uisrael.salazarvictorexamen1.controlador.ControllerViews;
import ec.edu.uisrael.salazarvictorexamen1.controlador.Controllerproduct;
import ec.edu.uisrael.salazarvictorexamen1.model.Usuario;
import ec.edu.uisrael.salazarvictorexamen1.model.producto;


public class productList extends AppCompatActivity {
    private static String NAMESPACE = "http://ws.docente.uisrael.edu.ec/";
    private static String URL = "http://www.cuscungosoft.com:8080/docente-ws/ProductoServices?wsdl";

    private Controllerproduct adminProduct;
    private ListView lista;
    private ImageView imagen_1;
    private TextView textView;
    private String email;
    private List<producto> productoList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        email = getIntent().getExtras().getString("email");
        lista = (ListView) findViewById(R.id.listView);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText(email);
        try {
            AsyncCallWS task = new AsyncCallWS();
            task.execute();
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    private class AsyncCallWS extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            listarproductosWS();
            return null;
        }

        protected void onPostExecute(Void result) {
            if(productoList.size() > 0){
                AdapterProduct adaptador;
                adaptador = new AdapterProduct(productList.this, android.R.layout.simple_list_item_2, productoList);
                lista.setAdapter(adaptador);
            }
        }

    }

    private void listarproductosWS() {
        String METHOD_NAME = "listarProducto";
        String SOAP_ACTION = "listarProductoAction";
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.setOutputSoapObject(request);
        HttpTransportSE transporte = new HttpTransportSE(URL);
        try {
            transporte.call(SOAP_ACTION, soapEnvelope);
            //Se procesa el resultado devuelto
            //SoapObject response = (SoapObject) soapEnvelope.getResponse();
            Vector<SoapObject> result = (Vector<SoapObject>) soapEnvelope.getResponse();

            for (SoapObject response : result) {
                producto producto = new producto();
                producto.setNombre(response.getPropertyAsString("nombre"));
                int a = Integer.parseInt(response.getPropertyAsString("idProducto"));
                producto.setIdProducto(a);
                Float pvp = Float.parseFloat(response.getPropertyAsString("pvp"));
                producto.setPvp(pvp);
                productoList.add(producto);
            }


        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    public void onclickreturn (View v) {
        Intent login = new Intent ( productList.this, MainActivity.class);
        startActivity(login);
    }

    public void onclickcreate (View v) {
        Intent createView = new Intent ( productList.this, ActivityCreate.class);
        startActivity(createView);
    }

}
