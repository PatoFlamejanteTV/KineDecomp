package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class Nc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzaxg f11704a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzatd f11705b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Nc(zzatd zzatdVar, zzaxg zzaxgVar) {
        this.f11705b = zzatdVar;
        this.f11704a = zzaxgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzarm zzarmVar;
        zzaji zzajiVar;
        zzaji zzajiVar2;
        zzarmVar = this.f11705b.zzdvp;
        zzarmVar.zza(this.f11704a);
        zzajiVar = this.f11705b.zzdzx;
        if (zzajiVar != null) {
            zzajiVar2 = this.f11705b.zzdzx;
            zzajiVar2.release();
            this.f11705b.zzdzx = null;
        }
    }
}
