package com.google.android.gms.internal;

import com.google.android.gms.internal.zzli;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fq implements zzli.e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzli f1561a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fq(zzli zzliVar) {
        this.f1561a = zzliVar;
    }

    @Override // com.google.android.gms.internal.zzli.e
    public void a(zzli.f<?> fVar) {
        com.google.android.gms.common.api.zza zzaVar;
        com.google.android.gms.common.api.zza zzaVar2;
        this.f1561a.zzacm.remove(fVar);
        if (fVar.zznF() != null) {
            zzaVar = this.f1561a.zzacn;
            if (zzaVar != null) {
                zzaVar2 = this.f1561a.zzacn;
                zzaVar2.a(fVar.zznF().intValue());
            }
        }
    }
}
