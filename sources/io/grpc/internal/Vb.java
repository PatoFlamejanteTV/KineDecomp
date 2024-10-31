package io.grpc.internal;

import io.grpc.AbstractC2408g;
import io.grpc.C2406e;
import io.grpc.MethodDescriptor;
import io.grpc.internal.W;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Logger;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: OobChannel.java */
@ThreadSafe
/* loaded from: classes3.dex */
final class Vb extends io.grpc.K implements InterfaceC2429eb<Object> {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f27511a = Logger.getLogger(Vb.class.getName());

    /* renamed from: b, reason: collision with root package name */
    private C2461mb f27512b;

    /* renamed from: c, reason: collision with root package name */
    private final C2492ub f27513c;

    /* renamed from: d, reason: collision with root package name */
    private final String f27514d;

    /* renamed from: e, reason: collision with root package name */
    private final Executor f27515e;

    /* renamed from: f, reason: collision with root package name */
    private final ScheduledExecutorService f27516f;

    /* renamed from: g, reason: collision with root package name */
    private final CountDownLatch f27517g;

    /* renamed from: h, reason: collision with root package name */
    private final C f27518h;
    private final W.b i;

    @Override // io.grpc.AbstractC2407f
    public <RequestT, ResponseT> AbstractC2408g<RequestT, ResponseT> a(MethodDescriptor<RequestT, ResponseT> methodDescriptor, C2406e c2406e) {
        return new W(methodDescriptor, c2406e.e() == null ? this.f27515e : c2406e.e(), c2406e, this.i, this.f27516f, this.f27518h, false);
    }

    @Override // io.grpc.AbstractC2407f
    public String b() {
        return this.f27514d;
    }

    @Override // io.grpc.K
    public boolean c() {
        return this.f27517g.getCount() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2461mb d() {
        return this.f27512b;
    }

    @Override // io.grpc.internal.Sc
    public C2492ub a() {
        return this.f27513c;
    }
}
