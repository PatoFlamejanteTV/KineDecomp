package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.5R, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C5R implements InterfaceC01455p {
    public static byte[] A05;

    @Nullable
    public JSONObject A00;

    @Nullable
    public JSONObject A01;
    public final EnumC01345d A03;
    public final List<C9X> A04 = new ArrayList();
    public boolean A02 = false;

    static {
        A03();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C5R.A05
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
            r0 = r0 ^ 61
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5R.A02(int, int, int):java.lang.String");
    }

    public static void A03() {
        A05 = new byte[]{96, 87, 76, 70, 78, 71, 2, 74, 67, 81, 2, 76, 77, 2, 68, 75, 76, 69, 71, 80, 82, 80, 75, 76, 86, 49, 62, 57, 48, 50, 37, 39, 37, 62, 57, 35, 119, 118, 106, 119, 57, 34, 59, 59, 86, 77, 84, 84, 70, 73, 78, 71, 69, 82, 80, 82, 73, 78, 84, 0, 29, 29, 0, 78, 85, 76, 76, 115, 68, 95, 85, 93, 84, 17, 88, 66, 17, 95, 94, 69, 17, 67, 84, 80, 85, 72, 55, 50, 39, 50, 115, 110, 110, 115, 61, 38, 63, 63, 122, 77, 86, 92, 84, 93, 24, 29, 75, 24, 92, 89, 76, 89, 24, 77, 72, 92, 89, 76, 93, 2, 50, 18, 18, 24, 92, 89, 76, 89, 24, 18, 18, 50, 29, 75, 50, 18, 18, 24, 94, 81, 86, 95, 93, 74, 72, 74, 81, 86, 76, 24, 18, 18, 50, 29, 75};
    }

    public C5R(EnumC01345d enumC01345d) {
        this.A03 = enumC01345d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x003a, code lost:            return r0;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A04(@android.support.annotation.Nullable org.json.JSONObject r3, @android.support.annotation.Nullable org.json.JSONObject r4) {
        /*
            r2 = this;
            r0 = 0
            r0 = 0
            r0 = 1
            r1 = 0
            if (r3 != 0) goto L38
            r1 = 2
        L7:
            switch(r1) {
                case 2: goto L2d;
                case 3: goto L2a;
                case 4: goto L3a;
                case 5: goto L22;
                case 6: goto Lb;
                case 7: goto L13;
                case 8: goto L35;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            if (r4 == 0) goto L11
            r1 = 7
            goto L7
        L11:
            r1 = 4
            goto L7
        L13:
            org.json.JSONObject r3 = (org.json.JSONObject) r3
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            boolean r1 = com.facebook.ads.redexgen.X.AnonymousClass64.A02(r3, r4)
            if (r1 == 0) goto L20
            r1 = 8
            goto L7
        L20:
            r1 = 4
            goto L7
        L22:
            org.json.JSONObject r3 = (org.json.JSONObject) r3
            if (r3 == 0) goto L28
            r1 = 6
            goto L7
        L28:
            r1 = 4
            goto L7
        L2a:
            r0 = 0
            r1 = 4
            goto L7
        L2d:
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            if (r4 != 0) goto L33
            r1 = 3
            goto L7
        L33:
            r1 = 5
            goto L7
        L35:
            r0 = 0
            r1 = 4
            goto L7
        L38:
            r1 = 5
            goto L7
        L3a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5R.A04(org.json.JSONObject, org.json.JSONObject):boolean");
    }

    public final synchronized boolean A05(JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        boolean z = false;
        synchronized (this) {
            if (jSONObject == null) {
                throw new IllegalArgumentException(A02(86, 12, 110));
            }
            if (jSONObject2 == null && this.A03.A04()) {
                throw new IllegalArgumentException(A02(48, 19, 29));
            }
            if (jSONObject2 != null && !this.A03.A04()) {
                throw new IllegalArgumentException(A02(25, 19, 106));
            }
            if (A04(this.A00, jSONObject) || A04(this.A01, jSONObject2)) {
                this.A00 = jSONObject;
                this.A01 = jSONObject2;
                this.A02 = true;
                Iterator<C9X> it = this.A04.iterator();
                while (it.hasNext()) {
                    it.next().A3d();
                }
                try {
                    Locale locale = Locale.US;
                    String A02 = A02(98, 57, 5);
                    Object[] objArr = new Object[3];
                    objArr[0] = this.A03;
                    objArr[1] = this.A00 == null ? A02(44, 4, 5) : this.A00.toString(2);
                    objArr[2] = this.A01 == null ? A02(44, 4, 5) : this.A01.toString(2);
                    String.format(locale, A02, objArr);
                } catch (JSONException unused) {
                }
                z = true;
            }
        }
        return z;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC01455p
    public final synchronized void A36(C9X c9x) {
        this.A04.add(c9x);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC01455p
    public final synchronized JSONObject A4X() {
        if (this.A00 == null) {
            throw new IllegalStateException(A02(67, 19, 12));
        }
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC01455p
    public final synchronized JSONObject A4g() {
        if (!this.A03.A04()) {
            throw new IllegalStateException(A02(0, 25, 31));
        }
        if (this.A01 == null) {
            throw new IllegalStateException(A02(67, 19, 12));
        }
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC01455p
    public final EnumC01345d A4j() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC01455p
    public final synchronized boolean A5G() {
        return this.A02;
    }
}
