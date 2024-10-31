package com.google.firebase.inappmessaging.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public class ForegroundNotifier implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    private final Handler f17759a = new Handler();

    /* renamed from: b */
    private boolean f17760b = false;

    /* renamed from: c */
    private boolean f17761c = true;

    /* renamed from: d */
    private Listener f17762d;

    /* renamed from: e */
    private Runnable f17763e;

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface Listener {
        void a();
    }

    public void a(Listener listener) {
        this.f17762d = listener;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.f17761c = true;
        Runnable runnable = this.f17763e;
        if (runnable != null) {
            this.f17759a.removeCallbacks(runnable);
        }
        Handler handler = this.f17759a;
        Runnable a2 = RunnableC1639t.a(this);
        this.f17763e = a2;
        handler.postDelayed(a2, 1000L);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.f17761c = false;
        boolean z = !this.f17760b;
        this.f17760b = true;
        Runnable runnable = this.f17763e;
        if (runnable != null) {
            this.f17759a.removeCallbacks(runnable);
        }
        if (z) {
            Logging.c("went foreground");
            this.f17762d.a();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
