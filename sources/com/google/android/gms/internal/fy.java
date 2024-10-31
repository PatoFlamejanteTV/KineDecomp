package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.GoogleApiAvailability;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class fy extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    protected Context f1569a;

    public static <T extends fy> T a(Context context, T t) {
        return (T) a(context, t, GoogleApiAvailability.a());
    }

    public static <T extends fy> T a(Context context, T t, GoogleApiAvailability googleApiAvailability) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        context.registerReceiver(t, intentFilter);
        t.f1569a = context;
        if (googleApiAvailability.a(context, "com.google.android.gms")) {
            return t;
        }
        t.a();
        t.b();
        return null;
    }

    protected abstract void a();

    public synchronized void b() {
        if (this.f1569a != null) {
            this.f1569a.unregisterReceiver(this);
        }
        this.f1569a = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            a();
            b();
        }
    }
}
