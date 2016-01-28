package gturedi.simple_mvp_android.login;

import gturedi.com.gitsamples.mvp.OperationListener;

public interface LoginModel {

    void checkAuthAsync(String user, OperationListener<String> listener);

}
