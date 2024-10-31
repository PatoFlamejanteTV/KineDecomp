package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

/* loaded from: classes.dex */
public class zzh implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f1007a;
    private final Fragment b;
    private final Intent c;
    private final int d;

    public zzh(Activity activity, Intent intent, int i) {
        this.f1007a = activity;
        this.b = null;
        this.c = intent;
        this.d = i;
    }

    public zzh(Fragment fragment, Intent intent, int i) {
        this.f1007a = null;
        this.b = fragment;
        this.c = intent;
        this.d = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            if (this.c != null && this.b != null) {
                this.b.startActivityForResult(this.c, this.d);
            } else if (this.c != null) {
                this.f1007a.startActivityForResult(this.c, this.d);
            }
            dialogInterface.dismiss();
        } catch (ActivityNotFoundException e) {
            Log.e("SettingsRedirect", "Can't redirect to app settings for Google Play services");
        }
    }
}
