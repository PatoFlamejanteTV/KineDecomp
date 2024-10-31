package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* loaded from: assets/audience_network.dex */
public final class A0 {
    public static byte[] A00;
    public static final AtomicReference<AB> A01;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.A0.A00
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
            int r0 = r0 + (-60)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.A0.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A00 = new byte[]{-45, -25, -42, -37, -41, -32, -43, -41, -47, -32, -41, -26, -23, -31, -28, -35, -96, -42, -41, -22, -17, -19, -10, -19, -6, -15, -21};
    }

    static {
        A01();
        A01 = new AtomicReference<>();
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A02(@Nullable Activity activity, MotionEvent motionEvent) {
        AB ab;
        try {
            if (A7.A0P(activity) && (ab = A01.get()) != null) {
                ab.A05(motionEvent);
            }
        } catch (Throwable t) {
            C0511Kb.A0E(A00(20, 7, 76), C0512Kc.A0u, new C0514Ke(t));
        }
    }

    public static void A03(Context context) {
        if (!(context instanceof Application)) {
            return;
        }
        JJ.A04(new InterfaceC02549y() { // from class: com.facebook.ads.redexgen.X.9z
            /* JADX WARN: Code restructure failed: missing block: B:25:0x003e, code lost:            return;     */
            @Override // com.facebook.ads.redexgen.X.InterfaceC02549y
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void onActivityCreated(android.app.Activity r5, android.os.Bundle r6) {
                /*
                    r4 = this;
                    r3 = r4
                    r2 = 0
                    android.view.Window r0 = r5.getWindow()
                    if (r0 == 0) goto L3c
                    r0 = 2
                L9:
                    switch(r0) {
                        case 2: goto Ld;
                        case 3: goto L19;
                        case 4: goto L1f;
                        case 5: goto L3e;
                        case 6: goto L39;
                        default: goto Lc;
                    }
                Lc:
                    goto L9
                Ld:
                    android.app.Activity r5 = (android.app.Activity) r5
                    android.view.Window r0 = r5.getWindow()
                    android.view.Window$Callback r2 = r0.getCallback()
                    r0 = 3
                    goto L9
                L19:
                    if (r2 == 0) goto L1d
                    r0 = 4
                    goto L9
                L1d:
                    r0 = 5
                    goto L9
                L1f:
                    com.facebook.ads.redexgen.X.9z r3 = (com.facebook.ads.redexgen.X.C02559z) r3
                    android.app.Activity r5 = (android.app.Activity) r5
                    com.facebook.ads.redexgen.X.JG r1 = new com.facebook.ads.redexgen.X.JG
                    r1.<init>(r2, r5)
                    com.facebook.ads.redexgen.X.9x r0 = new com.facebook.ads.redexgen.X.9x
                    r0.<init>()
                    com.facebook.ads.redexgen.X.JG.A00(r0)
                    android.view.Window r0 = r5.getWindow()
                    r0.setCallback(r1)
                    r0 = 5
                    goto L9
                L39:
                    r2 = 0
                    r0 = 3
                    goto L9
                L3c:
                    r0 = 6
                    goto L9
                L3e:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02559z.onActivityCreated(android.app.Activity, android.os.Bundle):void");
            }
        });
    }

    public static void A04(final C0365Ef c0365Ef, @Nullable final String str) {
        KJ.A05.execute(new AbstractRunnableC00351g() { // from class: com.facebook.ads.redexgen.X.9u
            @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
            public final void A05() {
                A0.A07(C0365Ef.this, str);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0051, code lost:            return;     */
    @android.annotation.SuppressLint({"CatchGeneralException"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A05(com.facebook.ads.redexgen.X.C0365Ef r3, final java.lang.String r4) {
        /*
            r2 = 0
            boolean r0 = com.facebook.ads.redexgen.X.A7.A0P(r3)
            if (r0 != 0) goto L4f
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto L51;
                case 3: goto L43;
                case 4: goto L33;
                case 5: goto L1a;
                case 6: goto Lc;
                case 7: goto L23;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            java.util.concurrent.atomic.AtomicReference<com.facebook.ads.redexgen.X.AB> r0 = com.facebook.ads.redexgen.X.A0.A01
            java.lang.Object r2 = r0.get()
            com.facebook.ads.redexgen.X.AB r2 = (com.facebook.ads.redexgen.X.AB) r2
            if (r2 == 0) goto L18
            r0 = 7
            goto L8
        L18:
            r0 = 2
            goto L8
        L1a:
            com.facebook.ads.redexgen.X.Ef r3 = (com.facebook.ads.redexgen.X.C0365Ef) r3
            java.lang.String r4 = (java.lang.String) r4
            A04(r3, r4)
            r0 = 2
            goto L8
        L23:
            java.lang.String r4 = (java.lang.String) r4
            com.facebook.ads.redexgen.X.AB r2 = (com.facebook.ads.redexgen.X.AB) r2
            java.util.concurrent.Executor r1 = com.facebook.ads.redexgen.X.KJ.A05
            com.facebook.ads.redexgen.X.9v r0 = new com.facebook.ads.redexgen.X.9v
            r0.<init>()
            r1.execute(r0)
            r0 = 2
            goto L8
        L33:
            java.lang.String r4 = (java.lang.String) r4
            com.facebook.ads.redexgen.X.Dm r0 = com.facebook.ads.redexgen.X.EJ.A03(r4)
            boolean r0 = com.facebook.ads.redexgen.X.EJ.A0E(r0)
            if (r0 == 0) goto L41
            r0 = 5
            goto L8
        L41:
            r0 = 6
            goto L8
        L43:
            java.util.concurrent.atomic.AtomicReference<com.facebook.ads.redexgen.X.AB> r0 = com.facebook.ads.redexgen.X.A0.A01
            java.lang.Object r0 = r0.get()
            if (r0 != 0) goto L4d
            r0 = 4
            goto L8
        L4d:
            r0 = 6
            goto L8
        L4f:
            r0 = 3
            goto L8
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.A0.A05(com.facebook.ads.redexgen.X.Ef, java.lang.String):void");
    }

    @SuppressLint({"CatchGeneralException"})
    public static synchronized void A07(C0365Ef c0365Ef, @Nullable String str) {
        synchronized (A0.class) {
            try {
                if (A01.get() == null && A7.A0P(c0365Ef)) {
                    A4 a4 = new A4(c0365Ef);
                    A2 a2 = new A2(c0365Ef);
                    AA A0J = new A9().A0I(true).A04(A7.A05(c0365Ef)).A02(A7.A03(c0365Ef)).A03(A7.A04(c0365Ef)).A06(A7.A07(c0365Ef)).A0G(A7.A0M()).A0A(a4).A09(a2.A00()).A00(A7.A01(c0365Ef)).A0C(EnumC0349Dp.A0F).A0F(A7.A0D(c0365Ef)).A0H(A7.A0N(c0365Ef)).A05(A7.A06(c0365Ef)).A0D(Build.class).A01(A7.A02(c0365Ef)).A08(A7.A09(c0365Ef)).A07(A7.A08(c0365Ef)).A0B(a2).A0E(A00(0, 20, 54)).A0J();
                    if (A7.A0Q(c0365Ef)) {
                        A03(c0365Ef.getApplicationContext());
                    }
                    AB ab = new AB(c0365Ef, A0J, A7.A0A(c0365Ef));
                    if (str != null) {
                        ab.A06(str);
                    }
                    A01.set(ab);
                }
            } catch (Throwable th) {
                C0511Kb.A06(c0365Ef, A00(20, 7, 76), C0512Kc.A0u, new C0514Ke(th));
            }
        }
    }
}
