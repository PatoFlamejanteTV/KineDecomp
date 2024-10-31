package io.grpc.internal;

import com.google.common.base.Preconditions;
import java.util.IdentityHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: SharedResourceHolder.java */
@ThreadSafe
/* loaded from: classes3.dex */
public final class Kc {

    /* renamed from: a */
    private static final Kc f27401a = new Kc(new Ic());

    /* renamed from: b */
    private final IdentityHashMap<b<?>, a> f27402b = new IdentityHashMap<>();

    /* renamed from: c */
    private final c f27403c;

    /* renamed from: d */
    private ScheduledExecutorService f27404d;

    /* compiled from: SharedResourceHolder.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a */
        final Object f27405a;

        /* renamed from: b */
        int f27406b;

        /* renamed from: c */
        ScheduledFuture<?> f27407c;

        a(Object obj) {
            this.f27405a = obj;
        }
    }

    /* compiled from: SharedResourceHolder.java */
    /* loaded from: classes3.dex */
    public interface b<T> {
        void a(T t);

        T create();
    }

    /* compiled from: SharedResourceHolder.java */
    /* loaded from: classes3.dex */
    public interface c {
        ScheduledExecutorService a();
    }

    Kc(c cVar) {
        this.f27403c = cVar;
    }

    synchronized <T> T b(b<T> bVar) {
        a aVar;
        aVar = this.f27402b.get(bVar);
        if (aVar == null) {
            aVar = new a(bVar.create());
            this.f27402b.put(bVar, aVar);
        }
        if (aVar.f27407c != null) {
            aVar.f27407c.cancel(false);
            aVar.f27407c = null;
        }
        aVar.f27406b++;
        return (T) aVar.f27405a;
    }

    public static <T> T a(b<T> bVar) {
        return (T) f27401a.b(bVar);
    }

    public static <T> T a(b<T> bVar, T t) {
        return (T) f27401a.b(bVar, t);
    }

    synchronized <T> T b(b<T> bVar, T t) {
        a aVar = this.f27402b.get(bVar);
        if (aVar != null) {
            Preconditions.a(t == aVar.f27405a, "Releasing the wrong instance");
            Preconditions.b(aVar.f27406b > 0, "Refcount has already reached zero");
            aVar.f27406b--;
            if (aVar.f27406b == 0) {
                if (GrpcUtil.f27339c) {
                    bVar.a(t);
                    this.f27402b.remove(bVar);
                } else {
                    Preconditions.b(aVar.f27407c == null, "Destroy task already scheduled");
                    if (this.f27404d == null) {
                        this.f27404d = this.f27403c.a();
                    }
                    aVar.f27407c = this.f27404d.schedule(new RunnableC2488tb(new Jc(this, aVar, bVar, t)), 1L, TimeUnit.SECONDS);
                }
            }
        } else {
            throw new IllegalArgumentException("No cached instance found for " + bVar);
        }
        return null;
    }
}
