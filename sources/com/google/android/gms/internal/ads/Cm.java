package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
final class Cm implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ Bm f11451a;

    public Cm(Bm bm) {
        this.f11451a = bm;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        boolean z;
        boolean z2;
        List list;
        obj = this.f11451a.f11425c;
        synchronized (obj) {
            z = this.f11451a.f11426d;
            if (z) {
                z2 = this.f11451a.f11427e;
                if (z2) {
                    Bm.a(this.f11451a, false);
                    zzbbd.zzdn("App went background");
                    list = this.f11451a.f11428f;
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        try {
                            ((zzsw) it.next()).zzs(false);
                        } catch (Exception e2) {
                            zzbbd.zzb("", e2);
                        }
                    }
                }
            }
            zzbbd.zzdn("App is still foreground");
        }
    }
}
