package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.C2406e;
import io.grpc.Context;
import io.grpc.InterfaceC2405d;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import javax.annotation.Nullable;

/* compiled from: MetadataApplierImpl.java */
/* loaded from: classes3.dex */
final class Rb implements InterfaceC2405d.a {

    /* renamed from: a, reason: collision with root package name */
    private final Y f27483a;

    /* renamed from: b, reason: collision with root package name */
    private final MethodDescriptor<?, ?> f27484b;

    /* renamed from: c, reason: collision with root package name */
    private final io.grpc.P f27485c;

    /* renamed from: d, reason: collision with root package name */
    private final C2406e f27486d;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private X f27489g;

    /* renamed from: h, reason: collision with root package name */
    boolean f27490h;
    Ea i;

    /* renamed from: f, reason: collision with root package name */
    private final Object f27488f = new Object();

    /* renamed from: e, reason: collision with root package name */
    private final Context f27487e = Context.s();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Rb(Y y, MethodDescriptor<?, ?> methodDescriptor, io.grpc.P p, C2406e c2406e) {
        this.f27483a = y;
        this.f27484b = methodDescriptor;
        this.f27485c = p;
        this.f27486d = c2406e;
    }

    public void a(Status status) {
        Preconditions.a(!status.g(), "Cannot fail with OK status");
        Preconditions.b(!this.f27490h, "apply() or fail() already called");
        a(new Ja(status));
    }

    private void a(X x) {
        Preconditions.b(!this.f27490h, "already finalized");
        this.f27490h = true;
        synchronized (this.f27488f) {
            if (this.f27489g == null) {
                this.f27489g = x;
            } else {
                Preconditions.b(this.i != null, "delayedStream is null");
                this.i.a(x);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public X a() {
        synchronized (this.f27488f) {
            if (this.f27489g == null) {
                this.i = new Ea();
                Ea ea = this.i;
                this.f27489g = ea;
                return ea;
            }
            return this.f27489g;
        }
    }
}
