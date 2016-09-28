package com.fei.trainingmvplogin.login;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by lee on 2016/9/28.
 */
public class LoginInteractorImpl implements ILoginInteractor {
    @Override
    public void validateCredentials(final String userName, String pwd, final OnLoginListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(userName)) {
                    error = true;
                    listener.onUsernameError();
                }

                if (!error) {
                    listener.onSuccess();
                }

            }
        }, 2000);
    }
}
