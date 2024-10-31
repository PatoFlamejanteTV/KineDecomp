package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.C2403b;
import java.net.SocketAddress;

/* loaded from: classes3.dex */
final class PairSocketAddress extends SocketAddress {
    private static final long serialVersionUID = -6854992294603212793L;
    private final SocketAddress address;
    private final C2403b attributes;

    @VisibleForTesting
    public PairSocketAddress(SocketAddress socketAddress, C2403b c2403b) {
        Preconditions.a(socketAddress);
        this.address = socketAddress;
        Preconditions.a(c2403b);
        this.attributes = c2403b;
    }

    public SocketAddress getAddress() {
        return this.address;
    }

    public C2403b getAttributes() {
        return this.attributes;
    }
}
