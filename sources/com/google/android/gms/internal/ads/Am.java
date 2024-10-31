package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

/* loaded from: classes2.dex */
final class Am implements zzsp {

    /* renamed from: a */
    private final /* synthetic */ Activity f11391a;

    public Am(C1102tm c1102tm, Activity activity) {
        this.f11391a = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzsp
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityDestroyed(this.f11391a);
    }
}
