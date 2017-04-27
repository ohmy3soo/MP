package org.towm.android.a170418lab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RegisterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Intent intent = getIntent();        //Receiving sent intent
        TextView name = (TextView) findViewById(R.id.name);
        TextView sex = (TextView) findViewById(R.id.sex);
        TextView reception = (TextView) findViewById(R.id.reception);

        //Get extras from intent
        name.setText(" : " + intent.getStringExtra("name"));
        sex.setText(" : " + intent.getStringExtra("sex"));
        reception.setText(" : " + intent.getStringExtra("reception"));

        Button btnBack = (Button) findViewById(R.id.back);
        btnBack.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();       //Back to MainActivity
            }
        });

    }
}
