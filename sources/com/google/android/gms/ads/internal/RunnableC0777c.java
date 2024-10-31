package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzwb;

/* renamed from: com.google.android.gms.ads.internal.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class RunnableC0777c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzwb f10024a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzah f10025b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0777c(zzah zzahVar, zzwb zzwbVar) {
        this.f10025b = zzahVar;
        this.f10024a = zzwbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        boolean A;
        obj = this.f10025b.t;
        synchronized (obj) {
            A = this.f10025b.A();
            if (A) {
                this.f10025b.a(this.f10024a);
            } else {
                this.f10025b.a(this.f10024a, 1);
            }
        }
    }
}
