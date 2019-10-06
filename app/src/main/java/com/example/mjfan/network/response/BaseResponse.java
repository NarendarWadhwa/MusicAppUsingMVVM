package com.example.mjfan.network.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BaseResponse<T> {

    @SerializedName("resultCount")
    private int resultCount;

    @SerializedName("results")
    private ArrayList<T> data;

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public ArrayList<T> getData() {
        return data;
    }

    public void setData(ArrayList<T> data) {
        this.data = data;
    }
}
