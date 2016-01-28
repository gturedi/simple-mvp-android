package gturedi.simple_mvp_android.login;

import gturedi.com.gitsamples.mvp.OperationListener;

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
        model.checkAuthAsync(user, pass, new OperationListener<String>() {
            @Override
            public void onComplate(String data, Exception error) {
                if (error == null) {
                    view.navigateToHome();
                } else {
                    view.showError(error.getMessage());
                }
            }
        });
    }

}