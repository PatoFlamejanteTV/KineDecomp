package io.fabric.sdk.android;

import android.app.Activity;
import android.os.Bundle;
import io.fabric.sdk.android.b;

/* compiled from: Fabric.java */
/* loaded from: classes3.dex */
public class d extends b.AbstractC0152b {

    /* renamed from: a */
    final /* synthetic */ f f26838a;

    public d(f fVar) {
        this.f26838a = fVar;
    }

    @Override // io.fabric.sdk.android.b.AbstractC0152b
    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.f26838a.a(activity);
    }

    @Override // io.fabric.sdk.android.b.AbstractC0152b
    public void onActivityResumed(Activity activity) {
        this.f26838a.a(activity);
    }

    @Override // io.fabric.sdk.android.b.AbstractC0152b
    public void onActivityStarted(Activity activity) {
        this.f26838a.a(activity);
    }
}
