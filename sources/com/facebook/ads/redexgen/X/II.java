package com.facebook.ads.redexgen.X;

import android.content.pm.PackageManager;
import android.util.Base64;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Map;

/* loaded from: assets/audience_network.dex */
public class II extends AbstractRunnableC00351g {
    public static byte[] A02;
    public final /* synthetic */ IH A00;
    public final /* synthetic */ IQ A01;

    static {
        A04();
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
            byte[] r1 = com.facebook.ads.redexgen.X.II.A02
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
            r0 = r0 ^ 62
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.II.A01(int, int, int):java.lang.String");
    }

    public static void A04() {
        A02 = new byte[]{98, 26, 8, 21, 22, 25, 25, 18, 5, 8, 28, 18, 14};
    }

    public II(IQ iq, IH ih) {
        this.A01 = iq;
        this.A00 = ih;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
    public final void A05() {
        C0362Ec c0362Ec;
        C0362Ec c0362Ec2;
        C0362Ec c0362Ec3;
        long j;
        C0362Ec c0362Ec4;
        C0362Ec c0362Ec5;
        long j2;
        C0362Ec c0362Ec6;
        C0362Ec c0362Ec7;
        C0483Iy c0483Iy;
        String str;
        C0483Iy c0483Iy2;
        Map<? extends String, ? extends String> map;
        IL A06;
        C0362Ec c0362Ec8;
        String str2;
        Map<? extends String, ? extends String> map2;
        InterfaceC0436Gz A08;
        Map map3;
        C0362Ec c0362Ec9;
        C0362Ec c0362Ec10;
        C0362Ec c0362Ec11;
        boolean z = true;
        c0362Ec = this.A01.A06;
        C0398Fm.A08(c0362Ec);
        c0362Ec2 = this.A01.A06;
        C02379g.A07(c0362Ec2);
        if (this.A00.A06().A09()) {
            try {
                this.A00.A06().A07(C02379g.A00().A03());
            } catch (C0454Hs e) {
                AdErrorType A00 = e.A00();
                c0362Ec3 = this.A01.A06;
                InterfaceC00050c A082 = c0362Ec3.A08();
                j = this.A01.A00;
                A082.A2j(K4.A01(j), A00.getErrorCode(), A00.getDefaultErrorMessage(), A00.isPublicError());
                this.A01.A0J(C0453Hr.A03(e));
            }
            this.A01.A0S(this.A00.A06().A06(), 0L);
            return;
        }
        IQ iq = this.A01;
        IH ih = this.A00;
        GQ A002 = GQ.A00();
        c0362Ec4 = this.A01.A06;
        iq.A05 = ih.A09(A002.A02(c0362Ec4, true).A4c());
        try {
            map3 = this.A01.A05;
            String A01 = A01(1, 12, 105);
            StringBuilder sb = new StringBuilder();
            c0362Ec9 = this.A01.A06;
            StringBuilder append = sb.append(c0362Ec9.getPackageName()).append(A01(0, 1, 124));
            c0362Ec10 = this.A01.A06;
            PackageManager packageManager = c0362Ec10.getPackageManager();
            c0362Ec11 = this.A01.A06;
            map3.put(A01, new String(Base64.encode(append.append(packageManager.getInstallerPackageName(c0362Ec11.getPackageName())).toString().getBytes(), 2)));
        } catch (Exception unused) {
        }
        try {
            if (this.A00.A05() != EnumC0458Hx.A04 && this.A00.A05() != EnumC0458Hx.A06 && this.A00.A05() != EnumC0458Hx.A05 && this.A00.A05() != null) {
                z = false;
            }
            c0362Ec6 = this.A01.A06;
            boolean shouldCheckSystemHttpAgent = C0413Gc.A0g(c0362Ec6);
            if (!shouldCheckSystemHttpAgent) {
                IQ iq2 = this.A01;
                c0362Ec7 = this.A01.A06;
                iq2.A03 = C7A.A02(c0362Ec7, z);
                c0483Iy = this.A01.A03;
                str = this.A01.A08;
                c0483Iy2 = this.A01.A03;
                JC A0M = c0483Iy2.A0M();
                map = this.A01.A05;
                JC A05 = A0M.A05(map);
                A06 = this.A01.A06(K4.A00());
                c0483Iy.A0R(str, A05, A06);
                return;
            }
            c0362Ec8 = this.A01.A06;
            FM A062 = C7A.A06(z, c0362Ec8);
            str2 = this.A01.A08;
            C7V c7v = new C7V();
            map2 = this.A01.A05;
            byte[] A07 = c7v.A05(map2).A07();
            A08 = this.A01.A08(K4.A00());
            A062.A7n(str2, A07, A08);
        } catch (Exception e2) {
            AdErrorType adErrorType = AdErrorType.AD_REQUEST_FAILED;
            String message = e2.getMessage();
            c0362Ec5 = this.A01.A06;
            InterfaceC00050c A083 = c0362Ec5.A08();
            j2 = this.A01.A00;
            A083.A2j(K4.A01(j2), adErrorType.getErrorCode(), message, adErrorType.isPublicError());
            this.A01.A0J(C0453Hr.A02(adErrorType, message));
        }
    }
}
