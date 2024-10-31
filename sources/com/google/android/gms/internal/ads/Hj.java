package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

/* loaded from: classes2.dex */
final class Hj implements zzdh {

    /* renamed from: a */
    private final /* synthetic */ Activity f11574a;

    public Hj(Cj cj, Activity activity) {
        this.f11574a = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzdh
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStopped(this.f11574a);
    }
}
