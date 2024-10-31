package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes2.dex */
public final class Sd<T> implements zzbbm<zzp, T> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzazy f11824a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Sd(zzazs zzazsVar, zzazy zzazyVar) {
        this.f11824a = zzazyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbm
    public final /* synthetic */ Object apply(zzp zzpVar) {
        return this.f11824a.zze(new ByteArrayInputStream(zzpVar.data));
    }
}
