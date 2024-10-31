package com.google.firebase.database.core;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.core.Repo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Repo.a f17043a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ DatabaseError f17044b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Repo f17045c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(Repo repo, Repo.a aVar, DatabaseError databaseError) {
        this.f17045c = repo;
        this.f17043a = aVar;
        this.f17044b = databaseError;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f17043a.f16912b.a(this.f17044b, false, null);
    }
}
