package com.example.mjfan.songs_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.mjfan.databinding.ItemSongBinding;
import com.example.mjfan.network.response.SongsModel;

import java.util.ArrayList;

public class SongsAdapter extends BaseAdapter {

    private ArrayList<SongsModel> songsList;
    private LayoutInflater mInflater;

    SongsAdapter(Context context) {
        this.songsList = new ArrayList<>();
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return songsList.size();
    }

    @Override
    public Object getItem(int position) {
        return songsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    void updateData(ArrayList<SongsModel> songsList) {
        this.songsList = songsList;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SongsViewHolder songsViewHolder;

        if (convertView == null) {
            ItemSongBinding binding = ItemSongBinding.inflate(mInflater);
            convertView = binding.getRoot();
            songsViewHolder = new SongsViewHolder(binding);
            convertView.setTag(songsViewHolder);
        } else {
            songsViewHolder = (SongsViewHolder) convertView.getTag();
        }

        SongsModel item = songsList.get(position);
        songsViewHolder.binding.setModel(item);

        return convertView;
    }

    private class SongsViewHolder {
        private ItemSongBinding binding;

        SongsViewHolder(ItemSongBinding binding) {
            this.binding = binding;
        }
    }
}
