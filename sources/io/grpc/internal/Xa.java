package io.grpc.internal;

import io.grpc.AbstractC2513n;
import io.grpc.C2406e;
import io.grpc.MethodDescriptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GrpcUtil.java */
/* loaded from: classes3.dex */
public class Xa implements Y {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Y f27534a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AbstractC2513n.a f27535b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Xa(Y y, AbstractC2513n.a aVar) {
        this.f27534a = y;
        this.f27535b = aVar;
    }

    @Override // io.grpc.internal.Y
    public X a(MethodDescriptor<?, ?> methodDescriptor, io.grpc.P p, C2406e c2406e) {
        return this.f27534a.a(methodDescriptor, p, c2406e.a(this.f27535b));
    }

    @Override // io.grpc.internal.Sc
    public C2492ub a() {
        return this.f27534a.a();
    }
}
