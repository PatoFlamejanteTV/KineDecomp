package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.ads.tm */
/* loaded from: classes2.dex */
final class C1102tm implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    private final Application f12565a;

    /* renamed from: b */
    private final WeakReference<Application.ActivityLifecycleCallbacks> f12566b;

    /* renamed from: c */
    private boolean f12567c = false;

    public C1102tm(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.f12566b = new WeakReference<>(activityLifecycleCallbacks);
        this.f12565a = application;
    }

    private final void a(zzsp zzspVar) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.f12566b.get();
            if (activityLifecycleCallbacks != null) {
                zzspVar.zza(activityLifecycleCallbacks);
            } else {
                if (this.f12567c) {
                    return;
                }
                this.f12565a.unregisterActivityLifecycleCallbacks(this);
                this.f12567c = true;
            }
        } catch (Exception e2) {
            zzbbd.zzb("Error while dispatching lifecycle callback.", e2);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(new C1116um(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        a(new Am(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(new C1158xm(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(new C1144wm(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        a(new C1186zm(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(new C1130vm(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        a(new C1172ym(this, activity));
    }
}
