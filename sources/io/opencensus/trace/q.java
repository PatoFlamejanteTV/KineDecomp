package io.opencensus.trace;

import com.google.common.annotations.VisibleForTesting;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* compiled from: Tracing.java */
/* loaded from: classes3.dex */
public final class q {

    /* renamed from: a */
    private static final Logger f28088a = Logger.getLogger(q.class.getName());

    /* renamed from: b */
    private static final l f28089b = a(l.class.getClassLoader());

    private q() {
    }

    public static io.opencensus.trace.propagation.d a() {
        return f28089b.a();
    }

    public static p b() {
        return f28089b.b();
    }

    @VisibleForTesting
    static l a(@Nullable ClassLoader classLoader) {
        try {
            return (l) e.a.c.a.a(Class.forName("io.opencensus.impl.trace.TraceComponentImpl", true, classLoader), l.class);
        } catch (ClassNotFoundException e2) {
            f28088a.log(Level.FINE, "Couldn't load full implementation for TraceComponent, now trying to load lite implementation.", (Throwable) e2);
            try {
                return (l) e.a.c.a.a(Class.forName("io.opencensus.impllite.trace.TraceComponentImplLite", true, classLoader), l.class);
            } catch (ClassNotFoundException e3) {
                f28088a.log(Level.FINE, "Couldn't load lite implementation for TraceComponent, now using default implementation for TraceComponent.", (Throwable) e3);
                return l.c();
            }
        }
    }
}
