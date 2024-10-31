package io.grpc.internal;

import io.grpc.InterfaceC2521p;
import java.io.InputStream;

/* compiled from: Framer.java */
/* loaded from: classes3.dex */
public interface Ra {
    Ra a(InterfaceC2521p interfaceC2521p);

    void a(InputStream inputStream);

    void c(int i);

    void close();

    void flush();

    boolean isClosed();
}
