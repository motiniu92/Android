package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText firstNameET, lastNameET, emailET, passwordET;
    private AutoCompleteTextView bloodgroupACTV;
    private CheckBox conditionCB;
    private Button signUpBtn;
    private String [] bloodgroup ={"A+","A-","B+","B-","O+","O-","AB+","AB-"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, bloodgroup);
   bloodgroupACTV.setAdapter(adapter);
   bloodgroupACTV.setThreshold(1);

   conditionCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
       @Override
       public void onCheckedChanged(CompoundButton compoundButton, boolean check) {
           if (check == true){
               signUpBtn.setVisibility(View.VISIBLE);
           }else
           {
               signUpBtn.setVisibility(View.INVISIBLE);
           }
       }
   });


   signUpBtn.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
       }
   });

    }

    private void init() {
        firstNameET = findViewById(R.id.firstNameET);
        lastNameET = findViewById(R.id.lastNameET);
        emailET = findViewById(R.id.emailET);
        passwordET = findViewById(R.id.passwordET);
        bloodgroupACTV = findViewById(R.id.bloodGroupACTV);
        conditionCB = findViewById(R.id.coditionCB);
        signUpBtn = findViewById(R.id.signUpBtn);
    }
}
