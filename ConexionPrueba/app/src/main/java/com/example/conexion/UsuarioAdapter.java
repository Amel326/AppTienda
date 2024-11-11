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
        TextView cantidad = convertView.findViewById(R.id.txtcantidad);

        try {
            // Obtener los datos del usuario
            String nombre = usuario.getString("nombre");
            String precio = usuario.getString("precio");
            String cant = usuario.getString("cantidad");
            String nombreImagen = usuario.getString("imagen");

            // Asignar los valores a los TextView
            txtNombreProducto.setText(nombre);
            txtPrecioProducto.setText("Precio: " + precio);
            cantidad.setText("Cantidad: "+cant );
            if (nombreImagen.equals("img1.jpg")){
                imgProducto.setImageResource(R.drawable.img1);
            } else if (nombreImagen.equals("img2.jpg")) {
                imgProducto.setImageResource(R.drawable.img2);
            }else if (nombreImagen.equals("img3.jpg")) {
                imgProducto.setImageResource(R.drawable.img3);
            }else if (nombreImagen.equals("img4.jpg")) {
                imgProducto.setImageResource(R.drawable.img4);
            }else if (nombreImagen.equals("img5.jpg")) {
                imgProducto.setImageResource(R.drawable.img5);
            }else if (nombreImagen.equals("img6.jpg")) {
                imgProducto.setImageResource(R.drawable.img6);
            }else if (nombreImagen.equals("img7.jpg")) {
                imgProducto.setImageResource(R.drawable.img7);
            }else if (nombreImagen.equals("img8.jpg")) {
                imgProducto.setImageResource(R.drawable.img8);
            }else if (nombreImagen.equals("img9.jpg")) {
                imgProducto.setImageResource(R.drawable.img9);
            }else if (nombreImagen.equals("img10.jpg")) {
                imgProducto.setImageResource(R.drawable.img10);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return convertView;
    }
}

