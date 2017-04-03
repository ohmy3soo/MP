package org.towm.android.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent intent=getIntent();
        if(intent!=null) {
            String loginName = intent.getStringExtra("Name");
            String loginAge = intent.getStringExtra("Age");

            Toast.makeText(getApplication(),"Student info : " + loginName + ", "
                    +loginAge,Toast.LENGTH_LONG).show();
        }

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });
    }
}
