package com.google.android.gms.internal;

import com.google.android.gms.fitness.data.zzk;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.internal.zzos;

/* loaded from: classes.dex */
class hi implements zzos.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnDataPointListener f1600a;
    final /* synthetic */ zzos b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hi(zzos zzosVar, OnDataPointListener onDataPointListener) {
        this.b = zzosVar;
        this.f1600a = onDataPointListener;
    }

    @Override // com.google.android.gms.internal.zzos.a
    public void a() {
        zzk.zza.a().c(this.f1600a);
    }
}
