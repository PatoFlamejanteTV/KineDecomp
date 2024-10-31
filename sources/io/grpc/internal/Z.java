package io.grpc.internal;

import java.io.Closeable;
import java.net.SocketAddress;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

/* compiled from: ClientTransportFactory.java */
/* loaded from: classes3.dex */
public interface Z extends Closeable {
    ScheduledExecutorService I();

    InterfaceC2424da a(SocketAddress socketAddress, String str, @Nullable String str2, @Nullable C2422cc c2422cc);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();
}
