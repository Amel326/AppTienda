package com.example.conexion;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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


public class MainActivity extends AppCompatActivity {
    EditText txtUsuario;
    EditText txtPassword;
    Button btnIniciarSesion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnIniciarSesion = findViewById(R.id.btnIniciar);
        txtUsuario = findViewById(R.id.edtUsuario);
        txtPassword = findViewById(R.id.edtPassword);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Aquí debes colocar la IP y la ruta correcta del archivo PHP en tu servidor XAMPP
                validarLogin("http://192.168.100.9/OCTUBRE/TIENDA/remoto_validalogin.php");
            }
        });
    }
    private void validarLogin(String URL) {
        Log.d("LoginData", "Usuario: " + txtUsuario.getText().toString());
        Log.d("LoginData", "Password: " + txtPassword.getText().toString());

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success) {
                        // Autenticación exitosa
                        Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                        startActivity(intent);
                    } else {
                        // Autenticación fallida
                        Toast.makeText(MainActivity.this, "Usuario o Contraseña Incorrectos", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Error en la respuesta del servidor", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", "Error en la solicitud HTTP: " + error.getMessage());
                Toast.makeText(MainActivity.this, "Error en la solicitud HTTP: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<>();
                parametros.put("usuario", txtUsuario.getText().toString());
                parametros.put("password", txtPassword.getText().toString());
                return parametros;
            }
        };
        // Agregar la solicitud a la cola de Volley
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}