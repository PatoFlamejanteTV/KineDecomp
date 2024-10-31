package com.google.firebase.database;

import com.google.firebase.database.core.EventRegistration;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ EventRegistration f17169a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Query f17170b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Query query, EventRegistration eventRegistration) {
        this.f17170b = query;
        this.f17169a = eventRegistration;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f17170b.f16642a.a(this.f17169a);
    }
}
