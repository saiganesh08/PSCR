package com.example.pscr22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {
    TextView t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t1.setText("How to Post your Complaint ?" + "\n"+" 1. Click on post u r query"+"\n"+" 2. Then enter your email"+"\n"+" 3. write the category of compliant"+"\n"+" 4. Describe your query"+"\n"+" 5. Click on send button");
        t2.setText("How to Post your Complaint via uploading a Photo ?" + "\n"+" 1. Go to Get GPS Location get the location andcopy the address "+"\n"+" 2. Click on post u r query"+"\n"+" 3. Then enter your email"+"\n"+" 4. write the category of compliant then upload a image that relates to the complaint"+"\n"+" 5. Describe your query"+"\n"+" 5. Click on send button");
    }
}

