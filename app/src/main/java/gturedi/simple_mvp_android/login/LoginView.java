package gturedi.simple_mvp_android.login;

public interface LoginView {

    void showLoading();
    void hideLoading();
    void showError(String msg);
    void navigateToHome();

}