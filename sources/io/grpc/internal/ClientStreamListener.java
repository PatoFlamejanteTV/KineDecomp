package io.grpc.internal;

import io.grpc.Status;

/* loaded from: classes3.dex */
public interface ClientStreamListener extends Oc {

    /* loaded from: classes3.dex */
    public enum RpcProgress {
        PROCESSED,
        REFUSED,
        DROPPED
    }

    void a(io.grpc.P p);

    void a(Status status, io.grpc.P p);

    void a(Status status, RpcProgress rpcProgress, io.grpc.P p);
}
