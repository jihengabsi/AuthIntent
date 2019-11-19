package com.example.authintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
   final String EXTRA_LOGIN ="user_login";
   final String EXTRA_PASSWORD="user_password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText login =findViewById(R.id.user_email);
        final EditText pass=findViewById(R.id.user_password);
        final Button loginButton =findViewById(R.id.connect);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String loginTxt=login.getText().toString();
                final String passTxt=pass.getText().toString();

                if (loginTxt.equals("")|| passTxt.equals("")){
                    Toast.makeText(MainActivity.this,R.string.email_or_password_empty,
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                Pattern p=Pattern.compile(".+@.+\\.[a-z]+");
                Matcher m=p.matcher(loginTxt);
                if(!m.matches()){
                    Toast.makeText(MainActivity.this,R.string.email_format_error,
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent=new Intent(MainActivity.this,
                        LoginDisplayActivity.class);
                intent.putExtra(EXTRA_LOGIN,loginTxt);
                intent.putExtra(EXTRA_PASSWORD,passTxt);
                startActivity(intent);

            }
            });
    }
}

