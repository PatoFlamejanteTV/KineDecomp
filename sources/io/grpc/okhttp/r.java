package io.grpc.okhttp;

import io.grpc.G;
import io.grpc.ManagedChannelProvider;
import io.grpc.internal.GrpcUtil;

/* compiled from: OkHttpChannelProvider.java */
/* loaded from: classes3.dex */
public final class r extends ManagedChannelProvider {
    @Override // io.grpc.ManagedChannelProvider
    public boolean a() {
        return true;
    }

    @Override // io.grpc.ManagedChannelProvider
    public int b() {
        return (GrpcUtil.f27339c || G.a(r.class.getClassLoader())) ? 8 : 3;
    }

    @Override // io.grpc.ManagedChannelProvider
    public q a(String str) {
        return q.a(str);
    }
}
