package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.wearable.internal.b;
import com.google.android.gms.wearable.zzc;

/* loaded from: classes.dex */
final class r implements b.a<zzc.zza> {
    /* renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(zzbo zzboVar, zzlb.zzb<Status> zzbVar, zzc.zza zzaVar, zzlm<zzc.zza> zzlmVar) throws RemoteException {
        zzboVar.a(zzbVar, zzaVar, zzlmVar);
    }

    @Override // com.google.android.gms.wearable.internal.b.a
    public /* bridge */ /* synthetic */ void a(zzbo zzboVar, zzlb.zzb zzbVar, zzc.zza zzaVar, zzlm<zzc.zza> zzlmVar) throws RemoteException {
        a2(zzboVar, (zzlb.zzb<Status>) zzbVar, zzaVar, zzlmVar);
    }
}
