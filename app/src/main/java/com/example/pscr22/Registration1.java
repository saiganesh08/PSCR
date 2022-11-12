package com.example.pscr22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Registration1 extends AppCompatActivity {
    EditText e1,e2,e3;
    Button register,login;
    DBHelper dbhelper;
    //ImageView i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration1);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);
        register=findViewById(R.id.b1);
        login=findViewById(R.id.b2);
        //i1=findViewById(R.id.i1);
        dbhelper=new DBHelper(this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=e1.getText().toString();
                String pass=e2.getText().toString();
                String repass=e3.getText().toString();
                /*if(!Patterns.EMAIL_ADDRESS.matcher(user).matches())
                {
                    e1.setText("Invalid Email");
                    e1.setFocusable(true);
                }*/

                if(user.equals("") || pass.equals("") || repass.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Please fill all the fields  ",Toast.LENGTH_SHORT).show();;
                }
                else
                {
                    if(pass.equals(repass))
                    {
                        Boolean checkuser=dbhelper.checkUsers(user);
                        if (checkuser == false)
                        {
                            Boolean insert=dbhelper.insertData(user,pass);
                            if (insert == true)
                            {
                                Toast.makeText(Registration1.this,"Registered Successfully ",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(Registration1.this,"Registration Failed",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(Registration1.this,"User alraedy exists !! Go for logging into account",Toast.LENGTH_SHORT).show();
                        }

                    }
                    else {
                        Toast.makeText(Registration1.this,"Password does not matches",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);


            }
        });
    }
}
