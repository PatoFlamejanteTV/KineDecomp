package com.google.firebase.database.connection;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebsocketConnection f16793a;

    public i(WebsocketConnection websocketConnection) {
        this.f16793a = websocketConnection;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f16793a.d();
    }
}
