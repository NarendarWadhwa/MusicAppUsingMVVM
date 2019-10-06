package com.example.mjfan.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;

import com.example.mjfan.utils.LoadingDialog;

    /*
    - It will act as abstract base Activity and all child activities will inherit from this activity.
    - Here all the initialization is done such as view inflation using data binding, viewModel creation for all child activities.
    - We can also write common functionality require for multiple activities such as keyboard hiding, back press handling,
    permissions handling so as to avoid boilerplate code.
    */
public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity
        implements UICallbacks {

    protected T mBinding;
    protected V mViewModel;
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(BaseActivity.this, getLayoutId());
        mViewModel = (V) new ViewModelProvider(this).get(getViewModel());
        mViewModel.setNavigator(getNavigatorReference());
        createDialog();
        onBinding();
    }

    // show/hide dialog using LiveData from viewModel
    private void createDialog() {
        loadingDialog = new LoadingDialog(BaseActivity.this);
        loadingDialog.setCancelable(false);

        mViewModel.dialogMessage.observe(BaseActivity.this, msg -> {
            if (loadingDialog != null) {
                loadingDialog.setMessage(String.valueOf(msg));
            }
        });

        mViewModel.dialogVisibility.observe(this, showDialog -> {
            if ((Boolean) showDialog) {
                if (loadingDialog != null && !loadingDialog.isShowing())
                    loadingDialog.show();

            } else {
                if (loadingDialog != null && loadingDialog.isShowing())
                    loadingDialog.dismiss();
            }

        });

    }
}
