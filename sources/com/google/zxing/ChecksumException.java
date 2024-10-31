package com.google.zxing;

/* loaded from: classes2.dex */
public final class ChecksumException extends ReaderException {

    /* renamed from: a */
    private static final ChecksumException f18943a;

    static {
        ChecksumException checksumException = new ChecksumException();
        f18943a = checksumException;
        checksumException.setStackTrace(ReaderException.NO_TRACE);
    }

    private ChecksumException() {
    }

    public static ChecksumException getChecksumInstance() {
        return ReaderException.isStackTrace ? new ChecksumException() : f18943a;
    }

    private ChecksumException(Throwable th) {
        super(th);
    }

    public static ChecksumException getChecksumInstance(Throwable th) {
        return ReaderException.isStackTrace ? new ChecksumException(th) : f18943a;
    }
}
