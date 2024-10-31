package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"ViewConstructor"})
/* loaded from: assets/audience_network.dex */
public final class PX extends FrameLayout {
    public static byte[] A0A;
    public static final float A0B;
    public static final RelativeLayout.LayoutParams A0C;
    public Map<String, String> A00;
    public final C2I A01;
    public final C00592e A02;
    public final C0362Ec A03;
    public final InterfaceC0422Gl A04;
    public final C1N A05;
    public final NM A06;
    public final InterfaceC0547Ll A07;
    public final AtomicBoolean A08;
    public final AtomicBoolean A09;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A04(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.PX.A0A
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
            int r0 = r0 + (-63)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.PX.A04(int, int, int):java.lang.String");
    }

    public static void A07() {
        A0A = new byte[]{-3, -21, -24, -27, -4, -17, -21, -3, -29, -1, -19, 9, -2, 22, -2, -1, 9, 2, -34, 1};
    }

    static {
        A07();
        A0B = (int) (4.0f * KE.A01);
        A0C = new RelativeLayout.LayoutParams(-1, -1);
    }

    public PX(C0362Ec c0362Ec, C2I c2i, C00592e c00592e, InterfaceC0422Gl interfaceC0422Gl, InterfaceC0547Ll interfaceC0547Ll, Map<String, String> map) {
        super(c0362Ec);
        this.A08 = new AtomicBoolean(false);
        this.A09 = new AtomicBoolean(false);
        this.A05 = new PV(this);
        this.A03 = c0362Ec;
        this.A01 = c2i;
        this.A02 = c00592e;
        this.A04 = interfaceC0422Gl;
        this.A07 = interfaceC0547Ll;
        this.A00 = map;
        this.A06 = A02();
        addView(this.A06, A0C);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x008b, code lost:            return r4;     */
    @android.annotation.SuppressLint({"AddJavascriptInterface", "ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.facebook.ads.redexgen.X.NM A02() {
        /*
            r13 = this;
            r9 = r13
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r6 = 16
            r3 = 0
            r5 = 1
            com.facebook.ads.redexgen.X.NM r4 = new com.facebook.ads.redexgen.X.NM
            com.facebook.ads.redexgen.X.Ec r2 = r9.A03
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            com.facebook.ads.redexgen.X.1N r0 = r9.A05
            r1.<init>(r0)
            r0 = 10
            r4.<init>(r2, r1, r0)
            float r0 = com.facebook.ads.redexgen.X.PX.A0B
            r4.setCornerRadius(r0)
            r4.setLogMultipleImpressions(r3)
            r4.setCheckAssetsByJavascriptBridge(r3)
            com.facebook.ads.redexgen.X.2e r0 = r9.A02
            int r0 = r0.A08()
            r4.setWebViewTimeoutInMillis(r0)
            com.facebook.ads.redexgen.X.2I r0 = r9.A01
            java.lang.String r0 = r0.A0T()
            r4.setRequestId(r0)
            com.facebook.ads.redexgen.X.PW r1 = new com.facebook.ads.redexgen.X.PW
            r0 = 0
            r1.<init>(r9, r0)
            r4.setOnTouchListener(r1)
            android.webkit.WebSettings r3 = r4.getSettings()
            r3.setLoadWithOverviewMode(r5)
            r3.setUseWideViewPort(r5)
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r6) goto L85
            r0 = 2
        L4e:
            switch(r0) {
                case 2: goto L52;
                case 3: goto L59;
                case 4: goto L61;
                case 5: goto L87;
                default: goto L51;
            }
        L51:
            goto L4e
        L52:
            android.webkit.WebSettings r3 = (android.webkit.WebSettings) r3
            r3.setAllowFileAccessFromFileURLs(r5)
            r0 = 3
            goto L4e
        L59:
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 <= r6) goto L5f
            r0 = 4
            goto L4e
        L5f:
            r0 = 5
            goto L4e
        L61:
            com.facebook.ads.redexgen.X.PX r9 = (com.facebook.ads.redexgen.X.PX) r9
            com.facebook.ads.redexgen.X.NM r4 = (com.facebook.ads.redexgen.X.NM) r4
            com.facebook.ads.redexgen.X.PY r7 = new com.facebook.ads.redexgen.X.PY
            com.facebook.ads.redexgen.X.Ec r8 = r9.A03
            com.facebook.ads.redexgen.X.Gl r10 = r9.A04
            java.util.Map<java.lang.String, java.lang.String> r11 = r9.A00
            com.facebook.ads.redexgen.X.2I r0 = r9.A01
            java.lang.String r12 = r0.A0P()
            r7.<init>(r8, r9, r10, r11, r12)
            r2 = 8
            r1 = 12
            r0 = 94
            java.lang.String r0 = A04(r2, r1, r0)
            r4.addJavascriptInterface(r7, r0)
            r0 = 5
            goto L4e
        L85:
            r0 = 3
            goto L4e
        L87:
            com.facebook.ads.redexgen.X.NM r4 = (com.facebook.ads.redexgen.X.NM) r4
            com.facebook.ads.redexgen.X.NM r4 = (com.facebook.ads.redexgen.X.NM) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.PX.A02():com.facebook.ads.redexgen.X.NM");
    }

    public final void A08() {
        this.A07.A6Q();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0004. Please report as an issue. */
    public final void A09() {
        PX px = this;
        String str = null;
        NM nm = null;
        char c = 2;
        while (true) {
            switch (c) {
                case 2:
                    px = px;
                    nm = px.A06;
                    c = !TextUtils.isEmpty(px.A02.A0B()) ? (char) 7 : (char) 11;
                case 7:
                    try {
                        px = px;
                        str = px.A02.A0B();
                        c = '\n';
                    } catch (Exception e) {
                        C0511Kb.A06(px.A03, A04(0, 8, 71), C0512Kc.A1n, new C0514Ke(e));
                        return;
                    }
                case '\n':
                    nm.loadUrl(str);
                    return;
                case 11:
                    px = px;
                    str = px.A02.A0E();
                    c = '\n';
            }
        }
    }

    public final void A0A() {
        this.A06.removeJavascriptInterface(A04(8, 12, 94));
        this.A06.destroy();
    }

    public K5 getTouchDataRecorder() {
        return this.A06.getTouchDataRecorder();
    }

    @Nullable
    public FP getViewabilityChecker() {
        return this.A06.getViewabilityChecker();
    }
}
