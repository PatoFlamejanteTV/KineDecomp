package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.internal.b;

/* loaded from: classes.dex */
final class c implements b.a<NodeApi.NodeListener> {
    /* renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(zzbo zzboVar, zzlb.zzb<Status> zzbVar, NodeApi.NodeListener nodeListener, zzlm<NodeApi.NodeListener> zzlmVar) throws RemoteException {
        zzboVar.a(zzbVar, nodeListener, zzlmVar);
    }

    @Override // com.google.android.gms.wearable.internal.b.a
    public /* bridge */ /* synthetic */ void a(zzbo zzboVar, zzlb.zzb zzbVar, NodeApi.NodeListener nodeListener, zzlm<NodeApi.NodeListener> zzlmVar) throws RemoteException {
        a2(zzboVar, (zzlb.zzb<Status>) zzbVar, nodeListener, zzlmVar);
    }
}
