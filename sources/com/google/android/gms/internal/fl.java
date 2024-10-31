package com.google.android.gms.internal;

import com.google.android.gms.internal.zzli;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fl extends zzli.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzlf f1556a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fl(zzlf zzlfVar, zzlj zzljVar) {
        super(zzljVar);
        this.f1556a = zzlfVar;
    }

    @Override // com.google.android.gms.internal.zzli.b
    public void a() {
        this.f1556a.onConnectionSuspended(1);
    }
}
