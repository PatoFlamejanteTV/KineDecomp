package com.facebook.ads.redexgen.X;

import android.content.Context;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: assets/audience_network.dex */
public class DC implements BI<String> {
    public final String A00;

    @Nullable
    public final String A01;

    public DC(Context context, String str, DB db) {
        this.A00 = str;
        this.A01 = A03(context, str, db);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0021, code lost:            return r2;     */
    @javax.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(android.content.Context r3, java.lang.String r4) {
        /*
            r2 = 0
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 17
            if (r1 >= r0) goto L1d
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L1f;
                case 4: goto Lf;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            r2 = 0
            r0 = 3
            goto L8
        Lf:
            android.content.Context r3 = (android.content.Context) r3
            java.lang.String r4 = (java.lang.String) r4
            android.content.ContentResolver r0 = r3.getContentResolver()
            java.lang.String r2 = android.provider.Settings.Global.getString(r0, r4)
            r0 = 3
            goto L8
        L1d:
            r0 = 4
            goto L8
        L1f:
            java.lang.String r2 = (java.lang.String) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.DC.A00(android.content.Context, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0021, code lost:            return r2;     */
    @javax.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(android.content.Context r3, java.lang.String r4) {
        /*
            r2 = 0
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 17
            if (r1 >= r0) goto L1d
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L1f;
                case 4: goto Lf;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            r2 = 0
            r0 = 3
            goto L8
        Lf:
            android.content.Context r3 = (android.content.Context) r3
            java.lang.String r4 = (java.lang.String) r4
            android.content.ContentResolver r0 = r3.getContentResolver()
            java.lang.String r2 = android.provider.Settings.Secure.getString(r0, r4)
            r0 = 3
            goto L8
        L1d:
            r0 = 4
            goto L8
        L1f:
            java.lang.String r2 = (java.lang.String) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.DC.A01(android.content.Context, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0021, code lost:            return r2;     */
    @javax.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(android.content.Context r3, java.lang.String r4) {
        /*
            r2 = 0
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 17
            if (r1 >= r0) goto L1d
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L1f;
                case 4: goto Lf;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            r2 = 0
            r0 = 3
            goto L8
        Lf:
            android.content.Context r3 = (android.content.Context) r3
            java.lang.String r4 = (java.lang.String) r4
            android.content.ContentResolver r0 = r3.getContentResolver()
            java.lang.String r2 = android.provider.Settings.System.getString(r0, r4)
            r0 = 3
            goto L8
        L1d:
            r0 = 4
            goto L8
        L1f:
            java.lang.String r2 = (java.lang.String) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.DC.A02(android.content.Context, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003d, code lost:            return r2;     */
    @javax.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A03(android.content.Context r3, java.lang.String r4, com.facebook.ads.redexgen.X.DB r5) {
        /*
            r2 = 0
            int[] r1 = com.facebook.ads.redexgen.X.DA.A00
            int r0 = r5.ordinal()
            r0 = r1[r0]
            switch(r0) {
                case 1: goto L37;
                case 2: goto L35;
                case 3: goto L33;
                default: goto Lc;
            }
        Lc:
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L39;
                case 4: goto L15;
                case 5: goto L1f;
                case 6: goto L29;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            java.lang.String r2 = ""
            r0 = 3
            goto Ld
        L15:
            android.content.Context r3 = (android.content.Context) r3
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r2 = A00(r3, r4)
            r0 = 3
            goto Ld
        L1f:
            android.content.Context r3 = (android.content.Context) r3
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r2 = A01(r3, r4)
            r0 = 3
            goto Ld
        L29:
            android.content.Context r3 = (android.content.Context) r3
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r2 = A02(r3, r4)
            r0 = 3
            goto Ld
        L33:
            r0 = 6
            goto Ld
        L35:
            r0 = 5
            goto Ld
        L37:
            r0 = 4
            goto Ld
        L39:
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = (java.lang.String) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.DC.A03(android.content.Context, java.lang.String, com.facebook.ads.redexgen.X.DB):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.BI
    /* renamed from: A04, reason: merged with bridge method [inline-methods] */
    public final JSONObject A8S(String str, JSONObject jSONObject) throws JSONException {
        jSONObject.put(this.A00, this.A01);
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x00ac, code lost:            return r3;     */
    @Override // com.facebook.ads.redexgen.X.BI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A5B(java.lang.Object r6) {
        /*
            Method dump skipped, instructions count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.DC.A5B(java.lang.Object):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x002d, code lost:            return r1;     */
    @Override // com.facebook.ads.redexgen.X.BI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A8O() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            java.lang.String r0 = r2.A00
            if (r0 == 0) goto L2b
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L15;
                case 4: goto L2d;
                case 5: goto L28;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.DC r2 = (com.facebook.ads.redexgen.X.DC) r2
            java.lang.String r0 = r2.A01
            if (r0 == 0) goto L13
            r0 = 3
            goto L7
        L13:
            r0 = 5
            goto L7
        L15:
            com.facebook.ads.redexgen.X.DC r2 = (com.facebook.ads.redexgen.X.DC) r2
            java.lang.String r0 = r2.A00
            byte[] r0 = r0.getBytes()
            int r1 = r0.length
            java.lang.String r0 = r2.A01
            byte[] r0 = r0.getBytes()
            int r0 = r0.length
            int r1 = r1 + r0
            r0 = 4
            goto L7
        L28:
            r1 = 0
            r0 = 4
            goto L7
        L2b:
            r0 = 5
            goto L7
        L2d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.DC.A8O():int");
    }
}
