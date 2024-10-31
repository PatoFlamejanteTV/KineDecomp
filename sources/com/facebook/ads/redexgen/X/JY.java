package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.pm.Signature;
import android.support.annotation.Nullable;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

/* loaded from: assets/audience_network.dex */
public final class JY {
    public static byte[] A00;
    public static final String A01;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.JY.A00
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
            int r0 = r0 + (-124)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JY.A01(int, int, int):java.lang.String");
    }

    public static void A05() {
        A00 = new byte[]{-82, -14, -8, -14, -13, -28, -20, -82, -32, -17, -17, -82, -46, -12, -17, -28, -15, -12, -14, -28, -15, -83, -32, -17, -22, 42, 31, 24, 8, -35, -36, -78, -71, -76, -67, 74, 76, 10, -5, 9, 10, -61, 1, -5, 15, 9, 36, 76, 105, 105, 110, 95, 94, 26, 93, 98, 95, 93, 101, 26, 96, 91, 99, 102, 95, 94, -23, -38, -19, -31};
    }

    static {
        A05();
        A01 = JY.class.getSimpleName();
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0022 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0027 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0043 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0047 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x004c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0051 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x005c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x001a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0012  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0015  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001e A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0012 -> B:5:0x001a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0015 -> B:5:0x001a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.JX A00() {
        /*
            r5 = 0
            r6 = 0
            r4 = 0
            boolean r0 = A07()     // Catch: java.lang.Throwable -> Lb
            if (r0 != 0) goto L18
            r0 = 3
            goto L1a
        Lb:
            r4 = move-exception
            boolean r0 = com.facebook.ads.internal.api.BuildConfigApi.isDebug()
            if (r0 == 0) goto L15
            r0 = 16
            goto L1a
        L15:
            r0 = 17
            goto L1a
        L18:
            r0 = 9
        L1a:
            switch(r0) {
                case 3: goto L51;
                case 4: goto L1d;
                case 5: goto L5c;
                case 6: goto L1d;
                case 7: goto L1d;
                case 8: goto L1e;
                case 9: goto L43;
                case 10: goto L3b;
                case 11: goto L22;
                case 12: goto L1d;
                case 13: goto L47;
                case 14: goto L1d;
                case 15: goto L1d;
                case 16: goto L27;
                case 17: goto L4c;
                case 18: goto L71;
                default: goto L1d;
            }
        L1d:
            goto L1a
        L1e:
            r6 = 0
            r0 = 10
            goto L1a
        L22:
            com.facebook.ads.redexgen.X.JX r5 = com.facebook.ads.redexgen.X.JX.A03     // Catch: java.lang.Throwable -> Lb
            r0 = 18
            goto L1a
        L27:
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            java.lang.String r3 = com.facebook.ads.redexgen.X.JY.A01
            r2 = 47
            r1 = 19
            r0 = 126(0x7e, float:1.77E-43)
            java.lang.String r0 = A01(r2, r1, r0)
            android.util.Log.e(r3, r0, r4)
            r0 = 17
            goto L1a
        L3b:
            if (r6 == 0) goto L40
            r0 = 11
            goto L1a
        L40:
            r0 = 13
            goto L1a
        L43:
            r6 = 1
            r0 = 10
            goto L1a
        L47:
            com.facebook.ads.redexgen.X.JX r5 = com.facebook.ads.redexgen.X.JX.A05     // Catch: java.lang.Throwable -> Lb
            r0 = 18
            goto L1a
        L4c:
            com.facebook.ads.redexgen.X.JX r5 = com.facebook.ads.redexgen.X.JX.A04
            r0 = 18
            goto L1a
        L51:
            boolean r0 = A06()     // Catch: java.lang.Throwable -> Lb
            if (r0 != 0) goto L59
            r0 = 5
            goto L1a
        L59:
            r0 = 9
            goto L1a
        L5c:
            r2 = 35
            r1 = 2
            r0 = 91
            java.lang.String r0 = A01(r2, r1, r0)     // Catch: java.lang.Throwable -> Lb
            boolean r0 = A08(r0)     // Catch: java.lang.Throwable -> Lb
            if (r0 == 0) goto L6e
            r0 = 9
            goto L1a
        L6e:
            r0 = 8
            goto L1a
        L71:
            com.facebook.ads.redexgen.X.JX r5 = (com.facebook.ads.redexgen.X.JX) r5
            com.facebook.ads.redexgen.X.JX r5 = (com.facebook.ads.redexgen.X.JX) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JY.A00():com.facebook.ads.redexgen.X.JX");
    }

    @Nullable
    public static String A02(Context context) {
        try {
            return A03(context);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0064, code lost:            return r6.toString();     */
    @android.annotation.SuppressLint({"PackageManagerGetSignatures"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A03(android.content.Context r7) throws android.content.pm.PackageManager.NameNotFoundException, java.security.NoSuchAlgorithmException, java.security.cert.CertificateException {
        /*
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            android.content.pm.PackageManager r2 = r7.getPackageManager()
            java.lang.String r1 = r7.getPackageName()
            r0 = 64
            android.content.pm.PackageInfo r0 = r2.getPackageInfo(r1, r0)
            android.content.pm.Signature[] r5 = r0.signatures
            int r4 = r5.length
            r3 = 0
            r0 = 2
        L1c:
            switch(r0) {
                case 2: goto L20;
                case 3: goto L26;
                case 4: goto L5c;
                default: goto L1f;
            }
        L1f:
            goto L1c
        L20:
            if (r3 >= r4) goto L24
            r0 = 3
            goto L1c
        L24:
            r0 = 4
            goto L1c
        L26:
            java.lang.StringBuilder r6 = (java.lang.StringBuilder) r6
            android.content.pm.Signature[] r5 = (android.content.pm.Signature[]) r5
            r7 = r5[r3]
            r2 = 25
            r1 = 4
            r0 = 91
            java.lang.String r0 = A01(r2, r1, r0)
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r0)
            java.security.PublicKey r0 = A04(r7)
            byte[] r0 = r0.getEncoded()
            byte[] r0 = r1.digest(r0)
            java.lang.String r0 = com.facebook.ads.redexgen.X.C0488Jd.A03(r0)
            r6.append(r0)
            r2 = 29
            r1 = 1
            r0 = 38
            java.lang.String r0 = A01(r2, r1, r0)
            r6.append(r0)
            int r3 = r3 + 1
            r0 = 2
            goto L1c
        L5c:
            java.lang.StringBuilder r6 = (java.lang.StringBuilder) r6
            java.lang.String r0 = r6.toString()
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JY.A03(android.content.Context):java.lang.String");
    }

    public static PublicKey A04(Signature signature) throws CertificateException {
        return CertificateFactory.getInstance(A01(30, 5, 8)).generateCertificate(new ByteArrayInputStream(signature.toByteArray())).getPublicKey();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0029, code lost:            return r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A06() {
        /*
            r4 = 0
            r0 = 0
            java.lang.String r3 = android.os.Build.TAGS
            if (r3 == 0) goto L27
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L21;
                case 4: goto L29;
                case 5: goto L24;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            java.lang.String r3 = (java.lang.String) r3
            r2 = 37
            r1 = 9
            r0 = 26
            java.lang.String r0 = A01(r2, r1, r0)
            boolean r0 = r3.contains(r0)
            if (r0 == 0) goto L1f
            r0 = 3
            goto L7
        L1f:
            r0 = 5
            goto L7
        L21:
            r4 = 1
            r0 = 4
            goto L7
        L24:
            r4 = 0
            r0 = 4
            goto L7
        L27:
            r0 = 5
            goto L7
        L29:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JY.A06():boolean");
    }

    public static boolean A07() {
        File superUserApk = new File(A01(0, 25, 3));
        return superUserApk.exists();
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x008e, code lost:            return r8;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A08(java.lang.String r9) {
        /*
            r7 = 0
            r6 = 0
            r0 = 0
            r0 = 0
            r5 = 0
            r0 = 0
            r4 = 0
            r0 = 0
            r8 = 0
            r2 = 66
            r1 = 4
            r0 = 29
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.String r3 = java.lang.System.getenv(r0)
            r2 = 46
            r1 = 1
            r0 = 110(0x6e, float:1.54E-43)
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.String[] r3 = r3.split(r0)
            int r2 = r3.length
            r1 = r8
            r0 = 2
        L26:
            switch(r0) {
                case 2: goto L5d;
                case 3: goto L4a;
                case 4: goto L3e;
                case 5: goto L3a;
                case 6: goto L2a;
                case 7: goto L64;
                case 8: goto L6c;
                case 9: goto L73;
                case 10: goto L36;
                case 11: goto L8e;
                case 12: goto L89;
                default: goto L29;
            }
        L29:
            goto L26
        L2a:
            java.io.File r4 = (java.io.File) r4
            java.io.File[] r5 = r4.listFiles()
            if (r5 == 0) goto L34
            r0 = 7
            goto L26
        L34:
            r0 = 5
            goto L26
        L36:
            r8 = 1
            r0 = 11
            goto L26
        L3a:
            int r1 = r1 + 1
            r0 = 2
            goto L26
        L3e:
            java.io.File r4 = (java.io.File) r4
            boolean r0 = r4.isDirectory()
            if (r0 != 0) goto L48
            r0 = 5
            goto L26
        L48:
            r0 = 6
            goto L26
        L4a:
            java.lang.String[] r3 = (java.lang.String[]) r3
            r0 = r3[r1]
            java.io.File r4 = new java.io.File
            r4.<init>(r0)
            boolean r0 = r4.exists()
            if (r0 == 0) goto L5b
            r0 = 4
            goto L26
        L5b:
            r0 = 5
            goto L26
        L5d:
            if (r1 >= r2) goto L61
            r0 = 3
            goto L26
        L61:
            r0 = 11
            goto L26
        L64:
            java.io.File[] r5 = (java.io.File[]) r5
            r8 = 0
            int r6 = r5.length
            r7 = r8
            r0 = 8
            goto L26
        L6c:
            if (r7 >= r6) goto L71
            r0 = 9
            goto L26
        L71:
            r0 = 5
            goto L26
        L73:
            java.lang.String r9 = (java.lang.String) r9
            java.io.File[] r5 = (java.io.File[]) r5
            r0 = r5[r7]
            java.lang.String r0 = r0.getName()
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L86
            r0 = 10
            goto L26
        L86:
            r0 = 12
            goto L26
        L89:
            int r7 = r7 + 1
            r0 = 8
            goto L26
        L8e:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JY.A08(java.lang.String):boolean");
    }
}
