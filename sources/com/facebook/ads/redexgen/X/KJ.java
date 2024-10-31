package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: assets/audience_network.dex */
public final class KJ implements Executor {
    public static int A03;
    public static byte[] A04;
    public static final Executor A05;
    public static final Executor A06;
    public static final Executor A07;
    public static final Executor A08;
    public static final ExecutorService A09;
    public static final ExecutorService A0A;
    public static final ExecutorService A0B;
    public static final AtomicBoolean A0C;
    public static final AtomicBoolean A0D;

    @Nullable
    public Executor A00;
    public ThreadPoolExecutor A01;
    public final int A02;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.KJ.A04
            int r0 = r2 + r3
            byte[] r2 = java.util.Arrays.copyOfRange(r1, r2, r0)
            r1 = 0
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L19;
                case 4: goto L27;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            byte[] r2 = (byte[]) r2
            int r0 = r2.length
            if (r1 >= r0) goto L17
            r0 = 3
            goto Lc
        L17:
            r0 = 4
            goto Lc
        L19:
            byte[] r2 = (byte[]) r2
            r0 = r2[r1]
            int r0 = r0 - r4
            int r0 = r0 + (-26)
            byte r0 = (byte) r0
            r2[r1] = r0
            int r1 = r1 + 1
            r0 = 2
            goto Lc
        L27:
            byte[] r2 = (byte[]) r2
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KJ.A00(int, int, int):java.lang.String");
    }

    public static void A04() {
        A04 = new byte[]{113, -125, -119, 126, 115, -25, -34, -19, -16, -24, -21, -28, -66, -68, -59, -68, -55, -64, -70, -43, -45, -71, -49, -32, -53, -122, -93, -122, 126, -117, -99, -107, -99, 74, -101, -97, -113, -97, -113, 74, -98, -103, -103, 74, -106, -103, -104, -111, 88};
    }

    static {
        A04();
        A07 = new KJ(A00(5, 7, 127), 0);
        A05 = new KJ(A00(0, 5, 22), 0);
        A06 = new KJ(A00(19, 2, 119), 0);
        A03 = 32;
        A0B = Executors.newSingleThreadExecutor();
        A0A = Executors.newFixedThreadPool(5);
        A0C = new AtomicBoolean();
        A0D = new AtomicBoolean();
        A09 = Executors.newCachedThreadPool(new KH());
        A08 = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    @VisibleForTesting
    public KJ(String str, int i) {
        this.A02 = i;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int KEEP_ALIVE_SECONDS = Math.max(2, Math.min(availableProcessors - 1, 4));
        this.A01 = new ThreadPoolExecutor(KEEP_ALIVE_SECONDS, (availableProcessors * 2) + 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new KI(this, str));
        this.A01.allowCoreThreadTimeOut(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001c, code lost:            return (java.util.concurrent.Executor) r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.concurrent.Executor A01() {
        /*
            r1 = 0
            java.util.concurrent.atomic.AtomicBoolean r0 = com.facebook.ads.redexgen.X.KJ.A0D
            boolean r0 = r0.get()
            if (r0 == 0) goto L16
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L18;
                case 4: goto L12;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            java.util.concurrent.ExecutorService r1 = com.facebook.ads.redexgen.X.KJ.A09
            r0 = 3
            goto La
        L12:
            java.util.concurrent.Executor r1 = com.facebook.ads.redexgen.X.KJ.A08
            r0 = 3
            goto La
        L16:
            r0 = 4
            goto La
        L18:
            java.lang.Object r1 = (java.lang.Object) r1
            java.util.concurrent.Executor r1 = (java.util.concurrent.Executor) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KJ.A01():java.util.concurrent.Executor");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001c, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.concurrent.ExecutorService A02() {
        /*
            r1 = 0
            java.util.concurrent.atomic.AtomicBoolean r0 = com.facebook.ads.redexgen.X.KJ.A0C
            boolean r0 = r0.get()
            if (r0 == 0) goto L16
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L18;
                case 4: goto L12;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            java.util.concurrent.ExecutorService r1 = com.facebook.ads.redexgen.X.KJ.A09
            r0 = 3
            goto La
        L12:
            java.util.concurrent.ExecutorService r1 = com.facebook.ads.redexgen.X.KJ.A0A
            r0 = 3
            goto La
        L16:
            r0 = 4
            goto La
        L18:
            java.util.concurrent.ExecutorService r1 = (java.util.concurrent.ExecutorService) r1
            java.util.concurrent.ExecutorService r1 = (java.util.concurrent.ExecutorService) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KJ.A02():java.util.concurrent.ExecutorService");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001c, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.concurrent.ExecutorService A03() {
        /*
            r1 = 0
            java.util.concurrent.atomic.AtomicBoolean r0 = com.facebook.ads.redexgen.X.KJ.A0C
            boolean r0 = r0.get()
            if (r0 == 0) goto L16
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L18;
                case 4: goto L12;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            java.util.concurrent.ExecutorService r1 = com.facebook.ads.redexgen.X.KJ.A09
            r0 = 3
            goto La
        L12:
            java.util.concurrent.ExecutorService r1 = com.facebook.ads.redexgen.X.KJ.A0B
            r0 = 3
            goto La
        L16:
            r0 = 4
            goto La
        L18:
            java.util.concurrent.ExecutorService r1 = (java.util.concurrent.ExecutorService) r1
            java.util.concurrent.ExecutorService r1 = (java.util.concurrent.ExecutorService) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KJ.A03():java.util.concurrent.ExecutorService");
    }

    public static void A05(Context context) {
        A0C.set(C0413Gc.A1G(context));
        A0D.set(C0413Gc.A1F(context));
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (this.A00 == null && Looper.myLooper() == Looper.getMainLooper()) {
            this.A00 = AsyncTask.THREAD_POOL_EXECUTOR;
        }
        if ((this.A00 instanceof ThreadPoolExecutor) && ((ThreadPoolExecutor) this.A00).getQueue().size() < this.A02) {
            this.A00.execute(runnable);
            return;
        }
        int size = this.A01.getQueue().size();
        synchronized (KJ.class) {
            int i = A03;
            if (size == A03) {
                A03 *= 2;
                C0365Ef sdkContext = C0363Ed.A00();
                if (sdkContext != null) {
                    sdkContext.A06().A5W(A00(12, 7, 61), C0512Kc.A1D, new C0514Ke(A00(28, 21, 16), A00(21, 7, 76) + i));
                }
            }
        }
        this.A01.execute(runnable);
    }
}
