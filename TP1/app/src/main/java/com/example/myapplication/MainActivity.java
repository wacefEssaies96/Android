package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText prenom, nom, email,  poids, taille;
    double result = 0;
    TextView msg ;
    Button btn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        email = findViewById(R.id.email);
        taille = findViewById(R.id.taille);
        poids = findViewById(R.id.poids);
        msg = findViewById(R.id.msg);
        btn =findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean error = false;
                if( nom.getText().toString().length() == 0 ){
                    nom.setError( "Nom is required!" );
                    error = true;
                }
                if( prenom.getText().toString().length() == 0 ){
                    prenom.setError( "prenom is required!" );
                    error = true;

                }
                if( email.getText().toString().length() == 0 ){
                    error = true;
                    email.setError( "email is required!" );
                }
                if( taille.getText().toString().length() == 0 ){
                    error = true;
                    taille.setError( "taille is required!" );
                }
                if( poids.getText().toString().length() == 0 ){
                    error = true;
                    poids.setError( "poids is required!" );
                }
                if (error == true){
                    String Msg = "Les champs ne sont pas valide ! ";
                    msg.setText(Msg);
                }
                else{
                    result = Math.round(Double.parseDouble(poids.getText().toString()) / Math.pow(Double.parseDouble(taille.getText().toString()),2));
                    String BMI;
                    if (result < 16){
                        BMI = "severement maigre";
                    }else if(result < 18.5){
                        BMI = "maigre";
                    }else if(result < 25){
                        BMI = "normal";
                    }else if(result < 30){
                        BMI = "en surpoids";
                    }else{
                        BMI = "en obésité ! ";
                    }
                    String Msg = "bonjour " +nom.getText().toString()+' '+prenom.getText().toString()+", votre BMI est : "+result+" Vous étes "+BMI;
                    msg.setText(Msg);
                }
            }
        });


    }
}
