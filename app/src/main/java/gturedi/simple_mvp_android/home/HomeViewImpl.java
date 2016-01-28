package gturedi.simple_mvp_android.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import gturedi.com.gitsamples.R;

public class HomeViewImpl
        extends AppCompatActivity
        implements HomeView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

}