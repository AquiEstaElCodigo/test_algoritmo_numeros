package cl.aquilotienes.test_algoritmo_numeros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    Button btnNumeros;
    TextView tvResultadoNumeros;
    EditText etNumeros;
    String resultado;
    Map<Integer, String> numeros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultado = "";
        numeros = new HashMap<Integer, String>();

        numeros.put(1, "kiñe");
        numeros.put(2, "epu");
        numeros.put(3, "küla");
        numeros.put(4, "meli");
        numeros.put(5, "kechu");
        numeros.put(6, "kayu");
        numeros.put(7, "regle");
        numeros.put(8, "pura");
        numeros.put(9, "aylla");
        numeros.put(10, "mari");
        numeros.put(100, "pataka");
        numeros.put(1000, "waranga");


        btnNumeros = (Button) findViewById(R.id.btnNumeros);
        etNumeros = (EditText) findViewById(R.id.etNumeros);
        tvResultadoNumeros = (TextView) findViewById(R.id.tvResultadoNumeros);

        btnNumeros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int num = Integer.parseInt(etNumeros.getText().toString());

                //transformarNumeros1(num);
                //Log.i("NUMERO: ", ""+ transformarNumero(num));
                transformacionDeNumeros(num);


            }
        });

    }

    private void transformacionDeNumeros(int num){

        String cadena = Integer.toString(num);
        char[] caracter = cadena.toCharArray();
        int[] digito = new int[6];
        int cantidad = cadena.length();


        switch (cantidad){

            case 1: //------- 1 y 9 -----
                Log.i("MENSAJE", "1 DIGITO");
                Log.i("NUMERO: ", "" + numeros.get(num));

                break;

            case 2: //----- 10 y 99 ---
                Log.i("MENSAJE", "2 DIGITO");

                for(int i = 0; i < cantidad; i++){
                    digito[i] = Character.getNumericValue(caracter[i]);
                }

                Log.i("NUMERO: ", ""+ dosDigitos(num, digito));
                limpiarResultado();

                break;

            case 3:
                Log.i("MENSAJE", "3 DIGITO");

                for(int i = 0; i < cantidad; i++){
                    digito[i] = Character.getNumericValue(caracter[i]);
                }

                Log.i("NUMERO: ", ""+ tresDigitos(num, digito));
                limpiarResultado();

                break;

            case 4:
                Log.i("MENSAJE", "4 DIGITO");

                for(int i = 0; i < cantidad; i++){
                    digito[i] = Character.getNumericValue(caracter[i]);
                }
                Log.i("NUMEROS: ", "" + cuatroDigitos(num, digito));


                break;

            case 5:
                Log.i("MENSAJE", "5 DIGITO");

                break;

            case 6:
                Log.i("MENSAJE", "6 DIGITO");

                break;


        }

    }


    private String cuatroDigitos(int num, int[] digito)
    {
        if(num == 1000)
        {
            resultado = numeros.get(num);
        }
        else
            {
                //2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000
                if(digito[1] == 0 && digito[2] == 0 && digito[3] == 0)
                {
                    resultado = numeros.get(digito[0]) + " waranga";
                }
                else{
                        //1100, 2100, 3100, 4100, 5100, 6100, 7100, 8100, 9100..
                        if(digito[1] == 1 && digito[2] == 0 && digito[3] == 0)
                        {
                            resultado = numeros.get(digito[0]) + " waranga pataka";

                        }
                        else{
                            //1200, 1300, 1400, 1500, 1600, 1700, 1800, 1900 = 2000, 3000...
                                if(digito[1] != 1 && digito[2] == 0 && digito[3] == 0)
                                {
                                    resultado = numeros.get(digito[0]) + " waranga " +
                                            numeros.get(digito[1]) + " pataka";
                                }
                                else
                                    {
                                        //1110, 2110, 3110, 4110, 5110, 6110, 7110, 8110, 9110...
                                        if(digito[1] == 1 && digito[2] == 1 && digito[3] ==0)
                                        {
                                            resultado = numeros.get(digito[0]) + " waranga pataka mari";
                                        }
                                        else
                                            {
                                                //1210, 1310, 1410, 1510, 1610, 1710, 1810, 1910...
                                                if(digito[1] != 1 && digito[2] == 1 && digito[3] == 0)
                                                {
                                                    resultado = numeros.get(digito[0]) + " waranga " +
                                                    numeros.get(digito[1]) + " pataka mari";
                                                }
                                                else
                                                    {
                                                        //1220, 1340, 1450, 1560, 1670, 1780, 1790
                                                        if(digito[1] != 1 && digito[2] != 1 && digito[3] == 0)
                                                        {
                                                            resultado = numeros.get(digito[0]) +
                                                                    " waranga " + numeros.get(digito[1]) +
                                                                    " pataka " + numeros.get(digito[2] +
                                                                    " mari");

                                                        }
                                                }
                                        }

                                }

                        }
                }
        }

        return resultado;
    }//fin método cuatroDigitos()

    private String tresDigitos(int num, int[] digito)
    {

        if(num == 100)
        {
            resultado = numeros.get(num);
        }
        else
        {
            if(num > 100 && num <= 999)
            {
                if(digito[1] == 0 && digito[2] == 0)
                {
                    //100, 200, 300, 400, 500, 600, 700, 800, 900
                    resultado += numeros.get(digito[0]) + " pataka";
                }
                else
                {
                    if(digito[1] == 0)
                    {
                        //101, 102, 103, 104, 105, 106, 107, 108, 109 = 200, 300, 400, 500...
                        resultado += numeros.get(digito[0]) + " pataka " + numeros.get(digito[2]);

                    }
                    else
                    {
                        if(digito[2] == 0)
                        {
                            //110, 120, 130, 140, 150, 160, 170, 180, 190 = 200, 300, 400, 500...
                            resultado += numeros.get(digito[0]) + " pataka " +
                                    numeros.get(digito[1]) + " mari";
                        }
                        else
                        {
                            if(digito[1] == 1)
                            {
                                //114, 115, 116, 117, 118, 119 = 200, 300, 400, 500...
                                resultado += numeros.get(digito[0]) + " pataka  mari "
                                        + numeros.get(digito[2]);
                            }
                            else
                            {
                                resultado += numeros.get(digito[0]) + " pataka " +
                                        numeros.get(digito[1]) + " mari " +
                                        numeros.get(digito[2]);
                            }
                        }
                    }
                }
            }
        }

        return resultado;
    }//fin método tresDigitos





    /*

    private void cuatroDigitos(int num, int[] digito){

        if(num == 1000)
        {
            Log.i("NUMERO: ", "" + numeros.get(num));
        }
        else
        {
            if(num > 1000 && num <= 9999)
            {
                //1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000
                if(digito[1] == 0 && digito[2] == 0 && digito[3] == 0)
                {
                    Log.i("NUMERO: ", "" + numeros.get(digito[0]) + " waranga");
                }
                else
                {
                    //1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009 = 2000, 3000...
                    if(digito[1] == 0 && digito[2] == 0)
                    {
                        Log.i("NUMERO: ", "" + numeros.get(digito[0]) + " waranga " +
                                numeros.get(digito[3]));
                    }
                    else
                    {
                        //1100, 1200, 1300, 1400, 1500, 1600, 1700, 1800, 1900 = 2000..
                        if(digito[2] == 0 && digito[3] == 0)
                        {
                            Log.i("NUMERO: ", "" + numeros.get(digito[0]) + " waranga " +
                                    numeros.get(digito[1]) + " pataka");
                        }
                        else
                        {
                            //1010, 1020, 1030, 1040, 1050, 1060, 1070, 1080, 1090
                            if(digito[1] == 0 && digito[3] == 0)
                            {
                                Log.i("NUMERO: ", "" + numeros.get(digito[0]) + " waranga " +
                                        numeros.get(digito[2]) + " mari");
                            }
                            else
                            {
                                //1110, 1120, 1130, 1140, 1150, 1160, 1170
                                if(digito[3] == 0)
                                {
                                    Log.i("NUMERO: ", "" +
                                            numeros.get(digito[0]) + " waranga " +
                                            numeros.get(digito[1]) + " pataka " +
                                            numeros.get(digito[2]) + " mari");
                                }
                                else
                                {
                                    //1101, 1102, 1103, 1104, 1105, 1106, 1107...
                                    if(digito[2] == 0)
                                    {
                                        Log.i("NUMERO: ", "" +
                                                numeros.get(digito[0]) + " waranga " +
                                                numeros.get(digito[1]) + " pataka " +
                                                numeros.get(digito[3]));
                                    }
                                    else
                                    {
                                        //1011, 1012, 1013, 1014, 1015, 1016...
                                        if(digito[1] == 0)
                                        {

                                            if(digito[2] == 1){
                                                Log.i("NUMERO: ", "" +
                                                        numeros.get(digito[0]) + " waranga mari " +  numeros.get(digito[3]));
                                            }else{

                                                Log.i("NUMERO: ", "" + numeros.get(digito[0]) + " waranga " + numeros.get(digito[2]) + " mari " +
                                                        numeros.get(digito[3]));
                                            }

                                        }
                                        else
                                            {
                                                //1115, 1116, 1117
                                                if(digito[3] == 1)
                                                {
                                                    Log.i("NUMEROS: ", ""+ numeros.get(digito[0]) + " waranga " + numeros.get(digito[1]) +
                                                            " pataka mari" + numeros.get(digito[3]));
                                                }
                                                else {
                                                    Log.i("NUMERO: ", "" +
                                                            numeros.get(digito[0]) +
                                                            " waranga " + numeros.get(digito[1]) +
                                                            " pataka " + numeros.get(digito[2]) +
                                                            " mari " + numeros.get(digito[3]));
                                                }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


    }


*/




    private String dosDigitos(int num, int[] digito){

        if(num == 10)
        {
            resultado += numeros.get(num);

        }
        else
        {
            if(num > 10 && num < 20)
            {
                resultado += "Mari " + numeros.get(digito[1]);
            }
            else
            {
                if(num >= 20 && num <= 99)
                {
                    //20, 30, 40, 50, 60, 70, 80, 90
                    if(digito[1] == 0)
                    {
                        resultado += numeros.get(digito[0]) + " mari";
                    }
                    else
                    {
                        resultado += numeros.get(digito[0]) + " mari " + numeros.get(digito[1]);
                    }

                }
            }
        }

        return resultado;
    }//fin método dosDigitos()










    private void limpiarResultado(){
        resultado = "";
    }




