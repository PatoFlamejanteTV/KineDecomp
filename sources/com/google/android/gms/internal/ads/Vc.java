package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Vc implements Callable<zzatz> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f11901a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzaub f11902b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Vc(zzaub zzaubVar, Context context) {
        this.f11902b = zzaubVar;
        this.f11901a = context;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzatz call() throws Exception {
        WeakHashMap weakHashMap;
        zzatz zzwx;
        WeakHashMap weakHashMap2;
        weakHashMap = this.f11902b.zzedp;
        Wc wc = (Wc) weakHashMap.get(this.f11901a);
        if (wc != null) {
            if (!(wc.f11918a + ((Long) zzwu.zzpz().zzd(zzaan.zzcsv)).longValue() < com.google.android.gms.ads.internal.zzbv.l().a())) {
                zzwx = new zzaua(this.f11901a, wc.f11919b).zzwx();
                weakHashMap2 = this.f11902b.zzedp;
                weakHashMap2.put(this.f11901a, new Wc(this.f11902b, zzwx));
                return zzwx;
            }
        }
        zzwx = new zzaua(this.f11901a).zzwx();
        weakHashMap2 = this.f11902b.zzedp;
        weakHashMap2.put(this.f11901a, new Wc(this.f11902b, zzwx));
        return zzwx;
    }
}
