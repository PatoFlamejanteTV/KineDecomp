package com.facebook.ads.redexgen.X;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Looper;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: com.facebook.ads.redexgen.X.Ew, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0382Ew {
    public static byte[] A04;
    public static final String A05;
    public static final Lock A06;
    public static final Lock A07;
    public static final ReentrantReadWriteLock A08;
    public SQLiteOpenHelper A00;
    public final C0365Ef A01;
    public final F1 A03 = new F1(this);
    public final C0377Er A02 = new C0377Er(this);

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A05(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0382Ew.A04
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
            r0 = r0 ^ 87
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0382Ew.A05(int, int, int):java.lang.String");
    }

    public static void A07() {
        A04 = new byte[]{74, 70, 57, 8, 19, 23, 25, 18, 15, 10, 25, 10, 1, 27, 28, 102, 124, 67, 47, 42, 46, 42, 55, 67, 91, 94, 75, 94, 93, 94, 76, 90, 38, 73, 72, 38, 51, 37, 44, 37, 35, 52, 64, 20, 15, 11, 5, 14, 19, 78, Byte.MAX_VALUE, 83, 78, 83, 106, 25, 15, 30, 106, 44, 41, 61, 56, 45, 60, 89, 81, 55, 35, 62, 60, 81, 54, 40, 54, 41, 3, 33, 46, 46, 47, 52, 96, 35, 33, 44, 44, 96, 39, 37, 52, 4, 33, 52, 33, 34, 33, 51, 37, 96, 38, 50, 47, 45, 96, 52, 40, 37, 96, 21, 9, 96, 52, 40, 50, 37, 33, 36, 97, 92, 54, 51, 53, 50, 92, 104, 31, 0, 13, 26, 13, 104, 28, 115, 110, 120, 121, 110, 28, 126, 101, 28, 15, 13, 51, 82, 64, 80};
    }

    static {
        A07();
        A05 = A05(36, 14, 55) + F1.A02.A01 + A05(0, 2, 49) + A05(3, 6, 43) + A05(50, 1, 6) + F1.A01.A01 + A05(0, 2, 49) + A05(9, 6, 56) + A05(50, 1, 6) + C0377Er.A03.A01 + A05(0, 2, 49) + A05(9, 6, 56) + A05(50, 1, 6) + C0377Er.A04.A01 + A05(0, 2, 49) + A05(9, 6, 56) + A05(50, 1, 6) + C0377Er.A09.A01 + A05(0, 2, 49) + A05(9, 6, 56) + A05(50, 1, 6) + C0377Er.A07.A01 + A05(0, 2, 49) + A05(9, 6, 56) + A05(50, 1, 6) + C0377Er.A06.A01 + A05(0, 2, 49) + A05(9, 6, 56) + A05(50, 1, 6) + C0377Er.A05.A01 + A05(0, 2, 49) + A05(9, 6, 56) + A05(50, 1, 6) + C0377Er.A02.A01 + A05(0, 2, 49) + A05(9, 6, 56) + A05(50, 1, 6) + C0377Er.A01.A01 + A05(66, 6, 38) + A05(9, 6, 56) + A05(119, 6, 43) + A05(3, 6, 43) + A05(32, 4, 81) + A05(9, 6, 56) + A05(50, 1, 6) + C0377Er.A08.A01 + A05(51, 3, 36) + A05(3, 6, 43) + A05(50, 1, 6) + F1.A02.A01 + A05(132, 10, 107) + A05(9, 6, 56) + A05(50, 1, 6) + C0377Er.A07.A01 + A05(144, 4, 68);
        A08 = new ReentrantReadWriteLock();
        A06 = A08.readLock();
        A07 = A08.writeLock();
    }

    public C0382Ew(C0365Ef c0365Ef) {
        this.A01 = c0365Ef;
    }

    private synchronized SQLiteDatabase A00() {
        if (this.A00 == null) {
            this.A00 = new C0383Ex(this.A01, this);
        }
        return this.A00.getWritableDatabase();
    }

    private synchronized SQLiteDatabase A01() {
        SQLiteException e = null;
        for (int i = 0; i < 10; i++) {
            try {
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException unused) {
                }
            }
        }
        this.A01.A06().A5W(A05(24, 8, 104), C0512Kc.A0i, new C0514Ke(e));
        throw e;
        return A00();
    }

    public final int A08(int i) {
        A07.lock();
        try {
            return A0E().delete(A05(9, 6, 56), C0377Er.A01.A01 + A05(72, 4, 65), new String[]{String.valueOf(i - 1)});
        } finally {
            A07.unlock();
        }
    }

    public final Cursor A09() {
        A06.lock();
        try {
            return this.A02.A0B();
        } finally {
            A06.unlock();
        }
    }

    public final Cursor A0A() {
        A06.lock();
        try {
            return this.A02.A0C();
        } finally {
            A06.unlock();
        }
    }

    public final Cursor A0B() {
        A06.lock();
        try {
            return this.A03.A0B();
        } finally {
            A06.unlock();
        }
    }

    public final Cursor A0C(int i) {
        A06.lock();
        try {
            return A0E().rawQuery(A05 + A05(17, 7, 52) + String.valueOf(i), null);
        } finally {
            A06.unlock();
        }
    }

    public final Cursor A0D(String str) {
        A06.lock();
        try {
            return this.A02.A0D(str);
        } finally {
            A06.unlock();
        }
    }

    public final SQLiteDatabase A0E() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException(A05(76, 43, 23));
        }
        return A01();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Eo != com.facebook.ads.internal.database.AdDatabaseCallback<T> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Es != com.facebook.ads.internal.database.AdDatabaseQuery<T> */
    public final <T> AsyncTask A0F(AbstractC0378Es<T> abstractC0378Es, AbstractC0374Eo<T> abstractC0374Eo) {
        return KG.A00(KJ.A06, new AsyncTaskC0381Ev(this.A01, abstractC0378Es, abstractC0374Eo), new Void[0]);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Eo != com.facebook.ads.internal.database.AdDatabaseCallback<java.lang.String> */
    public final AsyncTask A0G(String str, int i, String str2, double d, double d2, String str3, Map<String, String> map, AbstractC0374Eo<String> abstractC0374Eo) {
        return A0F(new C0380Eu(this, str2, str, i, d, d2, str3, map), abstractC0374Eo);
    }

    public final void A0H() {
        A07.lock();
        try {
            this.A02.A09();
            this.A03.A09();
        } finally {
            A07.unlock();
        }
    }

    public final void A0I() {
        A07.lock();
        try {
            this.A03.A0D();
        } finally {
            A07.unlock();
        }
    }

    public final synchronized void A0J() {
        for (int i = 0; i < A0M().length; i++) {
        }
        if (this.A00 != null) {
            this.A00.close();
            this.A00 = null;
        }
    }

    public final boolean A0K(String str) {
        A07.lock();
        try {
            return this.A02.A0F(str);
        } finally {
            A07.unlock();
        }
    }

    public final boolean A0L(String str) {
        boolean z;
        A07.lock();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(A05(59, 7, 46)).append(A05(9, 6, 56)).append(A05(54, 5, 29)).append(C0377Er.A01.A01).append(A05(2, 1, 83)).append(C0377Er.A01.A01).append(A05(15, 2, 26)).append(A05(125, 7, 31)).append(C0377Er.A03.A01).append(A05(142, 2, 101));
            A0E().execSQL(sb.toString(), new String[]{str});
            z = true;
        } catch (SQLiteException unused) {
            z = false;
        }
        A07.unlock();
        return z;
    }

    public final AbstractC0376Eq[] A0M() {
        return new AbstractC0376Eq[]{this.A03, this.A02};
    }
}
