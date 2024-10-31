package io.grpc.internal;

import com.google.common.base.Preconditions;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: AtomicBackoff.java */
@ThreadSafe
/* renamed from: io.grpc.internal.p */
/* loaded from: classes3.dex */
public final class C2471p {

    /* renamed from: a */
    private static final Logger f27711a = Logger.getLogger(C2471p.class.getName());

    /* renamed from: b */
    private final String f27712b;

    /* renamed from: c */
    private final AtomicLong f27713c = new AtomicLong();

    /* compiled from: AtomicBackoff.java */
    @ThreadSafe
    /* renamed from: io.grpc.internal.p$a */
    /* loaded from: classes3.dex */
    public final class a {

        /* renamed from: a */
        private final long f27714a;

        /* synthetic */ a(C2471p c2471p, long j, C2467o c2467o) {
            this(j);
        }

        public void a() {
            long j = this.f27714a;
            long max = Math.max(2 * j, j);
            if (C2471p.this.f27713c.compareAndSet(this.f27714a, max)) {
                C2471p.f27711a.log(Level.WARNING, "Increased {0} to {1}", new Object[]{C2471p.this.f27712b, Long.valueOf(max)});
            }
        }

        public long b() {
            return this.f27714a;
        }

        private a(long j) {
            this.f27714a = j;
        }
    }

    public C2471p(String str, long j) {
        Preconditions.a(j > 0, "value must be positive");
        this.f27712b = str;
        this.f27713c.set(j);
    }

    public a b() {
        return new a(this.f27713c.get());
    }
}
