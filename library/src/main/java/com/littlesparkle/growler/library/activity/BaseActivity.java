package com.littlesparkle.growler.library.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.littlesparkle.growler.library.R;

import cn.pedant.SweetAlert.SweetAlertDialog;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
    }

    protected abstract int getLayoutResId();

    protected Dialog showDialogWithMessage(final String message) {
        return showDialogWithMessage(null, message);
    }

    protected Dialog showDialogWithMessage(
            final SweetAlertDialog.OnSweetClickListener listener,
            final String message) {
        SweetAlertDialog dialog = new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText(message)
                .setConfirmText(getString(R.string.ok))
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        if (listener != null) {
                            listener.onClick(sweetAlertDialog);
                        }
                        if (sweetAlertDialog.isShowing()) {
                            sweetAlertDialog.dismissWithAnimation();
                        }
                    }
                });
        dialog.show();
        return dialog;
    }

    protected Dialog showDialogWithCancelButton(
            final SweetAlertDialog.OnSweetClickListener listener,
            final String title, final String message) {
        SweetAlertDialog dialog = new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText(title)
                .setConfirmText(message)
                .setConfirmText(getString(R.string.ok))
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        if (listener != null) {
                            listener.onClick(sweetAlertDialog);
                        }
                        if (sweetAlertDialog.isShowing()) {
                            sweetAlertDialog.dismissWithAnimation();
                        }
                    }
                })
                .showCancelButton(true)
                .setCancelText(getString(R.string.cancel))
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismissWithAnimation();
                    }
                });
        dialog.show();
        return dialog;
    }
}
