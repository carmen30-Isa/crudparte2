package com.example.crudparte2;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ConsultaSpinner extends AppCompatActivity {
    private Spinner sp_options;
    private TextView     tv_cod, tv_descripcion, tv_precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConexionSQLite Conexion =new ConexionSQLite(this);
        setContentView(R.layout.activity_consulta_spinner);
        setContentView(R.layout.activity_consulta_spinner);
        sp_options = (Spinner)findViewById(R.id.sp_options);

        tv_cod = (TextView)findViewById(R.id.tv_codigo);
        tv_descripcion = (TextView)findViewById(R.id.tv_descripcion);
        tv_precio = (TextView)findViewById(R.id.tv_precio);
//conexion.obtenerListaArticulos();
        Conexion.consultaListaArticulos();
//ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(this,android.R.layout.simple_spinner_item, listaArticulos);
        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(this,android.R.layout.simple_spinner_item, Conexion.obtenerListaArticulos());
        sp_options.setAdapter(adaptador);
        sp_options.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position,
                                       long l) {
                if (position!=0){
                    tv_cod.setText("Código: "+Conexion.consultaListaArticulos().get(position-
                            1).getCodigo());
                    tv_descripcion.setText("Descripción: "+Conexion.consultaListaArticulos().get(position-1).getDescripcion());
                    tv_precio.setText("Precio: "+String.valueOf(Conexion.consultaListaArticulos().get(position-1).getPrecio()));
                }else{
                    tv_cod.setText("Código: ");
                    tv_descripcion.setText("Descripción: ");
                    tv_precio.setText("Precio: ");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}