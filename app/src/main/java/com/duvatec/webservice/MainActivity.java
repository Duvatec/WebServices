package com.duvatec.webservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.transform.ErrorListener;

public class MainActivity extends AppCompatActivity implements Response.ErrorListener, Response.Listener<String> {

    EditText numero;
    Button enviar;
    TextView mensaje, codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero = (EditText) findViewById(R.id.numero);
        enviar = (Button) findViewById(R.id.envia);
        mensaje = (TextView) findViewById(R.id.mensaje);
        codigo = (TextView) findViewById(R.id.codigo);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviaNumero();
            }
        });

    }

    private void enviaNumero() {
        EnviaMensaje enviaMensaje = new EnviaMensaje(numero.getText().toString());
        Request<?> resquest = enviaMensaje.getRequest(this, this);
        AppController.getInstance().addToRequestQueue(resquest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e("ErrorResponse", error.getMessage());
    }

    @Override
    public void onResponse(String response) {

        Log.e("response", response);
        GsonBuilder builder = new GsonBuilder();
        builder.setExclusionStrategies(new DefaultExclusionStrategy());
        Gson gson = builder.create();
        try {
            Mensaje modelo = gson.fromJson(response, Mensaje.class);
            mensaje.setText("Mensaje: " + modelo.getMensaje());
            codigo.setText("Código: " + modelo.getCodMensaje() + "--Metodo: " + modelo.getMetodo());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
