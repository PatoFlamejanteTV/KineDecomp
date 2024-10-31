package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.os.Build;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: assets/audience_network.dex */
public class D7 implements InterfaceC0292Bk {
    public static byte[] A0K;
    public final float A00;
    public final float A01;
    public final float A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final int A07;
    public final String A0I;
    public final String A0J;
    public final String A08 = A00(18, 2, 111);
    public final String A0A = A00(4, 2, 118);
    public final String A0B = A00(14, 3, 75);
    public final String A09 = A00(0, 3, 15);
    public final String A0C = A00(10, 1, 28);
    public final String A0D = A00(3, 1, 55);
    public final String A0E = A00(9, 1, 97);
    public final String A0F = A00(17, 1, 74);
    public final String A0G = A00(11, 3, 43);
    public final String A0H = A00(6, 3, 94);

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
            byte[] r1 = com.facebook.ads.redexgen.X.D7.A0K
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
            int r0 = r0 + (-105)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.D7.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A0K = new byte[]{-27, -39, -36, 16, 76, 81, 61, 44, 57, 60, -13, 10, -7, 2, 33, 29, 24, 39, 65, 60};
    }

    public D7(Sensor sensor) {
        this.A03 = Build.VERSION.SDK_INT < 24 ? 0 : sensor.getId();
        this.A04 = Build.VERSION.SDK_INT >= 21 ? sensor.getMaxDelay() : 0;
        this.A00 = sensor.getMaximumRange();
        this.A05 = sensor.getMinDelay();
        this.A0I = sensor.getName();
        this.A01 = sensor.getPower();
        this.A02 = sensor.getResolution();
        this.A06 = sensor.getType();
        this.A0J = sensor.getVendor();
        this.A07 = sensor.getVersion();
    }

    /* JADX WARN: Code restructure failed: missing block: B:95:0x00d6, code lost:            return r3;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0292Bk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A5B(java.lang.Object r5) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.D7.A5B(java.lang.Object):boolean");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0292Bk
    public final int A8O() {
        return A00(18, 2, 111).length() + 4 + A00(0, 3, 15).length() + 4 + A00(4, 2, 118).length() + 4 + A00(14, 3, 75).length() + 4 + A00(10, 1, 28).length() + this.A0I.length() + A00(3, 1, 55).length() + 4 + A00(9, 1, 97).length() + 4 + A00(17, 1, 74).length() + 4 + A00(11, 3, 43).length() + this.A0J.length() + A00(6, 3, 94).length() + 4;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0292Bk
    @SuppressLint({"CatchGeneralException"})
    public final JSONObject A8R() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A00(18, 2, 111), this.A03);
            jSONObject.put(A00(0, 3, 15), this.A04);
            jSONObject.put(A00(4, 2, 118), this.A00);
            jSONObject.put(A00(14, 3, 75), this.A05);
            jSONObject.put(A00(10, 1, 28), this.A0I);
            jSONObject.put(A00(3, 1, 55), this.A01);
            jSONObject.put(A00(9, 1, 97), this.A02);
            jSONObject.put(A00(17, 1, 74), this.A06);
            jSONObject.put(A00(11, 3, 43), this.A0J);
            jSONObject.put(A00(6, 3, 94), this.A07);
        } catch (Throwable th) {
            AK.A03(th);
        }
        return jSONObject;
    }
}
