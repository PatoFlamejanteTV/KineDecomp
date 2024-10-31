package io.grpc;

import com.google.common.base.Preconditions;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: EquivalentAddressGroup.java */
/* renamed from: io.grpc.z */
/* loaded from: classes3.dex */
public final class C2530z {

    /* renamed from: a */
    private final List<SocketAddress> f28037a;

    /* renamed from: b */
    private final C2403b f28038b;

    /* renamed from: c */
    private final int f28039c;

    public C2530z(List<SocketAddress> list) {
        this(list, C2403b.f27155a);
    }

    public List<SocketAddress> a() {
        return this.f28037a;
    }

    public C2403b b() {
        return this.f28038b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2530z)) {
            return false;
        }
        C2530z c2530z = (C2530z) obj;
        if (this.f28037a.size() != c2530z.f28037a.size()) {
            return false;
        }
        for (int i = 0; i < this.f28037a.size(); i++) {
            if (!this.f28037a.get(i).equals(c2530z.f28037a.get(i))) {
                return false;
            }
        }
        return this.f28038b.equals(c2530z.f28038b);
    }

    public int hashCode() {
        return this.f28039c;
    }

    public String toString() {
        return "[addrs=" + this.f28037a + ", attrs=" + this.f28038b + "]";
    }

    public C2530z(List<SocketAddress> list, C2403b c2403b) {
        Preconditions.a(!list.isEmpty(), "addrs is empty");
        this.f28037a = Collections.unmodifiableList(new ArrayList(list));
        Preconditions.a(c2403b, "attrs");
        this.f28038b = c2403b;
        this.f28039c = this.f28037a.hashCode();
    }

    public C2530z(SocketAddress socketAddress) {
        this(socketAddress, C2403b.f27155a);
    }

    public C2530z(SocketAddress socketAddress, C2403b c2403b) {
        this((List<SocketAddress>) Collections.singletonList(socketAddress), c2403b);
    }
}
