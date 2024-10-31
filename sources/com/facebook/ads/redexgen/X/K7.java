package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: assets/audience_network.dex */
public final class K7 implements Executor {
    public static final K7 A01 = new K7();
    public final Handler A00 = new Handler(Looper.getMainLooper());

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0021, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A00(java.lang.Runnable r2) {
        /*
            android.os.Looper r1 = android.os.Looper.myLooper()
            android.os.Looper r0 = android.os.Looper.getMainLooper()
            if (r1 != r0) goto L1f
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L21;
                case 4: goto L16;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r2.run()
            r0 = 3
            goto Lb
        L16:
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            com.facebook.ads.redexgen.X.K7 r0 = com.facebook.ads.redexgen.X.K7.A01
            r0.execute(r2)
            r0 = 3
            goto Lb
        L1f:
            r0 = 4
            goto Lb
        L21:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.K7.A00(java.lang.Runnable):void");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.A00.post(runnable);
    }
}
