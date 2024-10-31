package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;

/* loaded from: classes.dex */
public abstract class zzl {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f1015a = new Object();
    private static zzl b;

    public static zzl a(Context context) {
        synchronized (f1015a) {
            if (b == null) {
                b = new zzm(context.getApplicationContext());
            }
        }
        return b;
    }

    public abstract boolean a(ComponentName componentName, ServiceConnection serviceConnection, String str);

    public abstract boolean a(String str, ServiceConnection serviceConnection, String str2);

    public abstract void b(ComponentName componentName, ServiceConnection serviceConnection, String str);

    public abstract void b(String str, ServiceConnection serviceConnection, String str2);
}
