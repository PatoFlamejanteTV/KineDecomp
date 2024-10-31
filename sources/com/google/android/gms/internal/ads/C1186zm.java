package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* renamed from: com.google.android.gms.internal.ads.zm */
/* loaded from: classes2.dex */
final class C1186zm implements zzsp {

    /* renamed from: a */
    private final /* synthetic */ Activity f12713a;

    /* renamed from: b */
    private final /* synthetic */ Bundle f12714b;

    public C1186zm(C1102tm c1102tm, Activity activity, Bundle bundle) {
        this.f12713a = activity;
        this.f12714b = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzsp
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.f12713a, this.f12714b);
    }
}
