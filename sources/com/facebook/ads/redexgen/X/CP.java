package com.facebook.ads.redexgen.X;

import java.io.File;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: assets/audience_network.dex */
public class CP implements BI<String> {
    public static byte[] A04;
    public final int A00;
    public final long A01;
    public final long A02;

    @Nullable
    public final File A03;

    static {
        A03();
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
            byte[] r1 = com.facebook.ads.redexgen.X.CP.A04
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
            r0 = r0 ^ 108(0x6c, float:1.51E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.CP.A01(int, int, int):java.lang.String");
    }

    public static void A03() {
        A04 = new byte[]{94, 87, 92, 94, 95, 70, 47, 58, 58};
    }

    public CP(@Nullable File file) {
        this.A03 = file;
        this.A01 = file != null ? file.lastModified() : 0L;
        this.A02 = file != null ? file.length() : 0L;
        this.A00 = A00(file);
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0062, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A00(@javax.annotation.Nullable java.io.File r2) {
        /*
            r1 = 0
            if (r2 == 0) goto L60
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L2f;
                case 3: goto L19;
                case 4: goto L62;
                case 5: goto L8;
                case 6: goto L2a;
                case 7: goto L40;
                case 8: goto L3b;
                case 9: goto L1c;
                case 10: goto L5b;
                case 11: goto L4e;
                case 12: goto L15;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            java.io.File r2 = (java.io.File) r2
            r1 = 0
            boolean r0 = r2.isFile()
            if (r0 == 0) goto L13
            r0 = 6
            goto L4
        L13:
            r0 = 7
            goto L4
        L15:
            r1 = r1 | 8
            r0 = 4
            goto L4
        L19:
            r1 = 0
            r0 = 4
            goto L4
        L1c:
            java.io.File r2 = (java.io.File) r2
            boolean r0 = r2.isAbsolute()
            if (r0 == 0) goto L27
            r0 = 10
            goto L4
        L27:
            r0 = 11
            goto L4
        L2a:
            r0 = 0
            r1 = r0 | 1
            r0 = 7
            goto L4
        L2f:
            java.io.File r2 = (java.io.File) r2
            boolean r0 = r2.exists()
            if (r0 != 0) goto L39
            r0 = 3
            goto L4
        L39:
            r0 = 5
            goto L4
        L3b:
            r1 = r1 | 2
            r0 = 9
            goto L4
        L40:
            java.io.File r2 = (java.io.File) r2
            boolean r0 = r2.isDirectory()
            if (r0 == 0) goto L4b
            r0 = 8
            goto L4
        L4b:
            r0 = 9
            goto L4
        L4e:
            java.io.File r2 = (java.io.File) r2
            boolean r0 = r2.isHidden()
            if (r0 == 0) goto L59
            r0 = 12
            goto L4
        L59:
            r0 = 4
            goto L4
        L5b:
            r1 = r1 | 4
            r0 = 11
            goto L4
        L60:
            r0 = 3
            goto L4
        L62:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.CP.A00(java.io.File):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.BI
    /* renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final JSONObject A8S(String str, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(A01(6, 3, 34), this.A00);
        jSONObject2.put(A01(0, 3, 94), this.A02);
        jSONObject2.put(A01(3, 3, 94), this.A01);
        jSONObject.put(str, jSONObject2);
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0067, code lost:            return r6;     */
    @Override // com.facebook.ads.redexgen.X.BI
    @android.annotation.SuppressLint({"BadMethodUse-java.io.File.getAbsolutePath"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A5B(java.lang.Object r8) {
        /*
            r7 = this;
            r5 = r7
            r0 = 0
            r0 = 0
            r6 = 0
            com.facebook.ads.redexgen.X.CP r8 = (com.facebook.ads.redexgen.X.CP) r8
            java.io.File r0 = r5.A03
            if (r0 == 0) goto L65
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto L4a;
                case 3: goto L67;
                case 4: goto L30;
                case 5: goto L1f;
                case 6: goto Lf;
                case 7: goto L54;
                case 8: goto L2d;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.CP r5 = (com.facebook.ads.redexgen.X.CP) r5
            com.facebook.ads.redexgen.X.CP r8 = (com.facebook.ads.redexgen.X.CP) r8
            long r3 = r5.A02
            long r1 = r8.A02
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 != 0) goto L1d
            r0 = 7
            goto Lb
        L1d:
            r0 = 3
            goto Lb
        L1f:
            com.facebook.ads.redexgen.X.CP r5 = (com.facebook.ads.redexgen.X.CP) r5
            com.facebook.ads.redexgen.X.CP r8 = (com.facebook.ads.redexgen.X.CP) r8
            int r1 = r5.A00
            int r0 = r8.A00
            if (r1 != r0) goto L2b
            r0 = 6
            goto Lb
        L2b:
            r0 = 3
            goto Lb
        L2d:
            r6 = 1
            r0 = 3
            goto Lb
        L30:
            com.facebook.ads.redexgen.X.CP r5 = (com.facebook.ads.redexgen.X.CP) r5
            com.facebook.ads.redexgen.X.CP r8 = (com.facebook.ads.redexgen.X.CP) r8
            java.io.File r0 = r5.A03
            java.lang.String r1 = r0.getAbsolutePath()
            java.io.File r0 = r8.A03
            java.lang.String r0 = r0.getAbsolutePath()
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L48
            r0 = 5
            goto Lb
        L48:
            r0 = 3
            goto Lb
        L4a:
            com.facebook.ads.redexgen.X.CP r8 = (com.facebook.ads.redexgen.X.CP) r8
            java.io.File r0 = r8.A03
            if (r0 != 0) goto L52
            r0 = 3
            goto Lb
        L52:
            r0 = 4
            goto Lb
        L54:
            com.facebook.ads.redexgen.X.CP r5 = (com.facebook.ads.redexgen.X.CP) r5
            com.facebook.ads.redexgen.X.CP r8 = (com.facebook.ads.redexgen.X.CP) r8
            long r3 = r5.A01
            long r1 = r8.A01
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 != 0) goto L63
            r0 = 8
            goto Lb
        L63:
            r0 = 3
            goto Lb
        L65:
            r0 = 3
            goto Lb
        L67:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.CP.A5B(java.lang.Object):boolean");
    }

    @Override // com.facebook.ads.redexgen.X.BI
    public final int A8O() {
        return A01(6, 3, 34).getBytes().length + A01(0, 3, 94).getBytes().length + A01(3, 3, 94).getBytes().length + 4 + 16;
    }
}
