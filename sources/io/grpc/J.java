package io.grpc;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import io.grpc.AbstractC2513n;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: LoadBalancer.java */
@NotThreadSafe
/* loaded from: classes3.dex */
public abstract class J {

    /* compiled from: LoadBalancer.java */
    @ThreadSafe
    /* loaded from: classes3.dex */
    public static abstract class a {
        public abstract J a(b bVar);
    }

    /* compiled from: LoadBalancer.java */
    @ThreadSafe
    /* loaded from: classes3.dex */
    public static abstract class b {
        public abstract e a(C2530z c2530z, C2403b c2403b);

        public abstract void a(@Nonnull ConnectivityState connectivityState, @Nonnull f fVar);

        public void a(e eVar, C2530z c2530z) {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: LoadBalancer.java */
    /* loaded from: classes3.dex */
    public static abstract class d {
        public abstract C2406e a();

        public abstract P b();

        public abstract MethodDescriptor<?, ?> c();
    }

    /* compiled from: LoadBalancer.java */
    @ThreadSafe
    /* loaded from: classes3.dex */
    public static abstract class e {
        public abstract C2530z a();

        public abstract C2403b b();

        public abstract void c();

        public abstract void d();
    }

    /* compiled from: LoadBalancer.java */
    @ThreadSafe
    /* loaded from: classes3.dex */
    public static abstract class f {
        public abstract c a(d dVar);
    }

    public abstract void a();

    public abstract void a(e eVar, r rVar);

    public abstract void a(Status status);

    public abstract void a(List<C2530z> list, C2403b c2403b);

    /* compiled from: LoadBalancer.java */
    @Immutable
    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a */
        private static final c f27093a = new c(null, null, Status.f27129b, false);

        /* renamed from: b */
        @Nullable
        private final e f27094b;

        /* renamed from: c */
        @Nullable
        private final AbstractC2513n.a f27095c;

        /* renamed from: d */
        private final Status f27096d;

        /* renamed from: e */
        private final boolean f27097e;

        private c(@Nullable e eVar, @Nullable AbstractC2513n.a aVar, Status status, boolean z) {
            this.f27094b = eVar;
            this.f27095c = aVar;
            Preconditions.a(status, "status");
            this.f27096d = status;
            this.f27097e = z;
        }

        public static c a(e eVar, @Nullable AbstractC2513n.a aVar) {
            Preconditions.a(eVar, "subchannel");
            return new c(eVar, aVar, Status.f27129b, false);
        }

        public static c b(Status status) {
            Preconditions.a(!status.g(), "error status shouldn't be OK");
            return new c(null, null, status, false);
        }

        public static c e() {
            return f27093a;
        }

        @Nullable
        public e c() {
            return this.f27094b;
        }

        public boolean d() {
            return this.f27097e;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return Objects.a(this.f27094b, cVar.f27094b) && Objects.a(this.f27096d, cVar.f27096d) && Objects.a(this.f27095c, cVar.f27095c) && this.f27097e == cVar.f27097e;
        }

        public int hashCode() {
            return Objects.a(this.f27094b, this.f27096d, this.f27095c, Boolean.valueOf(this.f27097e));
        }

        public String toString() {
            return MoreObjects.a(this).a("subchannel", this.f27094b).a("streamTracerFactory", this.f27095c).a("status", this.f27096d).a("drop", this.f27097e).toString();
        }

        public static c a(e eVar) {
            return a(eVar, null);
        }

        @Nullable
        public AbstractC2513n.a b() {
            return this.f27095c;
        }

        public static c a(Status status) {
            Preconditions.a(!status.g(), "drop status shouldn't be OK");
            return new c(null, null, status, true);
        }

        public Status a() {
            return this.f27096d;
        }
    }
}
