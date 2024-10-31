package com.google.firebase.database.connection;

import com.google.firebase.database.connection.WebsocketConnection;
import com.google.firebase.database.tubesock.WebSocketException;
import java.io.EOFException;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
class n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebSocketException f16799a;

    /* renamed from: b */
    final /* synthetic */ WebsocketConnection.b f16800b;

    public n(WebsocketConnection.b bVar, WebSocketException webSocketException) {
        this.f16800b = bVar;
        this.f16799a = webSocketException;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f16799a.getCause() == null || !(this.f16799a.getCause() instanceof EOFException)) {
            WebsocketConnection.this.l.a("WebSocket error.", this.f16799a, new Object[0]);
        } else {
            WebsocketConnection.this.l.a("WebSocket reached EOF.", new Object[0]);
        }
        WebsocketConnection.this.g();
    }
}
