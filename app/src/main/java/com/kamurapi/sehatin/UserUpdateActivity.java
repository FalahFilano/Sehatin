package com.kamurapi.sehatin;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.filano.sehatin.R;

public class UserUpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_update);
        addListenerButton();
    }

    private void addListenerButton() {
        final Context context = this;
        Button buttonsimpan = (Button) findViewById(R.id.simpan);
        buttonsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, MenuActivity.class);
                startActivity(intent);
            }
        });


    }
}
