package com.example.conexion;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {
    public static ArrayList<Producto> productosEnCarrito = new ArrayList<>();
    ListView listaUsuarios;
    ArrayList<JSONObject> usuariosList = new ArrayList<>();
    UsuarioAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listaUsuarios = findViewById(R.id.lv_listaUsuarios);

        obtenerUsuarios("http://192.168.100.9/OCTUBRE/TIENDA/categoria1.php");
        adapter = new UsuarioAdapter(this, usuariosList);
        listaUsuarios.setAdapter(adapter);

        // Botón para ir al carrito
        Button btnCarrito = findViewById(R.id.btnCarrito);
        btnCarrito.setOnClickListener(v -> irAlCarrito());

        // Listener para añadir al carrito al hacer clic en un item de la lista
        listaUsuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    JSONObject usuario = usuariosList.get(position);
                    String nombre = usuario.getString("nombre"); // Ajusta según tu JSON
                    double precio = usuario.getDouble("precio"); // Ajusta según tu JSON
                    productosEnCarrito.add(new Producto(nombre, precio, 1)); // Añadir producto al carrito
                    Toast.makeText(getApplicationContext(), "Añadido al carrito", Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void obtenerUsuarios(String URL) {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject usuario = response.getJSONObject(i);
                                usuariosList.add(usuario);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error", "Error al obtener los datos: " + error.getMessage());
                        Toast.makeText(getApplicationContext(), "Error en la solicitud HTTP: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }

    public void irAlCarrito() {
        Intent it = new Intent(getApplicationContext(), CarritoActivity1.class);
        startActivity(it);
    }

    public void Atras(View v) {
        Intent it = new Intent(getApplicationContext(), MainActivity3.class);
        startActivity(it);
    }
}
