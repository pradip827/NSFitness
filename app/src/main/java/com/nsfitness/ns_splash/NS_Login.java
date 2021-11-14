package com.nsfitness.ns_splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class NS_Login extends AppCompatActivity {
    EditText username,password;
    Button login;
    LinearLayout insta;
    SharedPreferences sharedPreferences;
    String RegistrationStat, permissionStat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n_s__login);

        getSupportActionBar().hide();

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        insta=findViewById(R.id.insta);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Checking That  user privided inout or not
                if(username.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Please Enter Your User Name",Toast.LENGTH_SHORT).show();
                }
                else if(password.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Please Enter Your Password",Toast.LENGTH_SHORT).show();
                }
                //compairing the login with pre define data
                else if(username.getText().toString().equals("admin") && password.getText().toString().equals("nsadmin"))
                {
                    SharedPreferences.Editor editor = getSharedPreferences("myPref", MODE_PRIVATE).edit();
                    editor.putString("id", username.getText().toString());
                    editor.putString("Registered", ("Yes"));
                   // editor.putString("email", encrypt(StateSelectEdit.getText().toString()));
                    editor.commit();

                    Intent newIntent = new Intent(NS_Login.this,NS_Home.class);
                    startActivity(newIntent);
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"User Name or Password incorrect",Toast.LENGTH_SHORT).show();
                }

            }
        });
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://instagram.com/_u/nsfitness5");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/xxx")));
                }
            }
        });

    }
}