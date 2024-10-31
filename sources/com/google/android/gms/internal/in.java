package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzqh;
import com.google.android.gms.plus.Moments;

/* loaded from: classes.dex */
class in implements Moments.LoadMomentsResult {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Status f1630a;
    final /* synthetic */ zzqh.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public in(zzqh.a aVar, Status status) {
        this.b = aVar;
        this.f1630a = status;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.f1630a;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public void release() {
    }
}
