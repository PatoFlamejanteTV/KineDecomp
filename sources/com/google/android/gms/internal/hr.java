package com.google.android.gms.internal;

import com.google.android.gms.internal.zzlm;
import com.google.android.gms.internal.zzpt;
import com.google.android.gms.nearby.connection.Connections;

/* loaded from: classes.dex */
class hr implements zzlm.zzb<Connections.MessageListener> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1608a;
    final /* synthetic */ byte[] b;
    final /* synthetic */ boolean c;
    final /* synthetic */ zzpt.b d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hr(zzpt.b bVar, String str, byte[] bArr, boolean z) {
        this.d = bVar;
        this.f1608a = str;
        this.b = bArr;
        this.c = z;
    }

    @Override // com.google.android.gms.internal.zzlm.zzb
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zzq(Connections.MessageListener messageListener) {
        messageListener.a(this.f1608a, this.b, this.c);
    }

    @Override // com.google.android.gms.internal.zzlm.zzb
    public void zznN() {
    }
}
