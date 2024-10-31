package com.google.firebase.database.connection;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ PersistentConnectionImpl f16792a;

    public h(PersistentConnectionImpl persistentConnectionImpl) {
        this.f16792a = persistentConnectionImpl;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean g2;
        this.f16792a.z = null;
        g2 = this.f16792a.g();
        if (!g2) {
            this.f16792a.f();
        } else {
            this.f16792a.b("connection_idle");
        }
    }
}
