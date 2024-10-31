package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzqi;
import com.google.android.gms.plus.People;

/* loaded from: classes.dex */
class it implements People.LoadPeopleResult {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Status f1636a;
    final /* synthetic */ zzqi.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public it(zzqi.a aVar, Status status) {
        this.b = aVar;
        this.f1636a = status;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.f1636a;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public void release() {
    }
}
