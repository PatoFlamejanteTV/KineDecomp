package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

/* renamed from: com.google.android.gms.internal.ads.vm */
/* loaded from: classes2.dex */
final class C1130vm implements zzsp {

    /* renamed from: a */
    private final /* synthetic */ Activity f12616a;

    public C1130vm(C1102tm c1102tm, Activity activity) {
        this.f12616a = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzsp
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStarted(this.f12616a);
    }
}
