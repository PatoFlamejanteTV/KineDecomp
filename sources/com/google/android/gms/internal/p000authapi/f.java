package com.google.android.gms.internal.p000authapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* loaded from: classes2.dex */
final class f extends zzg {

    /* renamed from: a */
    private BaseImplementation.ResultHolder<Status> f12747a;

    public f(BaseImplementation.ResultHolder<Status> resultHolder) {
        this.f12747a = resultHolder;
    }

    @Override // com.google.android.gms.internal.p000authapi.zzg, com.google.android.gms.internal.p000authapi.zzu
    public final void zzc(Status status) {
        this.f12747a.a(status);
    }
}
