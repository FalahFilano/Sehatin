package com.kamurapi.sehatin;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.filano.sehatin.R;

import static android.text.TextUtils.isEmpty;

public class RegisActivity extends AppCompatActivity {

    EditText etUsername,etPassword,etEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);


        etUsername = (EditText)findViewById(R.id.user);
        etPassword = (EditText) findViewById(R.id.pass);
        etEmail = (EditText) findViewById(R.id.email);
        addListenerButton();
    }

    private void addListenerButton() {
        final Context context = this;
        Button buttonlogin = (Button) findViewById(R.id.login);
        Button buttonRegis = (Button) findViewById(R.id.register);
        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, LoginActivity.class);
                startActivity(intent);
            }
        });
        buttonRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if(checkDataEntered()) {
                    Intent intent = new Intent(context, UserUpdateActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    protected boolean isEmail(EditText text){
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    protected boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }


    protected boolean checkDataEntered(){
        if (isEmpty(etUsername) && isEmpty(etPassword) && isEmpty(etEmail)){
            Toast t = Toast.makeText(this,"Don't Make empty!", Toast.LENGTH_SHORT);
            t.show();
            return false;
        }



        if (isEmpty(etUsername)){
            Toast t = Toast.makeText(this,"Enter a valid username!", Toast.LENGTH_SHORT);
            t.show();
            return false;
        }

        if (isEmail(etEmail) == false){
            etEmail.setError("Enter valid email!");
            return false;
        }

        if (isEmpty(etPassword)){
            Toast t = Toast.makeText(this,"Enter a valid password!", Toast.LENGTH_SHORT);
            t.show();
            return false;
        }


        return true;
    }
}
