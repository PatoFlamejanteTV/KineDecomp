package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.support.annotation.Nullable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

@SuppressLint({"CatchGeneralException"})
/* renamed from: com.facebook.ads.redexgen.X.1g, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractRunnableC00351g implements Runnable {
    public static byte[] A01;
    public static final AtomicBoolean A02;
    public static final AtomicBoolean A03;
    public static final AtomicReference<InterfaceC0408Fx> A04;

    @Nullable
    public final C0463Id A00;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.AbstractRunnableC00351g.A01
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
            r0 = r0 ^ r4
            r0 = r0 ^ 21
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractRunnableC00351g.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{94, 121, 98, 98, 109, 110, 96, 105, 44, 111, 126, 105, 109, 120, 105, 104, 34, 44, 88, 100, 126, 105, 109, 104, 54, 44};
    }

    public abstract void A05();

    static {
        A01();
        A02 = new AtomicBoolean();
        A03 = new AtomicBoolean(false);
        A04 = new AtomicReference<>();
    }

    public AbstractRunnableC00351g() {
        if (A03.get()) {
            this.A00 = C0477Is.A01(new C0476Ir(A00(0, 26, 25) + Thread.currentThread().getName()));
        } else {
            this.A00 = null;
        }
    }

    public static void A02(boolean z) {
        A03.set(z);
    }

    public static void A03(boolean z, InterfaceC0408Fx interfaceC0408Fx) {
        A02.set(z);
        A04.set(interfaceC0408Fx);
    }

    @Nullable
    public final C0463Id A04() {
        return this.A00;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:19:0x001b. Please report as an issue. */
    @Override // java.lang.Runnable
    public final void run() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            if (A03.get()) {
                C0477Is.A03(this);
            }
            try {
                A05();
            } catch (Throwable th) {
                char c = '\t';
                while (true) {
                    switch (c) {
                        case '\t':
                            c = A02.get() ? '\f' : (char) 23;
                        case '\f':
                            C0479Iu.A00().A5N(3301, th);
                            InterfaceC0408Fx interfaceC0408Fx = A04.get();
                            if (interfaceC0408Fx != null) {
                                interfaceC0408Fx.A88(th, this);
                                break;
                            }
                            break;
                        case 23:
                            throw th;
                    }
                }
            }
            if (!A03.get()) {
                return;
            }
            C0477Is.A04(this);
        } catch (Throwable t) {
            C0466Ig.A00(t, this);
        }
    }
}
