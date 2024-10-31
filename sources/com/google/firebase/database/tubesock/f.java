package com.google.firebase.database.tubesock;

import com.google.firebase.database.tubesock.WebSocket;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public /* synthetic */ class f {

    /* renamed from: a */
    static final /* synthetic */ int[] f17247a = new int[WebSocket.State.values().length];

    static {
        try {
            f17247a[WebSocket.State.NONE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f17247a[WebSocket.State.CONNECTING.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f17247a[WebSocket.State.CONNECTED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f17247a[WebSocket.State.DISCONNECTING.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f17247a[WebSocket.State.DISCONNECTED.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
