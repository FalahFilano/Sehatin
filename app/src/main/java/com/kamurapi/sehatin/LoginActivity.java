package com.kamurapi.sehatin;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.filano.sehatin.R;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername, etPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText)findViewById(R.id.user);
        etPassword = (EditText) findViewById(R.id.pass);
//        pass.setVisibility(View.GONE);
        addListenerButton();
    }

    private void addListenerButton() {
        final Context context = this;
        Button buttonlogin = (Button) findViewById(R.id.login);
        Button buttonRegis = (Button) findViewById(R.id.register);
        buttonlogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkDataEntered()) {
                    Intent intent = new Intent(context, UserUpdateActivity.class);
                    startActivity(intent);
                }
            }
        });

        buttonRegis.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RegisActivity.class);
                startActivity(intent);
            }
        });

    }

    protected boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    protected boolean checkDataEntered(){
        if (isEmpty(etUsername) && isEmpty(etPassword)){
            Toast t = Toast.makeText(this,"Don't Make empty!", Toast.LENGTH_SHORT);
            t.show();
            return false;
        }

        if (isEmpty(etUsername)){
            Toast t = Toast.makeText(this,"Enter a valid username!", Toast.LENGTH_SHORT);
            t.show();
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
