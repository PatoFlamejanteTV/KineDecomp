package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzaxf;

/* loaded from: classes.dex */
final class M implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ L f10004a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public M(L l) {
        this.f10004a = l;
    }

    @Override // java.lang.Runnable
    public final void run() {
        L l = this.f10004a;
        l.f10003d.zzb(new zzaxf(l.f10000a, null, null, null, null, null, null, null));
    }
}
