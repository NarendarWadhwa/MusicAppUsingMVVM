package com.example.mjfan.base;

/*
   It contains abstract methods for all child activities to implement to provide specific instances.
   */

public interface UICallbacks {

    int getLayoutId();

    Class getViewModel();

    BaseNavigator getNavigatorReference();

    void onBinding();
}
