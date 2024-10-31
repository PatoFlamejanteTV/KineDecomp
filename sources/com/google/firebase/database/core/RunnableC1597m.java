package com.google.firebase.database.core;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.core.Repo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* renamed from: com.google.firebase.database.core.m, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class RunnableC1597m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Repo.a f16989a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ DatabaseError f16990b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ DataSnapshot f16991c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Repo f16992d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1597m(Repo repo, Repo.a aVar, DatabaseError databaseError, DataSnapshot dataSnapshot) {
        this.f16992d = repo;
        this.f16989a = aVar;
        this.f16990b = databaseError;
        this.f16991c = dataSnapshot;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f16989a.f16912b.a(this.f16990b, false, this.f16991c);
    }
}
