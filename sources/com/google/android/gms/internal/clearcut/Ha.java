package com.google.android.gms.internal.clearcut;

import java.io.IOException;

/* loaded from: classes2.dex */
final class Ha extends Ga<zzey, zzey> {
    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(Object obj, zzey zzeyVar) {
        ((zzcg) obj).zzjp = zzeyVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.Ga
    public final /* synthetic */ zzey a() {
        return zzey.zzeb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.Ga
    public final void a(Object obj) {
        ((zzcg) obj).zzjp.zzv();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.Ga
    public final /* synthetic */ void a(zzey zzeyVar, int i, long j) {
        zzeyVar.zzb(i << 3, Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.Ga
    public final /* synthetic */ void a(zzey zzeyVar, Sa sa) throws IOException {
        zzeyVar.zzb(sa);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.Ga
    public final /* synthetic */ void a(Object obj, zzey zzeyVar) {
        a2(obj, zzeyVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.Ga
    public final /* synthetic */ int b(zzey zzeyVar) {
        return zzeyVar.zzas();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.Ga
    public final /* synthetic */ void b(zzey zzeyVar, Sa sa) throws IOException {
        zzeyVar.zza(sa);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.Ga
    public final /* synthetic */ void b(Object obj, zzey zzeyVar) {
        a2(obj, zzeyVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.Ga
    public final /* synthetic */ zzey c(Object obj) {
        return ((zzcg) obj).zzjp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.Ga
    public final /* synthetic */ zzey c(zzey zzeyVar, zzey zzeyVar2) {
        zzey zzeyVar3 = zzeyVar;
        zzey zzeyVar4 = zzeyVar2;
        return zzeyVar4.equals(zzey.zzea()) ? zzeyVar3 : zzey.zza(zzeyVar3, zzeyVar4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.Ga
    public final /* synthetic */ int d(zzey zzeyVar) {
        return zzeyVar.zzec();
    }
}
