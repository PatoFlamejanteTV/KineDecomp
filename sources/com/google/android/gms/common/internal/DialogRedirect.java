package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import com.google.android.gms.common.api.internal.LifecycleFragment;

/* loaded from: classes.dex */
public abstract class DialogRedirect implements DialogInterface.OnClickListener {
    public static DialogRedirect a(Activity activity, Intent intent, int i) {
        return new a(intent, activity, i);
    }

    protected abstract void a();

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            a();
        } catch (ActivityNotFoundException e2) {
            Log.e("DialogRedirect", "Failed to start resolution intent", e2);
        } finally {
            dialogInterface.dismiss();
        }
    }

    public static DialogRedirect a(Fragment fragment, Intent intent, int i) {
        return new b(intent, fragment, i);
    }

    public static DialogRedirect a(LifecycleFragment lifecycleFragment, Intent intent, int i) {
        return new c(intent, lifecycleFragment, i);
    }
}
