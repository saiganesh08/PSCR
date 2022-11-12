package com.example.pscr22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText username,password;
    Button login;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=findViewById(R.id.e1);
        password=findViewById(R.id.e2);
        login=findViewById(R.id.b1);
        dbHelper=new DBHelper(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
                if(user.equals("") || pass.equals(("")))
                {
                    Toast.makeText(LoginActivity.this,"Please fill all the details",Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkuserpass=dbHelper.checkusernamepasswords(user,pass);
                    if(checkuserpass == true)
                    {
                        Toast.makeText(LoginActivity.this,"Signin is Successful",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent);

                    }
                    //setEnterSharedElementCallback();
                    else {
                        Toast.makeText(LoginActivity.this,"Invalid credentials",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}
