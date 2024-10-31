package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import java.util.concurrent.Executors;

/* loaded from: assets/audience_network.dex */
public final class JS {
    public static int A00;
    public static byte[] A01;
    public static volatile JR A02;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A06(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.JS.A01
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
            int r0 = r0 + (-11)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JS.A06(int, int, int):java.lang.String");
    }

    public static void A07() {
        A01 = new byte[]{-81, -36, -46, -32, -35, -41, -46, -69, -49, -36, -41, -44, -45, -31, -30, -100, -26, -37, -38, -75, -79, -74, -101, -84, -77, -98, -83, -70, -69, -79, -73, -74, -61, -63, -77, -63, 123, -63, -78, -71};
    }

    static {
        A07();
        A00 = -1;
        A02 = JR.A04;
    }

    public static int A01(Context context) {
        if (A02 == JR.A04) {
            A08(context);
        }
        return A00;
    }

    @SuppressLint({"CatchGeneralException"})
    public static int A02(Context context) {
        try {
            return A05(context.getAssets().openXmlResourceParser(A06(0, 19, 99)));
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static int A03(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).minSdkVersion;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x007c, code lost:            return r5;     */
    @android.support.annotation.VisibleForTesting(otherwise = 2)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A05(org.xmlpull.v1.XmlPullParser r6) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        /*
            r5 = 0
            r4 = 0
            r0 = 2
        L3:
            switch(r0) {
                case 2: goto L13;
                case 3: goto L3e;
                case 4: goto L24;
                case 5: goto L21;
                case 6: goto L7;
                case 7: goto L58;
                case 8: goto L4b;
                case 9: goto L7c;
                case 10: goto L74;
                case 11: goto L78;
                default: goto L6;
            }
        L6:
            goto L3
        L7:
            org.xmlpull.v1.XmlPullParser r6 = (org.xmlpull.v1.XmlPullParser) r6
            int r0 = r6.getAttributeCount()
            if (r4 >= r0) goto L11
            r0 = 7
            goto L3
        L11:
            r0 = 2
            goto L3
        L13:
            org.xmlpull.v1.XmlPullParser r6 = (org.xmlpull.v1.XmlPullParser) r6
            int r1 = r6.next()
            r0 = 1
            if (r1 == r0) goto L1e
            r0 = 3
            goto L3
        L1e:
            r0 = 11
            goto L3
        L21:
            r4 = 0
            r0 = 6
            goto L3
        L24:
            org.xmlpull.v1.XmlPullParser r6 = (org.xmlpull.v1.XmlPullParser) r6
            java.lang.String r3 = r6.getName()
            r2 = 32
            r1 = 8
            r0 = 67
            java.lang.String r0 = A06(r2, r1, r0)
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L3c
            r0 = 5
            goto L3
        L3c:
            r0 = 2
            goto L3
        L3e:
            org.xmlpull.v1.XmlPullParser r6 = (org.xmlpull.v1.XmlPullParser) r6
            int r1 = r6.getEventType()
            r0 = 2
            if (r1 != r0) goto L49
            r0 = 4
            goto L3
        L49:
            r0 = 2
            goto L3
        L4b:
            org.xmlpull.v1.XmlPullParser r6 = (org.xmlpull.v1.XmlPullParser) r6
            java.lang.String r0 = r6.getAttributeValue(r4)
            int r5 = java.lang.Integer.parseInt(r0)
            r0 = 9
            goto L3
        L58:
            org.xmlpull.v1.XmlPullParser r6 = (org.xmlpull.v1.XmlPullParser) r6
            java.lang.String r3 = r6.getAttributeName(r4)
            r2 = 19
            r1 = 13
            r0 = 61
            java.lang.String r0 = A06(r2, r1, r0)
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 8
            goto L3
        L71:
            r0 = 10
            goto L3
        L74:
            int r4 = r4 + 1
            r0 = 6
            goto L3
        L78:
            r5 = 0
            r0 = 9
            goto L3
        L7c:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JS.A05(org.xmlpull.v1.XmlPullParser):int");
    }

    public static void A08(Context context) {
        if (A0A()) {
            return;
        }
        A09(context);
    }

    public static void A09(Context context) {
        if (A02 != JR.A04) {
            return;
        }
        A02 = JR.A03;
        Executors.newSingleThreadExecutor().execute(new JQ(context));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0A() {
        /*
            r2 = 0
            com.facebook.ads.redexgen.X.JR r1 = com.facebook.ads.redexgen.X.JS.A02
            com.facebook.ads.redexgen.X.JR r0 = com.facebook.ads.redexgen.X.JR.A02
            if (r1 != r0) goto L12
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L14;
                case 4: goto Lf;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            r2 = 1
            r0 = 3
            goto L8
        Lf:
            r2 = 0
            r0 = 3
            goto L8
        L12:
            r0 = 4
            goto L8
        L14:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JS.A0A():boolean");
    }
}
