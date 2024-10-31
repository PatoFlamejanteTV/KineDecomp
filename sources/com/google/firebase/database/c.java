package com.google.firebase.database;

import com.google.firebase.database.core.EventRegistration;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ EventRegistration f16688a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Query f16689b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Query query, EventRegistration eventRegistration) {
        this.f16689b = query;
        this.f16688a = eventRegistration;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f16689b.f16642a.b(this.f16688a);
    }
}
