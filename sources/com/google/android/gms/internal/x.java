package com.google.android.gms.internal;

import android.webkit.ValueCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements ValueCallback<String> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ w f1667a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.f1667a = wVar;
    }

    @Override // android.webkit.ValueCallback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onReceiveValue(String str) {
        this.f1667a.d.zza(this.f1667a.b, this.f1667a.c, str);
    }
}
