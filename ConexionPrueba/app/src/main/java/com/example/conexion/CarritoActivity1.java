package com.example.conexion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.conexion.CarritoAdapter;

import java.util.ArrayList;

public class CarritoActivity1 extends AppCompatActivity {
    ListView listaCarrito;
    ArrayList<Producto> productosEnCarrito; // Asegúrate de tener una clase Producto

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_carrito1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listaCarrito = findViewById(R.id.lv_listaCarrito);

        // Inicializa la lista de productos en el carrito
        productosEnCarrito = MainActivity4.productosEnCarrito; // Asumiendo que tienes una lista en MainActivity
        CarritoAdapter adapter = new CarritoAdapter(this, productosEnCarrito);
        listaCarrito.setAdapter(adapter);

        calcularTotal();
    }

    private void calcularTotal() {
        double total = 0;
        for (Producto producto : productosEnCarrito) {
            total += producto.getTotal();
        }
        TextView totalTextView = findViewById(R.id.tvTotal);
        totalTextView.setText("Total: " + total);
    }
    private void realizarPedido() {
        // Aquí podrías implementar la lógica para procesar el pedido
        Toast.makeText(this, "Pedido exitoso", Toast.LENGTH_SHORT).show();
    }
    public void Atras(View v) {
        Intent it = new Intent(getApplicationContext(), MainActivity3.class);
        startActivity(it);
    }
}