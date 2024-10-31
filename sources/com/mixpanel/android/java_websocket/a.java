package com.mixpanel.android.java_websocket;

import com.mixpanel.android.java_websocket.b.e;
import com.mixpanel.android.java_websocket.b.h;
import com.mixpanel.android.java_websocket.b.i;
import com.mixpanel.android.java_websocket.drafts.Draft;
import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.framing.d;
import java.net.InetSocketAddress;

/* compiled from: WebSocketAdapter.java */
/* loaded from: classes.dex */
public abstract class a implements c {
    @Override // com.mixpanel.android.java_websocket.c
    public i a(WebSocket webSocket, Draft draft, com.mixpanel.android.java_websocket.b.a aVar) throws InvalidDataException {
        return new e();
    }

    @Override // com.mixpanel.android.java_websocket.c
    public void a(WebSocket webSocket, com.mixpanel.android.java_websocket.b.a aVar, h hVar) throws InvalidDataException {
    }

    @Override // com.mixpanel.android.java_websocket.c
    public void a(WebSocket webSocket, com.mixpanel.android.java_websocket.b.a aVar) throws InvalidDataException {
    }

    @Override // com.mixpanel.android.java_websocket.c
    public void a(WebSocket webSocket, Framedata framedata) {
    }

    @Override // com.mixpanel.android.java_websocket.c
    public void b(WebSocket webSocket, Framedata framedata) {
        d dVar = new d(framedata);
        dVar.a(Framedata.Opcode.PONG);
        webSocket.a(dVar);
    }

    @Override // com.mixpanel.android.java_websocket.c
    public void c(WebSocket webSocket, Framedata framedata) {
    }

    @Override // com.mixpanel.android.java_websocket.c
    public String a(WebSocket webSocket) throws InvalidDataException {
        InetSocketAddress a2 = webSocket.a();
        if (a2 == null) {
            throw new InvalidHandshakeException("socket not bound");
        }
        StringBuffer stringBuffer = new StringBuffer(90);
        stringBuffer.append("<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"");
        stringBuffer.append(a2.getPort());
        stringBuffer.append("\" /></cross-domain-policy>\u0000");
        return stringBuffer.toString();
    }
}
