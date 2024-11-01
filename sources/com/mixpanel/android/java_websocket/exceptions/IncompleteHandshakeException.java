package com.mixpanel.android.java_websocket.exceptions;

/* loaded from: classes.dex */
public class IncompleteHandshakeException extends RuntimeException {
    private static final long serialVersionUID = 7906596804233893092L;
    private int newsize;

    public IncompleteHandshakeException(int i) {
        this.newsize = i;
    }

    public IncompleteHandshakeException() {
        this.newsize = 0;
    }

    public int getPreferedSize() {
        return this.newsize;
    }
}
