package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.Cf, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0313Cf implements FN {
    public int A00;

    @Nullable
    public String A01;

    @Nullable
    public Map<String, List<String>> A02;

    @Nullable
    public byte[] A03;

    public C0313Cf(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            this.A00 = httpURLConnection.getResponseCode();
            this.A01 = httpURLConnection.getURL().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.A02 = httpURLConnection.getHeaderFields();
        this.A03 = bArr;
    }

    @Override // com.facebook.ads.redexgen.X.FN
    @Nullable
    public final byte[] A4L() {
        return this.A03;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001d, code lost:            return r1;     */
    @Override // com.facebook.ads.redexgen.X.FN
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String A4M() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            byte[] r0 = r2.A03
            if (r0 == 0) goto L19
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L1b;
                case 4: goto L16;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.Cf r2 = (com.facebook.ads.redexgen.X.C0313Cf) r2
            java.lang.String r1 = new java.lang.String
            byte[] r0 = r2.A03
            r1.<init>(r0)
            r0 = 3
            goto L7
        L16:
            r1 = 0
            r0 = 3
            goto L7
        L19:
            r0 = 4
            goto L7
        L1b:
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0313Cf.A4M():java.lang.String");
    }

    @Override // com.facebook.ads.redexgen.X.FN
    @Nullable
    public final Map<String, List<String>> A4i() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.FN
    public final int A50() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.FN
    @Nullable
    public final String getUrl() {
        return this.A01;
    }
}
