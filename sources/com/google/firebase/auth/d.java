package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f16488a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FirebaseAuth firebaseAuth) {
        this.f16488a = firebaseAuth;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List list;
        list = this.f16488a.f16391d;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((FirebaseAuth.AuthStateListener) it.next()).a(this.f16488a);
        }
    }
}
