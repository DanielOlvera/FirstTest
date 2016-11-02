package com.example.daniel.first_test;

import android.content.Intent;
import android.os.StrictMode;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.daniel.first_test.entities.UsersPJ;

import java.io.IOException;
import java.util.ArrayList;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";
    EditText usrName;
    EditText usrLogin;
    Button btnLogin;

    int attempts = 3;

    OkHttpClient okConnection = new OkHttpClient();

    ArrayList<UsersPJ> usrList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        metaDJson();

        StrictMode.ThreadPolicy strictMode = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(strictMode);

        usrName = (EditText) findViewById(R.id.m_userNameEdTx);
        usrLogin = (EditText) findViewById(R.id.m_passwordEdTx);
        btnLogin = (Button) findViewById(R.id.m_loginBtn);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (UsersPJ usrPJ : usrList) {
                    if(usrPJ.getName().equals(usrName.getText()) && usrPJ.getPassword().equals(usrLogin.getText())){
                        Log.d(TAG, "onClick: " + usrName + usrPJ.getName());
                        Log.d(TAG, "onClick: " + usrLogin + usrPJ.getPassword());
                        //Here im sending the second activity and removing the toast
                        Toast.makeText(MainActivity.this, "Welcome " + usrName.getText(), Toast.LENGTH_SHORT).show();

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
            }
        });

    }

    public void login(View view) {
        Log.d(TAG, "login: ");
    }

    public void metaDJson(){
        String myJson = null;
        try {
            myJson = run("http://www.mocky.io/v2/57a4dfb40f0000821dc9a3b8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        UsersParser userParser = new UsersParser();
        usrList = userParser.parserMagic(myJson);

        for (UsersPJ userPJ : usrList) {
            Log.d(TAG, "metaDJson: " + userPJ);
        }
    }

    String run(String url) throws IOException {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = okConnection.newCall(request).execute();
        return response.body().string();
    }

    public static class RememberUsr extends PreferenceFragment{
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
        }
    }

}

    /*private void getJason(){

        StrictMode.ThreadPolicy strictMode = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(strictMode);

        StringBuilder resultString = new StringBuilder();

        HttpURLConnection urlConnection = null; //Always ni null as a best practice

        try {

            URL url = new URL("http://www.mocky.io/v2/57a01bec0f0000c10d0f650f");
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String jLine = bufferedReader.readLine();



            for (int i = 0; i < jLine.length(); i++) {
                resultString.append(jLine);
                Log.d(TAG, "getJason: ");
            }

            UsersParser usersParser = new UsersParser();
            List<UsersPJ> usersPJs = usersParser.parserMagic(jLine);
            Log.d(TAG, "getJason: " + usersPJs);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
