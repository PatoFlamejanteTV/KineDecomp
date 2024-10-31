package com.google.android.gms.internal;

import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.internal.zzlg;
import com.google.android.gms.internal.zzli;

/* loaded from: classes.dex */
class fo extends zzli.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzlg f1559a;
    final /* synthetic */ ResolveAccountResponse b;
    final /* synthetic */ zzlg.b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fo(zzlg.b bVar, zzlj zzljVar, zzlg zzlgVar, ResolveAccountResponse resolveAccountResponse) {
        super(zzljVar);
        this.c = bVar;
        this.f1559a = zzlgVar;
        this.b = resolveAccountResponse;
    }

    @Override // com.google.android.gms.internal.zzli.b
    public void a() {
        this.f1559a.zza(this.b);
    }
}
