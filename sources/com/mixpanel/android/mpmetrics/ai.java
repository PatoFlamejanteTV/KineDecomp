package com.mixpanel.android.mpmetrics;

import com.mixpanel.android.mpmetrics.af;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Tweaks.java */
/* loaded from: classes.dex */
public class ai implements ae<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3023a;
    final /* synthetic */ af b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(af afVar, String str) {
        this.b = afVar;
        this.f3023a = str;
    }

    @Override // com.mixpanel.android.mpmetrics.ae
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Boolean a() {
        af.b a2;
        a2 = this.b.a(this.f3023a);
        return a2.c();
    }
}
