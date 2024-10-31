package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;

/* renamed from: com.facebook.ads.redexgen.X.Jh, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0492Jh extends Thread implements Closeable {
    public boolean A00 = false;
    public final /* synthetic */ C0493Ji A01;

    public C0492Jh(C0493Ji c0493Ji) {
        this.A01 = c0493Ji;
        start();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        C0491Jg c0491Jg;
        synchronized (this) {
            this.A00 = true;
            c0491Jg = this.A01.A02;
            c0491Jg.A02();
        }
        try {
            join();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    @SuppressLint({"CatchGeneralException"})
    public final void run() {
        C0491Jg c0491Jg;
        C0491Jg c0491Jg2;
        C0491Jg c0491Jg3;
        boolean z;
        C0491Jg c0491Jg4;
        boolean runNow;
        C0491Jg c0491Jg5;
        Runnable runnable;
        if (C0466Ig.A02(this)) {
            return;
        }
        while (true) {
            try {
                try {
                    try {
                        c0491Jg3 = this.A01.A02;
                        c0491Jg3.A04();
                        synchronized (this.A01) {
                            synchronized (this) {
                                z = this.A00;
                                c0491Jg4 = this.A01.A02;
                                runNow = c0491Jg4.A05();
                            }
                        }
                        if (z) {
                            break;
                        }
                        if (runNow) {
                            runnable = this.A01.A03;
                            runnable.run();
                            break;
                        }
                    } catch (Throwable th) {
                        synchronized (this.A01) {
                            c0491Jg = this.A01.A02;
                            c0491Jg.A03();
                            this.A01.A00 = null;
                            throw th;
                        }
                    }
                } catch (Exception unused) {
                    synchronized (this.A01) {
                        c0491Jg2 = this.A01.A02;
                        c0491Jg2.A03();
                        this.A01.A00 = null;
                        return;
                    }
                }
            } catch (Throwable th2) {
                C0466Ig.A00(th2, this);
                return;
            }
        }
        synchronized (this.A01) {
            c0491Jg5 = this.A01.A02;
            c0491Jg5.A03();
            this.A01.A00 = null;
        }
    }
}
