package com.facebook.places.internal;

/* loaded from: classes.dex */
public class ScannerException extends Exception {
    public Type type;

    /* loaded from: classes.dex */
    public enum Type {
        NOT_SUPPORTED,
        PERMISSION_DENIED,
        DISABLED,
        SCAN_ALREADY_IN_PROGRESS,
        UNKNOWN_ERROR,
        TIMEOUT
    }

    public ScannerException(Type type) {
        super("Type: " + type.name());
        this.type = type;
    }

    public ScannerException(Type type, String str) {
        super(str);
        this.type = type;
    }

    public ScannerException(Type type, Exception exc) {
        super("Type: " + type.name(), exc);
        this.type = type;
    }
}
