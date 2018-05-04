package com.dmsoftware.followlife.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dmsoftware.followlife.R;
import com.dmsoftware.followlife.repositories.NotificationsRepository;
import com.dmsoftware.followlife.viewModel.UserViewModel;

public class SignUpActivity extends AppCompatActivity {

    EditText firstNameEditText;
    EditText lastNameEditText;
    EditText emailEditText;
    EditText passEditText;
    TextView signInTextView;
    Button signUpButton;
    UserViewModel userViewModel;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        userViewModel = new UserViewModel();
        context = this;

        firstNameEditText = (EditText) findViewById(R.id.nameSignUpEditText);
        lastNameEditText = (EditText) findViewById(R.id.lastNameEditText);
        emailEditText = (EditText) findViewById(R.id.emailSignUpEditText);
        passEditText = (EditText) findViewById(R.id.passEditText);
        signInTextView = (TextView) findViewById(R.id.signInTextView);
        signUpButton = (Button) findViewById(R.id.signUpConfirButton);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputValidation()) {
                    String message = userViewModel.signUp(firstNameEditText.getText().toString(),lastNameEditText.getText().toString(),emailEditText.getText().toString(),passEditText.getText().toString());
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    if ("success".equalsIgnoreCase(message)) {
                        builder.setMessage("Te has Registrado Correctamente");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Intent intent = new Intent(context, MainActivity.class);
                                context.startActivity(intent);
                                finish();
                            }
                        });
                    } else {
                        builder.setMessage(message);
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                    }
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            }
        });

        signInTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MainActivity.class);
                context.startActivity(intent);
            }
        });

    }

    private boolean inputValidation(){
        boolean isCorrect = true;
        emailEditText.setError(null);
        passEditText.setError(null);
        lastNameEditText.setError(null);
        firstNameEditText.setError(null);

        View focusView = null;

        if (TextUtils.isEmpty(passEditText.getText().toString())) {
            passEditText.setError("This field is required");
            focusView = passEditText;
            isCorrect = false;
        }

        if (TextUtils.isEmpty(emailEditText.getText().toString())) {
            emailEditText.setError("This field is required");
            focusView = emailEditText;
            isCorrect = false;
        }

        if (TextUtils.isEmpty(firstNameEditText.getText().toString())) {
            firstNameEditText.setError("This field is required");
            focusView = firstNameEditText;
            isCorrect = false;
        }

        if (TextUtils.isEmpty(lastNameEditText.getText().toString())) {
            lastNameEditText.setError("This field is required");
            focusView = lastNameEditText;
            isCorrect = false;
        }

        if (!isCorrect) {
            focusView.requestFocus();
        }

        return isCorrect;
    }
}
