package com.example.conexion;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

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

public class MainActivity3 extends AppCompatActivity {

    ListView listaUsuarios;
    ArrayList<JSONObject> usuariosList = new ArrayList<>();
    UsuarioAdapter adapter;
    ImageButton categoria1,categoria2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        categoria1 = findViewById(R.id.btncategoria1);
        categoria2 = findViewById(R.id.btncategoria2);
        listaUsuarios = findViewById(R.id.lv_listaUsuarios);

        obtenerUsuarios("http://192.168.100.9/OCTUBRE/TIENDA/listanuevo.php");
        adapter = new UsuarioAdapter(this, usuariosList);
        listaUsuarios.setAdapter(adapter);
    }
    private void obtenerUsuarios(String URL) {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {JSONObject usuario = response.getJSONObject(i);
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
    public void Activity4(View v)
    {
        Intent it = new Intent(getApplicationContext(), MainActivity4.class);
        startActivity(it);
    }
    public void Activity5(View v)
    {
        Intent it = new Intent(getApplicationContext(), MainActivity5.class);
        startActivity(it);
    }

}