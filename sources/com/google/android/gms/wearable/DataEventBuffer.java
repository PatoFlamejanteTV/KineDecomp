package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.zzz;

/* loaded from: classes.dex */
public class DataEventBuffer extends com.google.android.gms.common.data.zzf<DataEvent> implements Result {
    private final Status b;

    public DataEventBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.b = new Status(dataHolder.e());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.data.zzf
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public DataEvent a(int i, int i2) {
        return new zzz(this.f982a, i, i2);
    }

    @Override // com.google.android.gms.common.data.zzf
    protected String b() {
        return "path";
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.b;
    }
}
