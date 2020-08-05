package com.example.tp2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextInputLayout errornom,errorprenom, erroremail,errortxtDate;
    EditText prenom, nom, email;
    Spinner classe;
    Button btn;
    Button btnDatePicker, btnTimePicker;
    EditText txtDate, txtTime;
    private int mYear, mMonth, mDay, mHour, mMinute;


    public void openact2(){
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("nom", nom.getText().toString());
        intent.putExtra("prenom", prenom.getText().toString());
        intent.putExtra("email",email.getText().toString());
        intent.putExtra("classe",classe.getSelectedItem().toString());
        startActivity(intent);
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nom = findViewById(R.id.nom);
        errornom =  findViewById(R.id.filledTextField);
        prenom = findViewById(R.id.prenom);
        errorprenom = findViewById(R.id.filledTextField1);
        email = findViewById(R.id.email);
        erroremail = findViewById(R.id.filledTextField2);
        classe = findViewById(R.id.classe);
        btn =findViewById(R.id.button);
        btnDatePicker=findViewById(R.id.btn_date);
        btnTimePicker=findViewById(R.id.btn_time);
        txtDate=findViewById(R.id.in_date);
        errortxtDate = findViewById(R.id.filledTextField4);
        txtTime=findViewById(R.id.in_time);
        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);
        Spinner spinner = findViewById(R.id.classe);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
        R.array.classe, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valider(v);
            }
        });
    }

    public void valider(View v) {
        if (nom.getText().length() == 0 || prenom.getText().length() == 0 || email.getText().length() == 0 || txtDate.getText().length() == 0) {
           // Toast.makeText(this, "Veuillez remplir tous les champs ! ", Toast.LENGTH_LONG).show();
            if (nom.getText().length() == 0){
                errornom.setErrorEnabled(true);
                errornom.setError("You need to enter a name");
            }else{
                errornom.setErrorEnabled(false);
            }
            if (prenom.getText().length() == 0){
                errorprenom.setErrorEnabled(true);
                errorprenom.setError("You need to enter a prename");
            }else{
                errornom.setErrorEnabled(false);
            }
            if (txtDate.getText().length() == 0){
                errortxtDate.setErrorEnabled(true);
                errortxtDate.setError("You need to enter a Date");
            }else{
                errortxtDate.setErrorEnabled(false);
            }
            if (email.getText().length() == 0){
                erroremail.setErrorEnabled(true);
                erroremail.setError("You need to enter a email");
            }else{
                erroremail.setErrorEnabled(false);
            }

        } else {
            AlertDialog.Builder ad;
            ad = new AlertDialog.Builder(this);
            ad.setMessage("Les données sont enregistré");
            ad.setTitle("Success");
            ad.setIcon(android.R.drawable.btn_dialog);

            ad.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    openact2();
                }
            });
            ad.setNegativeButton("Cancel", null);
            AlertDialog a = ad.create();
            a.show();
        }
    }

    @Override
    public void onClick(View v) {
        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        public void onDateSet(DatePicker view, int year,int monthOfYear, int dayOfMonth) {
                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == btnTimePicker) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
    }
}
