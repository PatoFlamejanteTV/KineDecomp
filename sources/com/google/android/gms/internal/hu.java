package com.google.android.gms.internal;

import com.google.android.gms.internal.zzlm;
import com.google.android.gms.internal.zzpt;
import com.google.android.gms.nearby.connection.Connections;

/* loaded from: classes.dex */
class hu implements zzlm.zzb<Connections.ConnectionRequestListener> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1611a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ byte[] d;
    final /* synthetic */ zzpt.e e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hu(zzpt.e eVar, String str, String str2, String str3, byte[] bArr) {
        this.e = eVar;
        this.f1611a = str;
        this.b = str2;
        this.c = str3;
        this.d = bArr;
    }

    @Override // com.google.android.gms.internal.zzlm.zzb
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zzq(Connections.ConnectionRequestListener connectionRequestListener) {
        connectionRequestListener.a(this.f1611a, this.b, this.c, this.d);
    }

    @Override // com.google.android.gms.internal.zzlm.zzb
    public void zznN() {
    }
}
