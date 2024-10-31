package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* loaded from: classes2.dex */
final class rb extends qb<zzts, zzts> {
    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(Object obj, zzts zztsVar) {
        ((zzrc) obj).zzbak = zztsVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.qb
    public final boolean a(Za za) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.qb
    public final /* synthetic */ int b(zzts zztsVar) {
        return zztsVar.zzpe();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.qb
    public final /* synthetic */ zzts c(zzts zztsVar, zzts zztsVar2) {
        zzts zztsVar3 = zztsVar;
        zzts zztsVar4 = zztsVar2;
        return zztsVar4.equals(zzts.zzrj()) ? zztsVar3 : zzts.zza(zztsVar3, zztsVar4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.qb
    public final /* synthetic */ zzts d(Object obj) {
        zzts zztsVar = ((zzrc) obj).zzbak;
        if (zztsVar != zzts.zzrj()) {
            return zztsVar;
        }
        zzts zzrk = zzts.zzrk();
        a2(obj, zzrk);
        return zzrk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.qb
    public final /* synthetic */ int e(zzts zztsVar) {
        return zztsVar.zzrl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.qb
    public final void f(Object obj) {
        ((zzrc) obj).zzbak.zzmi();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.qb
    public final /* synthetic */ void a(zzts zztsVar, Cb cb) throws IOException {
        zztsVar.zzb(cb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.qb
    public final /* synthetic */ void b(zzts zztsVar, Cb cb) throws IOException {
        zztsVar.zza(cb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.qb
    public final /* synthetic */ void a(Object obj, zzts zztsVar) {
        a2(obj, zztsVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.qb
    public final /* synthetic */ zzts c(Object obj) {
        return ((zzrc) obj).zzbak;
    }

    @Override // com.google.android.gms.internal.gtm.qb
    final /* synthetic */ zzts a(zzts zztsVar) {
        zzts zztsVar2 = zztsVar;
        zztsVar2.zzmi();
        return zztsVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.qb
    public final /* synthetic */ void b(Object obj, zzts zztsVar) {
        a2(obj, zztsVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.qb
    public final /* synthetic */ zzts a() {
        return zzts.zzrk();
    }

    @Override // com.google.android.gms.internal.gtm.qb
    final /* synthetic */ void b(zzts zztsVar, int i, long j) {
        zztsVar.zzb((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.gtm.qb
    final /* synthetic */ void a(zzts zztsVar, int i, zzts zztsVar2) {
        zztsVar.zzb((i << 3) | 3, zztsVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.qb
    public final /* synthetic */ void a(zzts zztsVar, int i, zzps zzpsVar) {
        zztsVar.zzb((i << 3) | 2, zzpsVar);
    }

    @Override // com.google.android.gms.internal.gtm.qb
    final /* synthetic */ void a(zzts zztsVar, int i, int i2) {
        zztsVar.zzb((i << 3) | 5, Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.qb
    public final /* synthetic */ void a(zzts zztsVar, int i, long j) {
        zztsVar.zzb(i << 3, Long.valueOf(j));
    }
}
