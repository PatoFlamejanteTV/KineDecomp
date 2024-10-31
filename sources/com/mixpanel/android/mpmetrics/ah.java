package com.mixpanel.android.mpmetrics;

import com.mixpanel.android.mpmetrics.af;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Tweaks.java */
/* loaded from: classes.dex */
public class ah implements ae<Integer> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3022a;
    final /* synthetic */ af b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(af afVar, String str) {
        this.b = afVar;
        this.f3022a = str;
    }

    @Override // com.mixpanel.android.mpmetrics.ae
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a() {
        af.b a2;
        a2 = this.b.a(this.f3022a);
        return Integer.valueOf(a2.b().intValue());
    }
}
