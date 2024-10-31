package okhttp3;

import android.support.v7.widget.ActivityChooserView;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.connection.f;

/* compiled from: ConnectionPool.java */
/* renamed from: okhttp3.m */
/* loaded from: classes3.dex */
public final class C2569m {

    /* renamed from: a */
    private static final Executor f29175a = new ThreadPoolExecutor(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60, TimeUnit.SECONDS, new SynchronousQueue(), okhttp3.a.e.a("OkHttp ConnectionPool", true));

    /* renamed from: b */
    private final int f29176b;

    /* renamed from: c */
    private final long f29177c;

    /* renamed from: d */
    private final Runnable f29178d;

    /* renamed from: e */
    private final Deque<okhttp3.internal.connection.c> f29179e;

    /* renamed from: f */
    final okhttp3.internal.connection.d f29180f;

    /* renamed from: g */
    boolean f29181g;

    public C2569m() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    @Nullable
    public okhttp3.internal.connection.c a(C2557a c2557a, okhttp3.internal.connection.f fVar, P p) {
        for (okhttp3.internal.connection.c cVar : this.f29179e) {
            if (cVar.a(c2557a, p)) {
                fVar.a(cVar, true);
                return cVar;
            }
        }
        return null;
    }

    public void b(okhttp3.internal.connection.c cVar) {
        if (!this.f29181g) {
            this.f29181g = true;
            f29175a.execute(this.f29178d);
        }
        this.f29179e.add(cVar);
    }

    public C2569m(int i, long j, TimeUnit timeUnit) {
        this.f29178d = new RunnableC2568l(this);
        this.f29179e = new ArrayDeque();
        this.f29180f = new okhttp3.internal.connection.d();
        this.f29176b = i;
        this.f29177c = timeUnit.toNanos(j);
        if (j > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
    }

    @Nullable
    public Socket a(C2557a c2557a, okhttp3.internal.connection.f fVar) {
        for (okhttp3.internal.connection.c cVar : this.f29179e) {
            if (cVar.a(c2557a, null) && cVar.c() && cVar != fVar.c()) {
                return fVar.a(cVar);
            }
        }
        return null;
    }

    public boolean a(okhttp3.internal.connection.c cVar) {
        if (!cVar.k && this.f29176b != 0) {
            notifyAll();
            return false;
        }
        this.f29179e.remove(cVar);
        return true;
    }

    public long a(long j) {
        synchronized (this) {
            long j2 = Long.MIN_VALUE;
            okhttp3.internal.connection.c cVar = null;
            int i = 0;
            int i2 = 0;
            for (okhttp3.internal.connection.c cVar2 : this.f29179e) {
                if (a(cVar2, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - cVar2.o;
                    if (j3 > j2) {
                        cVar = cVar2;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.f29177c && i <= this.f29176b) {
                if (i > 0) {
                    return this.f29177c - j2;
                }
                if (i2 > 0) {
                    return this.f29177c;
                }
                this.f29181g = false;
                return -1L;
            }
            this.f29179e.remove(cVar);
            okhttp3.a.e.a(cVar.e());
            return 0L;
        }
    }

    private int a(okhttp3.internal.connection.c cVar, long j) {
        List<Reference<okhttp3.internal.connection.f>> list = cVar.n;
        int i = 0;
        while (i < list.size()) {
            Reference<okhttp3.internal.connection.f> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                okhttp3.a.d.f.a().a("A connection to " + cVar.d().a().k() + " was leaked. Did you forget to close a response body?", ((f.a) reference).f29022a);
                list.remove(i);
                cVar.k = true;
                if (list.isEmpty()) {
                    cVar.o = j - this.f29177c;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
