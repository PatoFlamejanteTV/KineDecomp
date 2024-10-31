package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.firebase.auth.internal.zza;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class e implements zza, com.google.firebase.auth.internal.zzw {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f16489a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FirebaseAuth firebaseAuth) {
        this.f16489a = firebaseAuth;
    }

    @Override // com.google.firebase.auth.internal.zza
    public final void a(zzcz zzczVar, FirebaseUser firebaseUser) {
        this.f16489a.a(firebaseUser, zzczVar, true);
    }

    @Override // com.google.firebase.auth.internal.zzw
    public final void zza(Status status) {
        int statusCode = status.getStatusCode();
        if (statusCode == 17011 || statusCode == 17021 || statusCode == 17005) {
            this.f16489a.b();
        }
    }
}
