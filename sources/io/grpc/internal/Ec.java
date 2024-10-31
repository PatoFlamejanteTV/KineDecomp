package io.grpc.internal;

import io.grpc.MethodDescriptor;
import io.grpc.internal.Ac;

/* compiled from: ServiceConfigInterceptor.java */
/* loaded from: classes3.dex */
final class Ec implements Ac.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MethodDescriptor f27274a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Gc f27275b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ec(Gc gc, MethodDescriptor methodDescriptor) {
        this.f27275b = gc;
        this.f27274a = methodDescriptor;
    }

    @Override // io.grpc.internal.Ac.a
    public Ac get() {
        boolean z;
        z = this.f27275b.f27331g;
        if (!z) {
            return Ac.f27199a;
        }
        return this.f27275b.a(this.f27274a);
    }
}
