package com.example.Varsani.Staff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.Varsani.R;

public class SelectLogin extends AppCompatActivity {

    private Button btn_finance,btn_shipping_mrg,btn_driver,btn_store_mrg, btn_service_mrg, btn_tech , btn_rec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_login);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btn_driver=findViewById(R.id.btn_driver);
        btn_finance=findViewById(R.id.btn_finance);
        btn_shipping_mrg=findViewById(R.id.btn_shipping_mrg);
        btn_store_mrg=findViewById(R.id.btn_store_manager);
        btn_service_mrg = findViewById(R.id.btn_service_manager);
        btn_tech = findViewById(R.id.btn_tech);
        btn_rec = findViewById(R.id.btn_receptionist);



        btn_driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String staff="Driver";
                Intent intent=new Intent(getApplicationContext(),StaffLogin.class);
                intent.putExtra("Staff",staff);
                startActivity(intent);
            }
        });
        btn_finance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String staff="Finance";
                Intent intent=new Intent(getApplicationContext(),StaffLogin.class);
                intent.putExtra("Staff",staff);
                startActivity(intent);
            }
        });
        btn_shipping_mrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String staff="Shipping manager";
                Intent intent=new Intent(getApplicationContext(),StaffLogin.class);
                intent.putExtra("Staff",staff);
                startActivity(intent);
            }
        });
        btn_store_mrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String staff="Stock manager";
                Intent intent=new Intent(getApplicationContext(),StaffLogin.class);
                intent.putExtra("Staff",staff);
                startActivity(intent);
            }
        });

        btn_service_mrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String staff="Service manager";
                Intent sv = new Intent(getApplicationContext(),StaffLogin.class);
                sv.putExtra("Staff",staff);
                startActivity(sv);
            }
        });

        btn_tech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String staff="Specialist";
                Intent tc = new Intent(getApplicationContext(),StaffLogin.class);
                tc.putExtra("Staff",staff);
                startActivity(tc);
            }
        });

        btn_rec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String staff="Receptionist";
                Intent tc = new Intent(getApplicationContext(),StaffLogin.class);
                tc.putExtra("Staff",staff);
                startActivity(tc);
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
