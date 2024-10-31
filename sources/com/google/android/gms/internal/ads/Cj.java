package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Cj implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    private final Application f11445a;

    /* renamed from: b */
    private final WeakReference<Application.ActivityLifecycleCallbacks> f11446b;

    /* renamed from: c */
    private boolean f11447c = false;

    public Cj(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.f11446b = new WeakReference<>(activityLifecycleCallbacks);
        this.f11445a = application;
    }

    private final void a(zzdh zzdhVar) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.f11446b.get();
            if (activityLifecycleCallbacks != null) {
                zzdhVar.zza(activityLifecycleCallbacks);
            } else {
                if (this.f11447c) {
                    return;
                }
                this.f11445a.unregisterActivityLifecycleCallbacks(this);
                this.f11447c = true;
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(new Dj(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        a(new Jj(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(new Gj(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(new Fj(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        a(new Ij(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(new Ej(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        a(new Hj(this, activity));
    }
}
