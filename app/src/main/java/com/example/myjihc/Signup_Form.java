package com.example.myjihc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class Signup_Form extends AppCompatActivity {

    EditText txt_fullName, txt_group, txtEmail, txtPassword, txtConfirmPassword;
    RadioButton radioGenderMale;
    RadioButton radioGenderFemale;
    Button btn_register;
    ProgressBar progressBar;
    private FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    String gender="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__form);
        getSupportActionBar().setTitle("Signup Form");

        txt_fullName = (EditText) findViewById(R.id.txt_full_name);
        txt_group = (EditText) findViewById(R.id.txt_group);
        txtEmail = (EditText) findViewById(R.id.txt_email);
        txtPassword = (EditText) findViewById(R.id.txt_password);
        txtConfirmPassword = (EditText) findViewById(R.id.txt_confirm_password);
        btn_register = (Button) findViewById(R.id.buttonRegister);
        radioGenderMale = (RadioButton) findViewById(R.id.radio_male);
        radioGenderFemale = (RadioButton) findViewById(R.id.radio_female);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("Student");

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String gender = "";
                final String fullName = txt_fullName.getText().toString().trim();
                final String group = txt_group.getText().toString().trim();
                final String email = txtEmail.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();
                String confirmpassword = txtConfirmPassword.getText().toString().trim();

              if(radioGenderMale.isChecked()) {

                  gender="Male";
              }
              final String finalGender = gender;
                Toast.makeText(Signup_Form.this, finalGender.toString(), Toast.LENGTH_LONG).show();
              if (radioGenderFemale.isChecked()) {
                  gender="Female";
              }

                if (TextUtils.isEmpty(fullName)) {
                    Toast.makeText(Signup_Form.this, "Full Name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(group)) {
                    Toast.makeText(Signup_Form.this, "Group", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Signup_Form.this, "Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Signup_Form.this, "Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(confirmpassword)) {
                    Toast.makeText(Signup_Form.this, "Confirm Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Signup_Form.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    student information;
                                    information = new student (
                                            fullName,
                                            group,
                                            email,
                                            finalGender
                                    );

                                    FirebaseDatabase .getInstance().getReference("Student")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {

                                            Toast.makeText(Signup_Form.this, "Registration complete", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(getApplicationContext(), MainActivity.class));


                                        }
                                    });

                                } else {
                                 }

                            }
                        });



                if (TextUtils.isEmpty(fullName)) {
                    Toast.makeText(Signup_Form.this, "Full Name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(group)) {
                    Toast.makeText(Signup_Form.this, "Group", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Signup_Form.this, "Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Signup_Form.this, "Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(confirmpassword)) {
                    Toast.makeText(Signup_Form.this, "Confirm Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length()<6) {

                    Toast.makeText(Signup_Form.this, "not enogh characters", Toast.LENGTH_SHORT).show();
                }
                progressBar.setVisibility(View.VISIBLE);

                if (password.equals(confirmpassword)) {
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Signup_Form.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    progressBar.setVisibility(View.GONE);

                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                        Toast.makeText(Signup_Form.this, "Registration complete", Toast.LENGTH_SHORT).show();
                                    } else {

                                        Toast.makeText(Signup_Form.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                }

            }
        });

    }
}