package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(14)
/* loaded from: classes2.dex */
public final class Bm implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    private Activity f11423a;

    /* renamed from: b */
    private Context f11424b;

    /* renamed from: h */
    private Runnable f11430h;
    private long j;

    /* renamed from: c */
    private final Object f11425c = new Object();

    /* renamed from: d */
    private boolean f11426d = true;

    /* renamed from: e */
    private boolean f11427e = false;

    /* renamed from: f */
    private final List<zzsw> f11428f = new ArrayList();

    /* renamed from: g */
    private final List<zztj> f11429g = new ArrayList();
    private boolean i = false;

    public final void a(Application application, Context context) {
        if (this.i) {
            return;
        }
        application.registerActivityLifecycleCallbacks(this);
        if (context instanceof Activity) {
            a((Activity) context);
        }
        this.f11424b = application;
        this.j = ((Long) zzwu.zzpz().zzd(zzaan.zzcrm)).longValue();
        this.i = true;
    }

    public final Context b() {
        return this.f11424b;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.f11425c) {
            if (this.f11423a == null) {
                return;
            }
            if (this.f11423a.equals(activity)) {
                this.f11423a = null;
            }
            Iterator<zztj> it = this.f11429g.iterator();
            while (it.hasNext()) {
                try {
                    if (it.next().zza(activity)) {
                        it.remove();
                    }
                } catch (Exception e2) {
                    com.google.android.gms.ads.internal.zzbv.i().zza(e2, "AppActivityTracker.ActivityListener.onActivityDestroyed");
                    zzbbd.zzb("", e2);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(activity);
        synchronized (this.f11425c) {
            Iterator<zztj> it = this.f11429g.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onActivityPaused(activity);
                } catch (Exception e2) {
                    com.google.android.gms.ads.internal.zzbv.i().zza(e2, "AppActivityTracker.ActivityListener.onActivityPaused");
                    zzbbd.zzb("", e2);
                }
            }
        }
        this.f11427e = true;
        Runnable runnable = this.f11430h;
        if (runnable != null) {
            zzayh.zzelc.removeCallbacks(runnable);
        }
        Handler handler = zzayh.zzelc;
        Cm cm = new Cm(this);
        this.f11430h = cm;
        handler.postDelayed(cm, this.j);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(activity);
        this.f11427e = false;
        boolean z = !this.f11426d;
        this.f11426d = true;
        Runnable runnable = this.f11430h;
        if (runnable != null) {
            zzayh.zzelc.removeCallbacks(runnable);
        }
        synchronized (this.f11425c) {
            Iterator<zztj> it = this.f11429g.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onActivityResumed(activity);
                } catch (Exception e2) {
                    com.google.android.gms.ads.internal.zzbv.i().zza(e2, "AppActivityTracker.ActivityListener.onActivityResumed");
                    zzbbd.zzb("", e2);
                }
            }
            if (z) {
                Iterator<zzsw> it2 = this.f11428f.iterator();
                while (it2.hasNext()) {
                    try {
                        it2.next().zzs(true);
                    } catch (Exception e3) {
                        zzbbd.zzb("", e3);
                    }
                }
            } else {
                zzbbd.zzdn("App is still foreground.");
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    public final void a(zzsw zzswVar) {
        synchronized (this.f11425c) {
            this.f11428f.add(zzswVar);
        }
    }

    public final Activity a() {
        return this.f11423a;
    }

    private final void a(Activity activity) {
        synchronized (this.f11425c) {
            if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                this.f11423a = activity;
            }
        }
    }

    public static /* synthetic */ boolean a(Bm bm, boolean z) {
        bm.f11426d = false;
        return false;
    }
}
