package gturedi.simple_mvp_android.login;

import gturedi.simple_mvp_android.LoginResultListener;

public class LoginPresenterImpl
        implements LoginPresenter {

    private final LoginView view;
    private final LoginModel model;

    public LoginPresenterImpl(LoginView view, LoginModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void login(String user, String pass) {
        view.showLoading();
        model.doLogin(user, pass, new LoginResultListener() {
            @Override
            public void onSuccess() {
                view.navigateToHome();
            }
            @Override
            public void onFail() {
                view.showError("given credentials are not valid");
            }
        });
    }

}