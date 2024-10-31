package io.grpc.internal;

import io.grpc.C2406e;
import io.grpc.MethodDescriptor;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: ClientTransport.java */
@ThreadSafe
/* loaded from: classes3.dex */
public interface Y extends InterfaceC2429eb<Object> {

    /* compiled from: ClientTransport.java */
    /* loaded from: classes3.dex */
    public interface a {
        void a(long j);

        void a(Throwable th);
    }

    X a(MethodDescriptor<?, ?> methodDescriptor, io.grpc.P p, C2406e c2406e);

    void a(a aVar, Executor executor);
}
