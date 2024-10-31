package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

/* loaded from: classes2.dex */
final class Ej implements zzdh {

    /* renamed from: a */
    private final /* synthetic */ Activity f11499a;

    public Ej(Cj cj, Activity activity) {
        this.f11499a = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzdh
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStarted(this.f11499a);
    }
}
