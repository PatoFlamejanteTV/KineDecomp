package e.a.d;

import com.google.common.annotations.VisibleForTesting;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* compiled from: Stats.java */
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a */
    private static final Logger f26754a = Logger.getLogger(h.class.getName());

    /* renamed from: b */
    private static final i f26755b = a(i.class.getClassLoader());

    private h() {
    }

    public static j a() {
        return f26755b.a();
    }

    @VisibleForTesting
    static i a(@Nullable ClassLoader classLoader) {
        try {
            return (i) e.a.c.a.a(Class.forName("io.opencensus.impl.stats.StatsComponentImpl", true, classLoader), i.class);
        } catch (ClassNotFoundException e2) {
            f26754a.log(Level.FINE, "Couldn't load full implementation for StatsComponent, now trying to load lite implementation.", (Throwable) e2);
            try {
                return (i) e.a.c.a.a(Class.forName("io.opencensus.impllite.stats.StatsComponentImplLite", true, classLoader), i.class);
            } catch (ClassNotFoundException e3) {
                f26754a.log(Level.FINE, "Couldn't load lite implementation for StatsComponent, now using default implementation for StatsComponent.", (Throwable) e3);
                return g.c();
            }
        }
    }
}
