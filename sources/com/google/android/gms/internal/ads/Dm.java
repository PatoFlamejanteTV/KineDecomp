package com.google.android.gms.internal.ads;

import android.view.View;

/* loaded from: classes2.dex */
final class Dm implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ View f11477a;

    /* renamed from: b */
    private final /* synthetic */ zzsx f11478b;

    public Dm(zzsx zzsxVar, View view) {
        this.f11478b = zzsxVar;
        this.f11477a = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11478b.zzk(this.f11477a);
    }
}
