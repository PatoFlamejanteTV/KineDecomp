package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
final class ub extends tb<zzxe, zzxe> {
    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(Object obj, zzxe zzxeVar) {
        ((zzuo) obj).zzbyd = zzxeVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.tb
    public final boolean a(InterfaceC1350bb interfaceC1350bb) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.tb
    public final /* synthetic */ int b(zzxe zzxeVar) {
        return zzxeVar.zzvx();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.tb
    public final /* synthetic */ zzxe c(zzxe zzxeVar, zzxe zzxeVar2) {
        zzxe zzxeVar3 = zzxeVar;
        zzxe zzxeVar4 = zzxeVar2;
        return zzxeVar4.equals(zzxe.zzyl()) ? zzxeVar3 : zzxe.zza(zzxeVar3, zzxeVar4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.tb
    public final /* synthetic */ zzxe d(Object obj) {
        zzxe zzxeVar = ((zzuo) obj).zzbyd;
        if (zzxeVar != zzxe.zzyl()) {
            return zzxeVar;
        }
        zzxe zzym = zzxe.zzym();
        a2(obj, zzym);
        return zzym;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.tb
    public final /* synthetic */ int e(zzxe zzxeVar) {
        return zzxeVar.zzyn();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.tb
    public final void f(Object obj) {
        ((zzuo) obj).zzbyd.zzsw();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.tb
    public final /* synthetic */ void a(zzxe zzxeVar, Fb fb) throws IOException {
        zzxeVar.zzb(fb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.tb
    public final /* synthetic */ void b(zzxe zzxeVar, Fb fb) throws IOException {
        zzxeVar.zza(fb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.tb
    public final /* synthetic */ void a(Object obj, zzxe zzxeVar) {
        a2(obj, zzxeVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.tb
    public final /* synthetic */ zzxe c(Object obj) {
        return ((zzuo) obj).zzbyd;
    }

    @Override // com.google.android.gms.internal.measurement.tb
    final /* synthetic */ zzxe a(zzxe zzxeVar) {
        zzxe zzxeVar2 = zzxeVar;
        zzxeVar2.zzsw();
        return zzxeVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.tb
    public final /* synthetic */ void b(Object obj, zzxe zzxeVar) {
        a2(obj, zzxeVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.tb
    public final /* synthetic */ zzxe a() {
        return zzxe.zzym();
    }

    @Override // com.google.android.gms.internal.measurement.tb
    final /* synthetic */ void b(zzxe zzxeVar, int i, long j) {
        zzxeVar.zzb((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.measurement.tb
    final /* synthetic */ void a(zzxe zzxeVar, int i, zzxe zzxeVar2) {
        zzxeVar.zzb((i << 3) | 3, zzxeVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.tb
    public final /* synthetic */ void a(zzxe zzxeVar, int i, zzte zzteVar) {
        zzxeVar.zzb((i << 3) | 2, zzteVar);
    }

    @Override // com.google.android.gms.internal.measurement.tb
    final /* synthetic */ void a(zzxe zzxeVar, int i, int i2) {
        zzxeVar.zzb((i << 3) | 5, Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.tb
    public final /* synthetic */ void a(zzxe zzxeVar, int i, long j) {
        zzxeVar.zzb(i << 3, Long.valueOf(j));
    }
}
