package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

@KeepForSdk
/* loaded from: classes.dex */
public class DataHolderResult implements Releasable, Result {

    /* renamed from: a */
    @KeepForSdk
    protected final Status f10732a;

    /* renamed from: b */
    @KeepForSdk
    protected final DataHolder f10733b;

    @Override // com.google.android.gms.common.api.Result
    @KeepForSdk
    public Status getStatus() {
        return this.f10732a;
    }

    @Override // com.google.android.gms.common.api.Releasable
    @KeepForSdk
    public void release() {
        DataHolder dataHolder = this.f10733b;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }
}
