package com.example.abhinav.volleytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RequestQueue mRequestQueue;
    Button button;
    private String urlJsonObj = "https://api.androidhive.info/volley/person_object.json";
    private String jsonResponse;
    TextView textView;
    String tag="MYTAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRequestQueue= Volley.newRequestQueue(this);
        button=(Button)findViewById(R.id.button);
        textView=(TextView)findViewById(R.id.textView);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, urlJsonObj, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


                Gson gson= new GsonBuilder().create();
                Person person=gson.fromJson(response.toString(),Person.class);
                jsonResponse = "";
                jsonResponse += "Name: " + person.name + "\n\n";
                jsonResponse += "Email: " + person.email + "\n\n";
                jsonResponse += "Home: " + person.phone.home + "\n\n";
                jsonResponse += "Mobile: " + person.phone.mobile + "\n\n";
                textView.setText(jsonResponse);
               /* String name = null,email = null,home=null,mobile=null;
                JSONObject phone=null;
                try {
                    name = response.getString("name");
                     email = response.getString("email");
                    phone = response.getJSONObject("phone");
                    home = phone.getString("home");
                    mobile = phone.getString("mobile");
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                jsonResponse = "";
                jsonResponse += "Name: " + name + "\n\n";
                jsonResponse += "Email: " + email + "\n\n";
                jsonResponse += "Home: " + home + "\n\n";
                jsonResponse += "Mobile: " + mobile + "\n\n";
                textView.setText(jsonResponse);*/

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        jsonObjectRequest.setTag(tag);
        mRequestQueue.add(jsonObjectRequest);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mRequestQueue.cancelAll(tag);
    }
}
