package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    Button btn;
    String str = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        if (intent != null){
            str = ("Nom : "+intent.getStringExtra("nom")+"\nPrenom : "+intent.getStringExtra("prenom")+"\nEmail : "+intent.getStringExtra("email")+"\nClasse :"+intent.getStringExtra("classe"));
            TextView textView = findViewById(R.id.text);
            textView.setText(str);
            btn = findViewById(R.id.button2);
            btn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent sendIntent = new Intent(Intent.ACTION_SEND);
                    sendIntent.setType("text/plain");
                    sendIntent.putExtra(Intent.EXTRA_TEXT, str);
                    startActivity(sendIntent);
                }
            });
        }
    }
}
