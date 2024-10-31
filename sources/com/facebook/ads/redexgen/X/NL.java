package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: assets/audience_network.dex */
public class NL extends WebViewClient {
    public static byte[] A0A;
    public Date A00;
    public boolean A01 = false;
    public final C0362Ec A02;
    public final WeakReference<NM> A03;
    public final WeakReference<C1N> A04;
    public final WeakReference<AtomicBoolean> A05;
    public final WeakReference<K5> A06;
    public final WeakReference<FP> A07;
    public final AtomicInteger A08;
    public final AtomicReference<String> A09;

    static {
        A01();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.NL.A0A
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
            r0 = r0 ^ 123(0x7b, float:1.72E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.NL.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A0A = new byte[]{67, 126, 114, 116, 103, 38, 98, 103, 114, 103, 60, 38, 110, 116, 88, 112, 98, 101, 88, 117, 98, 116, 104, 114, 117, 100, 98, 88, 98, 117, 117, 104, 117, 86, 65, 65, 92, 65, 108, 80, 92, 87, 86, 22, 1, 21, 17, 1, 23, 16, 59, 13, 0, 46, 45, 35, 38, 43, 44, 37, 29, 54, 43, 47, 39, 29, 43, 44, 29, 47, 43, 46, 46, 43, 49, 49, 35, 36, 25, 48, 47, 35, 49, 2, 21, 21, 8, 21, 56, 3, 2, 20, 4, 21, 14, 23, 19, 14, 8, 9, 55, 60, 45, 99, 99, 28, 11, 11, 6, 28, 20, 9, 13, 0, 6, 11, 28, 10, 9, 22, 23, 10, 28};
    }

    public NL(C0362Ec c0362Ec, WeakReference<C1N> weakReference, WeakReference<FP> weakReference2, WeakReference<K5> weakReference3, WeakReference<AtomicBoolean> weakReference4, WeakReference<NM> weakReference5, AtomicInteger atomicInteger, AtomicReference<String> atomicReference) {
        this.A02 = c0362Ec;
        this.A04 = weakReference;
        this.A07 = weakReference2;
        this.A06 = weakReference3;
        this.A05 = weakReference4;
        this.A03 = weakReference5;
        this.A08 = atomicInteger;
        this.A09 = atomicReference;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:            r8.put(A00(33, 10, 72), r11);        r8.put(A00(83, 17, 28), r12);        r8.put(A00(12, 21, 124), r3);        r8.put(A00(53, 22, 57), r13);        r8.put(A00(43, 10, 31), r10.A09.get());     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A02(int r11, java.lang.CharSequence r12, long r13) {
        /*
            r10 = this;
            r0 = 0
            r0 = 0
            r3 = 0
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            if (r12 == 0) goto L15
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto L12;
                case 3: goto Lf;
                case 4: goto L17;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            r3 = 0
            r0 = 4
            goto Lb
        L12:
            r3 = 1
            r0 = 4
            goto Lb
        L15:
            r0 = 3
            goto Lb
        L17:
            r2 = 33
            r1 = 10
            r0 = 72
            java.lang.String r0 = A00(r2, r1, r0)     // Catch: org.json.JSONException -> L5e
            r8.put(r0, r11)     // Catch: org.json.JSONException -> L5e
            r2 = 83
            r1 = 17
            r0 = 28
            java.lang.String r0 = A00(r2, r1, r0)     // Catch: org.json.JSONException -> L5e
            r8.put(r0, r12)     // Catch: org.json.JSONException -> L5e
            r2 = 12
            r1 = 21
            r0 = 124(0x7c, float:1.74E-43)
            java.lang.String r0 = A00(r2, r1, r0)     // Catch: org.json.JSONException -> L5e
            r8.put(r0, r3)     // Catch: org.json.JSONException -> L5e
            r2 = 53
            r1 = 22
            r0 = 57
            java.lang.String r0 = A00(r2, r1, r0)     // Catch: org.json.JSONException -> L5e
            r8.put(r0, r13)     // Catch: org.json.JSONException -> L5e
            r2 = 43
            r1 = 10
            r0 = 31
            java.lang.String r1 = A00(r2, r1, r0)     // Catch: org.json.JSONException -> L5e
            java.util.concurrent.atomic.AtomicReference<java.lang.String> r0 = r10.A09     // Catch: org.json.JSONException -> L5e
            java.lang.Object r0 = r0.get()     // Catch: org.json.JSONException -> L5e
            r8.put(r1, r0)     // Catch: org.json.JSONException -> L5e
        L5e:
            com.facebook.ads.redexgen.X.Ec r9 = r10.A02
            r2 = 75
            r1 = 8
            r0 = 61
            java.lang.String r7 = A00(r2, r1, r0)
            int r6 = com.facebook.ads.redexgen.X.C0512Kc.A1n
            com.facebook.ads.redexgen.X.Ke r5 = new com.facebook.ads.redexgen.X.Ke
            com.facebook.ads.internal.protocol.AdErrorType r0 = com.facebook.ads.internal.protocol.AdErrorType.WEB_VIEW_FAILED_TO_LOAD
            java.lang.String r4 = r0.getDefaultErrorMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r2 = 0
            r1 = 12
            r0 = 125(0x7d, float:1.75E-43)
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.StringBuilder r1 = r3.append(r0)
            java.lang.String r0 = r8.toString()
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            r5.<init>(r4, r0)
            com.facebook.ads.redexgen.X.C0511Kb.A06(r9, r7, r6, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.NL.A02(int, java.lang.CharSequence, long):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0062, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A03(int r6, @android.support.annotation.Nullable java.lang.String r7) {
        /*
            r5 = this;
            r4 = r5
            r2 = 100
            r1 = 23
            r0 = 34
            java.lang.String r0 = A00(r2, r1, r0)
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L60
            r0 = 2
        L12:
            switch(r0) {
                case 2: goto L16;
                case 3: goto L62;
                case 4: goto L23;
                case 5: goto L4f;
                default: goto L15;
            }
        L15:
            goto L12
        L16:
            com.facebook.ads.redexgen.X.NL r4 = (com.facebook.ads.redexgen.X.NL) r4
            com.facebook.ads.redexgen.X.Ec r0 = r4.A02
            com.facebook.ads.redexgen.X.0c r0 = r0.A08()
            r0.A8f()
            r0 = 3
            goto L12
        L23:
            com.facebook.ads.redexgen.X.NL r4 = (com.facebook.ads.redexgen.X.NL) r4
            java.lang.String r7 = (java.lang.String) r7
            com.facebook.ads.redexgen.X.Ec r0 = r4.A02
            com.facebook.ads.redexgen.X.0c r0 = r0.A08()
            r0.A8g(r6)
            java.util.Date r0 = new java.util.Date
            r0.<init>()
            long r2 = r0.getTime()
            java.util.Date r0 = r4.A00
            long r0 = r0.getTime()
            long r2 = r2 - r0
            r4.A02(r6, r7, r2)
            java.lang.ref.WeakReference<com.facebook.ads.redexgen.X.1N> r0 = r4.A04
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L4d
            r0 = 5
            goto L12
        L4d:
            r0 = 3
            goto L12
        L4f:
            com.facebook.ads.redexgen.X.NL r4 = (com.facebook.ads.redexgen.X.NL) r4
            java.lang.String r7 = (java.lang.String) r7
            java.lang.ref.WeakReference<com.facebook.ads.redexgen.X.1N> r0 = r4.A04
            java.lang.Object r0 = r0.get()
            com.facebook.ads.redexgen.X.1N r0 = (com.facebook.ads.redexgen.X.C1N) r0
            r0.A6d(r6, r7)
            r0 = 3
            goto L12
        L60:
            r0 = 4
            goto L12
        L62:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.NL.A03(int, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0065, code lost:            r4.A01 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0069, code lost:            return;     */
    @Override // android.webkit.WebViewClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onPageFinished(android.webkit.WebView r6, java.lang.String r7) {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r0 = 0
            r0 = 0
            r2 = 1
            com.facebook.ads.redexgen.X.Ec r0 = r4.A02
            com.facebook.ads.redexgen.X.0c r1 = r0.A08()
            java.lang.ref.WeakReference<com.facebook.ads.redexgen.X.NM> r0 = r4.A03
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L62
            r0 = 2
        L14:
            switch(r0) {
                case 2: goto L5c;
                case 3: goto L49;
                case 4: goto L3b;
                case 5: goto L27;
                case 6: goto L18;
                case 7: goto L65;
                case 8: goto L5f;
                default: goto L17;
            }
        L17:
            goto L14
        L18:
            com.facebook.ads.redexgen.X.NL r4 = (com.facebook.ads.redexgen.X.NL) r4
            java.lang.ref.WeakReference<com.facebook.ads.redexgen.X.NM> r0 = r4.A03
            java.lang.Object r0 = r0.get()
            com.facebook.ads.redexgen.X.NM r0 = (com.facebook.ads.redexgen.X.NM) r0
            com.facebook.ads.redexgen.X.NM.A06(r0)
            r0 = 7
            goto L14
        L27:
            com.facebook.ads.redexgen.X.NL r4 = (com.facebook.ads.redexgen.X.NL) r4
            java.lang.ref.WeakReference<java.util.concurrent.atomic.AtomicBoolean> r0 = r4.A05
            java.lang.Object r0 = r0.get()
            java.util.concurrent.atomic.AtomicBoolean r0 = (java.util.concurrent.atomic.AtomicBoolean) r0
            boolean r0 = r0.get()
            if (r0 != 0) goto L39
            r0 = 6
            goto L14
        L39:
            r0 = 7
            goto L14
        L3b:
            com.facebook.ads.redexgen.X.NL r4 = (com.facebook.ads.redexgen.X.NL) r4
            java.lang.ref.WeakReference<java.util.concurrent.atomic.AtomicBoolean> r0 = r4.A05
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L47
            r0 = 5
            goto L14
        L47:
            r0 = 7
            goto L14
        L49:
            com.facebook.ads.redexgen.X.NL r4 = (com.facebook.ads.redexgen.X.NL) r4
            com.facebook.ads.redexgen.X.0c r1 = (com.facebook.ads.redexgen.X.InterfaceC00050c) r1
            r1.A8h(r3)
            java.lang.ref.WeakReference<com.facebook.ads.redexgen.X.NM> r0 = r4.A03
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L5a
            r0 = 4
            goto L14
        L5a:
            r0 = 7
            goto L14
        L5c:
            r3 = r2
            r0 = 3
            goto L14
        L5f:
            r3 = 0
            r0 = 3
            goto L14
        L62:
            r0 = 8
            goto L14
        L65:
            com.facebook.ads.redexgen.X.NL r4 = (com.facebook.ads.redexgen.X.NL) r4
            r4.A01 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.NL.onPageFinished(android.webkit.WebView, java.lang.String):void");
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.A02.A08().A8i();
        this.A00 = new Date();
        new Handler().postDelayed(new NK(this), this.A08.get());
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        this.A01 = true;
        A03(i, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:            return;     */
    @Override // android.webkit.WebViewClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onReceivedError(android.webkit.WebView r4, android.webkit.WebResourceRequest r5, android.webkit.WebResourceError r6) {
        /*
            r3 = this;
            r2 = r3
            r0 = 1
            r2.A01 = r0
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 23
            if (r1 < r0) goto L31
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L33;
                case 4: goto L24;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.NL r2 = (com.facebook.ads.redexgen.X.NL) r2
            android.webkit.WebResourceError r6 = (android.webkit.WebResourceError) r6
            int r1 = r6.getErrorCode()
            java.lang.CharSequence r0 = r6.getDescription()
            java.lang.String r0 = r0.toString()
            r2.A03(r1, r0)
            r0 = 3
            goto Lb
        L24:
            com.facebook.ads.redexgen.X.NL r2 = (com.facebook.ads.redexgen.X.NL) r2
            com.facebook.ads.redexgen.X.Ec r0 = r2.A02
            com.facebook.ads.redexgen.X.0c r0 = r0.A08()
            r0.A8j()
            r0 = 3
            goto Lb
        L31:
            r0 = 4
            goto Lb
        L33:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.NL.onReceivedError(android.webkit.WebView, android.webkit.WebResourceRequest, android.webkit.WebResourceError):void");
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.A02.A08().A8k();
        sslErrorHandler.cancel();
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (this.A04.get() != null) {
            this.A04.get().A6K(str, new NS().A03(this.A07.get()).A02(this.A06.get()).A05());
            return true;
        }
        return true;
    }
}
