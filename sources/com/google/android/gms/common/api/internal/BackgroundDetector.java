package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

@KeepForSdk
/* loaded from: classes.dex */
public final class BackgroundDetector implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: a */
    private static final BackgroundDetector f10715a = new BackgroundDetector();

    /* renamed from: b */
    private final AtomicBoolean f10716b = new AtomicBoolean();

    /* renamed from: c */
    private final AtomicBoolean f10717c = new AtomicBoolean();

    /* renamed from: d */
    private final ArrayList<BackgroundStateChangeListener> f10718d = new ArrayList<>();

    /* renamed from: e */
    private boolean f10719e = false;

    @KeepForSdk
    /* loaded from: classes.dex */
    public interface BackgroundStateChangeListener {
        @KeepForSdk
        void a(boolean z);
    }

    @KeepForSdk
    private BackgroundDetector() {
    }

    @KeepForSdk
    public static BackgroundDetector a() {
        return f10715a;
    }

    @KeepForSdk
    public final boolean b() {
        return this.f10716b.get();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.f10716b.compareAndSet(true, false);
        this.f10717c.set(true);
        if (compareAndSet) {
            b(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.f10716b.compareAndSet(true, false);
        this.f10717c.set(true);
        if (compareAndSet) {
            b(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        if (i == 20 && this.f10716b.compareAndSet(false, true)) {
            this.f10717c.set(true);
            b(true);
        }
    }

    @KeepForSdk
    public static void a(Application application) {
        synchronized (f10715a) {
            if (!f10715a.f10719e) {
                application.registerActivityLifecycleCallbacks(f10715a);
                application.registerComponentCallbacks(f10715a);
                f10715a.f10719e = true;
            }
        }
    }

    private final void b(boolean z) {
        synchronized (f10715a) {
            ArrayList<BackgroundStateChangeListener> arrayList = this.f10718d;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                BackgroundStateChangeListener backgroundStateChangeListener = arrayList.get(i);
                i++;
                backgroundStateChangeListener.a(z);
            }
        }
    }

    @KeepForSdk
    @TargetApi(16)
    public final boolean a(boolean z) {
        if (!this.f10717c.get()) {
            if (!PlatformVersion.c()) {
                return z;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f10717c.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f10716b.set(true);
            }
        }
        return b();
    }

    @KeepForSdk
    public final void a(BackgroundStateChangeListener backgroundStateChangeListener) {
        synchronized (f10715a) {
            this.f10718d.add(backgroundStateChangeListener);
        }
    }
}
