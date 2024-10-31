package com.google.android.gms.internal;

import com.google.android.gms.internal.zzbb;
import com.google.android.gms.internal.zzdz;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements zzbb.zza {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbb f1441a;
    final /* synthetic */ az b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(az azVar, zzbb zzbbVar) {
        this.b = azVar;
        this.f1441a = zzbbVar;
    }

    @Override // com.google.android.gms.internal.zzbb.zza
    public void zzcj() {
        zzid.zzIE.postDelayed(new bb(this), zzdz.a.b);
    }
}
