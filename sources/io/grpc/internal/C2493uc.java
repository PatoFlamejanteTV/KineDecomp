package io.grpc.internal;

import io.grpc.MethodDescriptor;
import io.grpc.internal.wc;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RetriableStream.java */
/* renamed from: io.grpc.internal.uc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2493uc implements wc.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Object f27750a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ wc f27751b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2493uc(wc wcVar, Object obj) {
        this.f27751b = wcVar;
        this.f27750a = obj;
    }

    @Override // io.grpc.internal.wc.a
    public void a(wc.g gVar) {
        MethodDescriptor methodDescriptor;
        X x = gVar.f27777a;
        methodDescriptor = this.f27751b.f27760e;
        x.a(methodDescriptor.a((MethodDescriptor) this.f27750a));
    }
}
