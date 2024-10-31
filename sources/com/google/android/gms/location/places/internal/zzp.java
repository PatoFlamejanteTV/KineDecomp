package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class zzp {

    /* renamed from: a, reason: collision with root package name */
    private static final String f1895a = zzp.class.getSimpleName();
    private static final long b = TimeUnit.SECONDS.toMillis(1);
    private static zzp c;
    private final Context d;
    private final Handler e;
    private final Runnable f;
    private final Object g;
    private ArrayList<String> h;
    private ArrayList<String> i;

    /* loaded from: classes.dex */
    private class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (zzp.this.g) {
                Intent intent = new Intent("com.google.android.location.places.METHOD_CALL");
                intent.setPackage("com.google.android.gms");
                intent.putStringArrayListExtra("PLACE_IDS", zzp.this.h);
                intent.putStringArrayListExtra("METHOD_NAMES", zzp.this.i);
                intent.putExtra("PACKAGE_NAME", zzp.this.d.getPackageName());
                intent.putExtra("CLIENT_VERSION", GoogleApiAvailability.f862a);
                zzp.this.d.sendBroadcast(intent);
                zzp.this.h = null;
                zzp.this.i = null;
            }
        }
    }

    private zzp(Context context) {
        this((Context) zzx.a(context), new Handler(Looper.getMainLooper()));
    }

    zzp(Context context, Handler handler) {
        this.f = new a();
        this.g = new Object();
        this.h = null;
        this.i = null;
        this.d = context;
        this.e = handler;
    }

    public static synchronized zzp a(Context context) {
        zzp zzpVar;
        synchronized (zzp.class) {
            zzx.a(context);
            if (Build.VERSION.SDK_INT < 14) {
                zzpVar = null;
            } else {
                if (c == null) {
                    c = new zzp(context.getApplicationContext());
                }
                zzpVar = c;
            }
        }
        return zzpVar;
    }

    public void a(String str, String str2) {
        synchronized (this.g) {
            if (this.h == null) {
                this.h = new ArrayList<>();
                this.i = new ArrayList<>();
                this.e.postDelayed(this.f, b);
            }
            this.h.add(str);
            this.i.add(str2);
            if (this.h.size() >= 10000) {
                if (Log.isLoggable(f1895a, 5)) {
                    Log.w(f1895a, "Event buffer full, flushing");
                }
                this.f.run();
                this.e.removeCallbacks(this.f);
            }
        }
    }
}
