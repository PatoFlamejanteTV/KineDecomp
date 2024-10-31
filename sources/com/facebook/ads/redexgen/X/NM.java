package com.facebook.ads.redexgen.X;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.view.MotionEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: assets/audience_network.dex */
public final class NM extends ND {
    public static byte[] A0D;
    public static final String A0E;
    public float A00;
    public K5 A01;
    public AnonymousClass29 A02;

    @Nullable
    public FP A03;
    public boolean A04;
    public final Path A05;
    public final RectF A06;
    public final C0362Ec A07;
    public final WeakReference<C1N> A08;
    public final AtomicBoolean A09;
    public final AtomicBoolean A0A;
    public final AtomicInteger A0B;
    public final AtomicReference<String> A0C;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.NM.A0D
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
            int r0 = r0 + (-41)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.NM.A02(int, int, int):java.lang.String");
    }

    public static void A05() {
        A0D = new byte[]{114, -107, 116, -96, -97, -91, -93, -96, -99};
    }

    static {
        A05();
        A0E = NM.class.getSimpleName();
    }

    public NM(C0362Ec c0362Ec, WeakReference<C1N> weakReference, int i) {
        super(c0362Ec);
        this.A09 = new AtomicBoolean();
        this.A0A = new AtomicBoolean(true);
        this.A05 = new Path();
        this.A06 = new RectF();
        this.A0B = new AtomicInteger(5000);
        this.A0C = new AtomicReference<>();
        this.A01 = new K5();
        this.A04 = true;
        this.A07 = c0362Ec;
        this.A08 = weakReference;
        this.A02 = new NF(this);
        this.A03 = new FP(this, i, this.A02, this.A07);
        setWebChromeClient(A09());
        setWebViewClient(A0A());
        getSettings().setSupportZoom(false);
        getSettings().setCacheMode(1);
        if (Build.VERSION.SDK_INT > 16) {
            addJavascriptInterface(new NH(this, weakReference.get(), this.A03, this.A09, this.A0A, this.A07), A02(0, 9, 8));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04() {
        this.A07.A08().A8Z();
        this.A09.set(true);
        new Handler(Looper.getMainLooper()).post(new NI(this.A03));
    }

    @VisibleForTesting
    private final boolean A07() {
        return this.A09.get();
    }

    @Override // com.facebook.ads.redexgen.X.ND
    public final WebChromeClient A09() {
        return new NJ();
    }

    @Override // com.facebook.ads.redexgen.X.ND
    public final WebViewClient A0A() {
        return new NL(this.A07, this.A08, new WeakReference(this.A03), new WeakReference(this.A01), new WeakReference(this.A0A), new WeakReference(this), this.A0B, this.A0C);
    }

    public final void A0B(int i, int i2) {
        if (this.A03 != null) {
            this.A03.A0X(i);
            this.A03.A0Y(i2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.ND, android.webkit.WebView
    public final void destroy() {
        if (this.A03 != null) {
            this.A03.A0W();
            this.A03 = null;
        }
        KE.A0L(this);
        this.A02 = null;
        this.A01 = null;
        NN.A03(this);
        super.destroy();
    }

    public K5 getTouchDataRecorder() {
        return this.A01;
    }

    public FP getViewabilityChecker() {
        return this.A03;
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.A00 > 0.0f) {
            this.A06.set(0.0f, 0.0f, getWidth(), getHeight());
            this.A05.reset();
            this.A05.addRoundRect(this.A06, this.A00, this.A00, Path.Direction.CW);
            canvas.clipPath(this.A05);
        }
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        this.A01.A06(motionEvent, this, this);
        return super.onTouchEvent(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0060, code lost:            return;     */
    @Override // android.webkit.WebView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onWindowVisibilityChanged(int r3) {
        /*
            r2 = this;
            r1 = r2
            super.onWindowVisibilityChanged(r3)
            java.lang.ref.WeakReference<com.facebook.ads.redexgen.X.1N> r0 = r1.A08
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L5e
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L3a;
                case 3: goto L30;
                case 4: goto L60;
                case 5: goto L1e;
                case 6: goto L11;
                case 7: goto L43;
                case 8: goto L4c;
                case 9: goto L55;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.NM r1 = (com.facebook.ads.redexgen.X.NM) r1
            boolean r0 = r1.A07()
            if (r0 == 0) goto L1b
            r0 = 7
            goto Ld
        L1b:
            r0 = 8
            goto Ld
        L1e:
            com.facebook.ads.redexgen.X.NM r1 = (com.facebook.ads.redexgen.X.NM) r1
            com.facebook.ads.redexgen.X.Ec r0 = r1.A07
            com.facebook.ads.redexgen.X.0c r0 = r0.A08()
            r0.A8l(r3)
            if (r3 != 0) goto L2d
            r0 = 6
            goto Ld
        L2d:
            r0 = 8
            goto Ld
        L30:
            com.facebook.ads.redexgen.X.NM r1 = (com.facebook.ads.redexgen.X.NM) r1
            com.facebook.ads.redexgen.X.FP r0 = r1.A03
            if (r0 != 0) goto L38
            r0 = 4
            goto Ld
        L38:
            r0 = 5
            goto Ld
        L3a:
            com.facebook.ads.redexgen.X.NM r1 = (com.facebook.ads.redexgen.X.NM) r1
            java.lang.ref.WeakReference<com.facebook.ads.redexgen.X.1N> r0 = r1.A08
            r0.get()
            r0 = 3
            goto Ld
        L43:
            com.facebook.ads.redexgen.X.NM r1 = (com.facebook.ads.redexgen.X.NM) r1
            com.facebook.ads.redexgen.X.FP r0 = r1.A03
            r0.A0V()
            r0 = 4
            goto Ld
        L4c:
            r0 = 8
            if (r3 != r0) goto L53
            r0 = 9
            goto Ld
        L53:
            r0 = 4
            goto Ld
        L55:
            com.facebook.ads.redexgen.X.NM r1 = (com.facebook.ads.redexgen.X.NM) r1
            com.facebook.ads.redexgen.X.FP r0 = r1.A03
            r0.A0W()
            r0 = 4
            goto Ld
        L5e:
            r0 = 3
            goto Ld
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.NM.onWindowVisibilityChanged(int):void");
    }

    public void setCheckAssetsByJavascriptBridge(boolean z) {
        this.A0A.set(z);
    }

    public void setCornerRadius(float f) {
        this.A00 = f;
        invalidate();
    }

    public void setLogMultipleImpressions(boolean z) {
        this.A04 = z;
    }

    public void setRequestId(String str) {
        this.A0C.set(str);
    }

    public void setWebViewTimeoutInMillis(int i) {
        if (i >= 0) {
            this.A0B.set(i);
        }
    }
}
