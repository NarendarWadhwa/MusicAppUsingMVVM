package com.example.mjfan.song_details;

import com.example.mjfan.R;
import com.example.mjfan.base.BaseActivity;
import com.example.mjfan.base.BaseNavigator;
import com.example.mjfan.databinding.ActivitySongDetailsBinding;
import com.example.mjfan.network.response.SongsModel;
import com.example.mjfan.utils.Utils;

public class SongDetailsActivity extends BaseActivity<ActivitySongDetailsBinding, SongDetailsViewModel> implements SongDetailsNavigator {

    @Override
    public void onError(String message) {
        Utils.getInstance().showMessage(SongDetailsActivity.this, message);
    }

    @Override
    public void onNoInternet() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_song_details;
    }

    @Override
    public Class getViewModel() {
        return SongDetailsViewModel.class;
    }

    @Override
    public BaseNavigator getNavigatorReference() {
        return SongDetailsActivity.this;
    }

    @Override
    public void onBinding() {
        getSupportActionBar().setTitle("Song Details");
        if (getIntent() != null && getIntent().getExtras() != null) {
            SongsModel songModel = getIntent().getExtras().getParcelable("selected_song");
            mBinding.setModel(songModel);
        }
    }
}
