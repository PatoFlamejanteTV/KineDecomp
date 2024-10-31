package com.facebook.ads.redexgen.X;

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.locks.Lock;

/* renamed from: com.facebook.ads.redexgen.X.Eu, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0380Eu extends AbstractC0379Et<String> {
    public static byte[] A08;
    public final /* synthetic */ double A00;
    public final /* synthetic */ double A01;
    public final /* synthetic */ int A02;
    public final /* synthetic */ C0382Ew A03;
    public final /* synthetic */ String A04;
    public final /* synthetic */ String A05;
    public final /* synthetic */ String A06;
    public final /* synthetic */ Map A07;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C0380Eu.A08
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
            r0 = r0 ^ 25
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0380Eu.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A08 = new byte[]{12, 9, 28, 9, 10, 9, 27, 13};
    }

    public C0380Eu(C0382Ew c0382Ew, String str, String str2, int i, double d, double d2, String str3, Map map) {
        this.A03 = c0382Ew;
        this.A06 = str;
        this.A05 = str2;
        this.A02 = i;
        this.A01 = d;
        this.A00 = d2;
        this.A04 = str3;
        this.A07 = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC0378Es
    @Nullable
    /* renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final String A03() {
        C0365Ef c0365Ef;
        Lock lock;
        Lock lock2;
        C0365Ef c0365Ef2;
        C0365Ef c0365Ef3;
        Lock lock3;
        C0365Ef c0365Ef4;
        C0377Er c0377Er;
        F1 f1;
        Lock lock4;
        C0365Ef c0365Ef5;
        c0365Ef = this.A03.A01;
        c0365Ef.A06().A57(this.A06);
        if (TextUtils.isEmpty(this.A05)) {
            return null;
        }
        lock = C0382Ew.A07;
        lock.lock();
        SQLiteDatabase db = null;
        try {
            try {
                db = this.A03.A0E();
                db.beginTransaction();
                c0377Er = this.A03.A02;
                f1 = this.A03.A03;
                String A0E = c0377Er.A0E(f1.A0C(this.A05), this.A02, this.A06, this.A01, this.A00, this.A04, this.A07);
                db.setTransactionSuccessful();
                if (db != null && db.isOpen()) {
                    try {
                        if (db.inTransaction()) {
                            db.endTransaction();
                        }
                    } catch (Exception e) {
                        c0365Ef5 = this.A03.A01;
                        c0365Ef5.A06().A5W(A01(0, 8, 113), C0512Kc.A0m, new C0514Ke(e));
                    }
                }
                lock4 = C0382Ew.A07;
                lock4.unlock();
                return A0E;
            } catch (Throwable th) {
                if (db != null && db.isOpen()) {
                    try {
                        if (db.inTransaction()) {
                            db.endTransaction();
                        }
                    } catch (Exception e2) {
                        c0365Ef2 = this.A03.A01;
                        c0365Ef2.A06().A5W(A01(0, 8, 113), C0512Kc.A0m, new C0514Ke(e2));
                    }
                }
                lock2 = C0382Ew.A07;
                lock2.unlock();
                throw th;
            }
        } catch (Exception e3) {
            A01(EnumC0384Ey.A05);
            c0365Ef3 = this.A03.A01;
            c0365Ef3.A06().A5W(A01(0, 8, 113), C0512Kc.A0l, new C0514Ke(e3));
            if (db != null && db.isOpen()) {
                try {
                    if (db.inTransaction()) {
                        db.endTransaction();
                    }
                } catch (Exception e4) {
                    c0365Ef4 = this.A03.A01;
                    c0365Ef4.A06().A5W(A01(0, 8, 113), C0512Kc.A0m, new C0514Ke(e4));
                }
            }
            lock3 = C0382Ew.A07;
            lock3.unlock();
            return null;
        }
    }
}
