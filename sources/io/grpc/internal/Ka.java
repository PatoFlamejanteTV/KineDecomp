package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.C2406e;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FailingClientTransport.java */
/* loaded from: classes3.dex */
public class Ka implements Y {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    final Status f27396a;

    /* renamed from: b, reason: collision with root package name */
    private final ClientStreamListener.RpcProgress f27397b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ka(Status status, ClientStreamListener.RpcProgress rpcProgress) {
        Preconditions.a(!status.g(), "error must not be OK");
        this.f27396a = status;
        this.f27397b = rpcProgress;
    }

    @Override // io.grpc.internal.Y
    public X a(MethodDescriptor<?, ?> methodDescriptor, io.grpc.P p, C2406e c2406e) {
        return new Ja(this.f27396a, this.f27397b);
    }

    @Override // io.grpc.internal.Sc
    public C2492ub a() {
        throw new UnsupportedOperationException("Not a real transport");
    }
}
