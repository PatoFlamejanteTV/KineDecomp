package com.google.android.gms.internal;

import com.google.android.gms.internal.zzlm;
import com.google.android.gms.internal.zzpt;
import com.google.android.gms.nearby.connection.Connections;

/* loaded from: classes.dex */
class hw implements zzlm.zzb<Connections.EndpointDiscoveryListener> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1613a;
    final /* synthetic */ zzpt.g b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hw(zzpt.g gVar, String str) {
        this.b = gVar;
        this.f1613a = str;
    }

    @Override // com.google.android.gms.internal.zzlm.zzb
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zzq(Connections.EndpointDiscoveryListener endpointDiscoveryListener) {
        endpointDiscoveryListener.a(this.f1613a);
    }

    @Override // com.google.android.gms.internal.zzlm.zzb
    public void zznN() {
    }
}
