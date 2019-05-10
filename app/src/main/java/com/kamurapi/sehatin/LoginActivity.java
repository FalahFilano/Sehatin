package com.kamurapi.sehatin;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import android.view.View;
import android.view.View.OnClickListener;

import com.filano.sehatin.R;

public class LoginActivity extends AppCompatActivity {

    EditText user,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (EditText)findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
//        pass.setVisibility(View.GONE);
        addListenerButton();
    }

    private void addListenerButton() {
        final Context context = this;
        Button buttonlogin = (Button) findViewById(R.id.login);
        Button buttonRegis = (Button) findViewById(R.id.register);
        buttonlogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, UserUpdateActivity.class);
                startActivity(intent);
            }
        });
        buttonRegis.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, RegisActivity.class);
                startActivity(intent);
            }
        });

    }


}
