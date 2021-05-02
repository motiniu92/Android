package com.example.internalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private TextView nameTV, passwordTV;
    private EditText nameET, passwordET;
    private Button saveBtn, nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTV = findViewById(R.id.nameTV);
        passwordTV = findViewById(R.id.passwordTV);
        nameET = findViewById(R.id.nameET);
        passwordET = findViewById(R.id.passwordET);
        saveBtn = findViewById(R.id.saveBtn);
        nextBtn = findViewById(R.id.nextBtn);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Go to next page", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(MainActivity.this, SeconedActivity.class);
                startActivity(intent);
            }
        });


    }

    public void saveData(View view) {
        File file = null;

        String name = nameET.getText().toString();
        String password = passwordET.getText().toString();

        FileOutputStream fileOutputStream = null;
        try {
            name = name + " ";
            file = getFilesDir();
            fileOutputStream = openFileOutput("Code.txt", Context.MODE_PRIVATE); //MODE PRIVATE
            fileOutputStream.write(name.getBytes());
            fileOutputStream.write(password.getBytes());
            Toast.makeText(this, "Saved \n" + "Path --" + file + "\tCode.txt", Toast.LENGTH_SHORT).show();
            nameET.setText("");
            passwordET.setText("");
            return;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}