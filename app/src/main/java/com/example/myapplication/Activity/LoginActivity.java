package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity {
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        setVariable();

    }

    private void setVariable() {

        binding.loginBtn.setOnClickListener(view -> {
            String email = binding.UserEdit.getText().toString();
            String password = binding.PassEdit.getText().toString();

            if(!email.isEmpty() && !password.isEmpty())
            {
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this, task -> {
                    if(task.isSuccessful())
                    {
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }else {
                        Toast.makeText(LoginActivity.this,"Authentication Failed",Toast.LENGTH_SHORT).show();
                    }
                });
            }else {
                Toast.makeText(LoginActivity.this, "Please enter email and password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}