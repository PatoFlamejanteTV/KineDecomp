package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import io.grpc.C2403b;
import io.grpc.C2406e;
import io.grpc.InterfaceC2405d;
import io.grpc.MethodDescriptor;
import io.grpc.SecurityLevel;
import io.grpc.Status;
import java.net.SocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

/* compiled from: CallCredentialsApplyingTransportFactory.java */
/* renamed from: io.grpc.internal.z, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2506z implements Z {

    /* renamed from: a, reason: collision with root package name */
    private final Z f27803a;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f27804b;

    /* compiled from: CallCredentialsApplyingTransportFactory.java */
    /* renamed from: io.grpc.internal.z$a */
    /* loaded from: classes3.dex */
    private class a extends Na {

        /* renamed from: a, reason: collision with root package name */
        private final InterfaceC2424da f27805a;

        /* renamed from: b, reason: collision with root package name */
        private final String f27806b;

        a(InterfaceC2424da interfaceC2424da, String str) {
            Preconditions.a(interfaceC2424da, "delegate");
            this.f27805a = interfaceC2424da;
            Preconditions.a(str, "authority");
            this.f27806b = str;
        }

        @Override // io.grpc.internal.Na, io.grpc.internal.Y
        public X a(MethodDescriptor<?, ?> methodDescriptor, io.grpc.P p, C2406e c2406e) {
            InterfaceC2405d c2 = c2406e.c();
            if (c2 != null) {
                Rb rb = new Rb(this.f27805a, methodDescriptor, p, c2406e);
                C2403b.a b2 = C2403b.b();
                b2.a(InterfaceC2405d.f27182b, this.f27806b);
                b2.a(InterfaceC2405d.f27181a, SecurityLevel.NONE);
                b2.a(this.f27805a.getAttributes());
                if (c2406e.a() != null) {
                    b2.a(InterfaceC2405d.f27182b, c2406e.a());
                }
                try {
                    c2.a(methodDescriptor, b2.a(), (Executor) MoreObjects.a(c2406e.e(), C2506z.this.f27804b), rb);
                } catch (Throwable th) {
                    rb.a(Status.j.b("Credentials should use fail() instead of throwing exceptions").b(th));
                }
                return rb.a();
            }
            return this.f27805a.a(methodDescriptor, p, c2406e);
        }

        @Override // io.grpc.internal.Na
        protected InterfaceC2424da b() {
            return this.f27805a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2506z(Z z, Executor executor) {
        Preconditions.a(z, "delegate");
        this.f27803a = z;
        Preconditions.a(executor, "appExecutor");
        this.f27804b = executor;
    }

    @Override // io.grpc.internal.Z
    public ScheduledExecutorService I() {
        return this.f27803a.I();
    }

    @Override // io.grpc.internal.Z, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f27803a.close();
    }

    @Override // io.grpc.internal.Z
    public InterfaceC2424da a(SocketAddress socketAddress, String str, @Nullable String str2, @Nullable C2422cc c2422cc) {
        return new a(this.f27803a.a(socketAddress, str, str2, c2422cc), str);
    }
}
