package gturedi.simple_mvp_android.login;

import gturedi.simple_mvp_android.LoginResultListener;

// aslında sınıf ismi LoginService olsa daha uygun fakat mvp eşletiştirme kolay olsun diye böyle adlandırdım
public interface LoginModel {

    void doLogin(String user, String pass, LoginResultListener listener);

}