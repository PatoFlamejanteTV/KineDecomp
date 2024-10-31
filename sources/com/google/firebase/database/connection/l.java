package com.google.firebase.database.connection;

import com.google.firebase.database.connection.WebsocketConnection;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
class l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f16796a;

    /* renamed from: b */
    final /* synthetic */ WebsocketConnection.b f16797b;

    public l(WebsocketConnection.b bVar, String str) {
        this.f16797b = bVar;
        this.f16796a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        WebsocketConnection.this.c(this.f16796a);
    }
}
