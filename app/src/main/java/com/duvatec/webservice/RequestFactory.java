package com.duvatec.webservice;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

/**
 * Created by DavidGam on 29/11/16.
 */
public interface RequestFactory {

    public StringRequest getRequest(Response.Listener<String> responseListener,
                                    Response.ErrorListener errorListener);

}
