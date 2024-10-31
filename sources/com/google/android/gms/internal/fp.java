package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzlg;
import com.google.android.gms.internal.zzli;

/* loaded from: classes.dex */
class fp extends zzli.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ConnectionResult f1560a;
    final /* synthetic */ zzlg.e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fp(zzlg.e eVar, zzlj zzljVar, ConnectionResult connectionResult) {
        super(zzljVar);
        this.b = eVar;
        this.f1560a = connectionResult;
    }

    @Override // com.google.android.gms.internal.zzli.b
    public void a() {
        zzlg.this.zzf(this.f1560a);
    }
}
