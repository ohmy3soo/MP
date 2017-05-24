package org.towm.android.lab6;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText txtData;
    Button writeButton;
    Button clearButton;
    Button readButton;
    Button finishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtData = (EditText)findViewById(R.id.txtData);
        writeButton = (Button)findViewById(R.id.writeButton);
        clearButton = (Button)findViewById(R.id.clearButton);
        readButton = (Button)findViewById(R.id.readButton);
        finishButton = (Button)findViewById(R.id.finishButton);

        writeButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                File sdCard = Environment.getExternalStorageDirectory();
                File directory = new File (sdCard.getAbsolutePath() + "/MyFiles");
                directory.mkdirs();
                File file = new File(directory, "textfile.txt");
                try{
                    FileOutputStream fOut = new FileOutputStream(file);
                    OutputStreamWriter osw = new OutputStreamWriter(fOut);
                    osw.write(txtData.getText().toString());
                    osw.close();
                } catch (Throwable t) {}
                Toast.makeText(getApplicationContext(), "Done writing SD 'textfile.txt'", Toast.LENGTH_SHORT).show();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                txtData.setText("");
            }
        });

        readButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                File sdCard = Environment.getExternalStorageDirectory();
                File directory = new File (sdCard.getAbsolutePath() + "/MyFiles");
                directory.mkdirs();

                File file = new File(directory, "textfile.txt");
                try {
                    FileInputStream fIn = new FileInputStream(file);
                    InputStreamReader isr = new InputStreamReader(fIn);
                    BufferedReader reader = new BufferedReader(isr);
                    String str="";
                    StringBuffer buf = new StringBuffer();
                    while((str = reader.readLine()) != null){
                        buf.append(str + "\n");
                    }
                    isr.close();
                    txtData.setText(buf.toString());
                } catch (Throwable t) {}
                Toast.makeText(getApplicationContext(), "Done reading SD 'textfile.txt'", Toast.LENGTH_SHORT).show();
            }
        });

        finishButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });
    }
}
