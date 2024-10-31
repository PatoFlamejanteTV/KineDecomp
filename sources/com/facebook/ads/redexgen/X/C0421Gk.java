package com.facebook.ads.redexgen.X;

import android.net.ConnectivityManager;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.facebook.ads.redexgen.X.Gk, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0421Gk implements InterfaceC0418Gh {
    public static byte[] A0E;
    public static final String A0F;
    public int A00;
    public long A01;

    @Nullable
    public C0483Iy A02;

    @Nullable
    public FM A03;
    public final long A04;
    public final long A05;
    public final ConnectivityManager A06;
    public final Handler A07;
    public final C0365Ef A08;
    public final InterfaceC0417Gg A09;
    public volatile boolean A0D;
    public final Runnable A0B = new C0419Gi(this);
    public final Runnable A0A = new C0420Gj(this);
    public final ThreadPoolExecutor A0C = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A03(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0421Gk.A0E
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
            int r0 = r0 + (-76)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0421Gk.A03(int, int, int):java.lang.String");
    }

    public static void A07() {
        A0E = new byte[]{-69, -18, -39, -37, -26, -22, -33, -27, -28, -106, -19, -34, -33, -30, -37, -106, -38, -33, -23, -26, -41, -22, -39, -34, -33, -28, -35, -106, -37, -20, -37, -28, -22, -23, -92, -56, -38, -25, -21, -38, -25, -107, -25, -38, -23, -22, -25, -29, -38, -39, -107, -42, -107, -29, -28, -29, -94, -24, -22, -40, -40, -38, -24, -24, -37, -22, -31, -107, -24, -23, -42, -23, -22, -24, -107, -40, -28, -39, -38, -107, -28, -37, -107, -49, -31, -18, -14, -31, -18, -100, -13, -35, -17, -100, -15, -22, -35, -34, -24, -31, -100, -16, -21, -100, -20, -18, -21, -33, -31, -17, -17, -100, -35, -24, -24, -100, -31, -14, -31, -22, -16, -17, -88, -100, -16, -18, -11, -27, -22, -29, -100, -35, -29, -35, -27, -22, -86, -15, 9, 7, 14, 14, 7, 12, 5, -66, 2, 7, 17, 14, -1, 18, 1, 6, -66, 2, 19, 3, -66, 18, 13, -66, 10, -1, 1, 9, -66, 13, 4, -66, 1, 13, 12, 12, 3, 1, 18, 7, 20, 7, 18, 23, -52, 30, 47, 30, 39, 45, 44, -13, 5, 18, 22, 5, 18, -64, 18, 5, 19, 16, 15, 14, 19, 5, -64, 9, 19, -64, 5, 13, 16, 20, 25, -50, -66, -49, -75, -48, -34, -15, -15, -30, -22, -19, -15, -64, -27, -17, -20, -35, -16, -33, -28, -27, -22, -29, -100, -31, -14, -31, -22, -16, -100, -92, -12, 0, -1, -1, -10, -12, 5, -6, 7, -6, 5, 10, 17, 35, 48, 52, 35, 48, -34, 46, 48, 45, 33, 35, 49, 49, 35, 34, -34, 46, 31, 48, 50, 39, 31, 42, -34, 32, 31, 50, 33, 38, -22, -34, 33, 45, 44, 50, 39, 44, 51, 39, 44, 37, -34, 50, 45, -34, 44, 35, 54, 50, -34, 45, 44, 35, -20, -62, -77, -53, -66, -63, -77, -74, 40, 37, 56, 37};
    }

    static {
        A07();
        A0F = InterfaceC0418Gh.class.getSimpleName();
    }

    public C0421Gk(C0365Ef c0365Ef, InterfaceC0417Gg interfaceC0417Gg) {
        this.A09 = interfaceC0417Gg;
        this.A08 = c0365Ef;
        this.A06 = (ConnectivityManager) c0365Ef.getSystemService(A03(244, 12, 69));
        if (C0413Gc.A0h(c0365Ef)) {
            this.A03 = C7A.A05(c0365Ef);
        } else {
            this.A02 = C7A.A01(c0365Ef);
        }
        this.A07 = new Handler(Looper.getMainLooper());
        this.A05 = C0414Gd.A0J(c0365Ef);
        this.A04 = C0414Gd.A0I(c0365Ef);
    }

    public static /* synthetic */ int A00(C0421Gk c0421Gk) {
        int i = c0421Gk.A00 + 1;
        c0421Gk.A00 = i;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A05() {
        /*
            r3 = this;
            r2 = r3
            boolean r0 = com.facebook.ads.internal.api.BuildConfigApi.isDebug()
            if (r0 == 0) goto L2e
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L25;
                case 4: goto L30;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.Gk r2 = (com.facebook.ads.redexgen.X.C0421Gk) r2
            r0 = 0
            r2.A00 = r0
            r0 = 0
            r2.A01 = r0
            java.util.concurrent.ThreadPoolExecutor r0 = r2.A0C
            java.util.concurrent.BlockingQueue r0 = r0.getQueue()
            int r0 = r0.size()
            if (r0 != 0) goto L23
            r0 = 3
            goto L8
        L23:
            r0 = 4
            goto L8
        L25:
            com.facebook.ads.redexgen.X.Gk r2 = (com.facebook.ads.redexgen.X.C0421Gk) r2
            com.facebook.ads.redexgen.X.Gg r0 = r2.A09
            r0.A69()
            r0 = 4
            goto L8
        L2e:
            r0 = 2
            goto L8
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0421Gk.A05():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0045, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A06() {
        /*
            r5 = this;
            r4 = r5
            int r1 = r4.A00
            com.facebook.ads.redexgen.X.Ef r0 = r4.A08
            int r0 = com.facebook.ads.redexgen.X.C0414Gd.A09(r0)
            if (r1 < r0) goto L43
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L2e;
                case 3: goto L45;
                case 4: goto L17;
                case 5: goto L22;
                case 6: goto L10;
                case 7: goto L38;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            com.facebook.ads.redexgen.X.Gk r4 = (com.facebook.ads.redexgen.X.C0421Gk) r4
            r4.A40()
            r0 = 3
            goto Lc
        L17:
            com.facebook.ads.redexgen.X.Gk r4 = (com.facebook.ads.redexgen.X.C0421Gk) r4
            int r1 = r4.A00
            r0 = 1
            if (r1 != r0) goto L20
            r0 = 5
            goto Lc
        L20:
            r0 = 7
            goto Lc
        L22:
            com.facebook.ads.redexgen.X.Gk r4 = (com.facebook.ads.redexgen.X.C0421Gk) r4
            com.facebook.ads.redexgen.X.Ef r0 = r4.A08
            long r0 = com.facebook.ads.redexgen.X.C0414Gd.A0H(r0)
            r4.A01 = r0
            r0 = 6
            goto Lc
        L2e:
            com.facebook.ads.redexgen.X.Gk r4 = (com.facebook.ads.redexgen.X.C0421Gk) r4
            r4.A05()
            r4.A3z()
            r0 = 3
            goto Lc
        L38:
            com.facebook.ads.redexgen.X.Gk r4 = (com.facebook.ads.redexgen.X.C0421Gk) r4
            long r2 = r4.A01
            r0 = 2
            long r2 = r2 * r0
            r4.A01 = r2
            r0 = 6
            goto Lc
        L43:
            r0 = 4
            goto Lc
        L45:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0421Gk.A06():void");
    }

    private void A08(long j) {
        this.A07.postDelayed(this.A0A, j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A09(org.json.JSONObject r4) throws org.json.JSONException {
        /*
            r3 = this;
            r0 = 0
            com.facebook.ads.redexgen.X.Ef r0 = r3.A08
            com.facebook.ads.redexgen.X.Ei r0 = r0.A02()
            java.util.Map r0 = r0.A3p()
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r2 = r0.iterator()
            r0 = 2
        L14:
            switch(r0) {
                case 2: goto L18;
                case 3: goto L24;
                case 4: goto L3d;
                default: goto L17;
            }
        L17:
            goto L14
        L18:
            java.util.Iterator r2 = (java.util.Iterator) r2
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L22
            r0 = 3
            goto L14
        L22:
            r0 = 4
            goto L14
        L24:
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r0 = r2.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.getValue()
            r4.put(r1, r0)
            r0 = 2
            goto L14
        L3d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0421Gk.A09(org.json.JSONObject):void");
    }

    /* JADX WARN: Incorrect condition in loop: B:17:0x0066 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0B() {
        /*
            Method dump skipped, instructions count: 574
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0421Gk.A0B():void");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0418Gh
    public final void A3z() {
        if (this.A0D) {
            return;
        }
        this.A0D = true;
        this.A07.removeCallbacks(this.A0A);
        A08(this.A04);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0418Gh
    public final void A40() {
        this.A0D = true;
        this.A07.removeCallbacks(this.A0A);
        A08(this.A05);
    }
}
