package com.facebook.internal;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.WebDialog;

/* loaded from: classes.dex */
public class FacebookDialogFragment extends android.support.v4.app.i {
    public static final String TAG = "FacebookDialogFragment";
    private Dialog dialog;

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    @Override // android.support.v4.app.i, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        WebDialog facebookWebFallbackDialog;
        super.onCreate(bundle);
        if (this.dialog == null) {
            android.support.v4.app.l activity = getActivity();
            Bundle methodArgumentsFromIntent = NativeProtocol.getMethodArgumentsFromIntent(activity.getIntent());
            if (!methodArgumentsFromIntent.getBoolean(NativeProtocol.WEB_DIALOG_IS_FALLBACK, false)) {
                String string = methodArgumentsFromIntent.getString(NativeProtocol.WEB_DIALOG_ACTION);
                Bundle bundle2 = methodArgumentsFromIntent.getBundle(NativeProtocol.WEB_DIALOG_PARAMS);
                if (Utility.isNullOrEmpty(string)) {
                    Utility.logd(TAG, "Cannot start a WebDialog with an empty/missing 'actionName'");
                    activity.finish();
                    return;
                }
                facebookWebFallbackDialog = new WebDialog.Builder(activity, string, bundle2).setOnCompleteListener(new k(this)).build();
            } else {
                String string2 = methodArgumentsFromIntent.getString("url");
                if (Utility.isNullOrEmpty(string2)) {
                    Utility.logd(TAG, "Cannot start a fallback WebDialog with an empty/missing 'url'");
                    activity.finish();
                    return;
                } else {
                    facebookWebFallbackDialog = new FacebookWebFallbackDialog(activity, string2, String.format("fb%s://bridge/", FacebookSdk.getApplicationId()));
                    facebookWebFallbackDialog.setOnCompleteListener(new l(this));
                }
            }
            this.dialog = facebookWebFallbackDialog;
        }
    }

    @Override // android.support.v4.app.i
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.dialog == null) {
            onCompleteWebDialog(null, null);
            setShowsDialog(false);
        }
        return this.dialog;
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.dialog instanceof WebDialog) {
            ((WebDialog) this.dialog).resize();
        }
    }

    @Override // android.support.v4.app.i, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCompleteWebDialog(Bundle bundle, FacebookException facebookException) {
        android.support.v4.app.l activity = getActivity();
        activity.setResult(facebookException == null ? -1 : 0, NativeProtocol.createProtocolResultIntent(activity.getIntent(), bundle, facebookException));
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCompleteWebFallbackDialog(Bundle bundle) {
        android.support.v4.app.l activity = getActivity();
        Intent intent = new Intent();
        if (bundle == null) {
            bundle = new Bundle();
        }
        intent.putExtras(bundle);
        activity.setResult(-1, intent);
        activity.finish();
    }
}
