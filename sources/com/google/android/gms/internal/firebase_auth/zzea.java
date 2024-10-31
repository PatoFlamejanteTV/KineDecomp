package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzdz;
import com.google.android.gms.internal.firebase_auth.zzea;

/* loaded from: classes2.dex */
public abstract class zzea<MessageType extends zzdz<MessageType, BuilderType>, BuilderType extends zzea<MessageType, BuilderType>> implements zzhd {
    protected abstract BuilderType zza(MessageType messagetype);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.firebase_auth.zzhd
    public final /* synthetic */ zzhd zzb(zzhc zzhcVar) {
        if (zzhi().getClass().isInstance(zzhcVar)) {
            return zza((zzdz) zzhcVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    @Override // 
    /* renamed from: zzet */
    public abstract BuilderType clone();
}
