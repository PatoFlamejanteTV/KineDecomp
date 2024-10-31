package com.mixpanel.android.java_websocket;

import com.mixpanel.android.java_websocket.framing.Framedata;
import java.net.InetSocketAddress;

/* loaded from: classes.dex */
public interface WebSocket {

    /* loaded from: classes.dex */
    public enum READYSTATE {
        NOT_YET_CONNECTED,
        CONNECTING,
        OPEN,
        CLOSING,
        CLOSED
    }

    /* loaded from: classes.dex */
    public enum Role {
        CLIENT,
        SERVER
    }

    InetSocketAddress a();

    void a(Framedata framedata);
}
