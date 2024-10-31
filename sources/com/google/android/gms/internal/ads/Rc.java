package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class Rc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzatd f11800a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Rc(zzatd zzatdVar) {
        this.f11800a = zzatdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaji zzajiVar;
        zzaji zzajiVar2;
        zzajiVar = this.f11800a.zzdzx;
        if (zzajiVar != null) {
            zzajiVar2 = this.f11800a.zzdzx;
            zzajiVar2.release();
            this.f11800a.zzdzx = null;
        }
    }
}
