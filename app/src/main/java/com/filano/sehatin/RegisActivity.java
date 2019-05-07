package com.filano.sehatin;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);
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
                Intent intent = new Intent(context, UserUpdateActivity.class);
                startActivity(intent);
            }
        });

    }
}
