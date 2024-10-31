package io.grpc;

import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public class StatusRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 1950934672280720624L;
    private final Status status;
    private final P trailers;

    public StatusRuntimeException(Status status) {
        this(status, null);
    }

    public final Status getStatus() {
        return this.status;
    }

    public final P getTrailers() {
        return this.trailers;
    }

    public StatusRuntimeException(Status status, @Nullable P p) {
        super(Status.a(status), status.d());
        this.status = status;
        this.trailers = p;
    }
}
