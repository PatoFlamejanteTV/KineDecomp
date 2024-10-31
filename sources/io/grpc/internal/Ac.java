package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import io.grpc.Status;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

/* compiled from: RetryPolicy.java */
@Immutable
/* loaded from: classes3.dex */
public final class Ac {

    /* renamed from: a */
    static final Ac f27199a = new Ac(1, 0, 0, 1.0d, Collections.emptySet());

    /* renamed from: b */
    final int f27200b;

    /* renamed from: c */
    final long f27201c;

    /* renamed from: d */
    final long f27202d;

    /* renamed from: e */
    final double f27203e;

    /* renamed from: f */
    final Set<Status.Code> f27204f;

    /* compiled from: RetryPolicy.java */
    /* loaded from: classes3.dex */
    public interface a {
        @Nonnull
        Ac get();
    }

    public Ac(int i, long j, long j2, double d2, @Nonnull Set<Status.Code> set) {
        this.f27200b = i;
        this.f27201c = j;
        this.f27202d = j2;
        this.f27203e = d2;
        this.f27204f = ImmutableSet.copyOf((Collection) set);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Ac)) {
            return false;
        }
        Ac ac = (Ac) obj;
        return this.f27200b == ac.f27200b && this.f27201c == ac.f27201c && this.f27202d == ac.f27202d && Double.compare(this.f27203e, ac.f27203e) == 0 && Objects.a(this.f27204f, ac.f27204f);
    }

    public int hashCode() {
        return Objects.a(Integer.valueOf(this.f27200b), Long.valueOf(this.f27201c), Long.valueOf(this.f27202d), Double.valueOf(this.f27203e), this.f27204f);
    }

    public String toString() {
        return MoreObjects.a(this).a("maxAttempts", this.f27200b).a("initialBackoffNanos", this.f27201c).a("maxBackoffNanos", this.f27202d).a("backoffMultiplier", this.f27203e).a("retryableStatusCodes", this.f27204f).toString();
    }
}
