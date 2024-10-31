package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes2.dex */
final class Ij implements zzdh {

    /* renamed from: a */
    private final /* synthetic */ Activity f11606a;

    /* renamed from: b */
    private final /* synthetic */ Bundle f11607b;

    public Ij(Cj cj, Activity activity, Bundle bundle) {
        this.f11606a = activity;
        this.f11607b = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdh
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.f11606a, this.f11607b);
    }
}
