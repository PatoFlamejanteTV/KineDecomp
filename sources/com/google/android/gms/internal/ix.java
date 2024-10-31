package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzqn;
import com.google.android.gms.safetynet.AttestationData;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ix extends zzqj {

    /* renamed from: a */
    final /* synthetic */ zzqn.b f1639a;

    public ix(zzqn.b bVar) {
        this.f1639a = bVar;
    }

    @Override // com.google.android.gms.internal.zzqj, com.google.android.gms.internal.zzql
    public void zza(Status status, AttestationData attestationData) {
        this.f1639a.zzb((zzqn.b) new zzqn.a(status, attestationData));
    }
}
