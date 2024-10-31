package com.mixpanel.android.java_websocket.framing;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface Framedata {

    /* loaded from: classes.dex */
    public enum Opcode {
        CONTINUOUS,
        TEXT,
        BINARY,
        PING,
        PONG,
        CLOSING
    }

    ByteBuffer c();

    boolean d();

    boolean e();

    Opcode f();
}
