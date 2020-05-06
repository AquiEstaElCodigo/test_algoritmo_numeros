package cl.aquilotienes.test_algoritmo_numeros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button btnNumeros;
    TextView tvResultadoNumeros;
    EditText etNumeros;

    int kiñe = 1, epu = 2, küla = 3, meli = 4, kechu = 5, kayu = 6, regle = 7, pura = 8,
        aylla = 9, mari = 10, pataka = 100, waranga = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNumeros = (Button) findViewById(R.id.btnNumeros);
        etNumeros = (EditText) findViewById(R.id.etNumeros);
        tvResultadoNumeros = (TextView) findViewById(R.id.tvResultadoNumeros);

        btnNumeros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int num = Integer.parseInt(etNumeros.getText().toString());

                int cantidad = etNumeros.getText().toString().length();

                if(cantidad >=  1 && cantidad < 3)
                {
                    Log.i("TIPO","MARI");
                }
                else if(cantidad >= 3 && cantidad < 4)
                {
                    Log.i("TIPO", "PATAKA");
                }
                else if(cantidad >= 4 && cantidad <= 6)
                {
                    Log.i("TIPO", "WARANGA");
                }

                switch(num){

                    case 1:
                        tvResultadoNumeros.setText("Kiñe");
                        break;
                    case 2:
                        tvResultadoNumeros.setText("Epu");
                        break;
                }

            }
        });

    }



}
