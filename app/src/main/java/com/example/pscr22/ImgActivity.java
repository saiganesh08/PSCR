package com.example.pscr22;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class ImgActivity extends Activity {
    EditText edittextEmailAddress;
    EditText edittextEmailSubject;
    EditText edittextEmailText;
    TextView textImagePath;
    Button buttonSelectImage;
    Button buttonSendEmail_intent;

    final int RQS_LOADIMAGE = 0;
    final int RQS_SENDEMAIL = 1;

    Uri imageUri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);
        edittextEmailAddress = (EditText)findViewById(R.id.e1);
        edittextEmailSubject = (EditText)findViewById(R.id.e2);
        edittextEmailText = (EditText)findViewById(R.id.e3);
        textImagePath = (TextView)findViewById(R.id.t1);
        buttonSelectImage = (Button)findViewById(R.id.b1);
        buttonSendEmail_intent = (Button)findViewById(R.id.b2);

        buttonSelectImage.setOnClickListener(buttonSelectImageOnClickListener);
        buttonSendEmail_intent.setOnClickListener(buttonSendEmail_intentOnClickListener);
    }
    OnClickListener buttonSelectImageOnClickListener
            = new OnClickListener(){

        @Override
        public void onClick(View arg0) {
            Intent intent = new Intent(Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, RQS_LOADIMAGE);
        }};

    OnClickListener buttonSendEmail_intentOnClickListener
            = new OnClickListener(){

        @Override
        public void onClick(View arg0) {
            String emailAddress = edittextEmailAddress.getText().toString();
            String emailSubject = edittextEmailSubject.getText().toString();
            String emailText = edittextEmailText.getText().toString();
            //String emailAddressList[] = {emailAddress};

            Intent intent = new Intent(Intent.ACTION_SEND);

            intent.putExtra(Intent.EXTRA_EMAIL,new String[] { "apscr64@gmail.com" });
            intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
            intent.putExtra(Intent.EXTRA_TEXT, emailText);

            if(imageUri != null){
                intent.putExtra(Intent.EXTRA_STREAM, imageUri);
                intent.setType("image/png");
            }else{
                intent.setType("plain/text");
            }

            startActivity(Intent.createChooser(intent, "Choice App to send email:"));

        }};

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            switch(requestCode){
                case RQS_LOADIMAGE:
                    imageUri = data.getData();
                    textImagePath.setText(imageUri.toString());
                    break;
                case RQS_SENDEMAIL:

                    break;
            }

        }
    }


}
