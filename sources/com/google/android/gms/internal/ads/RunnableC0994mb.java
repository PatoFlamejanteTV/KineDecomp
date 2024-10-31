package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.mb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC0994mb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbcb f12320a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzala f12321b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0994mb(zzala zzalaVar, zzbcb zzbcbVar) {
        this.f12321b = zzalaVar;
        this.f12320a = zzbcbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map map;
        Map map2;
        map = this.f12321b.zzdnl;
        for (zzbcb zzbcbVar : map.keySet()) {
            if (zzbcbVar != this.f12320a) {
                map2 = this.f12321b.zzdnl;
                ((zzaku) map2.get(zzbcbVar)).cancel();
            }
        }
    }
}
