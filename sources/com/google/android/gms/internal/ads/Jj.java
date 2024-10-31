package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

/* loaded from: classes2.dex */
final class Jj implements zzdh {

    /* renamed from: a */
    private final /* synthetic */ Activity f11630a;

    public Jj(Cj cj, Activity activity) {
        this.f11630a = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzdh
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityDestroyed(this.f11630a);
    }
}
