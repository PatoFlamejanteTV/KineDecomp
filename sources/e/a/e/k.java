package e.a.e;

import com.google.common.annotations.VisibleForTesting;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* compiled from: Tags.java */
/* loaded from: classes3.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f26764a = Logger.getLogger(k.class.getName());

    /* renamed from: b, reason: collision with root package name */
    private static final l f26765b = a(l.class.getClassLoader());

    private k() {
    }

    public static io.opencensus.tags.propagation.b a() {
        return f26765b.a();
    }

    public static j b() {
        return f26765b.b();
    }

    @VisibleForTesting
    static l a(@Nullable ClassLoader classLoader) {
        try {
            return (l) e.a.c.a.a(Class.forName("io.opencensus.impl.tags.TagsComponentImpl", true, classLoader), l.class);
        } catch (ClassNotFoundException e2) {
            f26764a.log(Level.FINE, "Couldn't load full implementation for TagsComponent, now trying to load lite implementation.", (Throwable) e2);
            try {
                return (l) e.a.c.a.a(Class.forName("io.opencensus.impllite.tags.TagsComponentImplLite", true, classLoader), l.class);
            } catch (ClassNotFoundException e3) {
                f26764a.log(Level.FINE, "Couldn't load lite implementation for TagsComponent, now using default implementation for TagsComponent.", (Throwable) e3);
                return d.f();
            }
        }
    }
}
