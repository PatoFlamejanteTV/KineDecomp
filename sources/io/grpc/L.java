package io.grpc;

import io.grpc.L;

/* compiled from: ManagedChannelBuilder.java */
/* loaded from: classes3.dex */
public abstract class L<T extends L<T>> {
    public static L<?> a(String str) {
        return ManagedChannelProvider.c().a(str);
    }

    public abstract K a();
}
