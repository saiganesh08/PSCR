package com.example.pscr22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EmailActivity extends AppCompatActivity {
    EditText e1,e2,e3;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        e1=findViewById(R.id.e1);// from email address
        e2=findViewById(R.id.e2);//subject of the email
        e3=findViewById(R.id.e3);//body of the email
        b1=findViewById(R.id.b1);//send button
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,new String[] { "apscr64@gmail.com","userpscr@gmail.com" });

                intent.putExtra(Intent.EXTRA_SUBJECT,e2.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT,e3.getText().toString());
                
                //intent.setType("message/rfc822");
                intent.setPackage("com.google.android.gm");
                //startActivity(Intent.createChooser(intent,"choose mail app:"));
                // intent.setType("text/plain");
                intent.setType("message/rfc822");
                //Toast.makeText(EmailActivity.this, "Your message is sended successfully !!", Toast.LENGTH_SHORT).show();
                startActivity(intent);



            }



        });


    }
}

