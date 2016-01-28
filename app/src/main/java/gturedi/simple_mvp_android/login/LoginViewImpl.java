package gturedi.simple_mvp_android.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gturedi.simple_mvp_android.R;
import gturedi.simple_mvp_android.home.HomeViewImpl;

// aslında sınıf ismi LoginActivity olsa daha uygun fakat mvp eşletiştirme kolay olsun diye böyle adlandırdım
public class LoginViewImpl
        extends AppCompatActivity
        implements LoginView {

    @Bind(R.id.user)
    protected EditText user;
    @Bind(R.id.pass)
    protected EditText pass;
    @Bind(R.id.login)
    protected Button login;
    @Bind(R.id.progress)
    protected ProgressBar progress;

    protected LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        // basit tutmak adına dagger(dependency injection) kullanmadım, kullanmak daha makbul
        presenter = new LoginPresenterImpl(this, new LoginModelImpl());
    }

    @Override
    public void showLoading() {
        progress.setVisibility(View.VISIBLE);
        login.setEnabled(false);
    }

    @Override
    public void hideLoading() {
        progress.setVisibility(View.GONE);
        login.setEnabled(true);
    }

    @Override
    public void showError(String msg) {
        hideLoading();
        Snackbar.make(user, msg, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, HomeViewImpl.class));
        finish();
    }

    @OnClick(R.id.login)
    public void loginClick(View view) {
        String userVal = user.getText().toString().trim();
        String passVal = pass.getText().toString().trim();
        presenter.login(userVal, passVal);
    }

}