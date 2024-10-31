package com.google.android.gms.internal.ads;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.ads.zl, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1185zl implements zzii {

    /* renamed from: a, reason: collision with root package name */
    private final int f12708a;

    /* renamed from: b, reason: collision with root package name */
    private final int f12709b;

    /* renamed from: c, reason: collision with root package name */
    private final zzfs f12710c;

    /* renamed from: d, reason: collision with root package name */
    public zzfs f12711d;

    /* renamed from: e, reason: collision with root package name */
    private zzii f12712e;

    public C1185zl(int i, int i2, zzfs zzfsVar) {
        this.f12708a = i;
        this.f12709b = i2;
        this.f12710c = zzfsVar;
    }

    public final void a(zzmh zzmhVar) {
        if (zzmhVar == null) {
            this.f12712e = new zzhy();
            return;
        }
        this.f12712e = zzmhVar.zzb(this.f12708a, this.f12709b);
        zzii zziiVar = this.f12712e;
        if (zziiVar != null) {
            zziiVar.zzf(this.f12711d);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzii
    public final int zza(zzia zziaVar, int i, boolean z) throws IOException, InterruptedException {
        return this.f12712e.zza(zziaVar, i, z);
    }

    @Override // com.google.android.gms.internal.ads.zzii
    public final void zzf(zzfs zzfsVar) {
        this.f12711d = zzfsVar.zza(this.f12710c);
        this.f12712e.zzf(this.f12711d);
    }

    @Override // com.google.android.gms.internal.ads.zzii
    public final void zza(zzpx zzpxVar, int i) {
        this.f12712e.zza(zzpxVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzii
    public final void zza(long j, int i, int i2, int i3, zzij zzijVar) {
        this.f12712e.zza(j, i, i2, i3, zzijVar);
    }
}
