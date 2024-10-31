package com.facebook.ads.redexgen.X;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

/* renamed from: com.facebook.ads.redexgen.X.9i, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C02399i {
    public static byte[] A00;

    static {
        A02();
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
            byte[] r1 = com.facebook.ads.redexgen.X.C02399i.A00
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
            r0 = r0 ^ 31
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02399i.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A00 = new byte[]{82, 90, 87, 113, 125, 124, 102, 119, 124, 102, 40, 61, 61, 113, 125, Byte.MAX_VALUE, 60, 116, 115, 113, 119, 112, 125, 125, 121, 60, 121, 115, 102, 115, 124, 115, 60, 98, 96, 125, 100, 123, 118, 119, 96, 60, 83, 102, 102, 96, 123, 112, 103, 102, 123, 125, 124, 91, 118, 66, 96, 125, 100, 123, 118, 119, 96, 10, 5, 15, 25, 4, 2, 15, 2, 15, 107, 110, 106, 110, 115, 88, 115, 117, 102, 100, 108, 110, 105, 96};
    }

    public static C02389h A00(ContentResolver contentResolver) {
        C02389h c02389h;
        Cursor cursor = null;
        try {
            Cursor query = contentResolver.query(Uri.parse(A01(3, 60, 13)), new String[]{A01(0, 3, 44), A01(63, 9, 116), A01(72, 14, 24)}, null, null, null);
            if (query == null || !query.moveToFirst()) {
                c02389h = new C02389h(null, null, false);
                if (query != null) {
                    query.close();
                }
            } else {
                String string = query.getString(query.getColumnIndex(A01(0, 3, 44)));
                String attributionId = A01(63, 9, 116);
                String string2 = query.getString(query.getColumnIndex(attributionId));
                String attributionId2 = A01(72, 14, 24);
                c02389h = new C02389h(string, string2, Boolean.valueOf(query.getString(query.getColumnIndex(attributionId2))).booleanValue());
                if (query != null) {
                    query.close();
                }
            }
            return c02389h;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }
}
