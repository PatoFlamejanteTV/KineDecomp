package com.facebook.ads.redexgen.X;

import android.content.pm.PackageManager;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: assets/audience_network.dex */
public class CF implements BI<String> {
    public final String A00;
    public final boolean A01;

    public CF(String str) {
        PackageManager packageManager;
        this.A00 = str;
        packageManager = CG.A00;
        this.A01 = packageManager.hasSystemFeature(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.BI
    /* renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final JSONObject A8S(String str, JSONObject jSONObject) throws JSONException {
        jSONObject.put(this.A00, this.A01);
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x002a, code lost:            return r2;     */
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
            com.facebook.ads.redexgen.X.CF r5 = (com.facebook.ads.redexgen.X.CF) r5
            java.lang.String r1 = r3.A00
            java.lang.String r0 = r5.A00
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L28
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L14;
                case 3: goto L22;
                case 4: goto L2a;
                case 5: goto L25;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            com.facebook.ads.redexgen.X.CF r3 = (com.facebook.ads.redexgen.X.CF) r3
            com.facebook.ads.redexgen.X.CF r5 = (com.facebook.ads.redexgen.X.CF) r5
            boolean r1 = r3.A01
            boolean r0 = r5.A01
            if (r1 != r0) goto L20
            r0 = 3
            goto L10
        L20:
            r0 = 5
            goto L10
        L22:
            r2 = 1
            r0 = 4
            goto L10
        L25:
            r2 = 0
            r0 = 4
            goto L10
        L28:
            r0 = 5
            goto L10
        L2a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.CF.A5B(java.lang.Object):boolean");
    }

    @Override // com.facebook.ads.redexgen.X.BI
    public final int A8O() {
        return this.A00.getBytes().length + 8;
    }
}
