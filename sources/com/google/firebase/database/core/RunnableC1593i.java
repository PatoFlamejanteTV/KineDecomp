package com.google.firebase.database.core;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.core.Repo;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* renamed from: com.google.firebase.database.core.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class RunnableC1593i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Repo.a f16979a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ DataSnapshot f16980b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C1594j f16981c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1593i(C1594j c1594j, Repo.a aVar, DataSnapshot dataSnapshot) {
        this.f16981c = c1594j;
        this.f16979a = aVar;
        this.f16980b = dataSnapshot;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f16979a.f16912b.a(null, true, this.f16980b);
    }
}
