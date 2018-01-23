package ec.edu.uisrael.salazarvictorexamen1.vista;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ec.edu.uisrael.salazarvictorexamen1.R;
import ec.edu.uisrael.salazarvictorexamen1.controlador.ControllerLogin;
import ec.edu.uisrael.salazarvictorexamen1.controlador.ControllerViews;
import ec.edu.uisrael.salazarvictorexamen1.model.Usuario;

public class MainActivity extends AppCompatActivity {
    private static String NAMESPACE = "http://ws.docente.uisrael.edu.ec/";
    private static String URL = "http://www.cuscungosoft.com:8080/docente-ws/LoginServices?wsdl";
    private Usuario usuario;
    private String respuesta;

    private EditText etUsername;
    private EditText etPassword;
    private ControllerLogin adminLogin;
    private Button btnlogin;
    private ControllerViews adminview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etPassword = (EditText) findViewById(R.id.txtpassword);
        etUsername = (EditText) findViewById(R.id.txtusername);
        btnlogin = (Button) findViewById(R.id.btnlogin);
        adminLogin = new ControllerLogin();
    }

    public void onclicklogin (View v) {
        AsyncCallWS task = new AsyncCallWS();
        task.execute();
    }

    private class AsyncCallWS extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            String user = etUsername.getText().toString();
            String pwd = etPassword.getText().toString();
            loginWS(user, pwd);
            return null;
        }

        protected void onPostExecute(Void result) {
            if (respuesta.equals("OK")){
                Intent login = ControllerViews.getViewlogin(MainActivity.this, productList.class);
                login.putExtra("email", usuario.getNombre());
                startActivity(login);
            }else{
                Toast.makeText(MainActivity.this, getString(R.string.error_incorrect_password), Toast.LENGTH_SHORT).show();
            }

        }
    }

    private void loginWS(String usr, String pwd) {
        String METHOD_NAME = "login";
        String SOAP_ACTION = "loginAction";
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        request.addProperty("username", usr); //añade datos al servicio web
        request.addProperty("password", pwd); //añade datos al servicio web
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.setOutputSoapObject(request);
        HttpTransportSE transporte = new HttpTransportSE(URL);
        try {
            transporte.call(SOAP_ACTION, soapEnvelope);
            //Se procesa el resultado devuelto
            SoapObject response = (SoapObject) soapEnvelope.getResponse();

            //response = (SoapObject) response.getProperty("Servicos");
            //response = (SoapObject) response.getProperty("cServico");
            usuario = new Usuario();
            usuario.setUsername(usr);
            usuario.setPassword(pwd);
            usuario.setNombre(response.getPropertyAsString("nombre"));
            int a = Integer.parseInt(response.getPropertyAsString("idUsuario"));
            usuario.setCodigo(a);
            respuesta = "OK";
        } catch (Exception e) {
            e.printStackTrace();
            respuesta = "ERROR";
        }
    }
}
