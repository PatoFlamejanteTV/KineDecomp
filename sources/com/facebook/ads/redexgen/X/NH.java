package com.facebook.ads.redexgen.X;

import android.util.Log;
import android.webkit.JavascriptInterface;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: assets/audience_network.dex */
public class NH {
    public final String A00 = NH.class.getSimpleName();
    public final WeakReference<AtomicBoolean> A01;
    public final WeakReference<AtomicBoolean> A02;
    public final WeakReference<InterfaceC00050c> A03;
    public final WeakReference<C1N> A04;
    public final WeakReference<FP> A05;
    public final WeakReference<NM> A06;

    public NH(NM nm, C1N c1n, FP fp, AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2, C0362Ec c0362Ec) {
        this.A06 = new WeakReference<>(nm);
        this.A04 = new WeakReference<>(c1n);
        this.A05 = new WeakReference<>(fp);
        this.A01 = new WeakReference<>(atomicBoolean);
        this.A02 = new WeakReference<>(atomicBoolean2);
        this.A03 = new WeakReference<>(c0362Ec.A08());
    }

    private InterfaceC00050c A00() {
        InterfaceC00050c interfaceC00050c = this.A03.get();
        if (interfaceC00050c == null) {
            return new C00270y();
        }
        return interfaceC00050c;
    }

    @JavascriptInterface
    public void alert(String str) {
        Log.e(this.A00, str);
    }

