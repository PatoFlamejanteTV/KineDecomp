package com.mixpanel.android.mpmetrics;

import android.util.Log;
import com.mixpanel.android.mpmetrics.a;
import com.mixpanel.android.mpmetrics.n;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnalyticsMessages.java */
/* loaded from: classes.dex */
public class b implements n.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3024a;
    final /* synthetic */ a.b.HandlerC0058a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a.b.HandlerC0058a handlerC0058a, String str) {
        this.b = handlerC0058a;
        this.f3024a = str;
    }

    @Override // com.mixpanel.android.mpmetrics.n.a
    public void a(n nVar) {
        if (m.f3036a) {
            Log.v("MixpanelAPI.Messages", "Using existing pushId " + this.f3024a);
        }
        nVar.c().c(this.f3024a);
    }
}
