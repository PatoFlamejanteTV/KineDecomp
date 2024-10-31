package io.grpc.internal;

import io.grpc.Status;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: ManagedClientTransport.java */
@ThreadSafe
/* loaded from: classes3.dex */
public interface Nb extends Y {

    /* compiled from: ManagedClientTransport.java */
    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void a(Status status);

        void a(boolean z);

        void b();
    }

    @CheckReturnValue
    @Nullable
    Runnable a(a aVar);

    void a(Status status);

    void b(Status status);
}
