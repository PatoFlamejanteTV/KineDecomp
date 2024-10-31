package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbpl;
import com.google.android.gms.internal.ads.zzbpm;

/* loaded from: classes2.dex */
public abstract class zzbpm<MessageType extends zzbpl<MessageType, BuilderType>, BuilderType extends zzbpm<MessageType, BuilderType>> implements zzbsm {
    protected abstract BuilderType zza(MessageType messagetype);

    @Override // 
    /* renamed from: zzakh */
    public abstract BuilderType clone();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzbsm
    public final /* synthetic */ zzbsm zzd(zzbsl zzbslVar) {
        if (zzamv().getClass().isInstance(zzbslVar)) {
            return zza((zzbpl) zzbslVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
