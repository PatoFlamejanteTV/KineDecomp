package io.grpc.internal;

import com.google.common.base.MoreObjects;
import io.grpc.AbstractC2408g;
import io.grpc.C2406e;
import io.grpc.MethodDescriptor;

/* compiled from: ForwardingManagedChannel.java */
/* loaded from: classes3.dex */
abstract class Oa extends io.grpc.K {

    /* renamed from: a */
    private final io.grpc.K f27460a;

    public Oa(io.grpc.K k) {
        this.f27460a = k;
    }

    @Override // io.grpc.AbstractC2407f
    public <RequestT, ResponseT> AbstractC2408g<RequestT, ResponseT> a(MethodDescriptor<RequestT, ResponseT> methodDescriptor, C2406e c2406e) {
        return this.f27460a.a(methodDescriptor, c2406e);
    }

    @Override // io.grpc.AbstractC2407f
    public String b() {
        return this.f27460a.b();
    }

    @Override // io.grpc.K
    public boolean c() {
        return this.f27460a.c();
    }

    public String toString() {
        return MoreObjects.a(this).a("delegate", this.f27460a).toString();
    }
}
