package io.grpc.internal;

import com.google.common.base.Preconditions;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: LogExceptionRunnable.java */
/* renamed from: io.grpc.internal.tb */
/* loaded from: classes3.dex */
public final class RunnableC2488tb implements Runnable {

    /* renamed from: a */
    private static final Logger f27741a = Logger.getLogger(RunnableC2488tb.class.getName());

    /* renamed from: b */
    private final Runnable f27742b;

    public RunnableC2488tb(Runnable runnable) {
        Preconditions.a(runnable, "task");
        this.f27742b = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f27742b.run();
        } catch (Throwable th) {
            f27741a.log(Level.SEVERE, "Exception while executing runnable " + this.f27742b, th);
            Sb.a(th);
            throw new AssertionError(th);
        }
    }

    public String toString() {
        return "LogExceptionRunnable(" + this.f27742b + ")";
    }
}
