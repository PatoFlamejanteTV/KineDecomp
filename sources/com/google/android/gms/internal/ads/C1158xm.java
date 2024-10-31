package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

/* renamed from: com.google.android.gms.internal.ads.xm */
/* loaded from: classes2.dex */
final class C1158xm implements zzsp {

    /* renamed from: a */
    private final /* synthetic */ Activity f12673a;

    public C1158xm(C1102tm c1102tm, Activity activity) {
        this.f12673a = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzsp
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityPaused(this.f12673a);
    }
}
