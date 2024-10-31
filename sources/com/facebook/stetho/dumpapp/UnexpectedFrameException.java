package com.facebook.stetho.dumpapp;

/* loaded from: classes.dex */
class UnexpectedFrameException extends DumpappFramingException {
    public UnexpectedFrameException(byte b2, byte b3) {
        super("Expected '" + ((int) b2) + "', got: '" + ((int) b3) + "'");
    }
}
