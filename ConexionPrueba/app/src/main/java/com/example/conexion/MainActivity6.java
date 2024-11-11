package com.example.conexion;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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

public class MainActivity6 extends AppCompatActivity {

    TextView nom;
    String idusuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main6);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nom = findViewById(R.id.txtnom);

        Intent intent = getIntent();
        String usuario = intent.getStringExtra("usuario");
        String password = intent.getStringExtra("password");
        // Llama a la función para obtener el ID y el nombre del usuario
        obtenerDatosUsuario(usuario, password);
    }

    private void obtenerDatosUsuario(String usuario, String password) {
        String URL = "http://192.168.100.9/OCTUBRE/TIENDA/remoto_validalogin.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success) {
                        JSONObject user = jsonResponse.getJSONObject("user");
                        String id = user.getString("id");
                        String nombre = user.getString("nombre");
                        String apellido = user.getString("apellidoPat");

                        idusuario = id; // Guardar el ID del usuario
                        nom.setText("Nombre Cliente: " + nombre + " " + apellido);
                    } else {
                        Toast.makeText(MainActivity6.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity6.this, "Error en la respuesta del servidor", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", "Error en la solicitud HTTP: " + error.getMessage());
                Toast.makeText(MainActivity6.this, "Error en la solicitud HTTP: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<>();
                parametros.put("usuario", usuario);
                parametros.put("password", password);
                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void Activity3(View v) {
        Intent it = new Intent(getApplicationContext(), MainActivity3.class);
        it.putExtra("id", idusuario); // Pasar el ID del usuario a MainActivity3
        startActivity(it);
    }
}
