package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityIntroBinding;

public class IntroActivity extends BaseActivity {
ActivityIntroBinding binding;

//When you enable ViewBinding in your project, Android Studio generates a binding class for each XML layout file in
    // your project. This binding class allows you to access views and other resources defined in the layout XML file directly in your Java/Kotlin
    // code, without the need for findViewById() calls.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntroBinding.inflate(getLayoutInflater()); //The line binding = ActivityIntroBinding.inflate(getLayoutInflater());
        // is used to inflate the layout associated with your IntroActivity and create an instance of the binding class ActivityIntroBinding
        setContentView(binding.getRoot());// [getRoot()]retrieves the root View of the layout
        //setContentView(...): This method is used to set the content view of the activity.


        setVariable();
        getWindow().setStatusBarColor(Color.parseColor("#FFE4B5"));//is used in Android to set the color of the status bar programmatically.
    }

    private void setVariable() {
        binding.loginBtn.setOnClickListener(view -> {
            if(mAuth.getCurrentUser()==null)
            {
                startActivity(new Intent(IntroActivity.this, MainActivity.class));
            }else{
                startActivity(new Intent(IntroActivity.this, LoginActivity.class));
            }
        });


        binding.signUpBtn.setOnClickListener(view -> startActivity(new Intent(IntroActivity.this, SignUpActivity.class)));
    }



}