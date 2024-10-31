package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;

/* loaded from: classes2.dex */
final class Ga extends Fa<zzir, zzir> {
    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(Object obj, zzir zzirVar) {
        ((zzft) obj).zzwy = zzirVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_auth.Fa
    public final boolean a(InterfaceC1255ia interfaceC1255ia) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_auth.Fa
    public final /* synthetic */ void b(zzir zzirVar, Ra ra) throws IOException {
        zzirVar.zza(ra);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_auth.Fa
    public final /* synthetic */ int c(zzir zzirVar) {
        return zzirVar.zzgw();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_auth.Fa
    public final /* synthetic */ zzir d(Object obj) {
        return ((zzft) obj).zzwy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_auth.Fa
    public final /* synthetic */ zzir e(Object obj) {
        zzir zzirVar = ((zzft) obj).zzwy;
        if (zzirVar != zzir.zzjp()) {
            return zzirVar;
        }
        zzir zzjq = zzir.zzjq();
        a2(obj, zzjq);
        return zzjq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_auth.Fa
    public final /* synthetic */ int f(zzir zzirVar) {
        return zzirVar.zzjr();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_auth.Fa
    public final void a(Object obj) {
        ((zzft) obj).zzwy.zzev();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_auth.Fa
    public final /* synthetic */ void b(Object obj, zzir zzirVar) {
        a2(obj, zzirVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_auth.Fa
    public final /* synthetic */ zzir c(zzir zzirVar, zzir zzirVar2) {
        zzir zzirVar3 = zzirVar;
        zzir zzirVar4 = zzirVar2;
        return zzirVar4.equals(zzir.zzjp()) ? zzirVar3 : zzir.zza(zzirVar3, zzirVar4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_auth.Fa
    public final /* synthetic */ void a(zzir zzirVar, Ra ra) throws IOException {
        zzirVar.zzb(ra);
    }

    @Override // com.google.android.gms.internal.firebase_auth.Fa
    final /* synthetic */ zzir b(zzir zzirVar) {
        zzir zzirVar2 = zzirVar;
        zzirVar2.zzev();
        return zzirVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_auth.Fa
    public final /* synthetic */ void a(Object obj, zzir zzirVar) {
        a2(obj, zzirVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_auth.Fa
    public final /* synthetic */ zzir a() {
        return zzir.zzjq();
    }

    @Override // com.google.android.gms.internal.firebase_auth.Fa
    final /* synthetic */ void b(zzir zzirVar, int i, long j) {
        zzirVar.zzb((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.firebase_auth.Fa
    final /* synthetic */ void a(zzir zzirVar, int i, zzir zzirVar2) {
        zzirVar.zzb((i << 3) | 3, zzirVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_auth.Fa
    public final /* synthetic */ void a(zzir zzirVar, int i, zzeh zzehVar) {
        zzirVar.zzb((i << 3) | 2, zzehVar);
    }

    @Override // com.google.android.gms.internal.firebase_auth.Fa
    final /* synthetic */ void a(zzir zzirVar, int i, int i2) {
        zzirVar.zzb((i << 3) | 5, Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_auth.Fa
    public final /* synthetic */ void a(zzir zzirVar, int i, long j) {
        zzirVar.zzb(i << 3, Long.valueOf(j));
    }
}
