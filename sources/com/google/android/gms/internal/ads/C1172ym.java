package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

/* renamed from: com.google.android.gms.internal.ads.ym */
/* loaded from: classes2.dex */
final class C1172ym implements zzsp {

    /* renamed from: a */
    private final /* synthetic */ Activity f12690a;

    public C1172ym(C1102tm c1102tm, Activity activity) {
        this.f12690a = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzsp
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStopped(this.f12690a);
    }
}
