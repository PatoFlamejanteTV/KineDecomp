package com.facebook.ads.redexgen.X;

import java.util.HashMap;
import java.util.Map;

/* loaded from: assets/audience_network.dex */
public final class FO {
    public float A00;
    public EnumC00040b A01;
    public Map<String, String> A02;

    public FO(EnumC00040b enumC00040b) {
        this(enumC00040b, 0.0f);
    }

    public FO(EnumC00040b enumC00040b, float f) {
        this(enumC00040b, f, null);
    }

    public FO(EnumC00040b enumC00040b, float f, Map<String, String> map) {
        this.A01 = enumC00040b;
        this.A00 = f;
        if (map != null) {
            this.A02 = map;
        } else {
            Map<String, String> windowParams = new HashMap<>();
            this.A02 = windowParams;
        }
    }

    public final float A00() {
        return this.A00;
    }

    public final int A01() {
        return this.A01.A02();
    }

    public final EnumC00040b A02() {
        return this.A01;
    }

    public final Map<String, String> A03() {
        return this.A02;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A04() {
        /*
            r3 = this;
            r2 = 0
            com.facebook.ads.redexgen.X.0b r1 = r3.A01
            com.facebook.ads.redexgen.X.0b r0 = com.facebook.ads.redexgen.X.EnumC00040b.A0I
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FO.A04():boolean");
    }
}
