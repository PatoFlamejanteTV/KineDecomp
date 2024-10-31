package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes2.dex */
final class Dj implements zzdh {

    /* renamed from: a */
    private final /* synthetic */ Activity f11470a;

    /* renamed from: b */
    private final /* synthetic */ Bundle f11471b;

    public Dj(Cj cj, Activity activity, Bundle bundle) {
        this.f11470a = activity;
        this.f11471b = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdh
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.f11470a, this.f11471b);
    }
}
