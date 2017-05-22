package com.duvatec.webservice;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by DaveGam on 21/05/17.
 */

public class EnviaMensaje {
    private String numero;

    public EnviaMensaje(String numero) {
        this.numero = numero;
    }


    public StringRequest getRequest(Response.Listener<String> responseListener,
                                    Response.ErrorListener errorListener) {

        String url = "http://tutos.duvatec.com/developers/ws/numeros.php";
        final HashMap<String, String> credentials = new HashMap<String, String>();
        credentials.put("Num", numero);
        Log.e("credentials", credentials + ""); // Imprime el json que se envia

        StringRequest request = new StringRequest(Request.Method.POST, url,
                responseListener, errorListener) {

            @Override
            public String getBodyContentType() {
                return "application/json; charset=" + getParamsEncoding();
            }

            public byte[] getBody() throws AuthFailureError {
                try {
                    return new JSONObject(credentials).toString().getBytes(getParamsEncoding());

                } catch (UnsupportedEncodingException e) {

                }
                return null;
            }

        };

        request.setRetryPolicy(new LongTimeoutAndTryRetryPolicy(LongTimeoutAndTryRetryPolicy.RETRIES_PHONE_ISP));
        return request;
    }
}