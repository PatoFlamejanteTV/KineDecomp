package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Gm implements ValueCallback<String> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Em f11554a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Gm(Em em) {
        this.f11554a = em;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(String str) {
        Em em = this.f11554a;
        em.f11519e.zza(em.f11516b, em.f11517c, str, em.f11518d);
    }
}
