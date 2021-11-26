package com.example.basicbankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText fn,ln,en;
    private Button add;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fn=findViewById(R.id.fn);
        ln=findViewById(R.id.ln);
        en=findViewById(R.id.en);
        add=findViewById(R.id.add);

        dbHandler=new DBHandler(MainActivity.this);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName=fn.getText().toString();
                String lastName=ln.getText().toString();
                String email_ID=en.getText().toString();

                if (firstName.isEmpty() && lastName.isEmpty() && email_ID.isEmpty())
                {
                    Toast.makeText(MainActivity.this,"PLEASE ENTER ALL DATA...",Toast.LENGTH_SHORT).show();
                    return;
                }
                dbHandler .addCustomer(firstName,lastName,email_ID);
                Toast.makeText(MainActivity.this,"New Customer Added",Toast.LENGTH_SHORT).show();
                fn.setText("");
                ln.setText("");
                en.setText("");
            }
        });
    }


}