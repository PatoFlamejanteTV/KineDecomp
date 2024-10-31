package com.google.firebase.database.tubesock;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebSocket f17246a;

    public e(WebSocket webSocket) {
        this.f17246a = webSocket;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f17246a.k();
    }
}
