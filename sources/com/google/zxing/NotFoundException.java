package com.google.zxing;

/* loaded from: classes2.dex */
public final class NotFoundException extends ReaderException {

    /* renamed from: a */
    private static final NotFoundException f18950a;

    static {
        NotFoundException notFoundException = new NotFoundException();
        f18950a = notFoundException;
        notFoundException.setStackTrace(ReaderException.NO_TRACE);
    }

    private NotFoundException() {
    }

    public static NotFoundException getNotFoundInstance() {
        return f18950a;
    }
}
