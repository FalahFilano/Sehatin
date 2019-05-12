package com.kamurapi.sehatin;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.filano.sehatin.R;

public class UserUpdateActivity extends AppCompatActivity {

    EditText etGender, etTgl,etBb,etTb,etDana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_update);

        etGender = (EditText) findViewById(R.id.gender);
        etTgl = (EditText) findViewById(R.id.tgl);
        etBb = (EditText) findViewById(R.id.bb);
        etTb = (EditText) findViewById(R.id.tb);
        etDana = (EditText) findViewById(R.id.dana);
        addListenerButton();
    }

    private void addListenerButton() {
        final Context context = this;
        Button buttonsimpan = (Button) findViewById(R.id.simpan);
        buttonsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if(checkDataEntered()) {
                Intent intent = new Intent(context, MenuActivity.class);
                startActivity(intent);
                }
            }
        });


    }

    protected boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }


    protected boolean checkDataEntered(){
        if (isEmpty(etGender)){
            Toast t = Toast.makeText(this,"Enter a valid username!", Toast.LENGTH_SHORT);
            t.show();
            return false;
        }

        if (isEmpty(etTgl)){
            Toast t = Toast.makeText(this,"Enter a valid birthday!", Toast.LENGTH_SHORT);
            t.show();
            return false;
        }

        if (isEmpty(etTb)){
            Toast t = Toast.makeText(this,"Enter a valid height!", Toast.LENGTH_SHORT);
            t.show();
            return false;
        }

        if (isEmpty(etBb)){
            Toast t = Toast.makeText(this,"Enter a valid weight!", Toast.LENGTH_SHORT);
            t.show();
            return false;
        }

        if (isEmpty(etDana)){
            Toast t = Toast.makeText(this,"Enter a valid dana!", Toast.LENGTH_SHORT);
            t.show();
            return false;
        }



        return  true;
    }

}
