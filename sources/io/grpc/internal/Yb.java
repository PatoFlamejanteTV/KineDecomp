package io.grpc.internal;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import io.grpc.C2406e;
import io.grpc.J;
import io.grpc.MethodDescriptor;

/* compiled from: PickSubchannelArgsImpl.java */
/* loaded from: classes3.dex */
final class Yb extends J.d {

    /* renamed from: a, reason: collision with root package name */
    private final C2406e f27539a;

    /* renamed from: b, reason: collision with root package name */
    private final io.grpc.P f27540b;

    /* renamed from: c, reason: collision with root package name */
    private final MethodDescriptor<?, ?> f27541c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Yb(MethodDescriptor<?, ?> methodDescriptor, io.grpc.P p, C2406e c2406e) {
        Preconditions.a(methodDescriptor, "method");
        this.f27541c = methodDescriptor;
        Preconditions.a(p, "headers");
        this.f27540b = p;
        Preconditions.a(c2406e, "callOptions");
        this.f27539a = c2406e;
    }

    @Override // io.grpc.J.d
    public C2406e a() {
        return this.f27539a;
    }

    @Override // io.grpc.J.d
    public io.grpc.P b() {
        return this.f27540b;
    }

    @Override // io.grpc.J.d
    public MethodDescriptor<?, ?> c() {
        return this.f27541c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Yb.class != obj.getClass()) {
            return false;
        }
        Yb yb = (Yb) obj;
        return Objects.a(this.f27539a, yb.f27539a) && Objects.a(this.f27540b, yb.f27540b) && Objects.a(this.f27541c, yb.f27541c);
    }

    public int hashCode() {
        return Objects.a(this.f27539a, this.f27540b, this.f27541c);
    }

    public final String toString() {
        return "[method=" + this.f27541c + " headers=" + this.f27540b + " callOptions=" + this.f27539a + "]";
    }
}
