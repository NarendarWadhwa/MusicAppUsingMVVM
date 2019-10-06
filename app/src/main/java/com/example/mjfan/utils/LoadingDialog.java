package com.example.mjfan.utils;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;

import androidx.appcompat.app.AppCompatDialog;

import com.example.mjfan.databinding.DialogProgressBinding;

public class LoadingDialog extends AppCompatDialog {

    private DialogProgressBinding dialogProgressBinding;

    public LoadingDialog(Context context) {
        super(context);
        dialogProgressBinding = DialogProgressBinding.inflate(LayoutInflater.from(context));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setContentView(dialogProgressBinding.getRoot());
    }

    public void setMessage(String message) {
        dialogProgressBinding.txtMessage.setText(message);
    }
}
