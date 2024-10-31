package io.grpc;

import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public class StatusException extends Exception {
    private static final long serialVersionUID = -660954903976144640L;
    private final Status status;
    private final P trailers;

    public StatusException(Status status) {
        this(status, null);
    }

    public final Status getStatus() {
        return this.status;
    }

    public final P getTrailers() {
        return this.trailers;
    }

    public StatusException(Status status, @Nullable P p) {
        super(Status.a(status), status.d());
        this.status = status;
        this.trailers = p;
    }
}
