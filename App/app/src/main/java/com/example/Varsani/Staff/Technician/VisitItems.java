package com.example.Varsani.Staff.Technician;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.Varsani.Staff.Adapters.AdapterQuotItems;
import com.example.Varsani.Staff.Models.ClientItemsModal;
import com.example.Varsani.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.Varsani.utils.Urls.URL_QUOTATION_ITEMS;
import static com.example.Varsani.utils.Urls.URL_SEND_QUOTATION;

public class VisitItems extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProgressBar progressBar,progressBar1;
    private TextView txv_name,txv_orderID,txv_orderStatus,
            txv_address,txv_town, txv_county;
    private EditText edt_amount;
    private TextView edt_materials,edt_materialcost,edt_grandtotal;
    private List<ClientItemsModal> list;
    private AdapterQuotItems adapterQuotItems;
    private RelativeLayout layout_bottom;
    private LinearLayout layoutmaterials;
    private Button btn_submit,btn_sbmit1,btn_calculate;
    private RadioGroup radioGroup;
    private RadioButton rb_no_materials,rb_yes_materials;
    private ArrayList<String> drivers;
    CheckBox chk1,chk2,chk3,chk4,chk5,chk6,chk7,chk8,chk9,chk10;

    String orderID ,amount, materials;
    String orderStatus;
    int mcost=0;
    int grandtotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit_items);

        getSupportActionBar().setSubtitle("Fill Form");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        layout_bottom = findViewById(R.id.layout_bottom);
        progressBar = findViewById(R.id.progressBar);
        progressBar1 = findViewById(R.id.progressBar1);
        recyclerView = findViewById(R.id.recyclerView);
        txv_address = findViewById(R.id.txv_address);
        txv_town = findViewById(R.id.txv_town);
        txv_county = findViewById(R.id.txv_county);
        txv_name = findViewById(R.id.txv_name);
        txv_orderStatus = findViewById(R.id.txv_orderStatus);
        txv_orderID = findViewById(R.id.txv_orderID);
        btn_submit = findViewById(R.id.btn_submit);
        btn_calculate = findViewById(R.id.btn_calculate);
        edt_amount = findViewById(R.id.edt_agreed_amount);
        edt_materials = findViewById(R.id.edt_materials);
        edt_materialcost =findViewById(R.id.edt_materialcost);
        edt_grandtotal = findViewById(R.id.edt_grandtotal);
        radioGroup = findViewById(R.id.rb_materials);
        rb_no_materials = findViewById(R.id.rb_no_materials);
        rb_yes_materials = findViewById(R.id.rb_yes_materials);
        layoutmaterials = findViewById(R.id.materialslayout);
        //Getting instance of CheckBoxes and Button from the activty_main.xml file
        chk1 = (CheckBox) findViewById(R.id.checkBox);
        chk2 = (CheckBox) findViewById(R.id.checkBox2);
        chk3 = (CheckBox) findViewById(R.id.checkBox3);
        chk4 = (CheckBox) findViewById(R.id.checkBox4);
        chk5 = (CheckBox) findViewById(R.id.checkBox5);
        chk6 = (CheckBox) findViewById(R.id.checkBox6);
        chk7 = (CheckBox) findViewById(R.id.checkBox7);
        chk8 = (CheckBox) findViewById(R.id.checkBox8);
        chk9 = (CheckBox) findViewById(R.id.checkBox9);
        chk10 = (CheckBox) findViewById(R.id.checkBox10);

        radioGroup.clearCheck();
        layoutmaterials.setVisibility(View.GONE);
        edt_materials.setVisibility(View.GONE);
        edt_materialcost.setVisibility(View.GONE);

        rb_no_materials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutmaterials.setVisibility(View.GONE);

            }
        });
        rb_yes_materials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                layoutmaterials.setVisibility(View.VISIBLE);
                edt_materials.setVisibility(View.VISIBLE);
                edt_materialcost.setVisibility(View.VISIBLE);

            }
        });

        StringBuilder result=new StringBuilder();
        StringBuilder materials=new StringBuilder();

        result.append("Selected Materials:");



        //Displaying the message on the toast
        Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_SHORT).show();

        chk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chk1.isChecked()){
                    int cost= 450;
                    mcost+=450;
                    result.append("\nPair Of Gloves "+cost+"Kes");
                    materials.append(",Pair Of Gloves");
                    edt_materials.setText(materials);
                    edt_materialcost.setText("Total Material Cost:"+mcost);

                    Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "Total"+String.valueOf(mcost), Toast.LENGTH_SHORT).show();

                }else{
                    mcost-=450;
                    Toast.makeText(getApplicationContext(), "Total"+String.valueOf(mcost), Toast.LENGTH_SHORT).show();
                    edt_materialcost.setText("Total Material Cost:"+mcost);
                }

            }
        });

        chk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chk1.isChecked()){
                    int cost= 45;
                    mcost+=45;
                    result.append("\n syringe "+cost+"Kes");
                    materials.append(",syringe");
                    edt_materials.setText(materials);
                    edt_materialcost.setText("Total Material Cost:"+mcost);

                    Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "Total"+String.valueOf(mcost), Toast.LENGTH_SHORT).show();

                }else{
                    mcost-=45;
                    Toast.makeText(getApplicationContext(), "Total"+String.valueOf(mcost), Toast.LENGTH_SHORT).show();
                    edt_materialcost.setText("Total Material Cost:"+mcost);
                }

            }
        });
        chk3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chk2.isChecked()){
                    int cost = 18;
                    mcost+=18;
                    result.append("\n needle "+cost+"Kes");
                    materials.append(",needle");
                    edt_materials.setText(materials);
                    edt_materialcost.setText("Total Material Cost:"+mcost);

                    Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "Total:"+String.valueOf(mcost), Toast.LENGTH_SHORT).show();

                }
                else{
                    mcost-=18;
                    Toast.makeText(getApplicationContext(), "Total"+String.valueOf(mcost), Toast.LENGTH_SHORT).show();
                    edt_materialcost.setText("Total Material Cost:"+mcost);
                }
            }
        });
        chk4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chk3.isChecked()){
                    int cost = 200;
                    mcost+=200;
                    result.append("\n bandage"+cost+"Kes");
                    materials.append(",bandage");
                    edt_materials.setText(materials);
                    edt_materialcost.setText("Total Material Cost:"+mcost);

                    Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "Total:"+String.valueOf(mcost), Toast.LENGTH_SHORT).show();

                }else{
                    mcost-=200;
                    Toast.makeText(getApplicationContext(), "Total"+String.valueOf(mcost), Toast.LENGTH_SHORT).show();
                    edt_materialcost.setText("Total Material Cost:"+mcost);
                }
            }
        });
        chk5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chk4.isChecked()){
                    int cost = 3000;
                    mcost+=3000;
                    result.append("\n catheters"+cost+"Kes");
                    materials.append(",catheters");
                    edt_materials.setText(materials);
                    edt_materialcost.setText("Total Material Cost:"+mcost);

                    Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "Total:"+String.valueOf(mcost), Toast.LENGTH_SHORT).show();

                }else{
                    mcost-=3000;
                    Toast.makeText(getApplicationContext(), "Total"+String.valueOf(mcost), Toast.LENGTH_SHORT).show();
                    edt_materialcost.setText("Total Material Cost:"+mcost);
                }
            }
        });
        chk6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chk4.isChecked()){
                    int cost = 3800;
                    mcost+=3800;
                    result.append("\n nebulizers"+cost+"Kes");
                    materials.append(",nebulizers");
                    edt_materials.setText(materials);
                    edt_materialcost.setText("Total Material Cost:"+mcost);

                    Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "Total:"+String.valueOf(mcost), Toast.LENGTH_SHORT).show();

                }else{
                    mcost-=3800;
                    Toast.makeText(getApplicationContext(), "Total"+String.valueOf(mcost), Toast.LENGTH_SHORT).show();
                    edt_materialcost.setText("Total Material Cost:"+mcost);
                }
            }
        });
        chk7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chk4.isChecked()){
                    int cost = 3600;
                    mcost+=3600;
                    result.append("\n ventilators"+cost+"Kes");
                    materials.append(",ventilators");
                    edt_materials.setText(materials);
                    edt_materialcost.setText("Total Material Cost:"+mcost);

                    Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "Total:"+String.valueOf(mcost), Toast.LENGTH_SHORT).show();

                }else{
                    mcost-=3600;
                    Toast.makeText(getApplicationContext(), "Total"+String.valueOf(mcost), Toast.LENGTH_SHORT).show();
                    edt_materialcost.setText("Total Material Cost:"+mcost);
                }
            }
        });
        chk8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chk4.isChecked()){
                    int cost = 4500;
                    mcost+=4500;
                    result.append("\n Cautery device"+cost+"Kes");
                    materials.append(",Cautery device");
                    edt_materials.setText(materials);
                    edt_materialcost.setText("Total Material Cost:"+mcost);

                    Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "Total:"+String.valueOf(mcost), Toast.LENGTH_SHORT).show();

                }else{
                    mcost-=4500;
                    Toast.makeText(getApplicationContext(), "Total"+String.valueOf(mcost), Toast.LENGTH_SHORT).show();
                    edt_materialcost.setText("Total Material Cost:"+mcost);
                }
            }
        });
        chk9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chk4.isChecked()){
                    int cost = 320;
                    mcost+=320;
                    result.append("\n Bipolar forceps"+cost+"Kes");
                    materials.append(",Bipolar forceps");
                    edt_materials.setText(materials);
                    edt_materialcost.setText("Total Material Cost:"+mcost);

                    Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "Total:"+String.valueOf(mcost), Toast.LENGTH_SHORT).show();

                }else{
                    mcost-=3000;
                    Toast.makeText(getApplicationContext(), "Total"+String.valueOf(mcost), Toast.LENGTH_SHORT).show();
                    edt_materialcost.setText("Total Material Cost:"+mcost);
                }
            }
        });
        chk10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chk4.isChecked()){
                    int cost = 700;
                    mcost+=700;
                    result.append("\n nasal tampons"+cost+"Kes");
                    materials.append(",nasal tampons");
                    edt_materials.setText(materials);
                    edt_materialcost.setText("Total Material Cost:"+mcost);

                    Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "Total:"+String.valueOf(mcost), Toast.LENGTH_SHORT).show();

                }else{
                    mcost-=700;
                    Toast.makeText(getApplicationContext(), "Total"+String.valueOf(mcost), Toast.LENGTH_SHORT).show();
                    edt_materialcost.setText("Total Material Cost:"+mcost);
                }
            }
        });


        layout_bottom.setVisibility(View.GONE);
        progressBar1.setVisibility(View.GONE);
