package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Sf implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ View f11825a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzawr f11826b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ int f11827c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzbhu f11828d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Sf(zzbhu zzbhuVar, View view, zzawr zzawrVar, int i) {
        this.f11828d = zzbhuVar;
        this.f11825a = view;
        this.f11826b = zzawrVar;
        this.f11827c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11828d.zza(this.f11825a, this.f11826b, this.f11827c - 1);
    }
}
