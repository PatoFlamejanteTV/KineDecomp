package com.firebase.ui.auth.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import com.google.android.gms.common.GoogleApiAvailability;

/* loaded from: classes.dex */
public class PlayServicesHelper {
    private static final String TAG = "PlayServicesHelper";
    private static GoogleApiAvailability mApiAvailability;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.firebase.ui.auth.util.PlayServicesHelper$1 */
    /* loaded from: classes.dex */
    public static class AnonymousClass1 implements DialogInterface.OnDismissListener {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ DialogInterface.OnCancelListener val$cancelListener;

        AnonymousClass1(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
            activity = activity;
            onCancelListener = onCancelListener;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (PlayServicesHelper.getGoogleApiAvailability().c(activity) != 0) {
                onCancelListener.onCancel(dialogInterface);
            }
        }
    }

    public static GoogleApiAvailability getGoogleApiAvailability() {
        if (mApiAvailability == null) {
            mApiAvailability = GoogleApiAvailability.a();
        }
        return mApiAvailability;
    }

    public static boolean makePlayServicesAvailable(Activity activity, int i, DialogInterface.OnCancelListener onCancelListener) {
        Dialog a2 = getGoogleApiAvailability().a(activity, getGoogleApiAvailability().c(activity), i, (DialogInterface.OnCancelListener) null);
        if (a2 == null) {
            return true;
        }
        a2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.firebase.ui.auth.util.PlayServicesHelper.1
            final /* synthetic */ Activity val$activity;
            final /* synthetic */ DialogInterface.OnCancelListener val$cancelListener;

            AnonymousClass1(Activity activity2, DialogInterface.OnCancelListener onCancelListener2) {
                activity = activity2;
                onCancelListener = onCancelListener2;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (PlayServicesHelper.getGoogleApiAvailability().c(activity) != 0) {
                    onCancelListener.onCancel(dialogInterface);
                }
            }
        });
        a2.show();
        return false;
    }
}
