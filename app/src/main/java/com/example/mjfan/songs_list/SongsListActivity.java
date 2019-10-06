package com.example.mjfan.songs_list;

import android.content.Intent;

import com.example.mjfan.R;
import com.example.mjfan.base.BaseActivity;
import com.example.mjfan.base.BaseNavigator;
import com.example.mjfan.databinding.ActivitySongsListBinding;
import com.example.mjfan.network.response.SongsModel;
import com.example.mjfan.song_details.SongDetailsActivity;
import com.example.mjfan.utils.Utils;

public class SongsListActivity extends BaseActivity<ActivitySongsListBinding, SongsListViewModel> implements SongsListNavigator {

    @Override
    public void onError(String message) {
        Utils.getInstance().showMessage(SongsListActivity.this, message);
    }

    @Override
    public void onNoInternet() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_songs_list;
    }

    @Override
    public Class getViewModel() {
        return SongsListViewModel.class;
    }

    @Override
    public BaseNavigator getNavigatorReference() {
        return SongsListActivity.this;
    }

    @Override
    public void onBinding() {
        getSupportActionBar().setTitle("Songs List");
        setUpListView();
    }

    private void setUpListView() {
        SongsAdapter adapter = new SongsAdapter(SongsListActivity.this);
        mBinding.lvSongs.setAdapter(adapter);
        mViewModel.getSongsList().observe(this, adapter::updateData);
        mViewModel.getSongs();
        mBinding.lvSongs.setOnItemClickListener((parent, view, position, id) -> {
            SongsModel songModel = mViewModel.getSongsList().getValue().get(position);
            Intent songDetailIntent = new Intent(SongsListActivity.this, SongDetailsActivity.class);
            songDetailIntent.putExtra("selected_song", songModel);
            startActivity(songDetailIntent);
        });
    }
}
