package com.google.android.gms.common;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.widget.ProgressBar;
import com.google.android.gms.common.internal.zzn;

/* loaded from: classes.dex */
public class GoogleApiAvailability {

    /* renamed from: a, reason: collision with root package name */
    public static final int f862a = GooglePlayServicesUtil.f863a;
    private static final GoogleApiAvailability b = new GoogleApiAvailability();

    GoogleApiAvailability() {
    }

    public static GoogleApiAvailability a() {
        return b;
    }

    private String b(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(f862a);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                sb.append(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException e) {
            }
        }
        return sb.toString();
    }

    public int a(Context context) {
        int a2 = GooglePlayServicesUtil.a(context);
        if (GooglePlayServicesUtil.b(context, a2)) {
            return 18;
        }
        return a2;
    }

    public Dialog a(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(activity.getResources().getString(com.google.android.gms.R.string.common_google_play_services_updating_text, GooglePlayServicesUtil.f(activity)));
        builder.setTitle(com.google.android.gms.R.string.common_google_play_services_updating_title);
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        GooglePlayServicesUtil.a(activity, onCancelListener, "GooglePlayServicesUpdatingDialog", create);
        return create;
    }

    public Intent a(Context context, int i, String str) {
        switch (i) {
            case 1:
            case 2:
                return zzn.a("com.google.android.gms", b(context, str));
            case 3:
                return zzn.a("com.google.android.gms");
            case 42:
                return zzn.a();
            default:
                return null;
        }
    }

    public final boolean a(int i) {
        return GooglePlayServicesUtil.b(i);
    }

    public boolean a(Context context, int i) {
        return GooglePlayServicesUtil.b(context, i);
    }

    public boolean a(Context context, String str) {
        return GooglePlayServicesUtil.a(context, str);
    }

    @Deprecated
    public Intent b(int i) {
        return a(null, i, null);
    }

    public void b(Context context) {
        GooglePlayServicesUtil.c(context);
    }
}
