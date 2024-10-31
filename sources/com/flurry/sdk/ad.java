package com.flurry.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* loaded from: classes.dex */
public class ad {

    /* renamed from: a, reason: collision with root package name */
    private static ad f451a;
    private final Context b;
    private final Handler c = new Handler(Looper.getMainLooper());
    private final Handler d;

    public static synchronized void a(Context context) {
        synchronized (ad.class) {
            if (f451a == null) {
                if (context == null) {
                    throw new IllegalArgumentException("Context cannot be null");
                }
                f451a = new ad(context);
            }
        }
    }

    public static ad a() {
        return f451a;
    }

    private ad(Context context) {
        this.b = context.getApplicationContext();
        HandlerThread handlerThread = new HandlerThread("BackgroundHandler");
        handlerThread.start();
        this.d = new Handler(handlerThread.getLooper());
    }

    public Context b() {
        return this.b;
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            this.c.post(runnable);
        }
    }
}
