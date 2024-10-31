package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class f implements com.google.firebase.auth.internal.zzv {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ FirebaseUser f16490a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f16491b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        this.f16491b = firebaseAuth;
        this.f16490a = firebaseUser;
    }

    @Override // com.google.firebase.auth.internal.zzv
    public final void a() {
        FirebaseUser firebaseUser;
        firebaseUser = this.f16491b.f16393f;
        if (firebaseUser.R().equalsIgnoreCase(this.f16490a.R())) {
            this.f16491b.c();
        }
    }

    @Override // com.google.firebase.auth.internal.zzw
    public final void zza(Status status) {
        if (status.getStatusCode() == 17011 || status.getStatusCode() == 17021 || status.getStatusCode() == 17005) {
            this.f16491b.b();
        }
    }
}
