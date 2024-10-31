package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.os.Build;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Bl, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0293Bl implements InterfaceC0292Bk {
    public static byte[] A06;
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final String A05;

    static {
        A02();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0293Bl.A06
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0293Bl.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A06 = new byte[]{26, 12, 116, 50, 53, 53, 50, 12, 67, 74, 77};
    }

    @SuppressLint({"MissingPermission"})
    public C0293Bl(BluetoothDevice bluetoothDevice) {
        this.A05 = bluetoothDevice.getName();
        this.A03 = bluetoothDevice.getBondState();
        if (Build.VERSION.SDK_INT >= 18) {
            this.A04 = bluetoothDevice.getType();
        } else {
            this.A04 = -1;
        }
        this.A00 = bluetoothDevice.getBluetoothClass().getDeviceClass();
        this.A01 = bluetoothDevice.getBluetoothClass().getMajorDeviceClass();
        this.A02 = A00(bluetoothDevice.getBluetoothClass());
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x002a, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A00(android.bluetooth.BluetoothClass r4) {
        /*
            r0 = 0
            r0 = 0
            r0 = 0
            r3 = 1
            r2 = 0
            r1 = 0
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L13;
                case 4: goto L25;
                case 5: goto L21;
                case 6: goto L2a;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            r0 = 31
            if (r1 >= r0) goto L11
            r0 = 3
            goto L7
        L11:
            r0 = 6
            goto L7
        L13:
            android.bluetooth.BluetoothClass r4 = (android.bluetooth.BluetoothClass) r4
            int r0 = r3 << r1
            boolean r0 = r4.hasService(r0)
            if (r0 == 0) goto L1f
            r0 = 4
            goto L7
        L1f:
            r0 = 5
            goto L7
        L21:
            int r1 = r1 + 1
            r0 = 2
            goto L7
        L25:
            int r0 = r3 << r1
            r2 = r2 | r0
            r0 = 5
            goto L7
        L2a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0293Bl.A00(android.bluetooth.BluetoothClass):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x0082, code lost:            return r3;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0292Bk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A5B(java.lang.Object r5) {
        /*
            r4 = this;
            r2 = r4
            r3 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.Bl r5 = (com.facebook.ads.redexgen.X.C0293Bl) r5
            java.lang.String r0 = r2.A05
            if (r0 != 0) goto L80
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L62;
                case 3: goto L4f;
                case 4: goto L3c;
                case 5: goto L2d;
                case 6: goto Le;
                case 7: goto L1d;
                case 8: goto L6c;
                case 9: goto L7c;
                case 10: goto L82;
                case 11: goto L4b;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.Bl r2 = (com.facebook.ads.redexgen.X.C0293Bl) r2
            com.facebook.ads.redexgen.X.Bl r5 = (com.facebook.ads.redexgen.X.C0293Bl) r5
            int r1 = r2.A00
            int r0 = r5.A00
            if (r1 != r0) goto L1a
            r0 = 7
            goto La
        L1a:
            r0 = 11
            goto La
        L1d:
            com.facebook.ads.redexgen.X.Bl r2 = (com.facebook.ads.redexgen.X.C0293Bl) r2
            com.facebook.ads.redexgen.X.Bl r5 = (com.facebook.ads.redexgen.X.C0293Bl) r5
            int r1 = r2.A01
            int r0 = r5.A01
            if (r1 != r0) goto L2a
            r0 = 8
            goto La
        L2a:
            r0 = 11
            goto La
        L2d:
            com.facebook.ads.redexgen.X.Bl r2 = (com.facebook.ads.redexgen.X.C0293Bl) r2
            com.facebook.ads.redexgen.X.Bl r5 = (com.facebook.ads.redexgen.X.C0293Bl) r5
            int r1 = r2.A04
            int r0 = r5.A04
            if (r1 != r0) goto L39
            r0 = 6
            goto La
        L39:
            r0 = 11
            goto La
        L3c:
            com.facebook.ads.redexgen.X.Bl r2 = (com.facebook.ads.redexgen.X.C0293Bl) r2
            com.facebook.ads.redexgen.X.Bl r5 = (com.facebook.ads.redexgen.X.C0293Bl) r5
            int r1 = r2.A03
            int r0 = r5.A03
            if (r1 != r0) goto L48
            r0 = 5
            goto La
        L48:
            r0 = 11
            goto La
        L4b:
            r3 = 0
            r0 = 10
            goto La
        L4f:
            com.facebook.ads.redexgen.X.Bl r2 = (com.facebook.ads.redexgen.X.C0293Bl) r2
            com.facebook.ads.redexgen.X.Bl r5 = (com.facebook.ads.redexgen.X.C0293Bl) r5
            java.lang.String r1 = r2.A05
            java.lang.String r0 = r5.A05
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L5f
            r0 = 4
            goto La
        L5f:
            r0 = 11
            goto La
        L62:
            com.facebook.ads.redexgen.X.Bl r5 = (com.facebook.ads.redexgen.X.C0293Bl) r5
            java.lang.String r0 = r5.A05
            if (r0 == 0) goto L6a
            r0 = 3
            goto La
        L6a:
            r0 = 4
            goto La
        L6c:
            com.facebook.ads.redexgen.X.Bl r2 = (com.facebook.ads.redexgen.X.C0293Bl) r2
            com.facebook.ads.redexgen.X.Bl r5 = (com.facebook.ads.redexgen.X.C0293Bl) r5
            int r1 = r2.A02
            int r0 = r5.A02
            if (r1 != r0) goto L79
            r0 = 9
            goto La
        L79:
            r0 = 11
            goto La
        L7c:
            r3 = 1
            r0 = 10
            goto La
        L80:
            r0 = 3
            goto La
        L82:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0293Bl.A5B(java.lang.Object):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0073, code lost:            return ((((r3 + (A01(3, 2, 33).length() + 4)) + (A01(7, 1, 24).length() + 4)) + (A01(5, 2, 49).length() + 4)) + (A01(8, 3, 78).length() + 4)) + (A01(0, 2, 9).length() + 4);     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0292Bk
    @android.annotation.SuppressLint({"BadMethodUse-java.lang.String.length"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A8O() {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            java.lang.String r0 = r4.A05
            if (r0 == 0) goto L25
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L27;
                case 4: goto L22;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.Bl r4 = (com.facebook.ads.redexgen.X.C0293Bl) r4
            r2 = 2
            r1 = 1
            r0 = 122(0x7a, float:1.71E-43)
            java.lang.String r0 = A01(r2, r1, r0)
            int r3 = r0.length()
            java.lang.String r0 = r4.A05
            int r0 = r0.length()
            int r3 = r3 + r0
            r0 = 3
            goto L7
        L22:
            r3 = 0
            r0 = 3
            goto L7
        L25:
            r0 = 4
            goto L7
        L27:
            r2 = 3
            r1 = 2
            r0 = 33
            java.lang.String r0 = A01(r2, r1, r0)
            int r0 = r0.length()
            int r0 = r0 + 4
            int r3 = r3 + r0
            r2 = 7
            r1 = 1
            r0 = 24
            java.lang.String r0 = A01(r2, r1, r0)
            int r0 = r0.length()
            int r0 = r0 + 4
            int r3 = r3 + r0
            r2 = 5
            r1 = 2
            r0 = 49
            java.lang.String r0 = A01(r2, r1, r0)
            int r0 = r0.length()
            int r0 = r0 + 4
            int r3 = r3 + r0
            r2 = 8
            r1 = 3
            r0 = 78
            java.lang.String r0 = A01(r2, r1, r0)
            int r0 = r0.length()
            int r0 = r0 + 4
            int r3 = r3 + r0
            r2 = 0
            r1 = 2
            r0 = 9
            java.lang.String r0 = A01(r2, r1, r0)
            int r0 = r0.length()
            int r0 = r0 + 4
            int r3 = r3 + r0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0293Bl.A8O():int");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0292Bk
    public final JSONObject A8R() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(A01(2, 1, 122), this.A05);
        jSONObject.put(A01(3, 2, 33), this.A03);
        jSONObject.put(A01(7, 1, 24), this.A04);
        jSONObject.put(A01(5, 2, 49), this.A00);
        jSONObject.put(A01(8, 3, 78), this.A01);
        jSONObject.put(A01(0, 2, 9), this.A02);
        return jSONObject;
    }
}
