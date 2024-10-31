package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: assets/audience_network.dex */
public final class AS {
    public final AA A00;
    public final Map<Integer, C0343Dj> A01;
    public final AtomicBoolean A02 = new AtomicBoolean();

    public AS(AA aa, Map<Integer, C0343Dj> map) {
        this.A00 = aa;
        this.A01 = map;
        this.A02.compareAndSet(false, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int A00(int r4) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.AA r0 = r2.A00
            java.lang.Integer r0 = r0.A0e(r4)
            if (r0 == 0) goto L27
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L29;
                case 4: goto L1d;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.AS r2 = (com.facebook.ads.redexgen.X.AS) r2
            com.facebook.ads.redexgen.X.AA r0 = r2.A00
            java.lang.Integer r0 = r0.A0e(r4)
            int r1 = r0.intValue()
            r0 = 3
            goto Lb
        L1d:
            com.facebook.ads.redexgen.X.AS r2 = (com.facebook.ads.redexgen.X.AS) r2
            com.facebook.ads.redexgen.X.AA r0 = r2.A00
            int r1 = r0.A0R()
            r0 = 3
            goto Lb
        L27:
            r0 = 4
            goto Lb
        L29:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AS.A00(int):int");
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.AG != com.facebook.ads.internal.botdetection.interval.buffer.CircularBuffer<com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef> */
    private synchronized void A01(AbstractC0351Dr abstractC0351Dr, C0343Dj c0343Dj) {
        int signalId = c0343Dj.A00();
        Map<Integer, AG<AbstractC0351Dr>> A03 = C0347Dn.A01().A03();
        if (A03.containsKey(Integer.valueOf(signalId))) {
            AG<AbstractC0351Dr> ag = A03.get(Integer.valueOf(signalId));
            AbstractC0351Dr A02 = ag != null ? ag.A02() : null;
            if (ag == null) {
                ag = new AG<>(A00(signalId));
            }
            if (!abstractC0351Dr.A0B(A02, c0343Dj.A03())) {
                ag.A04(abstractC0351Dr);
                C0347Dn.A01().A04(signalId, ag, abstractC0351Dr.A05());
            }
        } else {
            AG<AbstractC0351Dr> ag2 = new AG<>(A00(signalId));
            ag2.A04(abstractC0351Dr);
            C0347Dn.A01().A04(signalId, ag2, abstractC0351Dr.A05());
        }
    }

    @SuppressLint({"CatchGeneralException"})
    public final void A02(AbstractC0351Dr abstractC0351Dr, AR ar) {
        if (!this.A02.get()) {
            return;
        }
        try {
            switch (ar) {
                case A0D:
                    C0343Dj bdGeomagneticRotationSensorSignal = this.A01.get(10800);
                    C0343Dj bdTouchSignal = bdGeomagneticRotationSensorSignal;
                    if (abstractC0351Dr != null && bdTouchSignal != null) {
                        A01(abstractC0351Dr, bdTouchSignal);
                        break;
                    }
                    break;
                case A02:
                    C0343Dj c0343Dj = this.A01.get(10810);
                    if (abstractC0351Dr != null && c0343Dj != null) {
                        A01(abstractC0351Dr, c0343Dj);
                        break;
                    }
                    break;
                case A08:
                    C0343Dj bdGeomagneticRotationSensorSignal2 = this.A01.get(10812);
                    C0343Dj bdGeomagneticRotationSensorSignal3 = bdGeomagneticRotationSensorSignal2;
                    if (abstractC0351Dr != null && bdGeomagneticRotationSensorSignal3 != null) {
                        A01(abstractC0351Dr, bdGeomagneticRotationSensorSignal3);
                        break;
                    }
                    break;
                case A05:
                    C0343Dj bdGeomagneticRotationSensorSignal4 = this.A01.get(10813);
                    if (abstractC0351Dr != null && bdGeomagneticRotationSensorSignal4 != null) {
                        A01(abstractC0351Dr, bdGeomagneticRotationSensorSignal4);
                        break;
                    }
                    break;
                case A09:
                    C0343Dj bdOrientationSensorSignal = this.A01.get(10814);
                    if (abstractC0351Dr != null && bdOrientationSensorSignal != null) {
                        A01(abstractC0351Dr, bdOrientationSensorSignal);
                        break;
                    }
                    break;
                case A0A:
                    C0343Dj bdProximitySensorSignal = this.A01.get(10815);
                    if (abstractC0351Dr != null && bdProximitySensorSignal != null) {
                        A01(abstractC0351Dr, bdProximitySensorSignal);
                        break;
                    }
                    break;
                case A0C:
                    C0343Dj bdStepDetectorSensorSignal = this.A01.get(10816);
                    if (abstractC0351Dr != null && bdStepDetectorSensorSignal != null) {
                        A01(abstractC0351Dr, bdStepDetectorSensorSignal);
                        break;
                    }
                    break;
                case A07:
                    C0343Dj bdLightSensorSignal = this.A01.get(10817);
                    if (abstractC0351Dr != null && bdLightSensorSignal != null) {
                        A01(abstractC0351Dr, bdLightSensorSignal);
                        break;
                    }
                    break;
                case A04:
                    C0343Dj c0343Dj2 = this.A01.get(10818);
                    if (abstractC0351Dr != null && c0343Dj2 != null) {
                        A01(abstractC0351Dr, c0343Dj2);
                        break;
                    }
                    break;
                case A03:
                    C0343Dj c0343Dj3 = this.A01.get(10819);
                    if (abstractC0351Dr != null && c0343Dj3 != null) {
                        A01(abstractC0351Dr, c0343Dj3);
                        break;
                    }
                    break;
                case A0B:
                    C0343Dj c0343Dj4 = this.A01.get(10820);
                    if (abstractC0351Dr != null && c0343Dj4 != null) {
                        A01(abstractC0351Dr, c0343Dj4);
                        break;
                    }
                    break;
            }
        } catch (Throwable t) {
            AK.A03(t);
        }
    }
}
