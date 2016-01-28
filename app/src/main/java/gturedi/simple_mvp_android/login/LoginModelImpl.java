package gturedi.simple_mvp_android.login;

import android.os.Handler;
import gturedi.simple_mvp_android.LoginResultListener;

public class LoginModelImpl
        implements LoginModel {

    public static final String USER = "fener";
    public static final String PASS = "1907";

    @Override
    public void doLogin(final String user, final String pass, final LoginResultListener listener) {
        // burda asenkron islemi karsilayan islemler ui thread'de calistigi icin
        // handler kullandım fakat aslında model katmanının android framework'une bagımlı olmaması gerekli
        // yoksa atıyorum aynı uygulamanın desktop/swing uyarlaması yazılırken sadece view'inin degismesi gerekli
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (user.equals(USER) && pass.equals(PASS)) {
                    listener.onSuccess();
                } else {
                    listener.onFail();
                }
            }
        }, 1500);
    }

}