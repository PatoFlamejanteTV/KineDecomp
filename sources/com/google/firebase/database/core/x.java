package com.google.firebase.database.core;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.connection.RequestResultCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class x implements RequestResultCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ UserWriteRecord f17159a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Repo f17160b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(Repo repo, UserWriteRecord userWriteRecord) {
        this.f17160b = repo;
        this.f17159a = userWriteRecord;
    }

    @Override // com.google.firebase.database.connection.RequestResultCallback
    public void a(String str, String str2) {
        DatabaseError b2;
        b2 = Repo.b(str, str2);
        this.f17160b.a("Persisted write", this.f17159a.c(), b2);
        this.f17160b.a(this.f17159a.d(), this.f17159a.c(), b2);
    }
}
