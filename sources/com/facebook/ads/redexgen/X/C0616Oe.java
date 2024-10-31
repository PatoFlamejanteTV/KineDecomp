package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.facebook.ads.internal.api.AudienceNetworkActivityApi;
import com.facebook.ads.internal.view.dynamiclayout.DynamicFullScreenAdView$AdFormatType;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Oe, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0616Oe extends FrameLayout implements InterfaceC0524Ko {
    public static byte[] A0L;

    @Nullable
    public AudienceNetworkActivityApi A00;
    public AnonymousClass86 A01;
    public boolean A02;
    public boolean A03;
    public boolean A04;
    public final C2I A05;
    public final EV A06;
    public final C0362Ec A07;
    public final InterfaceC0422Gl A08;
    public final C0432Gv A09;
    public final ViewOnSystemUiVisibilityChangeListenerC0509Jz A0A;
    public final K5 A0B;
    public final AnonymousClass81 A0C;
    public final MQ A0D;
    public final ND A0E;
    public final OV A0F;
    public final AnonymousClass29 A0G;
    public final FP A0H;
    public final String A0I;
    public final LinkedList<String> A0J;
    public final JSONObject A0K;

    static {
        A0C();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A09(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0616Oe.A0L
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
            r0 = r0 ^ 19
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0616Oe.A09(int, int, int):java.lang.String");
    }

    public static void A0C() {
        A0L = new byte[]{66, 71, 113, 70, 83, 76, 81, 87, 74, 77, 68, 112, 87, 66, 81, 87, 70, 71, 11, 4, 6, 80, 4, 10, 24, 107, 106, 69, 103, 112, 109, 114, 109, 112, 125, 86, 97, 119, 113, 105, 97, 96, 44, 35, 33, 119, 35, 45, 63, 78, 88, 73, Byte.MAX_VALUE, 92, 78, 88, 11, 9, 124, 78, 78, 88, 73, 78, 21, 26, 24, 78, 26, 17, 26, 24, 78, 26, 20, 10, 21, 25, 11, 46, 25, 29, 24, 5, 40, 19, 47, 20, 19, 11, 84, 91, 89, 15, 91, 85, 71, 86, 121, 115, 101, 120, 126, 115, 94, 121, 99, 114, 101, 113, 118, 116, 114, 25, 24, 55, 21, 2, 31, 0, 31, 2, 15, 38, 23, 3, 5, 19, 18, 94, 81, 83, 5, 81, 95, 77, 37, 103, 124, 101, 124, 99, 59, 45, 60, 9, 61, 60, 32, 3, 45, 49, 96, 111, 109, 59, 111, 100, 111, 109, 59, 111, 97, 115, 68, 65, 119, 64, 85, 74, 87, 81, 76, 75, 66, 99, 76, 75, 76, 86, 77, 64, 65, 13, 2, 0, 86, 2, 12, 30};
    }

    public C0616Oe(C0362Ec c0362Ec, InterfaceC0422Gl interfaceC0422Gl, AnonymousClass81 anonymousClass81, C2I c2i, MQ mq, @DynamicFullScreenAdView$AdFormatType int i) {
        super(c0362Ec);
        this.A01 = new OW(this);
        this.A0J = new LinkedList<>();
        this.A0B = new K5();
        this.A0G = new OX(this);
        this.A04 = true;
        this.A03 = false;
        this.A02 = true;
        this.A07 = c0362Ec;
        this.A08 = interfaceC0422Gl;
        this.A0C = anonymousClass81;
        this.A05 = c2i;
        this.A0D = mq;
        this.A0I = UUID.randomUUID().toString();
        this.A06 = new EV(this.A07);
        this.A09 = new C0432Gv(this.A05.A0P(), this.A08);
        this.A0F = new OV(c2i.A0T(), this.A05.A0L().A0D().A07(), i);
        this.A0K = C0620Oi.A01(this.A07, this.A05.A0X(), this.A06, this.A09, this.A0F);
        this.A0E = new C0614Oc(this, this.A07);
        KE.A0I(1003, this.A0E);
        this.A0H = new FP(this.A0E, 1, this.A0G, this.A07);
        this.A0H.A0X(this.A05.A0F());
        this.A0H.A0Y(this.A05.A0G());
        this.A0A = new ViewOnSystemUiVisibilityChangeListenerC0509Jz(this);
        this.A0A.A05(EnumC0508Jy.A02);
    }

    private void A0B() {
        C0633Ov A0B = new C0632Ou(this.A07, this.A05.A0L().A0E(), this.A05.A0N()).A08(this.A05.A0K().A01()).A0B();
        addView(A0B, new FrameLayout.LayoutParams(-1, -1));
        A0B.A04(new OZ(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00e6, code lost:            return;     */
    @android.annotation.SuppressLint({"AddJavascriptInterface"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A0D() {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0616Oe.A0D():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(21)
    public synchronized void A0E() {
        if (this.A03) {
            while (!this.A0J.isEmpty()) {
                this.A09.A02(EnumC0431Gu.A0K, null);
                this.A0E.evaluateJavascript(this.A0J.poll(), null);
            }
        }
    }

    private void A0H(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        new C0587Na(this.A07, this.A0D.A4U(), this.A0H, this.A0B, this.A08, this.A0C).A08(this.A05.A0P(), str, new HashMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void A0I(String str) {
        this.A0J.offer(str);
        A0E();
    }

    public final void A0L() {
        if (this.A00 == null) {
            return;
        }
        this.A00.finish();
    }

    public final void A0M() {
        this.A04 = true;
    }

    public final void A0N() {
        this.A04 = false;
    }

    public final void A0O() {
        A0H(this.A05.A0L().A0F().A04());
    }

    public final void A0P() {
        this.A0C.A3b(this.A0D.A4D());
        new C0647Pj(this.A07, this.A0D, this.A05.A0U(), this.A0C).A05();
    }

    public final void A0Q() {
        new Handler(Looper.getMainLooper()).post(new OY(this));
    }

    public final void A0R() {
        this.A0H.A0V();
    }

    public final void A0S(String str) {
        A0H(str);
    }

    public final void A0T(Map<String, String> map) {
        this.A08.A5V(this.A05.A0P(), new NS(map).A03(this.A0H).A05());
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005e, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A5L(android.content.Intent r7, @android.support.annotation.Nullable android.os.Bundle r8, com.facebook.ads.redexgen.X.AnonymousClass89 r9) {
        /*
            r6 = this;
            r5 = r6
            com.facebook.ads.redexgen.X.86 r0 = r5.A01
            r9.A0J(r0)
            r5.A00 = r9
            r5.A0D()
            com.facebook.ads.redexgen.X.2I r0 = r5.A05
            com.facebook.ads.redexgen.X.2L r0 = r0.A0L()
            boolean r0 = r0.A0O()
            if (r0 == 0) goto L5c
            r0 = 2
        L18:
            switch(r0) {
                case 2: goto L1c;
                case 3: goto L5e;
                case 4: goto L23;
                case 5: goto L3d;
                default: goto L1b;
            }
        L1b:
            goto L18
        L1c:
            com.facebook.ads.redexgen.X.Oe r5 = (com.facebook.ads.redexgen.X.C0616Oe) r5
            r5.A0B()
            r0 = 3
            goto L18
        L23:
            com.facebook.ads.redexgen.X.Oe r5 = (com.facebook.ads.redexgen.X.C0616Oe) r5
            com.facebook.ads.redexgen.X.2I r0 = r5.A05
            com.facebook.ads.redexgen.X.2L r0 = r0.A0L()
            com.facebook.ads.redexgen.X.2O r0 = r0.A0D()
            java.lang.String r0 = r0.A07()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L3b
            r0 = 5
            goto L18
        L3b:
            r0 = 3
            goto L18
        L3d:
            com.facebook.ads.redexgen.X.Oe r5 = (com.facebook.ads.redexgen.X.C0616Oe) r5
            java.util.Locale r4 = java.util.Locale.US
            r2 = 75
            r1 = 22
            r0 = 111(0x6f, float:1.56E-43)
            java.lang.String r3 = A09(r2, r1, r0)
            r0 = 1
            java.lang.Object[] r2 = new java.lang.Object[r0]
            r1 = 0
            java.lang.String r0 = r5.A0I
            r2[r1] = r0
            java.lang.String r0 = java.lang.String.format(r4, r3, r2)
            r5.A0I(r0)
            r0 = 3
            goto L18
        L5c:
            r0 = 4
            goto L18
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0616Oe.A5L(android.content.Intent, android.os.Bundle, com.facebook.ads.redexgen.X.89):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0049, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A7F(boolean r8) {
        /*
            r7 = this;
            r6 = r7
            r0 = 0
            r0 = 0
            r5 = 1
            r0 = 0
            if (r8 == 0) goto L47
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L49;
                case 4: goto L29;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.Oe r6 = (com.facebook.ads.redexgen.X.C0616Oe) r6
            r4 = 0
            java.util.Locale r3 = java.util.Locale.US
            r2 = 0
            r1 = 25
            r0 = 48
            java.lang.String r2 = A09(r2, r1, r0)
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.String r0 = r6.A0I
            r1[r4] = r0
            java.lang.String r0 = java.lang.String.format(r3, r2, r1)
            r6.A0I(r0)
            r0 = 3
            goto L8
        L29:
            com.facebook.ads.redexgen.X.Oe r6 = (com.facebook.ads.redexgen.X.C0616Oe) r6
            r4 = 0
            java.util.Locale r3 = java.util.Locale.US
            r2 = 113(0x71, float:1.58E-43)
            r1 = 23
            r0 = 101(0x65, float:1.42E-43)
            java.lang.String r2 = A09(r2, r1, r0)
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.String r0 = r6.A0I
            r1[r4] = r0
            java.lang.String r0 = java.lang.String.format(r3, r2, r1)
            r6.A0I(r0)
            r0 = 3
            goto L8
        L47:
            r0 = 4
            goto L8
        L49:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0616Oe.A7F(boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0059, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A7O(boolean r8) {
        /*
            r7 = this;
            r6 = r7
            r0 = 0
            r0 = 0
            r5 = 1
            r0 = 0
            boolean r0 = r6.A02
            if (r0 == 0) goto L57
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L59;
                case 4: goto L15;
                case 5: goto L1b;
                case 6: goto L39;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.Oe r6 = (com.facebook.ads.redexgen.X.C0616Oe) r6
            r0 = 0
            r6.A02 = r0
            r0 = 3
            goto La
        L15:
            if (r8 == 0) goto L19
            r0 = 5
            goto La
        L19:
            r0 = 6
            goto La
        L1b:
            com.facebook.ads.redexgen.X.Oe r6 = (com.facebook.ads.redexgen.X.C0616Oe) r6
            r4 = 0
            java.util.Locale r3 = java.util.Locale.US
            r2 = 164(0xa4, float:2.3E-43)
            r1 = 26
            r0 = 54
            java.lang.String r2 = A09(r2, r1, r0)
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.String r0 = r6.A0I
            r1[r4] = r0
            java.lang.String r0 = java.lang.String.format(r3, r2, r1)
            r6.A0I(r0)
            r0 = 3
            goto La
        L39:
            com.facebook.ads.redexgen.X.Oe r6 = (com.facebook.ads.redexgen.X.C0616Oe) r6
            r4 = 0
            java.util.Locale r3 = java.util.Locale.US
            r2 = 25
            r1 = 24
            r0 = 23
            java.lang.String r2 = A09(r2, r1, r0)
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.String r0 = r6.A0I
            r1[r4] = r0
            java.lang.String r0 = java.lang.String.format(r3, r2, r1)
            r6.A0I(r0)
            r0 = 3
            goto La
        L57:
            r0 = 4
            goto La
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0616Oe.A7O(boolean):void");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    public final void A8E(Bundle bundle) {
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    public final void onDestroy() {
        this.A0A.A03();
        this.A08.A5U(this.A05.A0P(), new NS().A02(this.A0B).A03(this.A0H).A05());
        this.A01 = null;
        this.A00 = null;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(motionEvent);
    }

    public void setListener(AnonymousClass81 anonymousClass81) {
    }
}
