package com.facebook.ads.redexgen.X;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: com.facebook.ads.redexgen.X.Ex, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0383Ex extends SQLiteOpenHelper {
    public static byte[] A01;
    public static final String A02;
    public final C0382Ew A00;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0383Ex.A01
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
            r0 = r0 ^ 104(0x68, float:1.46E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0383Ex.A00(int, int, int):java.lang.String");
    }

    public static void A02() {
        A01 = new byte[]{20, 78, 88, 69, 90, 42, 94, 75, 72, 70, 79, 42, 67, 76, 42, 79, 82, 67, 89, 94, 89, 42, 105, 120, 107, 121, 98, 111, 121, 50, 55, 32, 118, 32, 125, 55, 49, 57, 28, 60, 25, 12, 25, 26, 25, 11, 29, 48, 29, 20, 8, 29, 10, 88, 27, 25, 22, 88, 22, 23, 12, 88, 26, 29, 88, 22, 13, 20, 20, 42, 40, 59, 61, 55, 59, 90, 28, 21, 8, 31, 19, 29, 20, 37, 17, 31, 3, 9, 90, 71, 90, 53, 52, 65, 51, 62, 38, 55, 32, 82, 38, 51, 48, 62, 55, 82, 23, 4, 23, 28, 6, 1, 82, 51, 54, 54, 82, 49, 61, 62, 39, 63, 60, 82, 32, 68, 69, 70, 65, 85, 76, 84, 32, 48};
    }

    static {
        A02();
        A02 = C0383Ex.class.getSimpleName();
    }

    public C0383Ex(C0365Ef c0365Ef, C0382Ew c0382Ew) {
        super(c0365Ef, A01(c0365Ef), (SQLiteDatabase.CursorFactory) null, 4);
        if (c0382Ew == null) {
            throw new IllegalArgumentException(A00(37, 32, 16));
        }
        this.A00 = c0382Ew;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x007e, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(com.facebook.ads.redexgen.X.C0365Ef r9) {
        /*
            r0 = 0
            r0 = 0
            r6 = 0
            r0 = 0
            r5 = 1
            r8 = 0
            java.util.Locale r7 = java.util.Locale.US
            r2 = 29
            r1 = 8
            r0 = 59
            java.lang.String r4 = A00(r2, r1, r0)
            java.lang.Object[] r3 = new java.lang.Object[r5]
            r2 = 1
            r1 = 0
            r0 = 41
            java.lang.String r0 = A00(r2, r1, r0)
            r3[r8] = r0
            java.lang.String r1 = java.lang.String.format(r7, r4, r3)
            boolean r0 = com.facebook.ads.redexgen.X.C0413Gc.A1B(r9)
            if (r0 != 0) goto L78
            r0 = 2
        L29:
            switch(r0) {
                case 2: goto L7a;
                case 3: goto L2d;
                case 4: goto L41;
                case 5: goto L4d;
                default: goto L2c;
            }
        L2c:
            goto L29
        L2d:
            com.facebook.ads.redexgen.X.Ef r9 = (com.facebook.ads.redexgen.X.C0365Ef) r9
            java.lang.String r0 = r9.getPackageName()
            java.lang.String r6 = com.facebook.ads.internal.util.process.ProcessUtils.getProcessName(r9)
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L3f
            r0 = 4
            goto L29
        L3f:
            r0 = 2
            goto L29
        L41:
            java.lang.String r6 = (java.lang.String) r6
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto L4b
            r0 = 5
            goto L29
        L4b:
            r0 = 2
            goto L29
        L4d:
            java.lang.String r6 = (java.lang.String) r6
            java.util.Locale r4 = java.util.Locale.US
            r2 = 29
            r1 = 8
            r0 = 59
            java.lang.String r3 = A00(r2, r1, r0)
            java.lang.Object[] r2 = new java.lang.Object[r5]
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r0 = 95
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.StringBuilder r0 = r0.append(r6)
            java.lang.String r0 = r0.toString()
            r2[r8] = r0
            java.lang.String r1 = java.lang.String.format(r4, r3, r2)
            r0 = 2
            goto L29
        L78:
            r0 = 3
            goto L29
        L7a:
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0383Ex.A01(com.facebook.ads.redexgen.X.Ef):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0023, code lost:            return;     */
    @Override // android.database.sqlite.SQLiteOpenHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onCreate(android.database.sqlite.SQLiteDatabase r5) {
        /*
            r4 = this;
            r0 = 0
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.Ew r0 = r4.A00
            com.facebook.ads.redexgen.X.Eq[] r3 = r0.A0M()
            int r2 = r3.length
            r1 = 0
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L16;
                case 4: goto L23;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            if (r1 >= r2) goto L14
            r0 = 3
            goto Lc
        L14:
            r0 = 4
            goto Lc
        L16:
            android.database.sqlite.SQLiteDatabase r5 = (android.database.sqlite.SQLiteDatabase) r5
            com.facebook.ads.redexgen.X.Eq[] r3 = (com.facebook.ads.redexgen.X.AbstractC0376Eq[]) r3
            r0 = r3[r1]
            r0.A07(r5)
            int r1 = r1 + 1
            r0 = 2
            goto Lc
        L23:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0383Ex.onCreate(android.database.sqlite.SQLiteDatabase):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:            return;     */
    @Override // android.database.sqlite.SQLiteOpenHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onDowngrade(android.database.sqlite.SQLiteDatabase r5, int r6, int r7) {
        /*
            r4 = this;
            r0 = 0
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.Ew r0 = r4.A00
            com.facebook.ads.redexgen.X.Eq[] r3 = r0.A0M()
            int r2 = r3.length
            r1 = 0
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L16;
                case 4: goto L26;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            if (r1 >= r2) goto L14
            r0 = 3
            goto Lc
        L14:
            r0 = 4
            goto Lc
        L16:
            android.database.sqlite.SQLiteDatabase r5 = (android.database.sqlite.SQLiteDatabase) r5
            com.facebook.ads.redexgen.X.Eq[] r3 = (com.facebook.ads.redexgen.X.AbstractC0376Eq[]) r3
            r0 = r3[r1]
            r0.A08(r5)
            r0.A07(r5)
            int r1 = r1 + 1
            r0 = 2
            goto Lc
        L26:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0383Ex.onDowngrade(android.database.sqlite.SQLiteDatabase, int, int):void");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        if (!sQLiteDatabase.isReadOnly()) {
            sQLiteDatabase.execSQL(A00(69, 25, 18));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0075, code lost:            return;     */
    @Override // android.database.sqlite.SQLiteOpenHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onUpgrade(android.database.sqlite.SQLiteDatabase r7, int r8, int r9) {
        /*
            r6 = this;
            r0 = 0
            r4 = 3
            r0 = 2
            if (r8 != r0) goto L73
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L6d;
                case 3: goto L5d;
                case 4: goto L57;
                case 5: goto L50;
                case 6: goto La;
                case 7: goto L75;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            android.database.sqlite.SQLiteDatabase r7 = (android.database.sqlite.SQLiteDatabase) r7
            com.facebook.ads.redexgen.X.Ep r5 = com.facebook.ads.redexgen.X.C0377Er.A01
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r2 = 94
            r1 = 30
            r0 = 26
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.StringBuilder r1 = r3.append(r0)
            java.lang.String r0 = r5.A01
            java.lang.StringBuilder r3 = r1.append(r0)
            r2 = 0
            r1 = 1
            r0 = 92
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.StringBuilder r1 = r3.append(r0)
            java.lang.String r0 = r5.A02
            java.lang.StringBuilder r3 = r1.append(r0)
            r2 = 124(0x7c, float:1.74E-43)
            r1 = 10
            r0 = 104(0x68, float:1.46E-43)
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.String r0 = r0.toString()
            r7.execSQL(r0)
            r0 = 7
            goto L6
        L50:
            r0 = 4
            if (r9 < r0) goto L55
            r0 = 6
            goto L6
        L55:
            r0 = 7
            goto L6
        L57:
            if (r8 > r4) goto L5b
            r0 = 5
            goto L6
        L5b:
            r0 = 7
            goto L6
        L5d:
            android.database.sqlite.SQLiteDatabase r7 = (android.database.sqlite.SQLiteDatabase) r7
            r2 = 1
            r1 = 28
            r0 = 98
            java.lang.String r0 = A00(r2, r1, r0)
            r7.execSQL(r0)
            r0 = 4
            goto L6
        L6d:
            if (r9 < r4) goto L71
            r0 = 3
            goto L6
        L71:
            r0 = 4
            goto L6
        L73:
            r0 = 4
            goto L6
        L75:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0383Ex.onUpgrade(android.database.sqlite.SQLiteDatabase, int, int):void");
    }
}
