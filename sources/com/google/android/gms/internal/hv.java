package com.google.android.gms.internal;

import com.google.android.gms.internal.zzlm;
import com.google.android.gms.internal.zzpt;
import com.google.android.gms.nearby.connection.Connections;

/* loaded from: classes.dex */
class hv implements zzlm.zzb<Connections.EndpointDiscoveryListener> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1612a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ zzpt.g e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hv(zzpt.g gVar, String str, String str2, String str3, String str4) {
        this.e = gVar;
        this.f1612a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    @Override // com.google.android.gms.internal.zzlm.zzb
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zzq(Connections.EndpointDiscoveryListener endpointDiscoveryListener) {
        endpointDiscoveryListener.a(this.f1612a, this.b, this.c, this.d);
    }

    @Override // com.google.android.gms.internal.zzlm.zzb
    public void zznN() {
    }
}
