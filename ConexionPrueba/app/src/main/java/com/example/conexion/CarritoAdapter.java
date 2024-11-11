package com.example.conexion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CarritoAdapter extends ArrayAdapter<Producto> {
    private final Context context;
    private final ArrayList<Producto> productos;

    public CarritoAdapter(Context context, ArrayList<Producto> productos) {
        super(context, R.layout.item_producto_carrito, productos);
        this.context = context;
        this.productos = productos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item_producto_carrito, parent, false);

        TextView textViewNombre = rowView.findViewById(R.id.textViewNombre);
        TextView textViewPrecio = rowView.findViewById(R.id.textViewPrecio);

        Producto producto = productos.get(position);
        textViewNombre.setText(producto.getNombre());
        textViewPrecio.setText(String.valueOf(producto.getPrecio()));

        return rowView;
    }
}
