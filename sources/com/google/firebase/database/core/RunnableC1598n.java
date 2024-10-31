package com.google.firebase.database.core;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* renamed from: com.google.firebase.database.core.n, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class RunnableC1598n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Repo f16993a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1598n(Repo repo) {
        this.f16993a = repo;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f16993a.b();
    }
}
