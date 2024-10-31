package io.grpc.internal;

import io.grpc.C2403b;
import java.io.IOException;
import java.net.SocketAddress;
import javax.annotation.Nullable;

/* compiled from: ProxyDetector.java */
/* loaded from: classes3.dex */
public interface Zb {

    /* renamed from: a */
    public static final C2403b.C0153b<C2422cc> f27542a = C2403b.C0153b.a("proxy-params-key");

    @Nullable
    C2422cc a(SocketAddress socketAddress) throws IOException;
}
