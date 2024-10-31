package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.internal.b;

/* loaded from: classes.dex */
final class d implements b.a<NodeApi.zza> {
    /* renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(zzbo zzboVar, zzlb.zzb<Status> zzbVar, NodeApi.zza zzaVar, zzlm<NodeApi.zza> zzlmVar) throws RemoteException {
        zzboVar.a(zzbVar, zzaVar, zzlmVar);
    }

    @Override // com.google.android.gms.wearable.internal.b.a
    public /* bridge */ /* synthetic */ void a(zzbo zzboVar, zzlb.zzb zzbVar, NodeApi.zza zzaVar, zzlm<NodeApi.zza> zzlmVar) throws RemoteException {
        a2(zzboVar, (zzlb.zzb<Status>) zzbVar, zzaVar, zzlmVar);
    }
}
