package org.towm.android.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText Name;
    EditText Age;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText) findViewById(R.id.editText1);
        Age = (EditText) findViewById(R.id.editText2);
        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String loginName = Name.getText().toString();
                String loginAge = Age.getText().toString();

                Intent intent = new Intent (getApplicationContext(), NewActivity.class);
                intent.putExtra("Name", loginName);
                intent.putExtra("Age", loginAge);
                startActivity(intent);
            }
        });

    }
}
