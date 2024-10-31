package com.google.android.gms.internal;

import android.view.View;

/* loaded from: classes.dex */
class v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f1665a;
    final /* synthetic */ zzbk b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(zzbk zzbkVar, View view) {
        this.b = zzbkVar;
        this.f1665a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.zzg(this.f1665a);
    }
}
