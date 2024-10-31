package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.view.View;
import com.facebook.ads.internal.adquality.AdQualityRule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.3z, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C01063z implements InterfaceC00301b<Bundle> {
    public static byte[] A04;
    public AnonymousClass41 A00;
    public final View A01;
    public final C0362Ec A02;
    public final List<AnonymousClass42> A03;

    static {
        A01();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C01063z.A04
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
            int r0 = r0 + (-4)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01063z.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A04 = new byte[]{-42, -41, -60, -41, -52, -42, -41, -52, -58, -42, -74, -89, -75, -74, -75};
    }

    public C01063z(View view, List<C1X> list, Bundle bundle, C0362Ec c0362Ec) {
        this.A02 = c0362Ec;
        this.A01 = view;
        List<AdQualityRule> rules = new ArrayList<>(list.size());
        this.A03 = rules;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(A00(10, 5, 94));
        for (int i = 0; i < list.size(); i++) {
            this.A03.add(new AnonymousClass42(list.get(i), (Bundle) parcelableArrayList.get(i)));
        }
        this.A00 = (AnonymousClass41) Jk.A00(bundle.getByteArray(A00(0, 10, 127)));
    }

    public C01063z(View view, List<C1X> list, C0362Ec c0362Ec) {
        this.A02 = c0362Ec;
        this.A01 = view;
        this.A03 = new ArrayList(list.size());
        Iterator<C1X> it = list.iterator();
        while (it.hasNext()) {
            this.A03.add(new AnonymousClass42(it.next()));
        }
        this.A00 = new AnonymousClass41();
    }

    public final AnonymousClass41 A02() {
        return this.A00;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002a, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A03() {
        /*
            r2 = this;
            r0 = 0
            com.facebook.ads.redexgen.X.41 r0 = r2.A00
            r0.A03()
            java.util.List<com.facebook.ads.redexgen.X.42> r0 = r2.A03
            java.util.Iterator r1 = r0.iterator()
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L1d;
                case 4: goto L2a;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            java.util.Iterator r1 = (java.util.Iterator) r1
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L1b
            r0 = 3
            goto Ld
        L1b:
            r0 = 4
            goto Ld
        L1d:
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r0 = r1.next()
            com.facebook.ads.redexgen.X.42 r0 = (com.facebook.ads.redexgen.X.AnonymousClass42) r0
            r0.A05()
            r0 = 2
            goto Ld
        L2a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01063z.A03():void");
    }

    public final void A04() {
        this.A00.A02();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A05(double r8, double r10) {
        /*
            r7 = this;
            r3 = r7
            r6 = 0
            r1 = 0
            r4 = 0
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 < 0) goto L4e
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L18;
                case 4: goto L35;
                case 5: goto L41;
                case 6: goto L50;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.3z r3 = (com.facebook.ads.redexgen.X.C01063z) r3
            com.facebook.ads.redexgen.X.41 r0 = r3.A00
            r0.A05(r8, r10)
            r0 = 3
            goto Lb
        L18:
            com.facebook.ads.redexgen.X.3z r3 = (com.facebook.ads.redexgen.X.C01063z) r3
            android.view.View r2 = r3.A01
            r1 = 0
            com.facebook.ads.redexgen.X.Ec r0 = r3.A02
            com.facebook.ads.redexgen.X.FO r0 = com.facebook.ads.redexgen.X.FP.A0E(r2, r1, r0)
            float r0 = r0.A00()
            double r1 = (double) r0
            com.facebook.ads.redexgen.X.41 r0 = r3.A00
            r0.A04(r8, r1)
            java.util.List<com.facebook.ads.redexgen.X.42> r0 = r3.A03
            java.util.Iterator r6 = r0.iterator()
            r0 = 4
            goto Lb
        L35:
            java.util.Iterator r6 = (java.util.Iterator) r6
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L3f
            r0 = 5
            goto Lb
        L3f:
            r0 = 6
            goto Lb
        L41:
            java.util.Iterator r6 = (java.util.Iterator) r6
            java.lang.Object r0 = r6.next()
            com.facebook.ads.redexgen.X.42 r0 = (com.facebook.ads.redexgen.X.AnonymousClass42) r0
            r0.A06(r8, r1)
            r0 = 4
            goto Lb
        L4e:
            r0 = 3
            goto Lb
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01063z.A05(double, double):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004f, code lost:            r4 = r4;        r4.putParcelableArrayList(A00(10, 5, 94), r3);     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:            return r4;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC00301b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Bundle getSaveInstanceState() {
        /*
            r5 = this;
            r0 = 0
            r0 = 0
            r0 = 0
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            r2 = 0
            r1 = 10
            r0 = 127(0x7f, float:1.78E-43)
            java.lang.String r1 = A00(r2, r1, r0)
            com.facebook.ads.redexgen.X.41 r0 = r5.A00
            byte[] r0 = com.facebook.ads.redexgen.X.Jk.A01(r0)
            r4.putByteArray(r1, r0)
            java.util.ArrayList r3 = new java.util.ArrayList
            java.util.List<com.facebook.ads.redexgen.X.42> r0 = r5.A03
            int r0 = r0.size()
            r3.<init>(r0)
            java.util.List<com.facebook.ads.redexgen.X.42> r0 = r5.A03
            java.util.Iterator r1 = r0.iterator()
            r0 = 2
        L2c:
            switch(r0) {
                case 2: goto L30;
                case 3: goto L3c;
                case 4: goto L4f;
                default: goto L2f;
            }
        L2f:
            goto L2c
        L30:
            java.util.Iterator r1 = (java.util.Iterator) r1
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L3a
            r0 = 3
            goto L2c
        L3a:
            r0 = 4
            goto L2c
        L3c:
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r0 = r1.next()
            com.facebook.ads.redexgen.X.42 r0 = (com.facebook.ads.redexgen.X.AnonymousClass42) r0
            android.os.Bundle r0 = r0.getSaveInstanceState()
            r3.add(r0)
            r0 = 2
            goto L2c
        L4f:
            android.os.Bundle r4 = (android.os.Bundle) r4
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            r2 = 10
            r1 = 5
            r0 = 94
            java.lang.String r0 = A00(r2, r1, r0)
            r4.putParcelableArrayList(r0, r3)
            android.os.Bundle r4 = (android.os.Bundle) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01063z.getSaveInstanceState():android.os.Bundle");
    }
}
