package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.facebook.ads.internal.protocol.AdErrorType;

/* renamed from: com.facebook.ads.redexgen.X.Hr, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0453Hr {
    public final AdErrorType A00;
    public final String A01;

    public C0453Hr(int i, String str) {
        this(AdErrorType.adErrorTypeFromCode(i), str);
    }

    public C0453Hr(AdErrorType adErrorType, @Nullable String str) {
        str = TextUtils.isEmpty(str) ? adErrorType.getDefaultErrorMessage() : str;
        this.A00 = adErrorType;
        this.A01 = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003e, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.AdError A00(com.facebook.ads.redexgen.X.C0453Hr r3) {
        /*
            r2 = 0
            com.facebook.ads.internal.protocol.AdErrorType r0 = r3.A04()
            boolean r0 = r0.isPublicError()
            if (r0 == 0) goto L38
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L3a;
                case 4: goto L25;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            com.facebook.ads.redexgen.X.Hr r3 = (com.facebook.ads.redexgen.X.C0453Hr) r3
            com.facebook.ads.AdError r2 = new com.facebook.ads.AdError
            com.facebook.ads.internal.protocol.AdErrorType r0 = r3.A04()
            int r1 = r0.getErrorCode()
            java.lang.String r0 = r3.A05()
            r2.<init>(r1, r0)
            r0 = 3
            goto Lc
        L25:
            com.facebook.ads.AdError r2 = new com.facebook.ads.AdError
            com.facebook.ads.internal.protocol.AdErrorType r0 = com.facebook.ads.internal.protocol.AdErrorType.UNKNOWN_ERROR
            int r1 = r0.getErrorCode()
            com.facebook.ads.internal.protocol.AdErrorType r0 = com.facebook.ads.internal.protocol.AdErrorType.UNKNOWN_ERROR
            java.lang.String r0 = r0.getDefaultErrorMessage()
            r2.<init>(r1, r0)
            r0 = 3
            goto Lc
        L38:
            r0 = 4
            goto Lc
        L3a:
            com.facebook.ads.AdError r2 = (com.facebook.ads.AdError) r2
            com.facebook.ads.AdError r2 = (com.facebook.ads.AdError) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0453Hr.A00(com.facebook.ads.redexgen.X.Hr):com.facebook.ads.AdError");
    }

    public static C0453Hr A01(AdErrorType adErrorType) {
        return new C0453Hr(adErrorType, (String) null);
    }

    public static C0453Hr A02(AdErrorType adErrorType, @Nullable String str) {
        return new C0453Hr(adErrorType, str);
    }

    public static C0453Hr A03(C0454Hs c0454Hs) {
        return new C0453Hr(c0454Hs.A00(), c0454Hs.A01());
    }

    public final AdErrorType A04() {
        return this.A00;
    }

    public final String A05() {
        return this.A01;
    }
}
