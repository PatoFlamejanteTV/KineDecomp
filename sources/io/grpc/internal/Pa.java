package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import io.grpc.S;

/* compiled from: ForwardingNameResolver.java */
/* loaded from: classes3.dex */
abstract class Pa extends io.grpc.S {

    /* renamed from: a */
    private final io.grpc.S f27464a;

    public Pa(io.grpc.S s) {
        Preconditions.a(s, "delegate can not be null");
        this.f27464a = s;
    }

    @Override // io.grpc.S
    public void a(S.b bVar) {
        this.f27464a.a(bVar);
    }

    @Override // io.grpc.S
    public void b() {
        this.f27464a.b();
    }

    @Override // io.grpc.S
    public void c() {
        this.f27464a.c();
    }

    public String toString() {
        return MoreObjects.a(this).a("delegate", this.f27464a).toString();
    }
}
