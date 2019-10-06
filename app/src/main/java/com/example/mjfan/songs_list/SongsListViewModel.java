package com.example.mjfan.songs_list;

import androidx.lifecycle.MutableLiveData;

import com.example.mjfan.base.BaseViewModel;
import com.example.mjfan.network.DataProvider;
import com.example.mjfan.network.response.SongsModel;

import java.util.ArrayList;

public class SongsListViewModel extends BaseViewModel<SongsListNavigator> {

    private MutableLiveData<ArrayList<SongsModel>> songsList;

    public MutableLiveData<ArrayList<SongsModel>> getSongsList() {
        if (songsList == null) {
            songsList = new MutableLiveData<>();
        }
        return songsList;
    }

    public void getSongs() {
        dialogMessage.setValue("Fetching Songs...");
        dialogVisibility.setValue(true);
        mDisposable.add(DataProvider.getInstance().fetchData(response -> {
            dialogVisibility.setValue(false);
            songsList.setValue(response);
        }, this::checkError));
    }
}
