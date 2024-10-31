package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzpu;
import com.google.android.gms.nearby.connection.Connections;

/* loaded from: classes.dex */
class id implements Connections.StartAdvertisingResult {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Status f1620a;
    final /* synthetic */ zzpu.b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public id(zzpu.b bVar, Status status) {
        this.b = bVar;
        this.f1620a = status;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.f1620a;
    }
}
