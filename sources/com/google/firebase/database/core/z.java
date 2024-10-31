package com.google.firebase.database.core;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.connection.RequestResultCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class z implements RequestResultCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Path f17165a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f17166b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ DatabaseReference.CompletionListener f17167c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Repo f17168d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(Repo repo, Path path, long j, DatabaseReference.CompletionListener completionListener) {
        this.f17168d = repo;
        this.f17165a = path;
        this.f17166b = j;
        this.f17167c = completionListener;
    }

    @Override // com.google.firebase.database.connection.RequestResultCallback
    public void a(String str, String str2) {
        DatabaseError b2;
        b2 = Repo.b(str, str2);
        this.f17168d.a("updateChildren", this.f17165a, b2);
        this.f17168d.a(this.f17166b, this.f17165a, b2);
        this.f17168d.a(this.f17167c, b2, this.f17165a);
    }
}
