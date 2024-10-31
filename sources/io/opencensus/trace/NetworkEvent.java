package io.opencensus.trace;

import com.google.common.base.Preconditions;
import io.opencensus.trace.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* loaded from: classes3.dex */
public abstract class NetworkEvent {

    /* loaded from: classes3.dex */
    public enum Type {
        SENT,
        RECV
    }

    /* loaded from: classes3.dex */
    public static abstract class a {
        public abstract a a(long j);

        public abstract NetworkEvent a();

        abstract a b(long j);

        public abstract a c(long j);
    }

    public static a a(Type type, long j) {
        d.a aVar = new d.a();
        Preconditions.a(type, "type");
        aVar.a(type);
        aVar.b(j);
        aVar.c(0L);
        aVar.a(0L);
        return aVar;
    }

    public abstract long a();

    @Nullable
    public abstract e.a.a.b b();

    public abstract long c();

    public abstract Type d();

    public abstract long e();
}
