package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import io.grpc.AbstractC2513n;
import io.grpc.C2406e;
import io.grpc.Status;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: StatsTraceContext.java */
@ThreadSafe
/* loaded from: classes3.dex */
public final class Mc {

    /* renamed from: a, reason: collision with root package name */
    public static final Mc f27437a = new Mc(new io.grpc.ea[0]);

    /* renamed from: b, reason: collision with root package name */
    private final io.grpc.ea[] f27438b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f27439c = new AtomicBoolean(false);

    @VisibleForTesting
    Mc(io.grpc.ea[] eaVarArr) {
        this.f27438b = eaVarArr;
    }

    public static Mc a(C2406e c2406e, io.grpc.P p) {
        List<AbstractC2513n.a> h2 = c2406e.h();
        if (h2.isEmpty()) {
            return f27437a;
        }
        io.grpc.ea[] eaVarArr = new io.grpc.ea[h2.size()];
        for (int i = 0; i < eaVarArr.length; i++) {
            eaVarArr[i] = h2.get(i).a(c2406e, p);
        }
        return new Mc(eaVarArr);
    }

    public void b() {
        for (io.grpc.ea eaVar : this.f27438b) {
            ((AbstractC2513n) eaVar).b();
        }
    }

    public void c(long j) {
        for (io.grpc.ea eaVar : this.f27438b) {
            eaVar.c(j);
        }
    }

    public void d(long j) {
        for (io.grpc.ea eaVar : this.f27438b) {
            eaVar.d(j);
        }
    }

    public void b(int i) {
        for (io.grpc.ea eaVar : this.f27438b) {
            eaVar.b(i);
        }
    }

    public void b(int i, long j, long j2) {
        for (io.grpc.ea eaVar : this.f27438b) {
            eaVar.b(i, j, j2);
        }
    }

    public void b(long j) {
        for (io.grpc.ea eaVar : this.f27438b) {
            eaVar.b(j);
        }
    }

    public void a() {
        for (io.grpc.ea eaVar : this.f27438b) {
            ((AbstractC2513n) eaVar).a();
        }
    }

    public void a(Status status) {
        if (this.f27439c.compareAndSet(false, true)) {
            for (io.grpc.ea eaVar : this.f27438b) {
                eaVar.a(status);
            }
        }
    }

    public void a(int i) {
        for (io.grpc.ea eaVar : this.f27438b) {
            eaVar.a(i);
        }
    }

    public void a(int i, long j, long j2) {
        for (io.grpc.ea eaVar : this.f27438b) {
            eaVar.a(i, j, j2);
        }
    }

    public void a(long j) {
        for (io.grpc.ea eaVar : this.f27438b) {
            eaVar.a(j);
        }
    }
}
