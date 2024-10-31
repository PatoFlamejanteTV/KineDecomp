package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: assets/audience_network.dex */
public final class JI {
    public static byte[] A00;
    public static final Package A01;
    public static final String A02;
    public static final String A03;
    public static final String A04;
    public static final Set<C0362Ec> A05;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A06(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.JI.A00
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JI.A06(int, int, int):java.lang.String");
    }

    public static void A07() {
        A00 = new byte[]{11, 57, 46, 61, 60, 120, 43, 44, 57, 44, 61, 120, 58, 45, 54, 60, 52, 61, 120, 49, 43, 120, 61, 53, 40, 44, 33, 121, 69, 42, 47, 37, 60, 52, 42, 47, 52, 36, 41, 33, 52, 34, 47, 52, 32, 46, 50, 78, 33, 36, 46, 55, 63, 51, 33, 54, 37, 36, 63, 51, 52, 33, 52, 37, 63, 36, 33, 52, 33, 27, 116, 113, 123, 98, 106, 122, 103, 124, 114, 124, 123, 116, 121, 106, 112, 109, 97, 103, 116, 102};
    }

    static {
        A07();
        A01 = JI.class.getPackage();
        A03 = A01 + A06(47, 22, 127);
        A02 = A01 + A06(28, 19, 116);
        A04 = A01 + A06(69, 21, 42);
        A05 = Collections.newSetFromMap(new WeakHashMap());
    }

    public static Intent A00(Intent cloneIntent) {
        Intent cloneFilter = cloneIntent.cloneFilter();
        cloneFilter.setFlags(cloneIntent.getFlags());
        Parcel obtain = Parcel.obtain();
        obtain.writeBundle(cloneIntent.getExtras());
        cloneFilter.putExtra(A04, obtain.marshall());
        obtain.recycle();
        return cloneFilter;
    }

    public static Intent A01(Intent intent, ClassLoader classLoader) {
        Intent startIntent = intent.cloneFilter();
        startIntent.setFlags(intent.getFlags());
        Bundle bundle = new Bundle();
        Parcel obtain = Parcel.obtain();
        byte[] byteArrayExtra = intent.getByteArrayExtra(A04);
        if (byteArrayExtra != null) {
            obtain.unmarshall(byteArrayExtra, 0, byteArrayExtra.length);
            obtain.setDataPosition(0);
            bundle = obtain.readBundle(classLoader);
            obtain.recycle();
        }
        startIntent.putExtras(bundle);
        return startIntent;
    }

    public static Bundle A02(Bundle bundle, ClassLoader classLoader) {
        Parcel obtain = Parcel.obtain();
        byte[] byteArray = bundle.getByteArray(A03);
        if (byteArray != null) {
            obtain.unmarshall(byteArray, 0, byteArray.length);
            obtain.setDataPosition(0);
            Bundle readBundle = obtain.readBundle(classLoader);
            obtain.recycle();
            return readBundle;
        }
        throw new IllegalStateException(A06(0, 28, 71));
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0047, code lost:            return r3;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.C0362Ec A03(android.content.Intent r4) {
        /*
            r3 = 0
            r2 = 0
            r0 = 0
            java.lang.String r0 = com.facebook.ads.redexgen.X.JI.A02
            java.lang.String r1 = r4.getStringExtra(r0)
            if (r1 == 0) goto L43
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L18;
                case 4: goto L24;
                case 5: goto L45;
                case 6: goto L40;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            java.util.Set<com.facebook.ads.redexgen.X.Ec> r0 = com.facebook.ads.redexgen.X.JI.A05
            java.util.Iterator r2 = r0.iterator()
            r0 = 3
            goto Lc
        L18:
            java.util.Iterator r2 = (java.util.Iterator) r2
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L22
            r0 = 4
            goto Lc
        L22:
            r0 = 6
            goto Lc
        L24:
            java.lang.String r1 = (java.lang.String) r1
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r3 = r2.next()
            com.facebook.ads.redexgen.X.Ec r3 = (com.facebook.ads.redexgen.X.C0362Ec) r3
            com.facebook.ads.redexgen.X.0c r0 = r3.A08()
            java.lang.String r0 = r0.getId()
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L3e
            r0 = 5
            goto Lc
        L3e:
            r0 = 3
            goto Lc
        L40:
            r3 = 0
            r0 = 5
            goto Lc
        L43:
            r0 = 6
            goto Lc
        L45:
            com.facebook.ads.redexgen.X.Ec r3 = (com.facebook.ads.redexgen.X.C0362Ec) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JI.A03(android.content.Intent):com.facebook.ads.redexgen.X.Ec");
    }

    public static AdActivityIntent A04(C0362Ec c0362Ec) {
        AdActivityIntent adActivityIntent = new AdActivityIntent(c0362Ec.getApplicationContext(), A05());
        adActivityIntent.putExtra(A02, c0362Ec.A08().getId());
        A05.add(c0362Ec);
        return adActivityIntent;
    }

    public static Class A05() {
        return AudienceNetworkActivity.class;
    }

    public static void A08(Bundle bundle, Bundle bundle2) {
        Parcel obtain = Parcel.obtain();
        obtain.writeBundle(bundle2);
        bundle.putByteArray(A03, obtain.marshall());
        obtain.recycle();
    }

    public static void A09(C0362Ec c0362Ec, AdActivityIntent adActivityIntent) {
        c0362Ec.getApplicationContext().startActivity(A00(adActivityIntent));
    }
}
