package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.0e, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C00070e implements InterfaceC00050c {
    public static byte[] A06;
    public final C00140l A00;
    public final AtomicReference<String> A04 = new AtomicReference<>();
    public final AtomicReference<String> A03 = new AtomicReference<>();
    public final AtomicReference<EnumC00260x> A05 = new AtomicReference<>();
    public final UUID A01 = UUID.randomUUID();
    public final AtomicInteger A02 = new AtomicInteger(1);

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
            byte[] r1 = com.facebook.ads.redexgen.X.C00070e.A06
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00070e.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A06 = new byte[]{-119, -104, -111, -111, -120, -113, -126, -106, -120, -108};
    }

    public C00070e(C00140l c00140l) {
        this.A00 = c00140l;
    }

    public final void A02(EnumC00100h enumC00100h, C00150m... c00150mArr) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (C00150m c00150m : c00150mArr) {
                c00150m.A02(jSONObject);
            }
            try {
                jSONObject.put(A00(0, 10, 31), this.A02.getAndIncrement());
            } catch (JSONException unused) {
            }
            InterfaceC00160n.A0D.A02(this.A01).A02(jSONObject);
            String str = this.A04.get();
            if (!TextUtils.isEmpty(str)) {
                InterfaceC00160n.A0M.A02(str).A02(jSONObject);
            }
            String str2 = this.A03.get();
            if (!TextUtils.isEmpty(str2)) {
                InterfaceC00160n.A0L.A02(str2).A02(jSONObject);
            }
            EnumC00260x enumC00260x = this.A05.get();
            if (enumC00260x != null) {
                InterfaceC00160n.A0C.A02(enumC00260x).A02(jSONObject);
            }
            this.A00.A00(enumC00100h, jSONObject);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2P(String str) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A0R, InterfaceC00160n.A0I.A02(str));
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2Q(String str) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A0S, InterfaceC00160n.A0I.A02(str));
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2R(String str) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A0T, InterfaceC00160n.A0I.A02(str));
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2S(String str) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A0U, InterfaceC00160n.A0I.A02(str));
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2T(String str) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A0V, InterfaceC00160n.A0I.A02(str));
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2U(String str) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A0W, InterfaceC00160n.A0I.A02(str));
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2V() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A0g, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2W() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A0X, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2X() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A0s, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2Y() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A0t, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2Z(boolean z) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A0Y, InterfaceC00160n.A02.A02(Boolean.valueOf(z)));
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2a(long j, int i, String str) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A0u, InterfaceC00160n.A0E.A02(Integer.valueOf(i)), InterfaceC00160n.A0J.A02(str), InterfaceC00160n.A0H.A02(Long.valueOf(j)));
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2b() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A0w, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2c() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A0v, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2d() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A0x, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2e(long j) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A0y, InterfaceC00160n.A0H.A02(Long.valueOf(j)));
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2f(EnumC00040b enumC00040b) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A1Q, InterfaceC00160n.A01.A02(enumC00040b));
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2g(String str) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            this.A03.set(str);
            A02(EnumC00100h.A0Z, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2h() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A0a, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2i() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A0b, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2j(long j, int i, String str, boolean z) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A0c, InterfaceC00160n.A0H.A02(Long.valueOf(j)), InterfaceC00160n.A0E.A02(Integer.valueOf(i)), InterfaceC00160n.A0J.A02(str), InterfaceC00160n.A08.A02(Boolean.valueOf(z)));
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2k(long j) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A0d, InterfaceC00160n.A0H.A02(Long.valueOf(j)));
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2l(boolean z) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A14, InterfaceC00160n.A0B.A02(Boolean.valueOf(z)));
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2m() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A15, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2n() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A17, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2o(String str) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A18, InterfaceC00160n.A0J.A02(str));
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2p() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A19, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2q() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A1A, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2r() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A1B, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2s() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A1C, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2t() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A1D, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2u() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A1E, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2v() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A1F, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2w() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A1G, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2x() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A1H, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2y() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A1I, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A2z() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A1S, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A30() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A1T, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A31(EnumC00040b enumC00040b) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A1P, InterfaceC00160n.A01.A02(enumC00040b));
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A32(int i) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A1R, InterfaceC00160n.A0F.A02(Integer.valueOf(i)));
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A33() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A1U, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A3e(long j) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A0e, InterfaceC00160n.A0H.A02(Long.valueOf(j)));
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A3f(long j) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A0f, InterfaceC00160n.A0H.A02(Long.valueOf(j)));
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A3q() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A0h, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A3r() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A0l, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A3s(int i, String str) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A0m, InterfaceC00160n.A0E.A02(Integer.valueOf(i)), InterfaceC00160n.A0J.A02(str));
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A3t(boolean z) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A0k, InterfaceC00160n.A04.A02(Boolean.valueOf(z)));
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A3u() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A0o, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A3v() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A0p, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A3w() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A0q, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A3x() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A0r, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A5x(String str) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A0z, InterfaceC00160n.A0J.A02(str));
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A5y(int i) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A10, InterfaceC00160n.A0F.A02(Integer.valueOf(i)));
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A83(String str) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A12, InterfaceC00160n.A0J.A02(str));
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A84() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A13, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A8K(String str) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            this.A04.set(str);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A8M(EnumC00260x enumC00260x) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            this.A05.set(enumC00260x);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A8Z() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A1V, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A8a() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A1W, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A8b() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A1X, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A8c() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A1Y, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A8d(boolean z) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A1Z, InterfaceC00160n.A03.A02(Boolean.valueOf(z)));
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A8e() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A1a, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A8f() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A1b, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A8g(int i) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A1c, InterfaceC00160n.A0E.A02(Integer.valueOf(i)));
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A8h(boolean z) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A1d, InterfaceC00160n.A07.A02(Boolean.valueOf(z)));
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A8i() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A1e, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A8j() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A1f, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A8k() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A1g, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A8l(int i) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A1h, InterfaceC00160n.A0G.A02(Integer.valueOf(i)));
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A8p(String str) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A1J, InterfaceC00160n.A0J.A02(str));
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void A8q(String str) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A1K, InterfaceC00160n.A0J.A02(str));
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final String getId() {
        String str = null;
        if (C0466Ig.A02(this)) {
            return null;
        }
        try {
            str = this.A01.toString();
            return str;
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
            return str;
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00050c
    public final void unregisterView() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A02(EnumC00100h.A16, new C00150m[0]);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }
}
