package com.example.conexion;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity {
    private EditText txtNombre, txtApellidoPat, txtApellidoMat, txtUsuario, txtPassword, txtDireccion, txtCelular;
    private Button btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnRegistro = findViewById(R.id.btnRegistrarseR);
        txtNombre = findViewById(R.id.edtNombre);
        txtApellidoPat = findViewById(R.id.edtApellido1);
        txtApellidoMat = findViewById(R.id.edtApellido2);
        txtUsuario = findViewById(R.id.edtUsuarioR);
        txtPassword = findViewById(R.id.edtPasswordR);
        txtDireccion = findViewById(R.id.edtDireccion);
        txtCelular = findViewById(R.id.edtCelular);

        // Evento al hacer clic en el botón "Registrar"
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarUsuario();
            }
        });
    }

    private void registrarUsuario() {
        // Crear la solicitud POST
        String URL = "http://192.168.100.9/OCTUBRE/TIENDA/usuarios.php";

        // Crear la solicitud de String con metodo POST
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        //Mostrar respuesta del servidor
                        Toast.makeText(getApplicationContext(), "Registro exitoso", Toast.LENGTH_SHORT).show();
                        Intent it = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(it);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Mostrar errores en caso de fallo
                        Log.e("Error", "Error en la solicitud HTTP: " + error.getMessage());
                        Toast.makeText(getApplicationContext(), "Error en la solicitud HTTP: " +  error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Nullable
            @Override
            protected Map<String, String> getParams()
            {
                // Crear un mapa con los parámetros que se enviarán al servidor
                Map<String, String> parametros = new HashMap<>();
                parametros.put("usuario", txtUsuario.getText().toString());
                parametros.put("password", txtPassword.getText().toString());
                parametros.put("nombre", txtNombre.getText().toString());
                parametros.put("apellidoPat", txtApellidoPat.getText().toString());
                parametros.put("apellidoMat", txtApellidoMat.getText().toString());
                parametros.put("direccion", txtDireccion.getText().toString());
                parametros.put("celular", txtCelular.getText().toString());
                return parametros;
            }
        };

        // Crear una cola de solicitudes y agregar la solicitud
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
