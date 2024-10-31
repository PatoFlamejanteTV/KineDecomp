package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: Timeout.java */
/* loaded from: classes3.dex */
public class B {

    /* renamed from: a */
    public static final B f29225a = new A();

    /* renamed from: b */
    private boolean f29226b;

    /* renamed from: c */
    private long f29227c;

    /* renamed from: d */
    private long f29228d;

    public B a(long j, TimeUnit timeUnit) {
        if (j >= 0) {
            if (timeUnit != null) {
                this.f29228d = timeUnit.toNanos(j);
                return this;
            }
            throw new IllegalArgumentException("unit == null");
        }
        throw new IllegalArgumentException("timeout < 0: " + j);
    }

    public B b() {
        this.f29228d = 0L;
        return this;
    }

    public long c() {
        if (this.f29226b) {
            return this.f29227c;
        }
        throw new IllegalStateException("No deadline");
    }

    public boolean d() {
        return this.f29226b;
    }

    public void e() throws IOException {
        if (!Thread.interrupted()) {
            if (this.f29226b && this.f29227c - System.nanoTime() <= 0) {
                throw new InterruptedIOException("deadline reached");
            }
            return;
        }
        Thread.currentThread().interrupt();
        throw new InterruptedIOException("interrupted");
    }

    public long f() {
        return this.f29228d;
    }

    public B a(long j) {
        this.f29226b = true;
        this.f29227c = j;
        return this;
    }

    public B a() {
        this.f29226b = false;
        return this;
    }
}
