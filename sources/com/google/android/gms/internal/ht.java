package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.internal.zzpt;
import com.google.android.gms.nearby.connection.Connections;

/* loaded from: classes.dex */
class ht implements zzlm.zzb<Connections.ConnectionResponseCallback> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1610a;
    final /* synthetic */ int b;
    final /* synthetic */ byte[] c;
    final /* synthetic */ zzpt.d d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ht(zzpt.d dVar, String str, int i, byte[] bArr) {
        this.d = dVar;
        this.f1610a = str;
        this.b = i;
        this.c = bArr;
    }

    @Override // com.google.android.gms.internal.zzlm.zzb
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zzq(Connections.ConnectionResponseCallback connectionResponseCallback) {
        connectionResponseCallback.a(this.f1610a, new Status(this.b), this.c);
    }

    @Override // com.google.android.gms.internal.zzlm.zzb
    public void zznN() {
    }
}
