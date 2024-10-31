package com.facebook.ads.redexgen.X;

import android.support.annotation.VisibleForTesting;

/* renamed from: com.facebook.ads.redexgen.X.4y, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C4y {

    @VisibleForTesting
    public static boolean A02 = false;
    public long A00 = 0;
    public final C2K A01;

    public C4y(C2K c2k) {
        this.A01 = c2k;
        new Thread(new Runnable() { // from class: com.facebook.ads.redexgen.X.4z
            @Override // java.lang.Runnable
            public final void run() {
                if (!C0466Ig.A02(this)) {
                    try {
                        C4y.this.A00();
                    } catch (Throwable th) {
                        C0466Ig.A00(th, this);
                    }
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A00() {
        while (true) {
            synchronized (this) {
                if (this.A00 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                } else {
                    long nanoTime = System.nanoTime();
                    if (nanoTime < this.A00) {
                        int i = (int) ((this.A00 - nanoTime) / 1000000);
                        if (i >= 1) {
                            try {
                                wait(i);
                            } catch (InterruptedException unused2) {
                            }
                        }
                    }
                    this.A00 = 0L;
                    this.A01.A08();
                    long nanoTime2 = System.nanoTime();
                    synchronized (this) {
                        if (this.A00 < nanoTime2) {
                            this.A00 = 0L;
                        }
                    }
                }
            }
        }
    }

    public final synchronized void A02() {
        this.A00 = System.nanoTime();
        notifyAll();
    }

    public final synchronized void A03(int i) {
        long nanoTime = System.nanoTime() + (1000000 * i * (A02 ? 1 : 1000));
        if (this.A00 == 0 || this.A00 > nanoTime) {
            this.A00 = nanoTime;
            notifyAll();
        }
    }
}