//        edt_driver.setEnabled(false);

        drivers=new ArrayList<>();

        Intent intent=getIntent();

        orderID=intent.getStringExtra("orderID");
        orderStatus=intent.getStringExtra("orderStatus");
        String clientName=intent.getStringExtra("clientName");
        String address=intent.getStringExtra("address");
        String town=intent.getStringExtra("town");
        String county=intent.getStringExtra("county");
        amount = edt_amount.getText().toString().trim();


        txv_orderStatus.setText("Order status " +orderStatus );
        txv_name.setText("Name " +clientName );
        txv_town.setText("Town " +town );
        txv_county.setText("County " +county );
        txv_address.setText("Address " +address );
        txv_orderID.setText("Order ID " +orderID );

        list=new ArrayList<>();

        recyclerView.setLayoutManager( new LinearLayoutManager(getApplicationContext()));
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getApplicationContext(),1);
        recyclerView.setLayoutManager(layoutManager);


        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAlert(v);
            }
        });

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount= edt_amount.getText().toString();
                int appo = 300;
                int amount1 = Integer.parseInt(amount);
                grandtotal = amount1 +mcost + appo;
                edt_grandtotal.setText("Total: Kes "+grandtotal);

            }
        });

        getClientItems();
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    public void getClientItems(){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL_QUOTATION_ITEMS,
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
                                    String itemName=jsn.getString("itemName");
                                    String quantity=jsn.getString("quantity");
                                    String itemPrice=jsn.getString("itemPrice");
                                    String subTotal=jsn.getString("subTotal");
                                    ClientItemsModal clientItemsModal=new ClientItemsModal(itemName,itemPrice,quantity,subTotal);
                                    list.add(clientItemsModal);
                                }
                                adapterQuotItems =new AdapterQuotItems(getApplicationContext(),list);
                                recyclerView.setAdapter(adapterQuotItems);
                                progressBar.setVisibility(View.GONE);
                                if(orderStatus.equals("Proceed To Appointment")){
                                    layout_bottom.setVisibility(View.VISIBLE);
                                }

                            }else{
                                progressBar.setVisibility(View.GONE);
                                Toast toast=Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP,0,250);
                                toast.show();
                            }


                        }catch (Exception e){
                            e.printStackTrace();
                            Toast toast=Toast.makeText(getApplicationContext(), e.toString(),Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.TOP,0,250);
                            toast.show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast toast=Toast.makeText(getApplicationContext(), error.toString(),Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP,0,250);
                toast.show();
            }
        }){
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String> params =new HashMap<>();
                params.put("orderID",orderID);
                Log.e("Params",""+ params);
                return  params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }


    public void markOrder(){
        progressBar1.setVisibility(View.VISIBLE);
        btn_submit.setVisibility(View.GONE);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL_SEND_QUOTATION,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            Log.e("RESPONSE",response);
                            JSONObject jsonObject=new JSONObject(response);
                            String status=jsonObject.getString("status");
                            String msg=jsonObject.getString("message");
                            if (status.equals("1")) {

                                Toast toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP, 0, 250);
                                toast.show();
                                finish();
                            }
                            else{

                                Toast toast= Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP,0,250);
                                toast.show();
                                progressBar1.setVisibility(View.GONE);
                                btn_submit.setVisibility(View.VISIBLE);
                            }


                        }catch (Exception e){
                            e.printStackTrace();
                            Toast toast= Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.TOP,0,250);
                            toast.show();

                            progressBar1.setVisibility(View.GONE);
                            btn_submit.setVisibility(View.VISIBLE);
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast toast= Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP,0,250);
                toast.show();
                progressBar1.setVisibility(View.GONE);
                btn_submit.setVisibility(View.VISIBLE);
            }
        }){
            @Override
            protected Map<String,String>getParams()throws AuthFailureError{
                Map<String,String> params=new HashMap<>();
                params.put("orderID",orderID);
                params.put("amount",String.valueOf(grandtotal));
                params.put("materials",materials);
                Log.e("PARAMS",""+params);
                return params;
            }
        };
        RequestQueue requestQueue=Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }


    public void getAlert(View v){
        amount=edt_amount.getText().toString();
        materials= edt_materials.getText().toString();

        android.app.AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
        builder.setTitle("Send Quotation Now!!!");
        builder.setNegativeButton("Cancel",null);
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                if(TextUtils.isEmpty(amount)){
                    Toast.makeText(getApplicationContext(),"Enter amount to continue ",Toast.LENGTH_SHORT).show();

                }if(TextUtils.isEmpty(materials)){
                    Toast.makeText(getApplicationContext(),"Enter materials to request ",Toast.LENGTH_SHORT).show();
                }
                else{
                    markOrder();
                }

                return;
            }
        });
        builder.show();

    }
}
