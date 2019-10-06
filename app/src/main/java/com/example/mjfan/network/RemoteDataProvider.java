package com.example.mjfan.network;

import com.example.mjfan.network.response.SongsModel;

import java.util.ArrayList;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

    /*
    - It will act as a contract for providing data from web service to viewModel
    similarly we can create contract for local DB.
    */
public interface RemoteDataProvider {

    Disposable fetchData(Consumer<ArrayList<SongsModel>> success, Consumer<Throwable> error);


}
