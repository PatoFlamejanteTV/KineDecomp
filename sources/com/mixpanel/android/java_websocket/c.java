package com.mixpanel.android.java_websocket;

import com.mixpanel.android.java_websocket.b.f;
import com.mixpanel.android.java_websocket.b.h;
import com.mixpanel.android.java_websocket.b.i;
import com.mixpanel.android.java_websocket.drafts.Draft;
import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

/* compiled from: WebSocketListener.java */
/* loaded from: classes.dex */
public interface c {
    i a(WebSocket webSocket, Draft draft, com.mixpanel.android.java_websocket.b.a aVar) throws InvalidDataException;

    String a(WebSocket webSocket) throws InvalidDataException;

    void a(WebSocket webSocket, int i, String str);

    void a(WebSocket webSocket, int i, String str, boolean z);

    void a(WebSocket webSocket, com.mixpanel.android.java_websocket.b.a aVar) throws InvalidDataException;

    void a(WebSocket webSocket, com.mixpanel.android.java_websocket.b.a aVar, h hVar) throws InvalidDataException;

    void a(WebSocket webSocket, f fVar);

    void a(WebSocket webSocket, Framedata framedata);

    void a(WebSocket webSocket, Exception exc);

    void a(WebSocket webSocket, String str);

    void a(WebSocket webSocket, ByteBuffer byteBuffer);

    void b(WebSocket webSocket);

    void b(WebSocket webSocket, int i, String str, boolean z);

    void b(WebSocket webSocket, Framedata framedata);

    InetSocketAddress c(WebSocket webSocket);

    void c(WebSocket webSocket, Framedata framedata);
}
