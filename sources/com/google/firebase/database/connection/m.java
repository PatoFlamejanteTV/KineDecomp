package com.google.firebase.database.connection;

import com.google.firebase.database.connection.WebsocketConnection;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
class m implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebsocketConnection.b f16798a;

    public m(WebsocketConnection.b bVar) {
        this.f16798a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (WebsocketConnection.this.l.a()) {
            WebsocketConnection.this.l.a("closed", new Object[0]);
        }
        WebsocketConnection.this.g();
    }
}
