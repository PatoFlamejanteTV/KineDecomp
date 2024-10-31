package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.facebook.ads.internal.util.common.ANActivityLifecycleCallbacksListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: assets/audience_network.dex */
public final class JJ implements Application.ActivityLifecycleCallbacks {
    public static Context A00;
    public static C0365Ef A01;
    public static byte[] A02;
    public static final List<InterfaceC02549y> A03;
    public static final Map<Activity, Integer> A04;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.JJ.A02
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
            r0 = r0 ^ 96
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JJ.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A02 = new byte[]{28, 45, 57, 63, 41, 40, 108, 45, 47, 56, 37, 58, 37, 56, 53, 108, 37, 63, 108, 34, 35, 56, 108, 62, 41, 63, 57, 33, 41, 40, 98, 22, 53, 61, 121, 56, 58, 45, 48, 47, 48, 45, 32, 121, 42, 45, 56, 45, 60, 99, 121, 126, 73, 95, 22, 12, 13, 15, 24, 51, 25, 24, 5, 0, 49, 19, 4, 25, 6, 25, 4, 9, 80, 20, 25, 3, 19, 2, 21, 0, 17, 30, 19, 25, 21, 3, 94, 8, 36, 37, 40, 62, 57, 57, 46, 37, 63, 107, 38, 36, 47, 34, 45, 34, 40, 42, 63, 34, 36, 37, 107, 46, 51, 40, 46, 59, 63, 34, 36, 37, 107, 63, 35, 57, 36, 60, 37, 47, 62, 57, 34, 37, 44, 107, 57, 46, 44, 34, 56, 63, 46, 57, 10, 40, 63, 34, 61, 34, 63, 50, 8, 42, 39, 39, 41, 42, 40, 32, 56, 7, 34, 56, 63, 46, 37, 46, 57, 24, 20, 117, 87, 64, 93, 66, 93, 64, 77, 14, 20, 54, 39, 62, 23, 38, 38, 21, 57, 56, 34, 51, 46, 34, 118, 63, 37, 118, 56, 57, 34, 118, 23, 38, 38, 58, 63, 53, 55, 34, 63, 57, 56, 120, 9, 5, 87, 64, 67, 31, 5};
    }

    static {
        A02();
        A04 = Collections.synchronizedMap(new WeakHashMap());
        A03 = Collections.synchronizedList(new ArrayList());
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:            r5 = com.facebook.ads.redexgen.X.JH.A00();     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized android.app.Activity A00() {
        /*
            r4 = 1
            java.lang.Class<com.facebook.ads.redexgen.X.JJ> r8 = com.facebook.ads.redexgen.X.JJ.class
            monitor-enter(r8)
            r6 = 0
            java.util.Map<android.app.Activity, java.lang.Integer> r0 = com.facebook.ads.redexgen.X.JJ.A04     // Catch: java.lang.Throwable -> L9c
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L9c
            java.util.Iterator r3 = r0.iterator()     // Catch: java.lang.Throwable -> L9c
        Lf:
            boolean r0 = r3.hasNext()     // Catch: java.lang.Throwable -> L9c
            if (r0 == 0) goto L2e
            java.lang.Object r2 = r3.next()     // Catch: java.lang.Throwable -> L9c
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch: java.lang.Throwable -> L9c
            java.lang.Object r0 = r2.getValue()     // Catch: java.lang.Throwable -> L9c
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Throwable -> L9c
            int r1 = r0.intValue()     // Catch: java.lang.Throwable -> L9c
            r0 = 3
            if (r1 != r0) goto Lf
            java.lang.Object r6 = r2.getKey()     // Catch: java.lang.Throwable -> L9c
            android.app.Activity r6 = (android.app.Activity) r6     // Catch: java.lang.Throwable -> L9c
        L2e:
            r5 = 0
            if (r6 == 0) goto L39
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L9c
            r0 = 28
            if (r1 >= r0) goto L38
            goto L39
        L38:
            r4 = 0
        L39:
            if (r4 == 0) goto L3f
            android.app.Activity r5 = com.facebook.ads.redexgen.X.JH.A00()     // Catch: java.lang.Throwable -> L9c
        L3f:
            com.facebook.ads.redexgen.X.Ef r0 = com.facebook.ads.redexgen.X.JJ.A01     // Catch: java.lang.Throwable -> L9c
            if (r0 == 0) goto L96
            if (r4 == 0) goto L96
            if (r6 == r5) goto L96
            com.facebook.ads.redexgen.X.Ke r4 = new com.facebook.ads.redexgen.X.Ke     // Catch: java.lang.Throwable -> L9c
            r2 = 64
            r1 = 23
            r0 = 16
            java.lang.String r7 = A01(r2, r1, r0)     // Catch: java.lang.Throwable -> L9c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9c
            r3.<init>()     // Catch: java.lang.Throwable -> L9c
            r2 = 51
            r1 = 5
            r0 = 76
            java.lang.String r0 = A01(r2, r1, r0)     // Catch: java.lang.Throwable -> L9c
            java.lang.StringBuilder r0 = r3.append(r0)     // Catch: java.lang.Throwable -> L9c
            java.lang.StringBuilder r3 = r0.append(r6)     // Catch: java.lang.Throwable -> L9c
            r2 = 212(0xd4, float:2.97E-43)
            r1 = 7
            r0 = 69
            java.lang.String r0 = A01(r2, r1, r0)     // Catch: java.lang.Throwable -> L9c
            java.lang.StringBuilder r0 = r3.append(r0)     // Catch: java.lang.Throwable -> L9c
            java.lang.StringBuilder r0 = r0.append(r5)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L9c
            r4.<init>(r7, r0)     // Catch: java.lang.Throwable -> L9c
            r0 = 1
            r4.A03(r0)     // Catch: java.lang.Throwable -> L9c
            com.facebook.ads.redexgen.X.Ef r3 = com.facebook.ads.redexgen.X.JJ.A01     // Catch: java.lang.Throwable -> L9c
            r2 = 56
            r1 = 8
            r0 = 12
            java.lang.String r1 = A01(r2, r1, r0)     // Catch: java.lang.Throwable -> L9c
            int r0 = com.facebook.ads.redexgen.X.C0512Kc.A01     // Catch: java.lang.Throwable -> L9c
            com.facebook.ads.redexgen.X.C0511Kb.A06(r3, r1, r0, r4)     // Catch: java.lang.Throwable -> L9c
        L96:
            if (r6 == 0) goto L9a
        L98:
            monitor-exit(r8)
            return r6
        L9a:
            r6 = r5
            goto L98
        L9c:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JJ.A00():android.app.Activity");
    }

    public static synchronized void A03(C0365Ef c0365Ef) {
        synchronized (JJ.class) {
            A01 = c0365Ef;
            A00 = c0365Ef.getApplicationContext();
            if (A00 instanceof Application) {
                ANActivityLifecycleCallbacksListener anActivityLifecycleCallbacksListener = ANActivityLifecycleCallbacksListener.getANActivityLifecycleCallbacksListener();
                if (anActivityLifecycleCallbacksListener != null) {
                    Map<? extends Activity, ? extends Integer> activityStateMap = anActivityLifecycleCallbacksListener.getActivityStateMap();
                    synchronized (activityStateMap) {
                        try {
                            A04.putAll(activityStateMap);
                        } catch (ConcurrentModificationException unused) {
                            C0511Kb.A06(A01, A01(56, 8, 12), C0512Kc.A00, new C0514Ke(A01(87, 80, 43)));
                        }
                    }
                    ANActivityLifecycleCallbacksListener.unregisterActivityCallbacks(c0365Ef);
                }
                ((Application) A00).registerActivityLifecycleCallbacks(new JJ());
            } else {
                C0511Kb.A06(A01, A01(179, 3, 55), C0512Kc.A0R, new C0514Ke(A01(182, 30, 54)));
            }
        }
    }

    public static void A04(InterfaceC02549y interfaceC02549y) {
        A03.add(interfaceC02549y);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:            return;     */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onActivityCreated(android.app.Activity r3, android.os.Bundle r4) {
        /*
            r2 = this;
            r0 = 0
            java.util.Map<android.app.Activity, java.lang.Integer> r1 = com.facebook.ads.redexgen.X.JJ.A04
            r0 = 1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.put(r3, r0)
            java.util.List<com.facebook.ads.redexgen.X.9y> r0 = com.facebook.ads.redexgen.X.JJ.A03
            java.util.Iterator r1 = r0.iterator()
            r0 = 2
        L12:
            switch(r0) {
                case 2: goto L16;
                case 3: goto L22;
                case 4: goto L33;
                default: goto L15;
            }
        L15:
            goto L12
        L16:
            java.util.Iterator r1 = (java.util.Iterator) r1
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L20
            r0 = 3
            goto L12
        L20:
            r0 = 4
            goto L12
        L22:
            android.app.Activity r3 = (android.app.Activity) r3
            android.os.Bundle r4 = (android.os.Bundle) r4
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r0 = r1.next()
            com.facebook.ads.redexgen.X.9y r0 = (com.facebook.ads.redexgen.X.InterfaceC02549y) r0
            r0.onActivityCreated(r3, r4)
            r0 = 2
            goto L12
        L33:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JJ.onActivityCreated(android.app.Activity, android.os.Bundle):void");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        A04.put(activity, 6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0075, code lost:            com.facebook.ads.redexgen.X.JJ.A04.put(r8, 4);     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0081, code lost:            return;     */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onActivityPaused(android.app.Activity r8) {
        /*
            r7 = this;
            r0 = 0
            java.util.Map<android.app.Activity, java.lang.Integer> r0 = com.facebook.ads.redexgen.X.JJ.A04
            java.lang.Object r5 = r0.get(r8)
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r5 == 0) goto L73
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L1d;
                case 4: goto L75;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r1 = r5.intValue()
            r0 = 3
            if (r1 == r0) goto L1b
            r0 = 3
            goto Lc
        L1b:
            r0 = 4
            goto Lc
        L1d:
            android.app.Activity r8 = (android.app.Activity) r8
            java.lang.Integer r5 = (java.lang.Integer) r5
            com.facebook.ads.redexgen.X.Ke r4 = new com.facebook.ads.redexgen.X.Ke
            r2 = 0
            r1 = 31
            r0 = 44
            java.lang.String r6 = A01(r2, r1, r0)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r2 = 31
            r1 = 20
            r0 = 57
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.StringBuilder r3 = r0.append(r5)
            r2 = 167(0xa7, float:2.34E-43)
            r1 = 12
            r0 = 84
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.StringBuilder r0 = r0.append(r8)
            java.lang.String r0 = r0.toString()
            r4.<init>(r6, r0)
            r0 = 0
            r4.A03(r0)
            com.facebook.ads.redexgen.X.Ef r3 = com.facebook.ads.redexgen.X.JJ.A01
            r2 = 56
            r1 = 8
            r0 = 12
            java.lang.String r1 = A01(r2, r1, r0)
            int r0 = com.facebook.ads.redexgen.X.C0512Kc.A01
            com.facebook.ads.redexgen.X.C0511Kb.A06(r3, r1, r0, r4)
            r0 = 4
            goto Lc
        L73:
            r0 = 3
            goto Lc
        L75:
            android.app.Activity r8 = (android.app.Activity) r8
            java.util.Map<android.app.Activity, java.lang.Integer> r1 = com.facebook.ads.redexgen.X.JJ.A04
            r0 = 4
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.put(r8, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JJ.onActivityPaused(android.app.Activity):void");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        A04.put(activity, 3);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        A04.put(activity, 2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        A04.put(activity, 5);
    }
}
