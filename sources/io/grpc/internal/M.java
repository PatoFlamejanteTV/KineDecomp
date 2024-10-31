package io.grpc.internal;

import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: ChannelExecutor.java */
@ThreadSafe
/* loaded from: classes3.dex */
public class M {

    /* renamed from: a */
    private static final Logger f27421a = Logger.getLogger(M.class.getName());

    /* renamed from: b */
    private final Object f27422b = new Object();

    /* renamed from: c */
    private final Queue<Runnable> f27423c = new ArrayDeque();

    /* renamed from: d */
    private boolean f27424d;

    public final void a() {
        Runnable poll;
        boolean z = false;
        while (true) {
            synchronized (this.f27422b) {
                if (!z) {
                    if (this.f27424d) {
                        return;
                    }
                    this.f27424d = true;
                    z = true;
                }
                poll = this.f27423c.poll();
                if (poll == null) {
                    this.f27424d = false;
                    return;
                }
            }
            try {
                poll.run();
            } catch (Throwable th) {
                a(th);
            }
        }
    }

    public final M a(Runnable runnable) {
        synchronized (this.f27422b) {
            Queue<Runnable> queue = this.f27423c;
            Preconditions.a(runnable, "runnable is null");
            queue.add(runnable);
        }
        return this;
    }

    public void a(Throwable th) {
        f27421a.log(Level.WARNING, "Runnable threw exception in ChannelExecutor", th);
    }
}
