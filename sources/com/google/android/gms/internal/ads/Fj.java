package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

/* loaded from: classes2.dex */
final class Fj implements zzdh {

    /* renamed from: a */
    private final /* synthetic */ Activity f11536a;

    public Fj(Cj cj, Activity activity) {
        this.f11536a = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzdh
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityResumed(this.f11536a);
    }
}
