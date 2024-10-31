package com.google.firebase.database.tubesock;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public interface WebSocketEventHandler {
    void a();

    void a(WebSocketException webSocketException);

    void a(WebSocketMessage webSocketMessage);

    void onClose();
}
