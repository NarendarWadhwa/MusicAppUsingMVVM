package com.example.mjfan.splash;

import android.content.Intent;
import android.os.Handler;

import com.example.mjfan.R;
import com.example.mjfan.base.BaseActivity;
import com.example.mjfan.base.BaseNavigator;
import com.example.mjfan.databinding.ActivitySplashBinding;
import com.example.mjfan.songs_list.SongsListActivity;
import com.example.mjfan.utils.Utils;

public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashViewModel> implements SplashNavigator {

    @Override
    public void onError(String message) {
        Utils.getInstance().showMessage(SplashActivity.this, message);
    }

    @Override
    public void onNoInternet() {

    }

    @Override
    public int getLayoutId() {
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return R.layout.activity_splash;
    }

    @Override
    public Class getViewModel() {
        return SplashViewModel.class;
    }

    @Override
    public BaseNavigator getNavigatorReference() {
        return SplashActivity.this;
    }

    @Override
    public void onBinding() {
        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, SongsListActivity.class));
            finish();
        }, 2000);
    }
}
