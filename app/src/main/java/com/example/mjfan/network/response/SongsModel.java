package com.example.mjfan.network.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class SongsModel implements Parcelable {

    public static final Creator<SongsModel> CREATOR = new Creator<SongsModel>() {
        @Override
        public SongsModel createFromParcel(Parcel in) {
            return new SongsModel(in);
        }

        @Override
        public SongsModel[] newArray(int size) {
            return new SongsModel[size];
        }
    };
    @SerializedName("artworkUrl100")
    private String imageUrl;
    @SerializedName("artistName")
    private String artistName;
    @SerializedName("trackName")
    private String trackName;
    @SerializedName("collectionName")
    private String collectionName;
    @SerializedName("releaseDate")
    private String releaseDate;
    @SerializedName("country")
    private String country;

    protected SongsModel(Parcel in) {
        imageUrl = in.readString();
        artistName = in.readString();
        trackName = in.readString();
        collectionName = in.readString();
        releaseDate = in.readString();
        country = in.readString();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imageUrl);
        dest.writeString(artistName);
        dest.writeString(trackName);
        dest.writeString(collectionName);
        dest.writeString(releaseDate);
        dest.writeString(country);
    }
}
