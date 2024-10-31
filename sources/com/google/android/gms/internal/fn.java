package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzlg;
import com.google.android.gms.internal.zzli;

/* loaded from: classes.dex */
class fn extends zzli.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzlg f1558a;
    final /* synthetic */ ConnectionResult b;
    final /* synthetic */ zzlg.a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fn(zzlg.a aVar, zzlj zzljVar, zzlg zzlgVar, ConnectionResult connectionResult) {
        super(zzljVar);
        this.c = aVar;
        this.f1558a = zzlgVar;
        this.b = connectionResult;
    }

    @Override // com.google.android.gms.internal.zzli.b
    public void a() {
        this.f1558a.zzc(this.b);
    }
}
