package com.example.Varsani.Staff.Store_mrg;

import static com.example.Varsani.utils.Urls.URL_REQUESTMATERIALS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.Varsani.R;
import com.example.Varsani.Staff.Store_mrg.Adapter.AdapterMaterials;
import com.example.Varsani.Staff.Store_mrg.Model.RequestModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RequestedMaterials extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private List<RequestModel> list;
    private AdapterMaterials adapter;
    private Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requested_materials);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Requested Materials");
        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerView);
        btn_next = findViewById(R.id.btn_next);

        list = new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerView.setLayoutManager(layoutManager);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), RequestSupplier.class);
                startActivity(in);
            }
        });

        requests();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    public void requests(){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL_REQUESTMATERIALS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            Log.e("RESPONSE", response);
                            JSONObject jsonObject=new JSONObject(response);
                            String status=jsonObject.getString("status");
                            String msg=jsonObject.getString("message");
                            if(status.equals("1")){
                                JSONArray jsonArray=jsonObject.getJSONArray("details");
                                for(int i=0; i <jsonArray.length();i++){
                                    JSONObject jsn=jsonArray.getJSONObject(i);
                                    String requestID=jsn.getString("requestID");
                                    String name=jsn.getString("name");
                                    String phoneNo=jsn.getString("phoneNo");
                                    String items=jsn.getString("items");
                                    String requestDate=jsn.getString("requestDate");
                                    String requestStatus=jsn.getString("requestStatus");
                                    String amount=jsn.getString("amount");
                                    RequestModel rq=new RequestModel(requestID,  name,  phoneNo,
                                            items,  requestDate,  requestStatus, amount);
                                    list.add(rq);
                                }
                                adapter=new AdapterMaterials(getApplicationContext(),list);
                                recyclerView.setAdapter(adapter);
                                progressBar.setVisibility(View.GONE);

                            }else{
                                Toast toast=Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP,0,250);
                                toast.show();
                                progressBar.setVisibility(View.GONE);
                            }

                        }catch (Exception e){
                            e.printStackTrace();
                            Toast toast=Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.TOP,0,250);
                            toast.show();
                            Log.e("ERROR E ", e.toString());
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast toast=Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP,0,250);
                toast.show();
                Log.e("ERROR E ", error.toString());
            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }
    @Override
    public void onRestart()
    {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }
}