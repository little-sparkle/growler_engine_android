package com.littlesparkle.growler.library.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.littlesparkle.growler.library.R;
import com.littlesparkle.growler.library.base.OptionItemAdapter;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class DialogHelper {
    public static Dialog showDialogWithMessage(final Context context, final String message) {
        return showDialogWithMessage(context, null, message);
    }

    public static Dialog showDialogWithMessage(
            final Context context,
            final SweetAlertDialog.OnSweetClickListener listener,
            final String message) {
        SweetAlertDialog dialog = new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                .setTitleText(message)
                .setConfirmText(context.getString(R.string.ok))
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

    public static Dialog showDialogWithCancelButton(
            final Context context,
            final SweetAlertDialog.OnSweetClickListener listener,
            final String title, final String message) {
        SweetAlertDialog dialog = new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                .setTitleText(title)
                .setConfirmText(message)
                .setConfirmText(context.getString(R.string.ok))
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
                .setCancelText(context.getString(R.string.cancel))
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismissWithAnimation();
                    }
                });
        dialog.show();
        return dialog;
    }

    public static void showOptionsDialog(final Context context, final int[] options) {
        showOptionsDialog(context, options, null, null, null);
    }

    public static void showOptionsDialog(
            final Context context,
            final int[] options,
            final DialogInterface.OnClickListener clickListener,
            final DialogInterface.OnCancelListener cancelListener,
            final DialogInterface.OnDismissListener dismissListener) {
        new AlertDialog.Builder(context)
                .setAdapter(new OptionItemAdapter(context, R.layout.option_item, options), clickListener)
                .setOnCancelListener(cancelListener)
                .setOnDismissListener(dismissListener)
                .show();
    }
}
