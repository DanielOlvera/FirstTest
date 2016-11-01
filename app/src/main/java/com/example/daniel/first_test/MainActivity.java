package com.example.daniel.first_test;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usrName;
    EditText usrLogin;
    Button btnLogin;

    int attempts = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usrName = (EditText) findViewById(R.id.m_userName);
        usrLogin = (EditText) findViewById(R.id.m_password);
        btnLogin = (Button) findViewById(R.id.m_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usrName.getText().equals("test") && usrLogin.getText().equals("12345")){
                    //Here im sending the second activity and removing the toast
                    Toast.makeText(MainActivity.this, "Welcome" + usrName.getText(), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), LogginActivity.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(MainActivity.this, "Wrong credentials", Toast.LENGTH_SHORT).show();
                    attempts--;
                    if (attempts == 0){
                        Toast.makeText(MainActivity.this, "Blocked account", Toast.LENGTH_SHORT).show();
                        btnLogin.setEnabled(false);
                    }
                }
            }
        });

    }

    public void login(View view) {
    }
}
