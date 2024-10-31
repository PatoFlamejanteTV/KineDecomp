package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.zabr;
import com.google.android.gms.common.internal.ConnectionErrorMessages;
import com.google.android.gms.common.internal.DialogRedirect;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.base.zap;

/* loaded from: classes.dex */
public class GoogleApiAvailability extends GoogleApiAvailabilityLight {

    /* renamed from: c */
    private static final Object f10657c = new Object();

    /* renamed from: d */
    private static final GoogleApiAvailability f10658d = new GoogleApiAvailability();

    /* renamed from: e */
    public static final int f10659e = GoogleApiAvailabilityLight.f10663a;

    /* renamed from: f */
    private String f10660f;

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes.dex */
    public class a extends zap {

        /* renamed from: a */
        private final Context f10661a;

        public a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.f10661a = context.getApplicationContext();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                StringBuilder sb = new StringBuilder(50);
                sb.append("Don't know how to handle this message: ");
                sb.append(i);
                Log.w("GoogleApiAvailability", sb.toString());
                return;
            }
            int c2 = GoogleApiAvailability.this.c(this.f10661a);
            if (GoogleApiAvailability.this.c(c2)) {
                GoogleApiAvailability.this.c(this.f10661a, c2);
            }
        }
    }

    public static GoogleApiAvailability a() {
        return f10658d;
    }

    public boolean b(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog a2 = a(activity, i, i2, onCancelListener);
        if (a2 == null) {
            return false;
        }
        a(activity, a2, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    public void c(Context context, int i) {
        a(context, i, (String) null, a(context, i, 0, "n"));
    }

    public final void d(Context context) {
        new a(context).sendEmptyMessageDelayed(1, 120000L);
    }

    public Dialog a(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return a(activity, i, DialogRedirect.a(activity, a(activity, i, com.umeng.commonsdk.proguard.e.am), i2), onCancelListener);
    }

    private final String b() {
        String str;
        synchronized (f10657c) {
            str = this.f10660f;
        }
        return str;
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    @HideFirstParty
    public int c(Context context) {
        return super.c(context);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public final boolean c(int i) {
        return super.c(i);
    }

    public final boolean a(Activity activity, LifecycleFragment lifecycleFragment, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog a2 = a(activity, i, DialogRedirect.a(lifecycleFragment, a(activity, i, com.umeng.commonsdk.proguard.e.am), 2), onCancelListener);
        if (a2 == null) {
            return false;
        }
        a(activity, a2, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public final String b(int i) {
        return super.b(i);
    }

    public final boolean a(Context context, ConnectionResult connectionResult, int i) {
        PendingIntent a2 = a(context, connectionResult);
        if (a2 == null) {
            return false;
        }
        a(context, connectionResult.a(), (String) null, GoogleApiActivity.a(context, a2, i));
        return true;
    }

    public static Dialog a(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, android.R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(ConnectionErrorMessages.b(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        a(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    public final zabq a(Context context, zabr zabrVar) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        zabq zabqVar = new zabq(zabrVar);
        context.registerReceiver(zabqVar, intentFilter);
        zabqVar.a(context);
        if (a(context, "com.google.android.gms")) {
            return zabqVar;
        }
        zabrVar.a();
        zabqVar.a();
        return null;
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    @ShowFirstParty
    @KeepForSdk
    public int a(Context context, int i) {
        return super.a(context, i);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    @ShowFirstParty
    @KeepForSdk
    public Intent a(Context context, int i, String str) {
        return super.a(context, i, str);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public PendingIntent a(Context context, int i, int i2) {
        return super.a(context, i, i2);
    }

    public PendingIntent a(Context context, ConnectionResult connectionResult) {
        if (connectionResult.Q()) {
            return connectionResult.P();
        }
        return a(context, connectionResult.a(), 0);
    }

    public static Dialog a(Context context, int i, DialogRedirect dialogRedirect, DialogInterface.OnCancelListener onCancelListener) {
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(ConnectionErrorMessages.b(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String a2 = ConnectionErrorMessages.a(context, i);
        if (a2 != null) {
            builder.setPositiveButton(a2, dialogRedirect);
        }
        String e2 = ConnectionErrorMessages.e(context, i);
        if (e2 != null) {
            builder.setTitle(e2);
        }
        return builder.create();
    }

    public static void a(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        if (activity instanceof FragmentActivity) {
            SupportErrorDialogFragment.a(dialog, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), str);
        } else {
            ErrorDialogFragment.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
        }
    }

    @TargetApi(20)
    private final void a(Context context, int i, String str, PendingIntent pendingIntent) {
        int i2;
        if (i == 18) {
            d(context);
            return;
        }
        if (pendingIntent == null) {
            if (i == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String d2 = ConnectionErrorMessages.d(context, i);
        String c2 = ConnectionErrorMessages.c(context, i);
        Resources resources = context.getResources();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        NotificationCompat.Builder style = new NotificationCompat.Builder(context).setLocalOnly(true).setAutoCancel(true).setContentTitle(d2).setStyle(new NotificationCompat.BigTextStyle().bigText(c2));
        if (DeviceProperties.c(context)) {
            Preconditions.b(PlatformVersion.g());
            style.setSmallIcon(context.getApplicationInfo().icon).setPriority(2);
            if (DeviceProperties.d(context)) {
                style.addAction(com.google.android.gms.base.R.drawable.common_full_open_on_phone, resources.getString(com.google.android.gms.base.R.string.common_open_on_phone), pendingIntent);
            } else {
                style.setContentIntent(pendingIntent);
            }
        } else {
            style.setSmallIcon(android.R.drawable.stat_sys_warning).setTicker(resources.getString(com.google.android.gms.base.R.string.common_google_play_services_notification_ticker)).setWhen(System.currentTimeMillis()).setContentIntent(pendingIntent).setContentText(c2);
        }
        if (PlatformVersion.k()) {
            Preconditions.b(PlatformVersion.k());
            String b2 = b();
            if (b2 == null) {
                b2 = "com.google.android.gms.availability";
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                String b3 = ConnectionErrorMessages.b(context);
                if (notificationChannel == null) {
                    notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", b3, 4));
                } else if (!b3.contentEquals(notificationChannel.getName())) {
                    notificationChannel.setName(b3);
                    notificationManager.createNotificationChannel(notificationChannel);
                }
            }
            style.setChannelId(b2);
        }
        Notification build = style.build();
        if (i == 1 || i == 2 || i == 3) {
            i2 = 10436;
            GooglePlayServicesUtilLight.sCanceledAvailabilityNotification.set(false);
        } else {
            i2 = 39789;
        }
        notificationManager.notify(i2, build);
    }
}
