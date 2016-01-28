package gturedi.simple_mvp_android.login;

import android.os.Handler;

import gturedi.com.gitsamples.mvp.OperationListener;

public class LoginModelImpl
        implements LoginModel {

    @Override
    public void checkAuthAsync(final String user, final OperationListener<String> listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (user.equals("gturedi")) {
                    listener.onComplate("bla bla", null);
                } else {
                    listener.onComplate(null, new Exception("credentials are not valid"));
                }
            }
        }, 1500);
    }

}