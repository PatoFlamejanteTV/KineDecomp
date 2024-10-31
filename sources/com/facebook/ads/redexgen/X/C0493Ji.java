package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;

/* renamed from: com.facebook.ads.redexgen.X.Ji, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0493Ji implements Closeable {

    @Nullable
    public C0492Jh A00;
    public boolean A01;
    public final C0491Jg A02;
    public final Runnable A03;

    public C0493Ji(long j, Runnable runnable) {
        this.A02 = new C0491Jg(j);
        this.A02.A02();
        this.A03 = runnable;
        this.A01 = false;
    }

    private final synchronized void A03() {
        if (this.A00 == null && !this.A01) {
            this.A00 = new C0492Jh(this);
        }
    }

    public final C0491Jg A04() {
        return this.A02;
    }

    public final synchronized void A05() {
        if (this.A02.A05() && !this.A01) {
            A03();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        C0492Jh c0492Jh;
        synchronized (this) {
            this.A01 = true;
            c0492Jh = this.A00;
        }
        if (c0492Jh != null) {
            c0492Jh.close();
        }
    }
}
