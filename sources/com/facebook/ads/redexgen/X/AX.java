package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: assets/audience_network.dex */
public final class AX implements SensorEventListener {
    public static byte[] A09;
    public static final String A0A;
    public AV A00;
    public final Context A01;
    public final SensorManager A02;
    public final AS A04;
    public final AU A05;
    public final EnumC0349Dp A06;
    public final List<Sensor> A07;
    public final Map<Integer, EnumC0257Ab> A08 = new HashMap();
    public final Handler A03 = new Handler(EG.A00().A03().getLooper());

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.AX.A09
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
            int r0 = r0 + (-110)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AX.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A09 = new byte[]{15, 1, 10, 15, 11, 14};
    }

    static {
        A01();
        A0A = AX.class.getSimpleName();
    }

    public AX(Context context, AS as, EnumC0349Dp enumC0349Dp) {
        this.A01 = context;
        this.A02 = (SensorManager) context.getSystemService(A00(0, 6, 46));
        this.A07 = this.A02.getSensorList(-1);
        this.A04 = as;
        this.A05 = new AU(this.A04, enumC0349Dp);
        this.A06 = enumC0349Dp;
    }

    @SuppressLint({"CatchGeneralException"})
    public final synchronized void A02(List<EnumC0257Ab> list) {
        int A02;
        try {
            for (EnumC0257Ab enumC0257Ab : list) {
                if (enumC0257Ab != null && (A02 = enumC0257Ab.A02()) != -1) {
                    Map<Integer, EnumC0257Ab> map = this.A08;
                    int type = enumC0257Ab.ordinal();
                    if (map.get(Integer.valueOf(type)) == null) {
                        if (A02 == 0) {
                            int[] iArr = AW.A00;
                            int type2 = enumC0257Ab.ordinal();
                            switch (iArr[type2]) {
                                case 1:
                                    this.A05.A02(this.A01);
                                    break;
                            }
                        } else {
                            for (Sensor sensor : this.A07) {
                                int type3 = sensor.getType();
                                if (A02 == type3) {
                                    this.A00 = new AV(this);
                                    this.A02.registerListener(this.A00, sensor, 3, this.A03);
                                    Map<Integer, EnumC0257Ab> map2 = this.A08;
                                    int type4 = enumC0257Ab.ordinal();
                                    map2.put(Integer.valueOf(type4), enumC0257Ab);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            AK.A03(th);
        }
    }

    @SuppressLint({"CatchGeneralException"})
    public final synchronized void A03(List<EnumC0257Ab> list) {
        try {
            if (this.A08 != null) {
                if (list == null) {
                    this.A02.unregisterListener(this.A00);
                    this.A05.A01();
                    this.A08.clear();
                } else {
                    for (EnumC0257Ab enumC0257Ab : list) {
                        if (enumC0257Ab.A02() != -1) {
                            if (enumC0257Ab.A02() == 0) {
                                this.A08.remove(Integer.valueOf(enumC0257Ab.ordinal()));
                                switch (AW.A00[enumC0257Ab.ordinal()]) {
                                    case 1:
                                        this.A05.A01();
                                        continue;
                                }
                            }
                            Iterator<Sensor> it = this.A07.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    Sensor next = it.next();
                                    if (enumC0257Ab.A02() == next.getType()) {
                                        try {
                                            this.A02.unregisterListener(this.A00, next);
                                            this.A08.remove(Integer.valueOf(enumC0257Ab.ordinal()));
                                        } catch (Throwable t) {
                                            AK.A03(t);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable t2) {
            AK.A03(t2);
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    @SuppressLint({"CatchGeneralException"})
    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent == null) {
            return;
        }
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            E7 e7 = this.A06 == EnumC0349Dp.A0F ? null : new E7(this.A01 == null ? A00(6, 0, 41) : this.A01.getPackageName());
            switch (sensorEvent.sensor.getType()) {
                case 1:
                    this.A04.A02(new E3(elapsedRealtime, e7, new C0256Aa(new float[]{sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]})), AR.A02);
                    return;
                case 2:
                    this.A04.A02(new E3(elapsedRealtime, e7, new C0256Aa(new float[]{sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]})), AR.A08);
                    return;
                case 3:
                case 7:
                case 9:
                case 10:
                case 11:
                case 14:
                case 15:
                case 16:
                case 17:
                case 19:
                    return;
                case 4:
                    this.A04.A02(new E3(elapsedRealtime, e7, new C0256Aa(new float[]{sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]})), AR.A06);
                    return;
                case 5:
                    this.A04.A02(new C0355Dv(elapsedRealtime, e7, sensorEvent.values[0]), AR.A07);
                    return;
                case 6:
                    this.A04.A02(new C0355Dv(elapsedRealtime, e7, sensorEvent.values[0]), AR.A04);
                    return;
                case 8:
                    this.A04.A02(new C0355Dv(elapsedRealtime, e7, sensorEvent.values[0]), AR.A0A);
                    return;
                case 12:
                    this.A04.A02(new C0355Dv(elapsedRealtime, e7, sensorEvent.values[0]), AR.A0B);
                    return;
                case 13:
                    this.A04.A02(new C0355Dv(elapsedRealtime, e7, sensorEvent.values[0]), AR.A03);
                    return;
                case 18:
                    this.A04.A02(new C0355Dv(elapsedRealtime, e7, sensorEvent.values[0]), AR.A0C);
                    return;
                case 20:
                    this.A04.A02(new E3(elapsedRealtime, e7, new C0256Aa(new float[]{sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2], sensorEvent.values[3]})), AR.A05);
                    return;
                default:
                    return;
            }
        } catch (Throwable t) {
            AK.A03(t);
        }
    }
}
