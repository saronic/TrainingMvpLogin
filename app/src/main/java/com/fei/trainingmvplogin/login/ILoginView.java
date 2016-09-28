package com.fei.trainingmvplogin.login;

/**
 * Created by lee on 2016/9/28.
 */

public interface ILoginView {
    void showProgress();
    void hideProgress();
    void setUserNameError();
    void goToMainActivity();
}
