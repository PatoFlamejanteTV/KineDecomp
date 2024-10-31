package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
@zzark
/* loaded from: classes2.dex */
public final class Ue implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private zzbdk f11875a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f11876b = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ue(zzbdk zzbdkVar) {
        this.f11875a = zzbdkVar;
    }

    private final void d() {
        zzayh.zzelc.removeCallbacks(this);
        zzayh.zzelc.postDelayed(this, 250L);
    }

    public final void b() {
        this.f11876b = true;
        this.f11875a.zzabm();
    }

    public final void c() {
        this.f11876b = false;
        d();
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f11876b) {
            return;
        }
        this.f11875a.zzabm();
        d();
    }
}
