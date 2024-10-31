package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzqn;
import com.google.android.gms.safetynet.SafeBrowsingData;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class iy extends zzqj {

    /* renamed from: a */
    final /* synthetic */ zzqn.c f1640a;

    public iy(zzqn.c cVar) {
        this.f1640a = cVar;
    }

    @Override // com.google.android.gms.internal.zzqj, com.google.android.gms.internal.zzql
    public void zza(Status status, SafeBrowsingData safeBrowsingData) {
        this.f1640a.zzb((zzqn.c) new zzqn.d(status, safeBrowsingData));
    }
}
