package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Ef implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ View f11487a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzawr f11488b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ int f11489c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzbgh f11490d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ef(zzbgh zzbghVar, View view, zzawr zzawrVar, int i) {
        this.f11490d = zzbghVar;
        this.f11487a = view;
        this.f11488b = zzawrVar;
        this.f11489c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11490d.zza(this.f11487a, this.f11488b, this.f11489c - 1);
    }
}
