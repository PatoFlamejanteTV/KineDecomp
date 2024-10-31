package com.facebook.ads.redexgen.X;

/* loaded from: assets/audience_network.dex */
public final class Jk {
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:            return r2;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.Serializable A00(@android.support.annotation.Nullable byte[] r3) {
        /*
            r0 = 0
            r2 = 0
            r0 = 0
            if (r3 != 0) goto L24
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L26;
                case 4: goto Ld;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            r2 = 0
            r0 = 3
            goto L6
        Ld:
            byte[] r3 = (byte[]) r3
            r2 = 0
            android.os.Parcel r1 = android.os.Parcel.obtain()
            int r0 = r3.length
            r1.unmarshall(r3, r2, r0)
            r1.setDataPosition(r2)
            java.io.Serializable r2 = r1.readSerializable()
            r1.recycle()
            r0 = 3
            goto L6
        L24:
            r0 = 4
            goto L6
        L26:
            java.io.Serializable r2 = (java.io.Serializable) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.Jk.A00(byte[]):java.io.Serializable");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0021, code lost:            return r1;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] A01(@android.support.annotation.Nullable java.io.Serializable r2) {
        /*
            r1 = 0
            if (r2 != 0) goto L1d
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L8;
                case 3: goto L1f;
                case 4: goto Lb;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            r1 = 0
            r0 = 3
            goto L4
        Lb:
            java.io.Serializable r2 = (java.io.Serializable) r2
            android.os.Parcel r0 = android.os.Parcel.obtain()
            r0.writeSerializable(r2)
            byte[] r1 = r0.marshall()
            r0.recycle()
            r0 = 3
            goto L4
        L1d:
            r0 = 4
            goto L4
        L1f:
            byte[] r1 = (byte[]) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.Jk.A01(java.io.Serializable):byte[]");
    }
}
