package com.dmsoftware.followlife.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dmsoftware.followlife.R;
import com.dmsoftware.followlife.model.Patient;
import com.dmsoftware.followlife.model.User;
import com.dmsoftware.followlife.viewModel.UserViewModel;

public class MainActivity extends AppCompatActivity {

    EditText emailEditText;
    EditText passEditText;
    TextView forgotPassTextView;
    Button loginButton;
    TextView signUpTextView;
    UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context context = this;
        userViewModel = new UserViewModel();

        emailEditText = (EditText) findViewById(R.id.emailEditText);
        passEditText = (EditText) findViewById(R.id.passwordEditText);
        forgotPassTextView = (TextView) findViewById(R.id.forgotPassTextView);
        loginButton = (Button) findViewById(R.id.signInButton);
        signUpTextView = (TextView) findViewById(R.id.signUpTextView);

        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,SignUpActivity.class);
                context.startActivity(intent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateData()) {

                    User user = userViewModel.login(emailEditText.getText().toString(),passEditText.getText().toString(),"token");
                    if (user != null) {
                        Log.d("FollowApp",user.getEmail());

                        Intent intent = new Intent(context,BottomActivity.class);
                        //intent.putExtras();
                        context.startActivity(intent);
                    }
                }
            }
        });

    }

    private Boolean validateData() {

        boolean isCorrect = true;
        /*emailEditText.setError(null);
        passEditText.setError(null);

        View focusView = null;

        if (TextUtils.isEmpty(passEditText.getText().toString())) {
            passEditText.setError("This field is required");
            focusView = passEditText;
            isCorrect = false;
        }

        if (TextUtils.isEmpty(emailEditText.getText().toString())) {
            passEditText.setError("This field is required");
            focusView = emailEditText;
            isCorrect = false;
        }

        if (!isCorrect) {
            focusView.requestFocus();
        }*/

        return isCorrect;
    }
}
