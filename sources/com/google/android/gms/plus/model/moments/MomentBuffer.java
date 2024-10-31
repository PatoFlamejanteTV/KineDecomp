package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.plus.internal.model.moments.zzc;

/* loaded from: classes.dex */
public final class MomentBuffer extends AbstractDataBuffer<Moment> {
    public MomentBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Moment a(int i) {
        return new zzc(this.f982a, i);
    }
}
