package com.mixpanel.android.mpmetrics;

import android.util.Log;
import com.mixpanel.android.mpmetrics.n;

/* compiled from: MixpanelAPI.java */
/* loaded from: classes.dex */
class q implements n.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3045a;
    final /* synthetic */ n.d b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(n.d dVar, String str) {
        this.b = dVar;
        this.f3045a = str;
    }

    @Override // com.mixpanel.android.mpmetrics.n.a
    public void a(n nVar) {
        if (m.f3036a) {
            Log.v("MixpanelAPI.API", "Using existing pushId " + this.f3045a);
        }
        nVar.c().c(this.f3045a);
    }
}
