package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: assets/audience_network.dex */
public final class EE {
    public int A00;
    public final Context A01;
    public final AA A02;
    public final EB A03;
    public final EC A04;
    public final Set<C0343Dj> A05 = new HashSet();

    public EE(Context context, AA aa) {
        this.A02 = aa;
        this.A01 = context;
        this.A04 = aa.A0c();
        this.A03 = aa.A0b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x003a, code lost:            return r2;     */
    @javax.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.facebook.ads.redexgen.X.E7 A00() {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r2 = 0
            com.facebook.ads.redexgen.X.AA r0 = r4.A02
            com.facebook.ads.redexgen.X.Dp r1 = r0.A0a()
            com.facebook.ads.redexgen.X.Dp r0 = com.facebook.ads.redexgen.X.EnumC0349Dp.A0F
            if (r1 != r0) goto L36
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L33;
                case 3: goto L38;
                case 4: goto L29;
                case 5: goto L1b;
                case 6: goto L12;
                case 7: goto L1f;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            java.lang.String r3 = (java.lang.String) r3
            com.facebook.ads.redexgen.X.E7 r2 = new com.facebook.ads.redexgen.X.E7
            r2.<init>(r3)
            r0 = 3
            goto Le
        L1b:
            java.lang.String r3 = ""
            r0 = 6
            goto Le
        L1f:
            com.facebook.ads.redexgen.X.EE r4 = (com.facebook.ads.redexgen.X.EE) r4
            android.content.Context r0 = r4.A01
            java.lang.String r3 = r0.getPackageName()
            r0 = 6
            goto Le
        L29:
            com.facebook.ads.redexgen.X.EE r4 = (com.facebook.ads.redexgen.X.EE) r4
            android.content.Context r0 = r4.A01
            if (r0 != 0) goto L31
            r0 = 5
            goto Le
        L31:
            r0 = 7
            goto Le
        L33:
            r2 = 0
            r0 = 3
            goto Le
        L36:
            r0 = 4
            goto Le
        L38:
            com.facebook.ads.redexgen.X.E7 r2 = (com.facebook.ads.redexgen.X.E7) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EE.A00():com.facebook.ads.redexgen.X.E7");
    }

    @SuppressLint({"CatchGeneralException"})
    private void A01(long j) {
        AbstractC0351Dr A04;
        try {
            JSONObject jSONObject = new JSONObject();
            for (C0343Dj c0343Dj : this.A05) {
                InterfaceC0267Al A01 = c0343Dj.A01();
                if (A01 == null) {
                    A04 = new C0354Du(SystemClock.elapsedRealtime(), A00(), new E6(E5.A03));
                } else {
                    try {
                        A04 = A01.A44();
                    } catch (Throwable th) {
                        A04 = EJ.A04(this.A01.getPackageName(), th);
                    }
                }
                jSONObject.put(Integer.toString(c0343Dj.A00()), A04.A09(false));
            }
            EJ.A05();
        } catch (Throwable t) {
            AK.A03(t);
        }
    }

    @SuppressLint({"CatchGeneralException"})
    private void A02(long j) {
        try {
            this.A02.A0j().schedule(new ED(this), j, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            AK.A03(th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005c, code lost:            return;     */
    @android.annotation.SuppressLint({"BadMethodUse-java.lang.System.currentTimeMillis"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A03() {
        /*
            r9 = this;
            r6 = r9
            r2 = 0
            com.facebook.ads.redexgen.X.AA r0 = r6.A02
            long r7 = r0.A0W()
            r4 = 0
            int r0 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r0 > 0) goto L5a
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L5c;
                case 3: goto L14;
                case 4: goto L30;
                case 5: goto L40;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            com.facebook.ads.redexgen.X.EE r6 = (com.facebook.ads.redexgen.X.EE) r6
            long r2 = java.lang.System.currentTimeMillis()
            com.facebook.ads.redexgen.X.EC r0 = r6.A04
            long r0 = r0.getLastPeriodicCollectionTimeMs()
            long r7 = r2 - r0
            com.facebook.ads.redexgen.X.AA r0 = r6.A02
            long r4 = r0.A0W()
            int r0 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r0 < 0) goto L2e
            r0 = 4
            goto L10
        L2e:
            r0 = 5
            goto L10
        L30:
            com.facebook.ads.redexgen.X.EE r6 = (com.facebook.ads.redexgen.X.EE) r6
            r6.A01(r2)
            com.facebook.ads.redexgen.X.AA r0 = r6.A02
            long r0 = r0.A0W()
            r6.A02(r0)
            r0 = 2
            goto L10
        L40:
            com.facebook.ads.redexgen.X.EE r6 = (com.facebook.ads.redexgen.X.EE) r6
            com.facebook.ads.redexgen.X.EC r0 = r6.A04
            long r4 = r0.getLastPeriodicCollectionTimeMs()
            com.facebook.ads.redexgen.X.AA r0 = r6.A02
            long r0 = r0.A0W()
            long r4 = r4 + r0
            long r0 = r2 - r4
            long r0 = java.lang.Math.abs(r0)
            r6.A02(r0)
            r0 = 2
            goto L10
        L5a:
            r0 = 3
            goto L10
        L5c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EE.A03():void");
    }

    public final void A04(int i) {
        this.A00 = i;
    }

    public final void A05(C0343Dj c0343Dj) {
        this.A05.add(c0343Dj);
    }
}
