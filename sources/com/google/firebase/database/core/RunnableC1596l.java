package com.google.firebase.database.core;

import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.view.QuerySpec;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* renamed from: com.google.firebase.database.core.l, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class RunnableC1596l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Repo.a f16987a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Repo f16988b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1596l(Repo repo, Repo.a aVar) {
        this.f16988b = repo;
        this.f16987a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Repo repo = this.f16988b;
        repo.b(new ValueEventRegistration(repo, this.f16987a.f16913c, QuerySpec.a(this.f16987a.f16911a)));
    }
}
