package com.example.controles01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActitity extends AppCompatActivity {

    private TextView tv_s;
    private TextView tv_cb;
    private TextView tv_rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_actitity);

        tv_s = (TextView) findViewById(R.id.tv_string);

        tv_cb = (TextView) findViewById(R.id.tv_cb);
        tv_rb = (TextView) findViewById(R.id.tv_rb);

        String strings_data = getIntent().getStringExtra("strings_data");
        tv_s.setText("hola " + strings_data);

        String checkbox_data = getIntent().getStringExtra("cb_lenguajes");
        tv_cb.setText(checkbox_data);

        String radiobutton_data = getIntent().getStringExtra("rb_lenguajes");
        tv_rb.setText(radiobutton_data);


    }

    public void volver(View view){
        Intent volver = new Intent(this, MainActivity.class);
        startActivity(volver);
    }
}