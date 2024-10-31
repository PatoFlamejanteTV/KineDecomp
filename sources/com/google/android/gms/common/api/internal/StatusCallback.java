package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.IStatusCallback;

@KeepForSdk
/* loaded from: classes.dex */
public class StatusCallback extends IStatusCallback.Stub {

    /* renamed from: a */
    @KeepForSdk
    private final BaseImplementation.ResultHolder<Status> f10799a;

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    @KeepForSdk
    public void e(Status status) {
        this.f10799a.a(status);
    }
}
