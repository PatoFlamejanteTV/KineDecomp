package com.google.firebase.database.core;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class y implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DatabaseReference.CompletionListener f17161a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ DatabaseError f17162b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ DatabaseReference f17163c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Repo f17164d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(Repo repo, DatabaseReference.CompletionListener completionListener, DatabaseError databaseError, DatabaseReference databaseReference) {
        this.f17164d = repo;
        this.f17161a = completionListener;
        this.f17162b = databaseError;
        this.f17163c = databaseReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f17161a.a(this.f17162b, this.f17163c);
    }
}
