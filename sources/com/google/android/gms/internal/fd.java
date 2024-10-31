package com.google.android.gms.internal;

import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
class fd implements ResultCallback<Status> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f1549a;
    final /* synthetic */ zzko b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fd(zzko zzkoVar, long j) {
        this.b = zzkoVar;
        this.f1549a = j;
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResult(Status status) {
        if (status.d()) {
            return;
        }
        this.b.zzb(this.f1549a, status.e());
    }
}
