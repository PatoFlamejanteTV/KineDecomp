package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

/* renamed from: com.google.android.gms.internal.ads.wm */
/* loaded from: classes2.dex */
final class C1144wm implements zzsp {

    /* renamed from: a */
    private final /* synthetic */ Activity f12645a;

    public C1144wm(C1102tm c1102tm, Activity activity) {
        this.f12645a = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzsp
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityResumed(this.f12645a);
    }
}
