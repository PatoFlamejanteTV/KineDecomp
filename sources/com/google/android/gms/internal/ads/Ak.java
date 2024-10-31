package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class Ak implements InterfaceC1170yk {

    /* renamed from: a */
    private final /* synthetic */ zzip f11382a;

    private Ak(zzip zzipVar) {
        this.f11382a = zzipVar;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1170yk
    public final int a(int i) {
        return zzip.zzab(i);
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1170yk
    public final void b(int i) throws zzfx {
        this.f11382a.zzad(i);
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1170yk
    public final boolean c(int i) {
        return zzip.zzac(i);
    }

    public /* synthetic */ Ak(zzip zzipVar, C1184zk c1184zk) {
        this(zzipVar);
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1170yk
    public final void a(int i, long j, long j2) throws zzfx {
        this.f11382a.zzd(i, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1170yk
    public final void a(int i, long j) throws zzfx {
        this.f11382a.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1170yk
    public final void a(int i, double d2) throws zzfx {
        this.f11382a.zza(i, d2);
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1170yk
    public final void a(int i, String str) throws zzfx {
        this.f11382a.zza(i, str);
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1170yk
    public final void a(int i, int i2, zzia zziaVar) throws IOException, InterruptedException {
        this.f11382a.zza(i, i2, zziaVar);
    }
}
