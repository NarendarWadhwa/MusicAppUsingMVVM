package com.example.mjfan.network;

import com.example.mjfan.R;
import com.example.mjfan.base.MJFanApp;
import com.example.mjfan.network.response.SongsModel;
import com.example.mjfan.utils.NoInternetException;
import com.example.mjfan.utils.Utils;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

    /*
    - It will act as a Data Provider layer for providing data from various sources such as
    local DB, Web Services, shared Preferences, etc.
    */

public class DataProvider implements RemoteDataProvider {

    private static DataProvider mInstance;
    // retrofit instance
    private static ApiInterface mServices;
    private static Utils utils;

    private DataProvider() {
        mServices = ApiClient.getClient();
        utils = Utils.getInstance();
    }

    public static DataProvider getInstance() {
        if (mInstance == null) {
            synchronized (DataProvider.class) {
                if (mInstance == null) {
                    mInstance = new DataProvider();
                }
            }
        }
        return mInstance;
    }

    private boolean isNetworkAvailable() {
        return utils.isNetworkAvailable(MJFanApp.getContext());
    }

    private void noInternetAvailable(Consumer<Throwable> error) {
        try {
            error.accept(new NoInternetException(MJFanApp.getContext().getString(R.string.no_internet_connection)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Disposable getDefaultDisposable() {
        return new Disposable() {
            @Override
            public void dispose() {

            }

            @Override
            public boolean isDisposed() {
                return false;
            }
        };
    }

    @Override
    public Disposable fetchData(Consumer<ArrayList<SongsModel>> success, Consumer<Throwable> error) {
        if (isNetworkAvailable()) {
            return mServices.fetchData().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(baseResponse -> {
                        if (baseResponse.getResultCount() == 0 || baseResponse.getData().size() == 0) {
                            error.accept(new Throwable("No Data Available"));
                            return;
                        }
                        success.accept(baseResponse.getData());
                    }, error);
        } else {
            noInternetAvailable(error);
            return getDefaultDisposable();
        }
    }
}
