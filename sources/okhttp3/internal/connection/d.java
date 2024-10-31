package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.P;

/* compiled from: RouteDatabase.java */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a */
    private final Set<P> f29003a = new LinkedHashSet();

    public synchronized void a(P p) {
        this.f29003a.remove(p);
    }

    public synchronized void b(P p) {
        this.f29003a.add(p);
    }

    public synchronized boolean c(P p) {
        return this.f29003a.contains(p);
    }
}
