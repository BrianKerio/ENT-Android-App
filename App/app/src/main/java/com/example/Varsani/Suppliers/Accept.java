package com.example.Varsani.Suppliers;

import static com.example.Varsani.utils.Urls.URL_ACCEPT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.print.PrintHelper;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.Varsani.R;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Accept extends AppCompatActivity {
    private TextView txv_requestID,txv_name,txv_items,
            txv_requestDate, txv_requestStatus, txt_unitprice,txt_quantity;

    private Button btn_submit, btn_print;
    private ProgressBar progressBar;
    private String requestID, amount,product;
    private TextView edt_amount;
    private int unitprice, quantity,totalcharge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        txv_items =findViewById(R.id.txv_items);
        txv_name =findViewById(R.id.txv_name);
        txv_requestID = findViewById(R.id.txv_requestID);
        txv_requestStatus = findViewById(R.id.txv_requestStatus);
        txv_requestDate = findViewById(R.id.txv_requestDate);
        progressBar=findViewById(R.id.progressBar);
        btn_submit=findViewById(R.id.btn_submit);
        edt_amount = findViewById(R.id.edt_amount);
        progressBar.setVisibility(View.GONE);
        txt_unitprice= findViewById(R.id.unitprice);
        txt_quantity = findViewById(R.id.request_quantity);
        btn_print = findViewById(R.id.btn_print);

        Intent in=getIntent();
        requestID=in.getStringExtra("requestID");
        quantity = Integer.valueOf(in.getStringExtra("quantity"));
        txv_requestID.setText("ID "+in.getStringExtra("requestID"));
        txv_items.setText("Item/s "+in.getStringExtra("item"));
        txv_requestDate.setText("Date "+in.getStringExtra("requestDate"));
        txv_requestStatus.setText("Status "+in.getStringExtra("requestStatus"));


        if (in.getStringExtra("requestStatus").equals("Invoice Sent")){
            btn_submit.setVisibility(View.GONE);
        }

        if (in.getStringExtra("requestStatus").equals("Paid")){
            btn_submit.setVisibility(View.GONE);
        }

        product = in.getStringExtra("item");
        if (product.equals("JH-W3-OTC-Hearing-Aids")){
            unitprice = 8000;
            txt_unitprice.setText("Price: Kes "+unitprice);
            totalcharge = unitprice*quantity;
            edt_amount.setText("Total Amount: Kes "+totalcharge);
            txt_quantity.setText("Quantity:"+quantity);
        }
        if (product.equals("JH-A610 mini rechargeable ITE")){
            unitprice = 10000;
            txt_unitprice.setText("Price: Kes "+unitprice);
            totalcharge = unitprice*quantity;
            edt_amount.setText("Total Amount: Kes "+totalcharge);
            txt_quantity.setText("Quantity:"+quantity);
        }

        if (product.equals("JH-117 Analog BTE Hearing Amplifier")){
            unitprice = 4700;
            txt_unitprice.setText("Unit Price: Kes "+unitprice);
            totalcharge = unitprice*quantity;
            edt_amount.setText("Total Amount: Kes "+totalcharge);
            txt_quantity.setText("Quantity:"+quantity);
        }
        if (product.equals("Nosal Bone Remodeling oil")){
            unitprice = 500;
            txt_unitprice.setText("Price: Kes "+unitprice);
            totalcharge = unitprice*quantity;
            edt_amount.setText("Total Amount: Kes "+totalcharge);
            txt_quantity.setText("Quantity:"+quantity);
        }

        amount = String.valueOf(totalcharge);

        btn_submit.setOnClickListener(v-> approve());

        btn_print.setOnClickListener(v-> print());
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void approve(){
        String Amount = amount;
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL_ACCEPT,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            Log.e("RESPONSE",response);
                            JSONObject jsonObject=new JSONObject(response);
                            String status=jsonObject.getString("status");
                            String msg=jsonObject.getString("message");
                            if (status.equals("1")){

                                Toast toast= Toast.makeText(Accept.this, msg, Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP,0,250);
                                toast.show();
                                finish();
                            }else{

                                Toast toast= Toast.makeText(Accept.this, msg, Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP,0,250);
                                toast.show();
                            }

                        }catch (Exception e){
                            e.printStackTrace();
                            Toast toast= Toast.makeText(Accept.this, e.toString(), Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.TOP,0,250);
                            toast.show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast toast= Toast.makeText(Accept.this, error.toString(), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP,0,250);
                toast.show();
            }
        }){
            @Override
            protected Map<String,String> getParams()throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("requestID",requestID);
                params.put("amount",Amount);
                Log.e("PARAMS",""+params);
                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }

    public void alertApprove(){
        android.app.AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setMessage("Confirm");
        alertDialog.setCancelable(false);
        alertDialog.setButton2("Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

                return;
            }
        });
        alertDialog.setButton("Approve ", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                approve();
                return;
            }
        });
        alertDialog.show();
    }

    private void print(){
        btn_print.setVisibility(View.GONE);

        View view = getWindow().getDecorView().findViewById(android.R.id.content);
        view.setDrawingCacheEnabled(true);
        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),View. MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache(true);
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);

        PrintHelper photoPrinter = new PrintHelper(this); // Assume that 'this' is your activity
        photoPrinter.setScaleMode(PrintHelper.SCALE_MODE_FIT);
        photoPrinter.printBitmap("print", bitmap);

        btn_print.setVisibility(View.VISIBLE);
    }


}