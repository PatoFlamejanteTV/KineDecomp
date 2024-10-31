package com.facebook.ads.redexgen.X;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.Nullable;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: assets/audience_network.dex */
public final class KX implements SensorEventListener {
    public static byte[] A0A;
    public long A04;
    public long A05;
    public long A06;

    @Nullable
    public SensorManager A07;
    public final C0362Ec A08;
    public int A03 = 0;
    public float A00 = -1.0f;
    public float A01 = -1.0f;
    public float A02 = -1.0f;
    public final Set<KU> A09 = new CopyOnWriteArraySet();

    static {
        A02();
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
            byte[] r1 = com.facebook.ads.redexgen.X.KX.A0A
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
            r0 = r0 ^ 13
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KX.A00(int, int, int):java.lang.String");
    }

    public static void A02() {
        A0A = new byte[]{45, 59, 48, 45, 49, 44, 31, 36, 45, 39, 37, 34, 43, 108, 34, 35, 56, 108, 63, 57, 60, 60, 35, 62, 56, 41, 40, 107, 93, 86, 75, 87, 74, 75, 24, 86, 87, 76, 24, 75, 77, 72, 72, 87, 74, 76, 93, 92};
    }

    public KX(C0362Ec c0362Ec) {
        this.A08 = c0362Ec;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0082, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A01() {
        /*
            r7 = this;
            r5 = r7
            r6 = 0
            r0 = 0
            r0 = 0
            r4 = 1
            com.facebook.ads.redexgen.X.Ec r3 = r5.A08
            r2 = 0
            r1 = 6
            r0 = 83
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.Object r0 = r3.getSystemService(r0)
            android.hardware.SensorManager r0 = (android.hardware.SensorManager) r0
            r5.A07 = r0
            android.hardware.SensorManager r0 = r5.A07
            if (r0 != 0) goto L80
            r0 = 2
        L1c:
            switch(r0) {
                case 2: goto L54;
                case 3: goto L6b;
                case 4: goto L2c;
                case 5: goto L1f;
                case 6: goto L1f;
                case 7: goto L1f;
                case 8: goto L1f;
                case 9: goto L1f;
                case 10: goto L6e;
                case 11: goto L20;
                case 12: goto L76;
                case 13: goto L82;
                default: goto L1f;
            }
        L1f:
            goto L1c
        L20:
            com.facebook.ads.redexgen.X.KX r5 = (com.facebook.ads.redexgen.X.KX) r5
            android.hardware.SensorManager r0 = r5.A07
            if (r0 == 0) goto L29
            r0 = 12
            goto L1c
        L29:
            r0 = 13
            goto L1c
        L2c:
            com.facebook.ads.redexgen.X.KX r5 = (com.facebook.ads.redexgen.X.KX) r5     // Catch: java.lang.Exception -> L3f
            android.hardware.SensorManager r2 = r5.A07     // Catch: java.lang.Exception -> L3f
            android.hardware.SensorManager r1 = r5.A07     // Catch: java.lang.Exception -> L3f
            r0 = 1
            android.hardware.Sensor r1 = r1.getDefaultSensor(r0)     // Catch: java.lang.Exception -> L3f
            r0 = 3
            boolean r6 = r2.registerListener(r5, r1, r0)     // Catch: java.lang.Exception -> L3f
            r0 = 10
            goto L1c
        L3f:
            com.facebook.ads.redexgen.X.Ec r3 = r5.A08
            r2 = 6
            r1 = 21
            r0 = 65
            java.lang.String r0 = A00(r2, r1, r0)
            android.widget.Toast r0 = android.widget.Toast.makeText(r3, r0, r4)
            r0.show()
            r0 = 10
            goto L1c
        L54:
            com.facebook.ads.redexgen.X.KX r5 = (com.facebook.ads.redexgen.X.KX) r5
            com.facebook.ads.redexgen.X.Ec r3 = r5.A08
            r2 = 27
            r1 = 21
            r0 = 53
            java.lang.String r0 = A00(r2, r1, r0)
            android.widget.Toast r0 = android.widget.Toast.makeText(r3, r0, r4)
            r0.show()
            r0 = 3
            goto L1c
        L6b:
            r6 = 0
            r0 = 4
            goto L1c
        L6e:
            if (r6 != 0) goto L73
            r0 = 11
            goto L1c
        L73:
            r0 = 13
            goto L1c
        L76:
            com.facebook.ads.redexgen.X.KX r5 = (com.facebook.ads.redexgen.X.KX) r5
            android.hardware.SensorManager r0 = r5.A07
            r0.unregisterListener(r5)
            r0 = 13
            goto L1c
        L80:
            r0 = 3
            goto L1c
        L82:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KX.A01():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0032, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A03(com.facebook.ads.redexgen.X.KU r3) {
        /*
            r2 = this;
            r1 = r2
            java.util.Set<com.facebook.ads.redexgen.X.KU> r0 = r1.A09
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L30
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L15;
                case 4: goto L32;
                case 5: goto L20;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.KX r1 = (com.facebook.ads.redexgen.X.KX) r1
            r1.A01()
            r0 = 3
            goto La
        L15:
            com.facebook.ads.redexgen.X.KX r1 = (com.facebook.ads.redexgen.X.KX) r1
            com.facebook.ads.redexgen.X.KU r3 = (com.facebook.ads.redexgen.X.KU) r3
            java.util.Set<com.facebook.ads.redexgen.X.KU> r0 = r1.A09
            r0.add(r3)
            r0 = 4
            goto La
        L20:
            com.facebook.ads.redexgen.X.KX r1 = (com.facebook.ads.redexgen.X.KX) r1
            com.facebook.ads.redexgen.X.KU r3 = (com.facebook.ads.redexgen.X.KU) r3
            java.util.Set<com.facebook.ads.redexgen.X.KU> r0 = r1.A09
            boolean r0 = r0.contains(r3)
            if (r0 == 0) goto L2e
            r0 = 4
            goto La
        L2e:
            r0 = 3
            goto La
        L30:
            r0 = 5
            goto La
        L32:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KX.A03(com.facebook.ads.redexgen.X.KU):void");
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x00ef, code lost:            return;     */
    @Override // android.hardware.SensorEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onSensorChanged(android.hardware.SensorEvent r14) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KX.onSensorChanged(android.hardware.SensorEvent):void");
    }
}
