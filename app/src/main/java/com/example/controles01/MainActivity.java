package com.example.controles01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etn,eta;
    private CheckBox cb_java, cb_php, cb_c, cb_cc, cb_python;
    private RadioGroup rg;
    private RadioButton selectRadioButton;
    private String cb_lenguajes;
    private String nombre;
    private String rb_lenguajes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etn = (EditText) findViewById(R.id.txt_nombre);
        eta = (EditText) findViewById(R.id.txt_apellido);

        cb_java = (CheckBox) findViewById(R.id.cb_java);
        cb_php = (CheckBox) findViewById(R.id.cb_php);
        cb_c = (CheckBox) findViewById(R.id.cb_c);
        cb_cc = (CheckBox) findViewById(R.id.cb_cc);
        cb_python = (CheckBox) findViewById(R.id.cb_python);

        rg = (RadioGroup)findViewById(R.id.radioGroup);
    }


    public void enviarDatos (View view){
        Intent enviardato = new Intent(this, SecondActitity.class);
        nombre = etn.getText() + " " + eta.getText();
        enviardato.putExtra("strings_data", nombre);

        //Checkbox
        cb_lenguajes = "";
        enviardato.putExtra("nombre", nombre);
        lenguajesCheckBox (cb_java);
        lenguajesCheckBox (cb_php);
        lenguajesCheckBox (cb_c);
        lenguajesCheckBox (cb_cc);
        lenguajesCheckBox (cb_python);
        enviardato.putExtra("cb_lenguajes", cb_lenguajes);

        //RadioButtons
        selectRadioButton = (RadioButton)findViewById(rg.getCheckedRadioButtonId());
        enviardato.putExtra("rb_lenguajes", selectRadioButton.getText().toString());


        startActivity(enviardato);
    }

    public void lenguajesCheckBox (CheckBox checkBox){

        if(checkBox.isChecked()){

            if(cb_lenguajes != ""){
                cb_lenguajes += ", " + checkBox.getText().toString();
            }else{
                cb_lenguajes = checkBox.getText().toString();

            }
        }
    }
}