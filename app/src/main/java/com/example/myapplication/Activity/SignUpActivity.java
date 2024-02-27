package com.example.myapplication.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class SignUpActivity extends BaseActivity {
ActivitySignUpBinding binding; //This class allows you to access views from the layout file directly in your activity or fragment.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //  this code initializes the data binding for the "activity_sign_up.xml" layout file and sets it as the content view for the activity,
        //  allowing you to access and interact with the views defined in the layout using the binding object.
        
        setVariable();
    }

    private void setVariable() {
        binding.signupBtn.setOnClickListener(view -> {
            String email = binding.UserEdit.getText().toString();
            String password = binding.PassEdit.getText().toString();

            if(password.length()<6)
            {
                Toast.makeText(SignUpActivity.this, "Your password must be 6 character", Toast.LENGTH_SHORT).show();
                return;
            }
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUpActivity.this, task -> {

                if(task.isSuccessful())
                {
                    Log.i(TAG, "onComplete:  ");
                    Toast.makeText(SignUpActivity.this, "Sucessfully Regisgtered", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                }
                else {
                    Log.i(TAG, "failure: " + task.getException());
                    Toast.makeText(SignUpActivity.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                }

            });
        });
    }
}