    @JavascriptInterface
    public String getAnalogInfo() {
        return C0490Jf.A01(C0398Fm.A02());
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00bb, code lost:            return;     */
    @android.webkit.JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMainAssetLoaded() {
        /*
            r5 = this;
            r3 = r5
            r4 = 0
            com.facebook.ads.redexgen.X.0c r0 = r3.A00()
            r0.A8a()
            java.lang.ref.WeakReference<com.facebook.ads.redexgen.X.NM> r0 = r3.A06
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto Lb8
            r0 = 2
        L12:
            switch(r0) {
                case 2: goto L52;
                case 3: goto L60;
                case 4: goto Lbb;
                case 5: goto L3e;
                case 6: goto L16;
                case 7: goto L6e;
                case 8: goto L8d;
                case 9: goto La0;
                default: goto L15;
            }
        L15:
            goto L12
        L16:
            com.facebook.ads.redexgen.X.NH r3 = (com.facebook.ads.redexgen.X.NH) r3
            java.lang.ref.WeakReference<java.util.concurrent.atomic.AtomicBoolean> r0 = r3.A01
            java.lang.Object r1 = r0.get()
            java.util.concurrent.atomic.AtomicBoolean r1 = (java.util.concurrent.atomic.AtomicBoolean) r1
            r0 = 1
            r1.set(r0)
            com.facebook.ads.redexgen.X.0c r0 = r3.A00()
            r0.A8b()
            java.lang.ref.WeakReference<com.facebook.ads.redexgen.X.NM> r0 = r3.A06
            java.lang.Object r0 = r0.get()
            com.facebook.ads.redexgen.X.NM r0 = (com.facebook.ads.redexgen.X.NM) r0
            boolean r0 = r0.isShown()
            if (r0 == 0) goto L3b
            r0 = 7
            goto L12
        L3b:
            r0 = 8
            goto L12
        L3e:
            com.facebook.ads.redexgen.X.NH r3 = (com.facebook.ads.redexgen.X.NH) r3
            java.lang.ref.WeakReference<java.util.concurrent.atomic.AtomicBoolean> r0 = r3.A02
            java.lang.Object r0 = r0.get()
            java.util.concurrent.atomic.AtomicBoolean r0 = (java.util.concurrent.atomic.AtomicBoolean) r0
            boolean r0 = r0.get()
            if (r0 == 0) goto L50
            r0 = 6
            goto L12
        L50:
            r0 = 4
            goto L12
        L52:
            com.facebook.ads.redexgen.X.NH r3 = (com.facebook.ads.redexgen.X.NH) r3
            java.lang.ref.WeakReference<java.util.concurrent.atomic.AtomicBoolean> r0 = r3.A01
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L5e
            r0 = 3
            goto L12
        L5e:
            r0 = 4
            goto L12
        L60:
            com.facebook.ads.redexgen.X.NH r3 = (com.facebook.ads.redexgen.X.NH) r3
            java.lang.ref.WeakReference<java.util.concurrent.atomic.AtomicBoolean> r0 = r3.A02
            java.lang.Object r0 = r0.get()
            if (r0 != 0) goto L6c
            r0 = 4
            goto L12
        L6c:
            r0 = 5
            goto L12
        L6e:
            com.facebook.ads.redexgen.X.NH r3 = (com.facebook.ads.redexgen.X.NH) r3
            com.facebook.ads.redexgen.X.0c r0 = r3.A00()
            r0.A8c()
            android.os.Handler r2 = new android.os.Handler
            android.os.Looper r0 = android.os.Looper.getMainLooper()
            r2.<init>(r0)
            com.facebook.ads.redexgen.X.NI r1 = new com.facebook.ads.redexgen.X.NI
            java.lang.ref.WeakReference<com.facebook.ads.redexgen.X.FP> r0 = r3.A05
            r1.<init>(r0)
            r2.post(r1)
            r0 = 8
            goto L12
        L8d:
            com.facebook.ads.redexgen.X.NH r3 = (com.facebook.ads.redexgen.X.NH) r3
            java.lang.ref.WeakReference<com.facebook.ads.redexgen.X.1N> r0 = r3.A04
            java.lang.Object r4 = r0.get()
            com.facebook.ads.redexgen.X.1N r4 = (com.facebook.ads.redexgen.X.C1N) r4
            if (r4 == 0) goto L9d
            r0 = 9
            goto L12
        L9d:
            r0 = 4
            goto L12
        La0:
            com.facebook.ads.redexgen.X.NH r3 = (com.facebook.ads.redexgen.X.NH) r3
            com.facebook.ads.redexgen.X.1N r4 = (com.facebook.ads.redexgen.X.C1N) r4
            android.os.Handler r1 = new android.os.Handler
            android.os.Looper r0 = android.os.Looper.getMainLooper()
            r1.<init>(r0)
            com.facebook.ads.redexgen.X.NG r0 = new com.facebook.ads.redexgen.X.NG
            r0.<init>(r3, r4)
            r1.post(r0)
            r0 = 4
            goto L12
        Lb8:
            r0 = 4
            goto L12
        Lbb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.NH.onMainAssetLoaded():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0059, code lost:            return;     */
    @android.webkit.JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onPageInitialized() {
        /*
            r6 = this;
            r5 = r6
            r4 = 0
            r0 = 0
            r0 = 0
            r3 = 1
            java.lang.ref.WeakReference<com.facebook.ads.redexgen.X.NM> r0 = r5.A06
            java.lang.Object r2 = r0.get()
            com.facebook.ads.redexgen.X.NM r2 = (com.facebook.ads.redexgen.X.NM) r2
            if (r2 == 0) goto L57
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L25;
                case 3: goto L41;
                case 4: goto L59;
                case 5: goto L31;
                case 6: goto L14;
                case 7: goto L4c;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            com.facebook.ads.redexgen.X.NH r5 = (com.facebook.ads.redexgen.X.NH) r5
            com.facebook.ads.redexgen.X.1N r4 = (com.facebook.ads.redexgen.X.C1N) r4
            com.facebook.ads.redexgen.X.0c r1 = r5.A00()
            r0 = 0
            r1.A8d(r0)
            r4.A7D()
            r0 = 4
            goto L10
        L25:
            com.facebook.ads.redexgen.X.NM r2 = (com.facebook.ads.redexgen.X.NM) r2
            boolean r0 = r2.A03()
            if (r0 == 0) goto L2f
            r0 = 3
            goto L10
        L2f:
            r0 = 5
            goto L10
        L31:
            com.facebook.ads.redexgen.X.NH r5 = (com.facebook.ads.redexgen.X.NH) r5
            java.lang.ref.WeakReference<com.facebook.ads.redexgen.X.1N> r0 = r5.A04
            java.lang.Object r4 = r0.get()
            com.facebook.ads.redexgen.X.1N r4 = (com.facebook.ads.redexgen.X.C1N) r4
            if (r4 == 0) goto L3f
            r0 = 6
            goto L10
        L3f:
            r0 = 7
            goto L10
        L41:
            com.facebook.ads.redexgen.X.NH r5 = (com.facebook.ads.redexgen.X.NH) r5
            com.facebook.ads.redexgen.X.0c r0 = r5.A00()
            r0.A8d(r3)
            r0 = 4
            goto L10
        L4c:
            com.facebook.ads.redexgen.X.NH r5 = (com.facebook.ads.redexgen.X.NH) r5
            com.facebook.ads.redexgen.X.0c r0 = r5.A00()
            r0.A8d(r3)
            r0 = 4
            goto L10
        L57:
            r0 = 3
            goto L10
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.NH.onPageInitialized():void");
    }
}
