package com.facebook.ads.redexgen.X;

import android.content.pm.Signature;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: assets/audience_network.dex */
public class BJ implements BI<Integer> {
    public static byte[] A02;
    public final String A00;
    public final String A01;

    static {
        A03();
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
            byte[] r1 = com.facebook.ads.redexgen.X.BJ.A02
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
            int r0 = r0 + (-8)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.BJ.A00(int, int, int):java.lang.String");
    }

    public static void A03() {
        A02 = new byte[]{-77, 113, -122, 92, 99, 94, 103, -15, -80};
    }

    public BJ(Signature signature) throws CertificateException, NoSuchAlgorithmException {
        this.A00 = A01(signature, EI.A04);
        this.A01 = A01(signature, EI.A05);
    }

    public static String A01(Signature signature, EI ei) throws NoSuchAlgorithmException, CertificateException {
        InputStream input = new ByteArrayInputStream(signature.toByteArray());
        return EJ.A08(((X509Certificate) CertificateFactory.getInstance(A00(2, 5, 38)).generateCertificate(input)).getEncoded(), ei);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.BI
    /* renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final JSONObject A8S(Integer num, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(A00(0, 2, 56), this.A00);
        jSONObject2.put(A00(7, 2, 118), this.A01);
        jSONObject.put(Integer.toString(num.intValue()), jSONObject2);
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0044, code lost:            return r2;     */
    @Override // com.facebook.ads.redexgen.X.BI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A5B(java.lang.Object r5) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.BJ r5 = (com.facebook.ads.redexgen.X.BJ) r5
            java.lang.String r0 = r3.A00
            if (r0 == 0) goto L42
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L30;
                case 3: goto L23;
                case 4: goto L11;
                case 5: goto Le;
                case 6: goto L44;
                case 7: goto L2d;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            r2 = 1
            r0 = 6
            goto La
        L11:
            com.facebook.ads.redexgen.X.BJ r3 = (com.facebook.ads.redexgen.X.BJ) r3
            com.facebook.ads.redexgen.X.BJ r5 = (com.facebook.ads.redexgen.X.BJ) r5
            java.lang.String r1 = r3.A01
            java.lang.String r0 = r5.A01
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L21
            r0 = 5
            goto La
        L21:
            r0 = 7
            goto La
        L23:
            com.facebook.ads.redexgen.X.BJ r3 = (com.facebook.ads.redexgen.X.BJ) r3
            java.lang.String r0 = r3.A01
            if (r0 == 0) goto L2b
            r0 = 4
            goto La
        L2b:
            r0 = 7
            goto La
        L2d:
            r2 = 0
            r0 = 6
            goto La
        L30:
            com.facebook.ads.redexgen.X.BJ r3 = (com.facebook.ads.redexgen.X.BJ) r3
            com.facebook.ads.redexgen.X.BJ r5 = (com.facebook.ads.redexgen.X.BJ) r5
            java.lang.String r1 = r3.A00
            java.lang.String r0 = r5.A00
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L40
            r0 = 3
            goto La
        L40:
            r0 = 7
            goto La
        L42:
            r0 = 7
            goto La
        L44:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.BJ.A5B(java.lang.Object):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0032, code lost:            return r2 + r1;     */
    @Override // com.facebook.ads.redexgen.X.BI
    @android.annotation.SuppressLint({"BadMethodUse-java.lang.String.length"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A8O() {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            r0 = 0
            r1 = 0
            java.lang.String r0 = r3.A01
            if (r0 == 0) goto L2f
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L17;
                case 4: goto L21;
                case 5: goto L31;
                case 6: goto L2b;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.BJ r3 = (com.facebook.ads.redexgen.X.BJ) r3
            java.lang.String r0 = r3.A01
            int r2 = r0.length()
            r0 = 3
            goto L9
        L17:
            com.facebook.ads.redexgen.X.BJ r3 = (com.facebook.ads.redexgen.X.BJ) r3
            java.lang.String r0 = r3.A00
            if (r0 == 0) goto L1f
            r0 = 4
            goto L9
        L1f:
            r0 = 5
            goto L9
        L21:
            com.facebook.ads.redexgen.X.BJ r3 = (com.facebook.ads.redexgen.X.BJ) r3
            java.lang.String r0 = r3.A00
            int r1 = r0.length()
            r0 = 5
            goto L9
        L2b:
            r1 = 0
            r2 = r1
            r0 = 3
            goto L9
        L2f:
            r0 = 6
            goto L9
        L31:
            int r2 = r2 + r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.BJ.A8O():int");
    }
}
