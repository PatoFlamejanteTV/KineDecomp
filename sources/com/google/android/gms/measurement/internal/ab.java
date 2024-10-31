package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ab implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Q f13744a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ _a f13745b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(_a _aVar, Q q) {
        this.f13745b = _aVar;
        this.f13744a = q;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13744a.zzgw();
        if (zzn.a()) {
            this.f13744a.zzgs().a(this);
            return;
        }
        boolean c2 = this.f13745b.c();
        _a.a(this.f13745b, 0L);
        if (c2) {
            this.f13745b.b();
        }
    }
}
