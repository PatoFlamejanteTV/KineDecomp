package com.google.firebase.database.connection;

import com.google.firebase.database.connection.WebsocketConnection;
import java.util.concurrent.ScheduledFuture;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
class k implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebsocketConnection.b f16795a;

    public k(WebsocketConnection.b bVar) {
        this.f16795a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        scheduledFuture = WebsocketConnection.this.i;
        scheduledFuture.cancel(false);
        WebsocketConnection.this.f16768c = true;
        if (WebsocketConnection.this.l.a()) {
            WebsocketConnection.this.l.a("websocket opened", new Object[0]);
        }
        WebsocketConnection.this.h();
    }
}
