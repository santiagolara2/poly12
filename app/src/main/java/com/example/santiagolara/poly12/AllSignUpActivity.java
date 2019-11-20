package com.example.santiagolara.poly12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static com.example.santiagolara.poly12.SelectLanguageActivity.LANGUAGE_NAME;

public class AllSignUpActivity extends AppCompatActivity {
    private EditText FName;
    private EditText LName;
    private EditText UserName;
    private EditText Email;
    private EditText Password;
    private EditText ConfirmPassword; //Second password check may not be as important...
    private Button Register;
    private TextView userLogin;
    SignInButton signIn;

    //Firebase
    private FirebaseAuth mAuth;

    //Take user here after selecting New to Selected Language or after Basic Language Test
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_sign_up);

        setupUIViews();

        mAuth = FirebaseAuth.getInstance();

        Intent intent = getIntent();
        final String language = intent.getStringExtra(SelectLanguageActivity.LANGUAGE_NAME);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()){
                    //Upload data to database (10/2/19 2:07am and dying)
                    String user_email = Email.getText().toString().trim();
                    String user_password = Password.getText().toString().trim();

                    mAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                //Sign in success, udpate UI with the Signin user's info
                                Toast.makeText(AllSignUpActivity.this, "Registration Success", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(AllSignUpActivity.this, LanguageIntroActivity.class);
                                intent.putExtra(LANGUAGE_NAME, language);
                                startActivity(intent); //Take user to LessonIntro Page of their choice (future)
                            } else {
                                Toast.makeText(AllSignUpActivity.this, "Registration Fail, please try again", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AllSignUpActivity.this, GoogleLoginActivity.class)); //When clicked, initiate Google Sign In procedure
            }
        });
        userLogin.setOnClickListener(new View.OnClickListener(){ //When this TextView is clicked on, it should go back to AllLoginPage
            @Override
            public void onClick(View v){
                startActivity(new Intent(AllSignUpActivity.this, AllLoginActivity.class)); //Take user to Login page
            }
        });
    }

    private void setupUIViews(){
        FName = (EditText)findViewById(R.id.etUserFirst);
        LName = (EditText)findViewById(R.id.etUserLast);
        UserName = (EditText)findViewById(R.id.etUsername);
        Email = (EditText)findViewById(R.id.etEmailAddress);
        Password = (EditText)findViewById(R.id.etUserPassword);
        ConfirmPassword = (EditText)findViewById(R.id.etConfirmPassword);
        Register = (Button)findViewById(R.id.btRegister);
        userLogin = (TextView)findViewById(R.id.tvUserLogin);
    }

    private Boolean validate(){
        Boolean result = false;

        String name = UserName.getText().toString();
        String password1 = Password.getText().toString();
        String password2 = ConfirmPassword.getText().toString();
        String email = Email.getText().toString();
        String fname = FName.getText().toString();
        String lname = LName.getText().toString();

        if(name.isEmpty() || password1.isEmpty() || password2.isEmpty() || email.isEmpty() || fname.isEmpty() || lname.isEmpty()){ //If any field is empty... rather that if all but one (i don't get the error message)
            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show();    //Provides Error Message
        } else if (!(password1.equals(password2))) {
            Toast.makeText(this, "Please make sure passwords match!", Toast.LENGTH_SHORT).show(); //Provides another Error Message
        } else {
            result = true;
        }
        return result;
    }
}
