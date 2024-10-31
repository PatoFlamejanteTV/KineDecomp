package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.Go, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0425Go implements InterfaceC0422Gl {

    @SuppressLint({"StaticFieldLeak"})
    @Nullable
    public static InterfaceC0422Gl A03;
    public static byte[] A04;
    public static final String A05;
    public static volatile boolean A06;
    public final C0365Ef A00;
    public final C0382Ew A01;
    public final InterfaceC0418Gh A02;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0425Go.A04
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
            r0 = r0 ^ 21
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0425Go.A02(int, int, int):java.lang.String");
    }

    public static void A03() {
        A04 = new byte[]{12, 73, 90, 73, 66, 88, 2, 77, 120, 120, 105, 97, 124, 120, 101, 98, 107, 44, 120, 99, 44, 96, 99, 107, 44, 109, 98, 44, 101, 98, 122, 109, 96, 101, 104, 44};
    }

    static {
        A03();
        A05 = C0425Go.class.getSimpleName();
        A06 = false;
    }

    public C0425Go(C0365Ef c0365Ef) {
        this.A00 = c0365Ef;
        this.A01 = new C0382Ew(c0365Ef);
        this.A02 = new C0421Gk(c0365Ef, new C0429Gs(c0365Ef, this.A01));
        KJ.A07.execute(new C0423Gm(this));
        A04(c0365Ef);
    }

    public static synchronized InterfaceC0422Gl A01(C0365Ef c0365Ef) {
        InterfaceC0422Gl interfaceC0422Gl;
        synchronized (C0425Go.class) {
            if (A03 == null) {
                A03 = new C0425Go(c0365Ef);
            }
            interfaceC0422Gl = A03;
        }
        return interfaceC0422Gl;
    }

    public static synchronized void A04(C0365Ef c0365Ef) {
        synchronized (C0425Go.class) {
            if (!A06) {
                DynamicLoaderFactory.makeLoader(c0365Ef).getInitApi().onAdEventManagerCreated(c0365Ef);
                A06 = true;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0073, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A05(com.facebook.ads.redexgen.X.C0416Gf r14) {
        /*
            r13 = this;
            r1 = r13
            boolean r0 = r14.A0A()
            if (r0 != 0) goto L71
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L73;
                case 4: goto L3f;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.Gf r14 = (com.facebook.ads.redexgen.X.C0416Gf) r14
            java.lang.String r5 = com.facebook.ads.redexgen.X.C0425Go.A05
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r3 = 7
            r2 = 29
            r0 = 25
            java.lang.String r0 = A02(r3, r2, r0)
            java.lang.StringBuilder r2 = r4.append(r0)
            com.facebook.ads.redexgen.X.Gq r0 = r14.A06()
            java.lang.StringBuilder r4 = r2.append(r0)
            r3 = 0
            r2 = 7
            r0 = 57
            java.lang.String r0 = A02(r3, r2, r0)
            java.lang.StringBuilder r0 = r4.append(r0)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r5, r0)
            r0 = 3
            goto L8
        L3f:
            com.facebook.ads.redexgen.X.Go r1 = (com.facebook.ads.redexgen.X.C0425Go) r1
            com.facebook.ads.redexgen.X.Gf r14 = (com.facebook.ads.redexgen.X.C0416Gf) r14
            com.facebook.ads.redexgen.X.Ew r2 = r1.A01
            java.lang.String r3 = r14.A08()
            com.facebook.ads.redexgen.X.Gp r0 = r14.A05()
            int r4 = r0.A00
            com.facebook.ads.redexgen.X.Gq r0 = r14.A06()
            java.lang.String r5 = r0.toString()
            double r6 = r14.A04()
            double r8 = r14.A03()
            java.lang.String r10 = r14.A07()
            java.util.Map r11 = r14.A09()
            com.facebook.ads.redexgen.X.Gn r12 = new com.facebook.ads.redexgen.X.Gn
            r12.<init>(r1, r14)
            r2.A0G(r3, r4, r5, r6, r8, r10, r11, r12)
            r0 = 3
            goto L8
        L71:
            r0 = 4
            goto L8
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0425Go.A05(com.facebook.ads.redexgen.X.Gf):void");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0422Gl
    public final void A5P(String str, Map<String, String> map) {
        A05(new C0415Ge().A04(str).A00(this.A00.A04().A01()).A03(this.A00.A04().A02()).A05(map).A01(EnumC0426Gp.A03).A02(EnumC0427Gq.A03).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0422Gl
    public final void A5S(String str, Map<String, String> map) {
        A05(new C0415Ge().A04(str).A00(this.A00.A04().A01()).A03(this.A00.A04().A02()).A05(map).A01(EnumC0426Gp.A03).A02(EnumC0427Gq.A05).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0422Gl
    public final void A5T(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C0415Ge().A04(str).A00(this.A00.A04().A01()).A03(this.A00.A04().A02()).A05(map).A01(EnumC0426Gp.A03).A02(EnumC0427Gq.A06).A06(C0434Gx.A0A(str, EnumC0431Gu.A0H)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0422Gl
    public final void A5U(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C0415Ge().A04(str).A00(this.A00.A04().A01()).A03(this.A00.A04().A02()).A05(map).A01(EnumC0426Gp.A03).A02(EnumC0427Gq.A07).A06(C0434Gx.A0A(str, EnumC0431Gu.A05)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0422Gl
    public final void A5V(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C0415Ge().A04(str).A00(this.A00.A04().A01()).A03(this.A00.A04().A02()).A05(map).A01(EnumC0426Gp.A03).A02(EnumC0427Gq.A0A).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0422Gl
    public final void A5Y(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C0415Ge().A04(str).A00(this.A00.A04().A01()).A03(this.A00.A04().A02()).A05(map).A01(EnumC0426Gp.A03).A02(EnumC0427Gq.A0B).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0422Gl
    public final void A5a(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C0415Ge().A04(str).A00(this.A00.A04().A01()).A03(this.A00.A04().A02()).A05(map).A01(EnumC0426Gp.A04).A02(EnumC0427Gq.A0C).A06(C0434Gx.A0A(str, EnumC0431Gu.A0S)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0422Gl
    public final void A5b(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C0415Ge().A04(str).A00(this.A00.A04().A01()).A03(this.A00.A04().A02()).A05(map).A01(EnumC0426Gp.A04).A02(EnumC0427Gq.A0D).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0422Gl
    public final void A5c(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C0415Ge().A04(str).A00(this.A00.A04().A01()).A03(this.A00.A04().A02()).A05(map).A01(EnumC0426Gp.A04).A02(EnumC0427Gq.A0G).A06(C0434Gx.A0A(str, EnumC0431Gu.A0U)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0422Gl
    public final void A5e(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C0415Ge().A04(str).A00(this.A00.A04().A01()).A03(this.A00.A04().A02()).A05(map).A01(EnumC0426Gp.A03).A02(EnumC0427Gq.A0F).A06(C0434Gx.A0A(str, EnumC0431Gu.A0V)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0422Gl
    public final void A5g(String str, Map<String, String> map, String str2, EnumC0426Gp enumC0426Gp) {
        A05(new C0415Ge().A04(str).A00(this.A00.A04().A01()).A03(this.A00.A04().A02()).A05(map).A01(enumC0426Gp).A02(EnumC0427Gq.A00(str2)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0422Gl
    public final void A5h(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C0415Ge().A04(str).A00(this.A00.A04().A01()).A03(this.A00.A04().A02()).A05(map).A01(EnumC0426Gp.A03).A02(EnumC0427Gq.A0H).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0422Gl
    public final void A5m(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C0415Ge().A04(str).A00(this.A00.A04().A01()).A03(this.A00.A04().A02()).A01(EnumC0426Gp.A03).A02(EnumC0427Gq.A0J).A06(C0434Gx.A0A(str, EnumC0431Gu.A0X)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0422Gl
    public final void A5o(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C0415Ge().A04(str).A00(this.A00.A04().A01()).A03(this.A00.A04().A02()).A05(map).A01(EnumC0426Gp.A03).A02(EnumC0427Gq.A0E).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0422Gl
    public final void A5p(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C0415Ge().A04(str).A00(this.A00.A04().A01()).A03(this.A00.A04().A02()).A05(map).A01(EnumC0426Gp.A04).A02(EnumC0427Gq.A0K).A06(C0434Gx.A0A(str, EnumC0431Gu.A0b)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0422Gl
    public final void A5q(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C0415Ge().A04(str).A00(this.A00.A04().A01()).A03(this.A00.A04().A02()).A05(map).A01(EnumC0426Gp.A03).A02(EnumC0427Gq.A0O).A06(C0434Gx.A0A(str, EnumC0431Gu.A0d)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0422Gl
    public final void A5r(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C0415Ge().A04(str).A00(this.A00.A04().A01()).A03(this.A00.A04().A02()).A05(map).A01(EnumC0426Gp.A03).A02(EnumC0427Gq.A0N).A06(C0434Gx.A0A(str, EnumC0431Gu.A0e)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0422Gl
    public final void A5s(String str, Map<String, String> map) {
        A05(new C0415Ge().A04(str).A00(this.A00.A04().A01()).A03(this.A00.A04().A02()).A05(map).A01(EnumC0426Gp.A04).A02(EnumC0427Gq.A0P).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0422Gl
    public final void A5t(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C0415Ge().A04(str).A00(this.A00.A04().A01()).A03(this.A00.A04().A02()).A05(map).A01(EnumC0426Gp.A04).A02(EnumC0427Gq.A0Q).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0422Gl
    public final void A7o(String str) {
        new AnonymousClass79(this.A00).execute(str);
    }
}
