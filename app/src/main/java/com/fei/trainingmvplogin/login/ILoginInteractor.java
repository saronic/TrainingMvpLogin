package com.fei.trainingmvplogin.login;

/**
 * Created by lee on 2016/9/28.
 */

public interface ILoginInteractor {
    interface OnLoginListener {
        void onUsernameError();
        void onSuccess();
    }

    void validateCredentials(String userName, String pwd, OnLoginListener listener);
}