/*

    private String transformarNumero(int num){


         //   Algoritmo_numeros Brian Riveros Sepúlveda


        String[] basicos =
                {
                        "kiñe", "epu", "küla", "meli", "kechu",
                        "kayu", "regle", "pura", "aylla", "mari"
                };

        String[] inter =
                {
                        "waranga", "pataka", "mari", ""
                };

        String cadena = Integer.toString(num);
        String palabra = " ";
        int var = cadena.length();


        for(int i = 0; i <= var; i++){

            if((var - i) == 1)

            if( Character.getNumericValue(cadena.charAt(i)) == 1)
                palabra = palabra + " " + basicos[0];

            if(Character.getNumericValue(cadena.charAt(i)) == 2)
                palabra = palabra + " " + basicos[1];

            if(Character.getNumericValue(cadena.charAt(i)) == 3)
                palabra = palabra + " " + basicos[2];

            if(Character.getNumericValue(cadena.charAt(i)) == 4)
                palabra = palabra + " " + basicos[3];

            if(Character.getNumericValue(cadena.charAt(i)) == 5)
                palabra = palabra + " " + basicos[4];

            if(Character.getNumericValue(cadena.charAt(i)) == 6)
                palabra = palabra + " " + basicos[5];

            if(Character.getNumericValue(cadena.charAt(i)) == 7)
                palabra = palabra + " " + basicos[6];

            if(Character.getNumericValue(cadena.charAt(i)) == 8)
                palabra = palabra + " " + basicos[7];

            if(Character.getNumericValue(cadena.charAt(i)) == 9)
                palabra = palabra + " " + basicos[8];

            if(Character.getNumericValue(cadena.charAt(i)) == 10)
                palabra = palabra + " " + basicos[9];

            if( (Character.getNumericValue(cadena.charAt(i)) != 0) || (var == 4)){

                if(var == 6)
                    palabra = palabra + " " + inter[1];

                if(var == 5)
                    palabra = palabra + " " + inter[2];

                if(var == 4)
                    palabra = palabra + " " + inter[0];

                if(var == 3)
                    palabra = palabra + " " + inter[1];

                if(var == 2)
                    palabra = palabra + " " + inter[2];

                if(var == 1)
                    palabra = palabra + " " + inter[3];

                var = var - 1;

            }


        }

        return palabra;


    }



    private void transformarNumeros1(int num){


        if(num == 0 && num < 0) // 1-
        {
            Log.i("NUMERO: ", "INCORRECTO");
        }
        else // 1-
        {
            if(num >=1 && num <= 10) //--2
            {
                Log.i("NUMERO: ", ""+numeros.get(num));
            }
            else //--2
            {
                if(num > 11 && num < 20) //---3
                {

                    String valor = Integer.toString(num);
                    char caracter = valor.charAt(1);
                    int num1 = Character.getNumericValue(caracter);

                    Log.i("NUMEROS: ", " "+ numeros.get(10)+ " " + numeros.get(num1));


                }else //---3
                {
                    if(num >= 20 && num <= 99) //--4
                    {

                        String valor = Integer.toString(num);
                        char dato1 = valor.charAt(0);
                        char dato2 = valor.charAt(1);

                        int num1 = Character.getNumericValue(dato1);
                        int num2 = Character.getNumericValue(dato2);

                        if(num2 != 0)//---4.1
                        {
                            Log.i("NUMERO: ", "" + numeros.get(num1) +
                                    " mari--" + numeros.get(num2));
                        }
                        else//---4.1
                            {
                            Log.i("NUMERO: ", ""+ numeros.get(num1) +
                                    " mari ");
                        }


                    }
                    else //--4
                        {

                            if(num >= 100 && num <= 999)//--5
                            {
                                String valor = Integer.toString(num);
                                char dato1 = valor.charAt(0);
                                char dato2 = valor.charAt(1);
                                char dato3 = valor.charAt(2);

                                int num1 = Character.getNumericValue(dato1);
                                int num2 = Character.getNumericValue(dato2);
                                int num3 = Character.getNumericValue(dato3);

                                if(num == 100){ //5.1

                                    Log.i("NUMERO: ", ""+ numeros.get(num));

                                }else{ //5.1
                                    if(num2 == 0 && num3 == 0)//5.1.1
                                    {

                                        Log.i("NUMERO: ", ""+ numeros.get(num1) +
                                                " pataka");
                                    }else //5.1.1
                                        {

                                        if(num2 == 0) //5.1.1.1
                                        {
                                            Log.i("NUMERO: ", "" + numeros.get(num1) +
                                                    " pataka " + numeros.get(num3));
                                        }else //5.1.1.1
                                            {
                                            Log.i("NUMERO: ", "" + numeros.get(num1) +
                                                    " pataka " + numeros.get(num2) + " mari "
                                                    + numeros.get(num3));
                                        }
                                    }

                                }

                            }
                            else //--5
                                {

                                    if(num >= 1000 && num <= 9999)//--6
                                    {
                                        String valor = Integer.toString(num);
                                        char dato1 = valor.charAt(0);
                                        char dato2 = valor.charAt(1);
                                        char dato3 = valor.charAt(2);
                                        char dato4 = valor.charAt(3);

                                        int num1 = Character.getNumericValue(dato1);
                                        int num2 = Character.getNumericValue(dato2);
                                        int num3 = Character.getNumericValue(dato3);
                                        int num4 = Character.getNumericValue(dato4);

                                        if(num == 1000)//6.1
                                        {
                                            Log.i("NUMERO: ", ""+ numeros.get(num));
                                        }
                                        else//6.1
                                            {
                                            if(dato2 == 0 && dato3 == 0)
                                            {
                                                Log.i("NUMERO: ", ""+ numeros.get(num1)
                                                        + " waranga " + numeros.get(num));
                                            }
                                        }




                                    }
                                    else //--6
                                        {

                                    }


                            }


                    }


                }


            }


        }



    }

*/



}
