package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.internal.b;

/* loaded from: classes.dex */
final class t implements b.a<ChannelApi.ChannelListener> {
    /* renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(zzbo zzboVar, zzlb.zzb<Status> zzbVar, ChannelApi.ChannelListener channelListener, zzlm<ChannelApi.ChannelListener> zzlmVar) throws RemoteException {
        zzboVar.a(zzbVar, channelListener, zzlmVar, null);
    }

    @Override // com.google.android.gms.wearable.internal.b.a
    public /* bridge */ /* synthetic */ void a(zzbo zzboVar, zzlb.zzb zzbVar, ChannelApi.ChannelListener channelListener, zzlm<ChannelApi.ChannelListener> zzlmVar) throws RemoteException {
        a2(zzboVar, (zzlb.zzb<Status>) zzbVar, channelListener, zzlmVar);
    }
}
