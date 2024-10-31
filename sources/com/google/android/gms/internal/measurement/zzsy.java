package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzsx;
import com.google.android.gms.internal.measurement.zzsy;

/* loaded from: classes2.dex */
public abstract class zzsy<MessageType extends zzsx<MessageType, BuilderType>, BuilderType extends zzsy<MessageType, BuilderType>> implements zzvw {
    protected abstract BuilderType zza(MessageType messagetype);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzvw
    public final /* synthetic */ zzvw zza(zzvv zzvvVar) {
        if (zzwj().getClass().isInstance(zzvvVar)) {
            return zza((zzsy<MessageType, BuilderType>) zzvvVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    @Override // 
    /* renamed from: zzty */
    public abstract BuilderType clone();
}
