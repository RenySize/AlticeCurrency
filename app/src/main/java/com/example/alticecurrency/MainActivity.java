package com.example.alticecurrency;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Action Bar
    ActionBar actionBar;

    // Monedas
    Cambio d;
    Cambio u;
    Cambio e;
    Cambio j;
    Cambio g;
    Cambio a;
    Cambio c;
    Cambio m;
    Cambio k;
    Cambio s;
    //------------

    // Spinner Seleccion
    Spinner sp1;
    Spinner sp2;
    //--------

    //Titulo
    TextView titulo;

    // Datos
    EditText aConvertir;
    TextView convertido;
    //------

    //Adaptadores
    String[] nombresM;
    ArrayAdapter<String> adapt;
    ArrayList<Cambio> monedas;
    //------

    //Proceso de Conversion
    float dn1;
    float  dn2;
    float res;
    float result;
    //------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Cambio de Color de Action bar
        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0a136e")));
        //-------

        // Inicializacion de cada moneda
        d = new Cambio("DOP", 0.020f);
        u = new Cambio("USD", 1.00f);
        e = new Cambio("EUR", 1.11f);
        j = new Cambio("JPY", 0.0092f);
        g = new Cambio("GBP", 1.24f);
        a = new Cambio("AUD", 0.69f);
        c = new Cambio("CAD", 0.76f);
        m = new Cambio("MXN", 0.053f);
        k = new Cambio("KRW", 0.00085f);
        s = new Cambio("SEK", 0.11f);
        //-------

        // Inicializacion de Spinner
        sp1 = findViewById(R.id.spinner);
        sp2 = findViewById(R.id.spinner2);
        //-----

        // Inicializacion de monedas a convertir y titulo
        aConvertir = findViewById(R.id.editText);
        aConvertir.getText();
        convertido = findViewById(R.id.textView2);
        titulo = findViewById(R.id.textView);
        //------------------

        // Agregar las moneas al arraylist
        monedas = new ArrayList<Cambio>();
        monedas.add(d);
        monedas.add(u);
        monedas.add(e);
        monedas.add(j);
        monedas.add(g);
        monedas.add(a);
        monedas.add(c);
        monedas.add(m);
        monedas.add(k);
        monedas.add(s);
        //-------

        // Declaracion de Nombres
        nombresM = new String[]{
                "Dominican Peso", "USA Dollar", "Euro", "Japanese yen", "Pound Sterling", "Australia Dollar", "Canadian Dollar", "Mexican Peso", "Korean Won", "Swedish Kroa"
        };
        //--------

        // Inicio y set del adapter
        adapt = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nombresM);
        adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapt);
        sp2.setAdapter(adapt);
        //------

        // Evento de eleccion de monedas
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dn1 = (monedas.get(position).valor);
                if (aConvertir.getText().toString().equals("")){
                    return;
                }
                res = Float.parseFloat(aConvertir.getText().toString());
                result = Math.round((dn1/dn2) * res);
                convertido.setText(Float.toString(result));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dn2 = (monedas.get(position).valor);
                if(aConvertir.getText().toString().equals("")){
                    return;
                }
                res = Float.parseFloat(aConvertir.getText().toString());
                result = Math.round((dn1/dn2) * res);
                convertido.setText(Float.toString(result));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //---------


         // Evento mientras se escribe
        aConvertir.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(aConvertir.getText().toString().equals("")){
                    return;
                }
                res = Float.parseFloat(aConvertir.getText().toString());
                result = Math.round((dn1/dn2) * res);
                convertido.setText(Float.toString(result));

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //----------
    }
}
