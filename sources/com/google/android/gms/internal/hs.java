package com.google.android.gms.internal;

import com.google.android.gms.internal.zzlm;
import com.google.android.gms.internal.zzpt;
import com.google.android.gms.nearby.connection.Connections;

/* loaded from: classes.dex */
class hs implements zzlm.zzb<Connections.MessageListener> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1609a;
    final /* synthetic */ zzpt.b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hs(zzpt.b bVar, String str) {
        this.b = bVar;
        this.f1609a = str;
    }

    @Override // com.google.android.gms.internal.zzlm.zzb
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zzq(Connections.MessageListener messageListener) {
        messageListener.a(this.f1609a);
    }

    @Override // com.google.android.gms.internal.zzlm.zzb
    public void zznN() {
    }
}
