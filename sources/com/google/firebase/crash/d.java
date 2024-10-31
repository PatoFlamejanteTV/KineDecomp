package com.google.firebase.crash;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ FirebaseCrash f16619a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FirebaseCrash firebaseCrash) {
        this.f16619a = firebaseCrash;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16619a.d();
    }
}
