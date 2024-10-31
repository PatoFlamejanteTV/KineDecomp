package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* renamed from: com.facebook.ads.redexgen.X.1E, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C1E {
    public static byte[] A06;

    @Nullable
    public Application A01;

    @Nullable
    public C1D A03;
    public final InterfaceC0422Gl A05;
    public long A00 = 0;

    @Nullable
    public String A04 = null;

    @Nullable
    public AnonymousClass10 A02 = null;

    static {
        A03();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C1E.A06
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
            int r0 = r0 + (-42)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1E.A02(int, int, int):java.lang.String");
    }

    public static void A03() {
        A06 = new byte[]{-112, -113, -111, -103, -115, -94, -105, -101, -109, -10, -17, -21, 0, -17, -23, -2, -13, -9, -17, -28, -22, -23, -40, -28, -30, -38};
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.facebook.ads.redexgen.X.1D] */
    public C1E(InterfaceC0422Gl interfaceC0422Gl, final Activity activity, int i) {
        this.A05 = interfaceC0422Gl;
        this.A01 = activity.getApplication();
        this.A03 = new Application.ActivityLifecycleCallbacks(activity, this) { // from class: com.facebook.ads.redexgen.X.1D

            @Nullable
            public C1E A00;
            public final WeakReference<Activity> A01;

            {
                this.A01 = new WeakReference<>(activity);
                this.A00 = this;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityCreated(Activity activity2, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityDestroyed(Activity activity2) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityPaused(Activity activity2) {
            }

            /* JADX WARN: Code restructure failed: missing block: B:38:0x003f, code lost:            return;     */
            @Override // android.app.Application.ActivityLifecycleCallbacks
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void onActivityResumed(android.app.Activity r4) {
                /*
                    r3 = this;
                    r2 = r3
                    r1 = 0
                    com.facebook.ads.redexgen.X.1E r0 = r2.A00
                    if (r0 != 0) goto L3d
                    r0 = 2
                L7:
                    switch(r0) {
                        case 2: goto L3f;
                        case 3: goto Lb;
                        case 4: goto L1b;
                        case 5: goto L23;
                        case 6: goto L31;
                        default: goto La;
                    }
                La:
                    goto L7
                Lb:
                    com.facebook.ads.redexgen.X.1D r2 = (com.facebook.ads.redexgen.X.C1D) r2
                    java.lang.ref.WeakReference<android.app.Activity> r0 = r2.A01
                    java.lang.Object r1 = r0.get()
                    android.app.Activity r1 = (android.app.Activity) r1
                    if (r1 == 0) goto L19
                    r0 = 4
                    goto L7
                L19:
                    r0 = 6
                    goto L7
                L1b:
                    android.app.Activity r1 = (android.app.Activity) r1
                    if (r1 == 0) goto L21
                    r0 = 5
                    goto L7
                L21:
                    r0 = 2
                    goto L7
                L23:
                    android.app.Activity r4 = (android.app.Activity) r4
                    android.app.Activity r1 = (android.app.Activity) r1
                    boolean r0 = r4.equals(r1)
                    if (r0 == 0) goto L2f
                    r0 = 6
                    goto L7
                L2f:
                    r0 = 2
                    goto L7
                L31:
                    com.facebook.ads.redexgen.X.1D r2 = (com.facebook.ads.redexgen.X.C1D) r2
                    com.facebook.ads.redexgen.X.1E r0 = r2.A00
                    r0.A05()
                    r0 = 0
                    r2.A00 = r0
                    r0 = 2
                    goto L7
                L3d:
                    r0 = 3
                    goto L7
                L3f:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1D.onActivityResumed(android.app.Activity):void");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivitySaveInstanceState(Activity activity2, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityStarted(Activity activity2) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityStopped(Activity activity2) {
            }
        };
    }

    public static C1E A00(InterfaceC0422Gl interfaceC0422Gl, Activity activity) {
        return A01(interfaceC0422Gl, activity, Build.VERSION.SDK_INT);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0022, code lost:            return r1;     */
    @android.support.annotation.VisibleForTesting
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.C1E A01(com.facebook.ads.redexgen.X.InterfaceC0422Gl r2, android.app.Activity r3, int r4) {
        /*
            r1 = 0
            if (r3 == 0) goto L1e
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L8;
                case 3: goto L10;
                case 4: goto L20;
                case 5: goto L1b;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            r0 = 14
            if (r4 < r0) goto Le
            r0 = 3
            goto L4
        Le:
            r0 = 5
            goto L4
        L10:
            com.facebook.ads.redexgen.X.Gl r2 = (com.facebook.ads.redexgen.X.InterfaceC0422Gl) r2
            android.app.Activity r3 = (android.app.Activity) r3
            com.facebook.ads.redexgen.X.1E r1 = new com.facebook.ads.redexgen.X.1E
            r1.<init>(r2, r3, r4)
            r0 = 4
            goto L4
        L1b:
            r1 = 0
            r0 = 4
            goto L4
        L1e:
            r0 = 5
            goto L4
        L20:
            com.facebook.ads.redexgen.X.1E r1 = (com.facebook.ads.redexgen.X.C1E) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1E.A01(com.facebook.ads.redexgen.X.Gl, android.app.Activity, int):com.facebook.ads.redexgen.X.1E");
    }

    private void A04(String str, long j, long j2, @Nullable AnonymousClass10 anonymousClass10) {
        HashMap hashMap = new HashMap();
        hashMap.put(A02(9, 10, 96), Long.toString(j));
        hashMap.put(A02(0, 9, 4), Long.toString(j2));
        if (anonymousClass10 != null) {
            hashMap.put(A02(19, 7, 75), anonymousClass10.name());
        }
        this.A05.A5s(str, hashMap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0035, code lost:            return;     */
    @android.annotation.TargetApi(14)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A05() {
        /*
            r10 = this;
            r3 = r10
            r0 = 0
            r0 = 0
            java.lang.String r4 = r3.A04
            long r5 = r3.A00
            long r7 = java.lang.System.currentTimeMillis()
            com.facebook.ads.redexgen.X.10 r9 = r3.A02
            r3.A04(r4, r5, r7, r9)
            android.app.Application r0 = r3.A01
            if (r0 == 0) goto L33
            r0 = 2
        L15:
            switch(r0) {
                case 2: goto L19;
                case 3: goto L23;
                case 4: goto L35;
                default: goto L18;
            }
        L18:
            goto L15
        L19:
            com.facebook.ads.redexgen.X.1E r3 = (com.facebook.ads.redexgen.X.C1E) r3
            com.facebook.ads.redexgen.X.1D r0 = r3.A03
            if (r0 == 0) goto L21
            r0 = 3
            goto L15
        L21:
            r0 = 4
            goto L15
        L23:
            com.facebook.ads.redexgen.X.1E r3 = (com.facebook.ads.redexgen.X.C1E) r3
            r2 = 0
            android.app.Application r1 = r3.A01
            com.facebook.ads.redexgen.X.1D r0 = r3.A03
            r1.unregisterActivityLifecycleCallbacks(r0)
            r3.A03 = r2
            r3.A01 = r2
            r0 = 4
            goto L15
        L33:
            r0 = 4
            goto L15
        L35:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1E.A05():void");
    }

    public final void A06(@Nullable AnonymousClass10 anonymousClass10) {
        this.A02 = anonymousClass10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003a, code lost:            return;     */
    @android.annotation.TargetApi(14)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A07(java.lang.String r10) {
        /*
            r9 = this;
            r3 = r10
            r2 = r9
            r0 = 0
            r4 = -1
            r2.A04 = r3
            com.facebook.ads.redexgen.X.1D r0 = r2.A03
            if (r0 == 0) goto L38
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L1b;
                case 4: goto L3a;
                case 5: goto L2c;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.1E r2 = (com.facebook.ads.redexgen.X.C1E) r2
            android.app.Application r0 = r2.A01
            if (r0 == 0) goto L19
            r0 = 3
            goto Ld
        L19:
            r0 = 5
            goto Ld
        L1b:
            com.facebook.ads.redexgen.X.1E r2 = (com.facebook.ads.redexgen.X.C1E) r2
            long r0 = java.lang.System.currentTimeMillis()
            r2.A00 = r0
            android.app.Application r1 = r2.A01
            com.facebook.ads.redexgen.X.1D r0 = r2.A03
            r1.registerActivityLifecycleCallbacks(r0)
            r0 = 4
            goto Ld
        L2c:
            com.facebook.ads.redexgen.X.1E r2 = (com.facebook.ads.redexgen.X.C1E) r2
            java.lang.String r3 = (java.lang.String) r3
            com.facebook.ads.redexgen.X.10 r8 = com.facebook.ads.redexgen.X.AnonymousClass10.A03
            r6 = r4
            r2.A04(r3, r4, r6, r8)
            r0 = 4
            goto Ld
        L38:
            r0 = 5
            goto Ld
        L3a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1E.A07(java.lang.String):void");
    }
}
