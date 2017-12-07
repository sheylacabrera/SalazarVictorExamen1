package ec.edu.uisrael.salazarvictorexamen1.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ec.edu.uisrael.salazarvictorexamen1.R;
import ec.edu.uisrael.salazarvictorexamen1.controlador.ControllerLogin;
import ec.edu.uisrael.salazarvictorexamen1.controlador.ControllerViews;

public class MainActivity extends AppCompatActivity {
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
        String user = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        Pattern pcorreo = Pattern.compile("^[A-Za-z0-9]*@uisrael.edu.ec$");
        Matcher matchercorreo = pcorreo.matcher(user.toString());
        if (!matchercorreo.matches()){
            Toast.makeText(MainActivity.this, getString(R.string.error_invalid_email), Toast.LENGTH_SHORT).show();
            return;
        }

        if (adminLogin.login(user,password)) {
            Intent login = ControllerViews.getViewlogin(MainActivity.this, productList.class);
            login.putExtra("email", user);
            startActivity(login);
        }else {
            Toast.makeText(MainActivity.this, getString(R.string.error_incorrect_password), Toast.LENGTH_SHORT).show();
        }

    }
}
