package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

/* loaded from: classes2.dex */
final class Gj implements zzdh {

    /* renamed from: a */
    private final /* synthetic */ Activity f11552a;

    public Gj(Cj cj, Activity activity) {
        this.f11552a = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzdh
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityPaused(this.f11552a);
    }
}
