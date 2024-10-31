package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzwb;

/* renamed from: com.google.android.gms.ads.internal.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class RunnableC0778d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzwb f10026a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ int f10027b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzah f10028c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0778d(zzah zzahVar, zzwb zzwbVar, int i) {
        this.f10028c = zzahVar;
        this.f10026a = zzwbVar;
        this.f10027b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        obj = this.f10028c.t;
        synchronized (obj) {
            this.f10028c.a(this.f10026a, this.f10027b);
        }
    }
}
