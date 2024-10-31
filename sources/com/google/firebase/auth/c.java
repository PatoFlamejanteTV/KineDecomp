package com.google.firebase.auth;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.IdTokenListener;
import com.google.firebase.internal.InternalTokenResult;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ InternalTokenResult f16486a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f16487b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FirebaseAuth firebaseAuth, InternalTokenResult internalTokenResult) {
        this.f16487b = firebaseAuth;
        this.f16486a = internalTokenResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FirebaseApp firebaseApp;
        List list;
        List list2;
        firebaseApp = this.f16487b.f16388a;
        firebaseApp.a(this.f16486a);
        list = this.f16487b.f16390c;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((IdTokenListener) it.next()).a(this.f16486a);
        }
        list2 = this.f16487b.f16389b;
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            ((FirebaseAuth.IdTokenListener) it2.next()).a(this.f16487b);
        }
    }
}
