package com.example.conexion;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class UsuarioAdapter extends ArrayAdapter<JSONObject> {

    private final Context context;
    private final List<JSONObject> usuariosList;

    public UsuarioAdapter(Context context, List<JSONObject> usuariosList) {
        super(context, 0, usuariosList);
        this.context = context;
        this.usuariosList = usuariosList;
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_usuario, parent, false);
        }

        // Obtener el usuario actual
        JSONObject usuario = usuariosList.get(position);

        // Referencias a los elementos del layout personalizado
        ImageView imgProducto = convertView.findViewById(R.id.imgProducto);
        TextView txtNombreProducto = convertView.findViewById(R.id.txtNombreProducto);
        TextView txtPrecioProducto = convertView.findViewById(R.id.txtPrecioProducto);

        try {
            // Obtener los datos del usuario
            String nombre = usuario.getString("nombre");
            String precio = usuario.getString("precio");

            // Asignar los valores a los TextView
            txtNombreProducto.setText(nombre);
            txtPrecioProducto.setText("Precio: " + precio);

            // Aquí puedes cargar una imagen si tienes la URL de la imagen en tu JSON
            // Por ejemplo, usando una librería como Picasso o Glide
            // Picasso.get().load("URL_DE_LA_IMAGEN").into(imgProducto);
            imgProducto.setImageResource(R.drawable.ic_launcher_foreground); // imagen por defecto

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return convertView;
    }
}

