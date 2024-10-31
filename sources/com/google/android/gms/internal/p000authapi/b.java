package com.google.android.gms.internal.p000authapi;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
final class b extends zzg {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ a f12746a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f12746a = aVar;
    }

    @Override // com.google.android.gms.internal.p000authapi.zzg, com.google.android.gms.internal.p000authapi.zzu
    public final void zzc(Status status, Credential credential) {
        this.f12746a.a((a) new zzh(status, credential));
    }

    @Override // com.google.android.gms.internal.p000authapi.zzg, com.google.android.gms.internal.p000authapi.zzu
    public final void zzc(Status status) {
        this.f12746a.a((a) zzh.zzd(status));
    }
}
