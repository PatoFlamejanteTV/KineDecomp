package com.facebook.ads.redexgen.X;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.UUID;

/* loaded from: assets/audience_network.dex */
public final class F1 extends AbstractC0376Eq {
    public static byte[] A00;
    public static final C0375Ep A01;
    public static final C0375Ep A02;
    public static final C0375Ep[] A03;
    public static final String A04;
    public static final String A05;
    public static final String A06;
    public static final String A07;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.F1.A00
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
            int r0 = r0 + (-62)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.F1.A00(int, int, int):java.lang.String");
    }

    public static void A04() {
        A00 = new byte[]{39, 34, 30, 24, 33, 38, -75, -58, -75, -66, -60, -61, -56, -15, -14, -7, -14, 1, -14, -51, -13, -1, -4, -6, -51, 33, 28, 24, 18, 27, 32, -51, 4, -11, -14, -1, -14, -51, -5, -4, 1, -51, -14, 5, -10, 0, 1, 0, -51, -43, 0, -14, -7, -14, -16, 1, -51, -34, -51, -13, -1, -4, -6, -51, 18, 35, 18, 27, 33, 32, -51, 4, -11, -14, -1, -14, -51, 33, 28, 24, 18, 27, 32, -37, -83, -110, -81, -110, 12, -3, 16, 12, -61, -66, -70, -76, -67, -82, -72, -77, -11, -26, -7, -11, -63, -15, -13, -22, -18, -30, -13, -6, -63, -20, -26, -6, -19, 18, 26, 5, 16, 13, 8, -60, 24, 19, 15, 9, 18, -46, -3, 48, 27, 29, 40, 44, 33, 39, 38, -40, 47, 32, 29, 38, -40, 44, 42, 49, 33, 38, 31, -40, 44, 39, -40, 28, 29, 36, 29, 44, 29, -40, 27, 32, 33, 36, 28, 36, 29, 43, 43, -40, 44, 39, 35, 29, 38, 43, -26, -59, -64, -68, -74, -65};
    }

    static {
        A04();
        A02 = new C0375Ep(0, A00(92, 8, 17), A00(100, 16, 99));
        A01 = new C0375Ep(1, A00(179, 5, 19), A00(88, 4, 122));
        A03 = new C0375Ep[]{A02, A01};
        A07 = F1.class.getSimpleName();
        A05 = AbstractC0376Eq.A02(A00(0, 6, 117), A03);
        A06 = AbstractC0376Eq.A03(A00(0, 6, 117), A03, A01);
        A04 = A00(13, 71, 111) + A02.A01 + A00(85, 3, 52) + A00(6, 6, 18) + A00(84, 1, 65) + C0377Er.A08.A01 + A00(12, 1, 97);
    }

    public F1(C0382Ew c0382Ew) {
        super(c0382Ew);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0376Eq
    public final String A06() {
        return A00(0, 6, 117);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0376Eq
    public final C0375Ep[] A0A() {
        return A03;
    }

    public final Cursor A0B() {
        return A05().rawQuery(A05, null);
    }

    public final String A0C(String str) throws IllegalArgumentException, SQLiteException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(A00(116, 14, 102));
        }
        Cursor cursor = null;
        try {
            cursor = A05().rawQuery(A06, new String[]{str});
            String existingTokenId = cursor.moveToNext() ? cursor.getString(A02.A00) : null;
            if (!TextUtils.isEmpty(existingTokenId)) {
                if (cursor != null) {
                    cursor.close();
                }
            } else {
                existingTokenId = UUID.randomUUID().toString();
                ContentValues contentValues = new ContentValues(2);
                String newTokenId = A02.A01;
                contentValues.put(newTokenId, existingTokenId);
                String newTokenId2 = A01.A01;
                contentValues.put(newTokenId2, str);
                A05().insertOrThrow(A00(0, 6, 117), null, contentValues);
            }
            return existingTokenId;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final void A0D() {
        try {
            A05().execSQL(A04);
        } catch (SQLException e) {
            if (BuildConfigApi.isDebug()) {
                Log.e(A07, A00(130, 49, 122), e);
            }
        }
    }
}
