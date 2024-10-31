package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
final class Mi extends Li<zzbtv, zzbtv> {
    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(Object obj, zzbtv zzbtvVar) {
        ((zzbrd) obj).zzfpu = zzbtvVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.Li
    public final boolean a(InterfaceC1098ti interfaceC1098ti) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.Li
    public final /* synthetic */ void b(zzbtv zzbtvVar, Xi xi) throws IOException {
        zzbtvVar.zza(xi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.Li
    public final /* synthetic */ zzbtv c(zzbtv zzbtvVar, zzbtv zzbtvVar2) {
        zzbtv zzbtvVar3 = zzbtvVar;
        zzbtv zzbtvVar4 = zzbtvVar2;
        return zzbtvVar4.equals(zzbtv.zzaoz()) ? zzbtvVar3 : zzbtv.zza(zzbtvVar3, zzbtvVar4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.Li
    public final /* synthetic */ int d(zzbtv zzbtvVar) {
        return zzbtvVar.zzapb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.Li
    public final void e(Object obj) {
        ((zzbrd) obj).zzfpu.zzakj();
    }

    @Override // com.google.android.gms.internal.ads.Li
    final /* synthetic */ zzbtv f(zzbtv zzbtvVar) {
        zzbtv zzbtvVar2 = zzbtvVar;
        zzbtvVar2.zzakj();
        return zzbtvVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.Li
    public final /* synthetic */ int a(zzbtv zzbtvVar) {
        return zzbtvVar.zzamj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.Li
    public final /* synthetic */ void b(Object obj, zzbtv zzbtvVar) {
        a2(obj, zzbtvVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.Li
    public final /* synthetic */ void a(zzbtv zzbtvVar, Xi xi) throws IOException {
        zzbtvVar.zzb(xi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.Li
    public final /* synthetic */ zzbtv c(Object obj) {
        zzbtv zzbtvVar = ((zzbrd) obj).zzfpu;
        if (zzbtvVar != zzbtv.zzaoz()) {
            return zzbtvVar;
        }
        zzbtv zzapa = zzbtv.zzapa();
        a2(obj, zzapa);
        return zzapa;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.Li
    public final /* synthetic */ zzbtv b(Object obj) {
        return ((zzbrd) obj).zzfpu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.Li
    public final /* synthetic */ void a(Object obj, zzbtv zzbtvVar) {
        a2(obj, zzbtvVar);
    }

    @Override // com.google.android.gms.internal.ads.Li
    final /* synthetic */ void b(zzbtv zzbtvVar, int i, long j) {
        zzbtvVar.zzc((i << 3) | 1, Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.Li
    public final /* synthetic */ zzbtv a() {
        return zzbtv.zzapa();
    }

    @Override // com.google.android.gms.internal.ads.Li
    final /* synthetic */ void a(zzbtv zzbtvVar, int i, zzbtv zzbtvVar2) {
        zzbtvVar.zzc((i << 3) | 3, zzbtvVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.Li
    public final /* synthetic */ void a(zzbtv zzbtvVar, int i, zzbpu zzbpuVar) {
        zzbtvVar.zzc((i << 3) | 2, zzbpuVar);
    }

    @Override // com.google.android.gms.internal.ads.Li
    final /* synthetic */ void a(zzbtv zzbtvVar, int i, int i2) {
        zzbtvVar.zzc((i << 3) | 5, Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.Li
    public final /* synthetic */ void a(zzbtv zzbtvVar, int i, long j) {
        zzbtvVar.zzc(i << 3, Long.valueOf(j));
    }
}
