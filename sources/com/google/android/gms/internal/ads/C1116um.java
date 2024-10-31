package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* renamed from: com.google.android.gms.internal.ads.um */
/* loaded from: classes2.dex */
final class C1116um implements zzsp {

    /* renamed from: a */
    private final /* synthetic */ Activity f12595a;

    /* renamed from: b */
    private final /* synthetic */ Bundle f12596b;

    public C1116um(C1102tm c1102tm, Activity activity, Bundle bundle) {
        this.f12595a = activity;
        this.f12596b = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzsp
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.f12595a, this.f12596b);
    }
}
