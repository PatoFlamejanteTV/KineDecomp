package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth.AuthStateListener f16484a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f16485b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FirebaseAuth firebaseAuth, FirebaseAuth.AuthStateListener authStateListener) {
        this.f16485b = firebaseAuth;
        this.f16484a = authStateListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16484a.a(this.f16485b);
    }
}
