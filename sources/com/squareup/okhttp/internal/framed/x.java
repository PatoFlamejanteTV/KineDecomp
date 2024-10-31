package com.squareup.okhttp.internal.framed;

import java.util.concurrent.CountDownLatch;

/* compiled from: Ping.java */
/* loaded from: classes3.dex */
public final class x {

    /* renamed from: a */
    private final CountDownLatch f25407a = new CountDownLatch(1);

    /* renamed from: b */
    private long f25408b = -1;

    /* renamed from: c */
    private long f25409c = -1;

    x() {
    }

    public void a() {
        if (this.f25409c == -1) {
            long j = this.f25408b;
            if (j != -1) {
                this.f25409c = j - 1;
                this.f25407a.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }

    public void b() {
        if (this.f25409c == -1 && this.f25408b != -1) {
            this.f25409c = System.nanoTime();
            this.f25407a.countDown();
            return;
        }
        throw new IllegalStateException();
    }

    public void c() {
        if (this.f25408b == -1) {
            this.f25408b = System.nanoTime();
            return;
        }
        throw new IllegalStateException();
    }
}
