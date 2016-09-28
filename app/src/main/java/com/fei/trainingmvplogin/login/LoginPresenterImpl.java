package com.fei.trainingmvplogin.login;

/**
 * Created by lee on 2016/9/28.
 */

public class LoginPresenterImpl implements ILoginPresenter, ILoginInteractor.OnLoginListener {
    private ILoginView mLoginView;
    private ILoginInteractor mLoginInteractor;

    public LoginPresenterImpl(ILoginView loginView) {
        this.mLoginView = loginView;
        mLoginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String userName, String pwd) {
        if (mLoginView != null) {
            mLoginView.showProgress();
        }
        mLoginInteractor.validateCredentials(userName, pwd, this);
    }

    @Override
    public void onUsernameError() {
        mLoginView.hideProgress();
        mLoginView.setUserNameError();
    }

    @Override
    public void onSuccess() {
        mLoginView.hideProgress();
        mLoginView.goToMainActivity();
    }
}
