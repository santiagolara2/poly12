package com.example.santiagolara.poly12;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class AllLoginActivity extends AppCompatActivity {
    private EditText LoginEmail;
    private EditText LoginPassword;
    private Button Login;
    private TextView UserSignUp;


    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private FirebaseAuth.AuthStateListener mAuthListener;
    SignInButton GsignIn;

    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_login);


        LoginEmail = findViewById(R.id.etEmail);
        LoginPassword = findViewById(R.id.etUserPassword);
        Login = findViewById(R.id.btLogin);
        UserSignUp = findViewById(R.id.tvUserSignUp);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validate(LoginName.getText().toString(), LoginPassword.getText().toString());
                String emailString = LoginEmail.getText().toString();
                String pwd = LoginPassword.getText().toString();

                if (!emailString.equals("") & !pwd.equals("")) {
                    mAuth.signInWithEmailAndPassword(emailString, pwd).addOnCompleteListener(AllLoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(!task.isSuccessful())
                                Toast.makeText(AllLoginActivity.this, "Sign In Failed, try again", Toast.LENGTH_SHORT).show();
                                else
                                Toast.makeText(AllLoginActivity.this, "Sign In Successful!", Toast.LENGTH_LONG).show();

                        }
                    });
                }
            }
        });

        UserSignUp.setOnClickListener(new View.OnClickListener(){ //When this TextView is clicked on, it should go to RegisterPage
            @Override
            public void onClick(View v){
                startActivity(new Intent(AllLoginActivity.this, AllSignUpActivity.class));
            }
        });

        GsignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AllLoginActivity.this, GoogleLoginActivity.class)); //When clicked, initiate Google Sign In procedure
            }
        });


        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth){
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user !=null)
                    Log.d(TAG, "user signed in");
                else
                    Log.d(TAG, "user signed out");
            }
        };

    }


    @Override
    protected void onStart(){
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


}
