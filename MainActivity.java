package org.towm.android.a170418lab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    RadioGroup radioGroup;
    RadioButton male;
    RadioButton female;
    Intent intent;
    CheckBox sms;
    CheckBox eMail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.name);
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.female);
        intent = new Intent(getApplicationContext(), RegisterActivity.class);
        sms = (CheckBox) findViewById(R.id.sms);
        eMail = (CheckBox) findViewById(R.id.email);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                //Name
                String name = editText.getText().toString();
                intent.putExtra("name", name);

                //Sex
                int radioId = radioGroup.getCheckedRadioButtonId();
                if (female.getId() == radioId) {
                    intent.putExtra("sex", "여");
                }
                if (male.getId() == radioId) {
                    intent.putExtra("sex", "남");
                }

                //Reception
                String str = "";
                if(sms.isChecked()){
                    str +=  "SMS";
                }
                if(eMail.isChecked()){
                    //check whether of not & is necessary
                    if(!str.equals(""))
                        str += " & ";
                    str += "e-mail";
                }
                intent.putExtra("reception", str);

                //Call new activity
                startActivity(intent);
            }
        });
    }
}

