package com.example.demorcv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import clases.Planeta;
import clases.PlanetaAdapter;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.LayoutManager layoutManager;

    //Creamos objeto de la clase RecyclerView
    private RecyclerView rcvPrincipal;
    //Creamos objeto de la clase PlanetaAdapter
    private PlanetaAdapter adpPlaneta;
    //Creamos objeto Arraylist para almacenar datos
    private ArrayList<Planeta> arlPlaneta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Obtenemos datos desde URL externa
        arlPlaneta = new ArrayList<>();
        adpPlaneta = new PlanetaAdapter(this,arlPlaneta);
        rcvPrincipal = (RecyclerView) findViewById(R.id.rcv_principal);
        rcvPrincipal.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rcvPrincipal.setLayoutManager(layoutManager);
        rcvPrincipal.setAdapter(adpPlaneta);
        obtenerDatosPlanetas();






    }

    private void obtenerDatosPlanetas() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://app.gestiondocente.online/calendario-reservas/test_array_planets.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsonArray   = new JSONArray(response);

                            String nombrePlaneta;
                            int distanciaSol;
                            int  gravedad;
                            int diametro;

                            for(int i=0; i < jsonArray.length();i++){
                                JSONObject object = jsonArray.getJSONObject(i);
                                nombrePlaneta   = object.getString("planetName");
                                distanciaSol    = Integer.parseInt(object.getString("distanceFromSun"));
                                gravedad        = Integer.parseInt(object.getString("gravity"));
                                diametro        = Integer.parseInt(object.getString("diameter"));

                                Planeta planeta = new Planeta(nombrePlaneta,distanciaSol,gravedad,diametro);
                                arlPlaneta.add(planeta);
                                adpPlaneta.notifyDataSetChanged();

                            }

                            Context context = getApplicationContext();
                            CharSequence text = "Respuesta " + response.toString();
                            int duration = Toast.LENGTH_LONG;

                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Manage Error
                Context context = getApplicationContext();
                CharSequence text = "Error al cargar datos";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            } });
        queue.add(stringRequest);

    }
}
