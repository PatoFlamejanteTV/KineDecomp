package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;

/* compiled from: FailingClientStream.java */
/* loaded from: classes3.dex */
public final class Ja extends Tb {

    /* renamed from: b, reason: collision with root package name */
    private boolean f27386b;

    /* renamed from: c, reason: collision with root package name */
    private final Status f27387c;

    /* renamed from: d, reason: collision with root package name */
    private final ClientStreamListener.RpcProgress f27388d;

    public Ja(Status status) {
        this(status, ClientStreamListener.RpcProgress.PROCESSED);
    }

    @Override // io.grpc.internal.Tb, io.grpc.internal.X
    public void a(ClientStreamListener clientStreamListener) {
        Preconditions.b(!this.f27386b, "already started");
        this.f27386b = true;
        clientStreamListener.a(this.f27387c, this.f27388d, new io.grpc.P());
    }

    public Ja(Status status, ClientStreamListener.RpcProgress rpcProgress) {
        Preconditions.a(!status.g(), "error must not be OK");
        this.f27387c = status;
        this.f27388d = rpcProgress;
    }
}
