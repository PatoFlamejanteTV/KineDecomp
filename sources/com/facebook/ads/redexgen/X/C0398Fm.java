package com.facebook.ads.redexgen.X;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.support.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.facebook.ads.redexgen.X.Fm */
/* loaded from: assets/audience_network.dex */
public final class C0398Fm {
    public static Sensor A00;
    public static Sensor A01;
    public static SensorEventListener A02;
    public static SensorEventListener A03;
    public static SensorManager A04;
    public static Map<String, String> A05;
    public static byte[] A06;
    public static String[] A07;
    public static final AtomicReference<String> A08;
    public static volatile float[] A09;
    public static volatile float[] A0A;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0398Fm.A06
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
            r0 = r0 ^ 111(0x6f, float:1.56E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0398Fm.A01(int, int, int):java.lang.String");
    }

    public static void A03() {
        A06 = new byte[]{126, 119, 100, 119, 126, 2, 22, 1, 1, 59, 23, 20, 5, 7, 1, 35, 53, 62, 35, 63, 34, 36, 43, 33, 55, 42, 44, 33, 107, 44, 43, 49, 32, 43, 49, 107, 36, 38, 49, 44, 42, 43, 107, 7, 4, 17, 17, 0, 23, 28, 26, 6, 13, 4, 11, 2, 0, 1, 8, 72, 37, 24, 15, 24, 16, 21, 24, 27, 21, 28, 38, 20, 28, 20, 22, 11, 0, 111, 15, 20, 9, 18, 7, 18, 15, 9, 8, 57, 103, 124, 103, 114, Byte.MAX_VALUE, 76, 126, 118, 126, 124, 97, 106, 27, 25, 18, 25, 14, 21, 31, 77, 79, 79, 73, 64, 73, 94, 67, 65, 73, 88, 73, 94, 115, Byte.MAX_VALUE, 111, 109, 96, 105, 21, 30, 23, 4, 17, 31, 24, 17, 74, 72, 95, 66, 93, 66, 95, 82, 122, 121, 108, 108, 125, 106, 97, 2, 5, 16, 5, 4, 2};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 6 out of bounds for length 5
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:118)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:626)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:39)
     */
    public static void A08(Context context) {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        String valueOf = String.valueOf(statFs.getAvailableBlocks() * statFs.getBlockSize());
        A08.set(valueOf);
        A05.put(A01(5, 10, 11), valueOf);
    }

    static {
        A03();
        A04 = null;
        A00 = null;
        A01 = null;
        A05 = new ConcurrentHashMap();
        A07 = new String[]{A01(77, 1, 120), A01(60, 1, 51), A01(59, 1, 93)};
        A08 = new AtomicReference<>();
    }

    @Nullable
    public static String A00() {
        return A08.get();
    }

    public static Map<String, String> A02() {
        Map<String, String> currentAnalogInfo = new HashMap<>();
        currentAnalogInfo.putAll(A05);
        A0C(currentAnalogInfo);
        return currentAnalogInfo;
    }

    public static synchronized void A06() {
        synchronized (C0398Fm.class) {
            if (A04 != null) {
                A04.unregisterListener(A02);
            }
            A02 = null;
        }
    }

    public static synchronized void A07() {
        synchronized (C0398Fm.class) {
            if (A04 != null) {
                A04.unregisterListener(A03);
            }
            A03 = null;
        }
    }

    public static void A09(Context context) {
        ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(A01(134, 8, 68))).getMemoryInfo(mi);
        A05.put(A01(61, 16, 22), String.valueOf(mi.availMem));
        if (Build.VERSION.SDK_INT >= 16) {
            A05.put(A01(88, 12, 124), String.valueOf(mi.totalMem));
        }
    }

    public static void A0A(C0361Eb c0361Eb) {
        try {
            Intent registerReceiver = c0361Eb.registerReceiver(null, new IntentFilter(A01(21, 37, 42)));
            if (registerReceiver != null) {
                int intExtra = registerReceiver.getIntExtra(A01(0, 5, 125), -1);
                int intExtra2 = registerReceiver.getIntExtra(A01(121, 5, 99), -1);
                int scale = registerReceiver.getIntExtra(A01(149, 6, 30), -1);
                boolean z = scale == 2 || scale == 5;
                float batteryLevel = 0.0f;
                if (intExtra2 > 0) {
                    float batteryLevel2 = intExtra;
                    batteryLevel = (batteryLevel2 / intExtra2) * 100.0f;
                }
                A05.put(A01(142, 7, 119), String.valueOf(batteryLevel));
                A05.put(A01(126, 8, 25), z ? A01(58, 1, 86) : A01(78, 1, 80));
            }
        } catch (IllegalArgumentException e) {
            c0361Eb.A06().A5W(A01(100, 7, 19), C0512Kc.A15, new C0514Ke(e));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0070, code lost:            if (com.facebook.ads.redexgen.X.C0398Fm.A04 == null) goto L55;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void A0B(com.facebook.ads.redexgen.X.C0361Eb r5) {
        /*
            java.lang.Class<com.facebook.ads.redexgen.X.Fm> r4 = com.facebook.ads.redexgen.X.C0398Fm.class
            monitor-enter(r4)
            A09(r5)     // Catch: java.lang.Throwable -> L74
            A0A(r5)     // Catch: java.lang.Throwable -> L74
            android.hardware.SensorManager r0 = com.facebook.ads.redexgen.X.C0398Fm.A04     // Catch: java.lang.Throwable -> L74
            if (r0 != 0) goto L21
            r2 = 15
            r1 = 6
            r0 = 63
            java.lang.String r0 = A01(r2, r1, r0)     // Catch: java.lang.Throwable -> L74
            java.lang.Object r0 = r5.getSystemService(r0)     // Catch: java.lang.Throwable -> L74
            android.hardware.SensorManager r0 = (android.hardware.SensorManager) r0     // Catch: java.lang.Throwable -> L74
            com.facebook.ads.redexgen.X.C0398Fm.A04 = r0     // Catch: java.lang.Throwable -> L74
            android.hardware.SensorManager r0 = com.facebook.ads.redexgen.X.C0398Fm.A04     // Catch: java.lang.Throwable -> L74
            goto L70
        L21:
            android.hardware.Sensor r0 = com.facebook.ads.redexgen.X.C0398Fm.A00     // Catch: java.lang.Throwable -> L74
            if (r0 != 0) goto L2e
            android.hardware.SensorManager r1 = com.facebook.ads.redexgen.X.C0398Fm.A04     // Catch: java.lang.Throwable -> L74
            r0 = 1
            android.hardware.Sensor r0 = r1.getDefaultSensor(r0)     // Catch: java.lang.Throwable -> L74
            com.facebook.ads.redexgen.X.C0398Fm.A00 = r0     // Catch: java.lang.Throwable -> L74
        L2e:
            android.hardware.Sensor r0 = com.facebook.ads.redexgen.X.C0398Fm.A01     // Catch: java.lang.Throwable -> L74
            if (r0 != 0) goto L3b
            android.hardware.SensorManager r1 = com.facebook.ads.redexgen.X.C0398Fm.A04     // Catch: java.lang.Throwable -> L74
            r0 = 4
            android.hardware.Sensor r0 = r1.getDefaultSensor(r0)     // Catch: java.lang.Throwable -> L74
            com.facebook.ads.redexgen.X.C0398Fm.A01 = r0     // Catch: java.lang.Throwable -> L74
        L3b:
            android.hardware.SensorEventListener r0 = com.facebook.ads.redexgen.X.C0398Fm.A02     // Catch: java.lang.Throwable -> L74
            if (r0 != 0) goto L55
            com.facebook.ads.redexgen.X.Fk r1 = new com.facebook.ads.redexgen.X.Fk     // Catch: java.lang.Throwable -> L74
            r0 = 0
            r1.<init>()     // Catch: java.lang.Throwable -> L74
            com.facebook.ads.redexgen.X.C0398Fm.A02 = r1     // Catch: java.lang.Throwable -> L74
            android.hardware.Sensor r0 = com.facebook.ads.redexgen.X.C0398Fm.A00     // Catch: java.lang.Throwable -> L74
            if (r0 == 0) goto L55
            android.hardware.SensorManager r3 = com.facebook.ads.redexgen.X.C0398Fm.A04     // Catch: java.lang.Throwable -> L74
            android.hardware.SensorEventListener r2 = com.facebook.ads.redexgen.X.C0398Fm.A02     // Catch: java.lang.Throwable -> L74
            android.hardware.Sensor r1 = com.facebook.ads.redexgen.X.C0398Fm.A00     // Catch: java.lang.Throwable -> L74
            r0 = 3
            r3.registerListener(r2, r1, r0)     // Catch: java.lang.Throwable -> L74
        L55:
            android.hardware.SensorEventListener r0 = com.facebook.ads.redexgen.X.C0398Fm.A03     // Catch: java.lang.Throwable -> L74
            if (r0 != 0) goto L72
            com.facebook.ads.redexgen.X.Fl r1 = new com.facebook.ads.redexgen.X.Fl     // Catch: java.lang.Throwable -> L74
            r0 = 0
            r1.<init>()     // Catch: java.lang.Throwable -> L74
            com.facebook.ads.redexgen.X.C0398Fm.A03 = r1     // Catch: java.lang.Throwable -> L74
            android.hardware.Sensor r0 = com.facebook.ads.redexgen.X.C0398Fm.A01     // Catch: java.lang.Throwable -> L74
            if (r0 == 0) goto L72
            android.hardware.SensorManager r3 = com.facebook.ads.redexgen.X.C0398Fm.A04     // Catch: java.lang.Throwable -> L74
            android.hardware.SensorEventListener r2 = com.facebook.ads.redexgen.X.C0398Fm.A03     // Catch: java.lang.Throwable -> L74
            android.hardware.Sensor r1 = com.facebook.ads.redexgen.X.C0398Fm.A01     // Catch: java.lang.Throwable -> L74
            r0 = 3
            r3.registerListener(r2, r1, r0)     // Catch: java.lang.Throwable -> L74
            goto L72
        L70:
            if (r0 != 0) goto L21
        L72:
            monitor-exit(r4)
            return
        L74:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0398Fm.A0B(com.facebook.ads.redexgen.X.Eb):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a6, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0C(java.util.Map<java.lang.String, java.lang.String> r10) {
        /*
            r0 = 0
            r7 = 0
            r6 = 0
            r0 = 0
            r5 = 0
            r4 = 0
            float[] r3 = com.facebook.ads.redexgen.X.C0398Fm.A09
            float[] r2 = com.facebook.ads.redexgen.X.C0398Fm.A0A
            if (r3 == 0) goto La3
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L5d;
                case 3: goto L57;
                case 4: goto L27;
                case 5: goto L1e;
                case 6: goto L11;
                case 7: goto L6a;
                case 8: goto L72;
                case 9: goto La6;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            float[] r2 = (float[]) r2
            java.lang.String[] r0 = com.facebook.ads.redexgen.X.C0398Fm.A07
            int r1 = r0.length
            int r0 = r2.length
            int r4 = java.lang.Math.min(r1, r0)
            r7 = 0
            r0 = 7
            goto Ld
        L1e:
            float[] r2 = (float[]) r2
            if (r2 == 0) goto L24
            r0 = 6
            goto Ld
        L24:
            r0 = 9
            goto Ld
        L27:
            java.util.Map r10 = (java.util.Map) r10
            float[] r3 = (float[]) r3
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r8 = 107(0x6b, float:1.5E-43)
            r1 = 14
            r0 = 67
            java.lang.String r0 = A01(r8, r1, r0)
            java.lang.StringBuilder r1 = r9.append(r0)
            java.lang.String[] r0 = com.facebook.ads.redexgen.X.C0398Fm.A07
            r0 = r0[r6]
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r1 = r0.toString()
            r0 = r3[r6]
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r10.put(r1, r0)
            int r6 = r6 + 1
            r0 = 3
            goto Ld
        L57:
            if (r6 >= r5) goto L5b
            r0 = 4
            goto Ld
        L5b:
            r0 = 5
            goto Ld
        L5d:
            float[] r3 = (float[]) r3
            java.lang.String[] r0 = com.facebook.ads.redexgen.X.C0398Fm.A07
            int r1 = r0.length
            int r0 = r3.length
            int r5 = java.lang.Math.min(r1, r0)
            r6 = 0
            r0 = 3
            goto Ld
        L6a:
            if (r7 >= r4) goto L6f
            r0 = 8
            goto Ld
        L6f:
            r0 = 9
            goto Ld
        L72:
            java.util.Map r10 = (java.util.Map) r10
            float[] r2 = (float[]) r2
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r8 = 79
            r1 = 9
            r0 = 9
            java.lang.String r0 = A01(r8, r1, r0)
            java.lang.StringBuilder r1 = r9.append(r0)
            java.lang.String[] r0 = com.facebook.ads.redexgen.X.C0398Fm.A07
            r0 = r0[r7]
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r1 = r0.toString()
            r0 = r2[r7]
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r10.put(r1, r0)
            int r7 = r7 + 1
            r0 = 7
            goto Ld
        La3:
            r0 = 5
            goto Ld
        La6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0398Fm.A0C(java.util.Map):void");
    }
}
