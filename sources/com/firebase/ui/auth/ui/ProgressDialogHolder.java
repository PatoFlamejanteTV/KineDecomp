package com.firebase.ui.auth.ui;

import android.app.ProgressDialog;
import android.content.Context;

/* loaded from: classes.dex */
public class ProgressDialogHolder {
    private Context mContext;
    private ProgressDialog mProgressDialog;

    public ProgressDialogHolder(Context context) {
        this.mContext = context;
    }

    private void showLoadingDialog(String str) {
        dismissDialog();
        if (this.mProgressDialog == null) {
            this.mProgressDialog = new ProgressDialog(this.mContext);
            this.mProgressDialog.setIndeterminate(true);
            this.mProgressDialog.setTitle("");
        }
        this.mProgressDialog.setMessage(str);
        this.mProgressDialog.show();
    }

    public void dismissDialog() {
        ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog != null) {
            progressDialog.dismiss();
            this.mProgressDialog = null;
        }
    }

    public boolean isProgressDialogShowing() {
        ProgressDialog progressDialog = this.mProgressDialog;
        return progressDialog != null && progressDialog.isShowing();
    }

    public void showLoadingDialog(int i) {
        showLoadingDialog(this.mContext.getString(i));
    }
}
