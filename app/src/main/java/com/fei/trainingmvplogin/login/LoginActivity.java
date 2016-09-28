package com.fei.trainingmvplogin.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.fei.trainingmvplogin.R;

public class LoginActivity extends AppCompatActivity implements ILoginView{
    private ProgressBar mProgressBar;
    private EditText mUserNameEditText;
    private EditText mPwdEditText;
    private Button mLoginButton;
    ILoginPresenter mLoginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        mLoginPresenter = new LoginPresenterImpl(this);
    }

    private void initView() {
        mProgressBar = (ProgressBar) findViewById(R.id.progress);
        mUserNameEditText = (EditText) findViewById(R.id.username);
        mPwdEditText = (EditText) findViewById(R.id.password);
        mLoginButton = (Button) findViewById(R.id.button);
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLoginPresenter.validateCredentials(mUserNameEditText.getText().toString(),
                        mPwdEditText.getText().toString());
            }
        });
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setUserNameError() {
        mUserNameEditText.setError("username can not be empty");
    }

    @Override
    public void goToMainActivity() {
        Toast.makeText(this, "go to main activity", Toast.LENGTH_SHORT).show();
    }
}
