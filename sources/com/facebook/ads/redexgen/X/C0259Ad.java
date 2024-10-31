package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Ad, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0259Ad {
    public static final String A08 = C0259Ad.class.getSimpleName();
    public final int A00;
    public final Context A01;
    public final AA A02;
    public final AP A03;
    public final C0261Af A04;
    public final C0262Ag A05;
    public final C0263Ah A06;
    public final EE A07;

    public C0259Ad(Context context, AA aa) {
        C0265Aj c0265Aj = new C0265Aj(context, new C0266Ak(new BS(context, aa)), aa);
        this.A01 = context;
        this.A05 = c0265Aj.A0A();
        this.A06 = c0265Aj.A0B();
        this.A04 = c0265Aj.A09();
        this.A00 = c0265Aj.A08();
        this.A02 = aa;
        this.A03 = new AP();
        this.A03.A01(this.A04);
        this.A07 = c0265Aj.A0C();
        this.A07.A03();
    }

    @SuppressLint({"BadMethodUse-android.util.Log.e", "CatchGeneralException"})
    public static JSONObject A00() {
        JSONObject jSONObject = new JSONObject();
        Map<Integer, AG<AbstractC0351Dr>> A03 = C0347Dn.A01().A03();
        if (A03 != null && !A03.isEmpty()) {
            try {
                Set<Integer> keyset = A03.keySet();
                for (Integer num : keyset) {
                    List<AbstractC0351Dr> A032 = A03.get(num).A03();
                    JSONArray jSONArray = new JSONArray();
                    Iterator<AbstractC0351Dr> it = A032.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().A09(true));
                    }
                    jSONObject.put(num.toString(), jSONArray);
                }
            } catch (Throwable th) {
                AK.A03(th);
            }
        }
        return jSONObject;
    }

    @SuppressLint({"BadMethodUse-java.lang.System.currentTimeMillis"})
    private void A01(String str, EnumC0346Dm enumC0346Dm, EnumC0350Dq enumC0350Dq) {
        A3 A0Y = this.A02.A0Y();
        if (A0Y != null) {
            A0Y.A5n(EJ.A05(), str, this.A00, enumC0346Dm.A03(), (int) (System.currentTimeMillis() / 1000), A00(), enumC0350Dq);
        }
        EJ.A0B(this.A02, AI.A07.A02(), str);
    }

    public final void A02() {
        this.A03.A00();
    }

    public final void A03(EnumC0346Dm enumC0346Dm) {
        this.A04.A03(enumC0346Dm, this.A01);
    }

    public final void A04(EnumC0348Do enumC0348Do, EnumC0346Dm enumC0346Dm, @Nullable String str) {
        A05(enumC0348Do, enumC0346Dm, str, EnumC0350Dq.A04);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002f, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A05(com.facebook.ads.redexgen.X.EnumC0348Do r3, com.facebook.ads.redexgen.X.EnumC0346Dm r4, @javax.annotation.Nullable java.lang.String r5, com.facebook.ads.redexgen.X.EnumC0350Dq r6) {
        /*
            r2 = this;
            r1 = r2
            com.facebook.ads.redexgen.X.Ag r0 = r1.A05
            r0.A04(r4)
            com.facebook.ads.redexgen.X.Do r0 = com.facebook.ads.redexgen.X.EnumC0348Do.A02
            if (r3 != r0) goto L2d
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L20;
                case 4: goto L2f;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.Ad r1 = (com.facebook.ads.redexgen.X.C0259Ad) r1
            com.facebook.ads.redexgen.X.Dm r4 = (com.facebook.ads.redexgen.X.EnumC0346Dm) r4
            java.lang.String r5 = (java.lang.String) r5
            com.facebook.ads.redexgen.X.Ah r0 = r1.A06
            r0.A03(r4)
            if (r5 == 0) goto L1e
            r0 = 3
            goto Lb
        L1e:
            r0 = 4
            goto Lb
        L20:
            com.facebook.ads.redexgen.X.Ad r1 = (com.facebook.ads.redexgen.X.C0259Ad) r1
            com.facebook.ads.redexgen.X.Dm r4 = (com.facebook.ads.redexgen.X.EnumC0346Dm) r4
            java.lang.String r5 = (java.lang.String) r5
            com.facebook.ads.redexgen.X.Dq r6 = (com.facebook.ads.redexgen.X.EnumC0350Dq) r6
            r1.A01(r5, r4, r6)
            r0 = 4
            goto Lb
        L2d:
            r0 = 4
            goto Lb
        L2f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0259Ad.A05(com.facebook.ads.redexgen.X.Do, com.facebook.ads.redexgen.X.Dm, java.lang.String, com.facebook.ads.redexgen.X.Dq):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0023, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A06() {
        /*
            r3 = this;
            r2 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.Ag r0 = r3.A05
            java.util.List r1 = r0.A02()
            if (r1 == 0) goto L21
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L1b;
                case 4: goto L23;
                case 5: goto L1e;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            java.util.List r1 = (java.util.List) r1
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto L19
            r0 = 3
            goto Lb
        L19:
            r0 = 5
            goto Lb
        L1b:
            r2 = 1
            r0 = 4
            goto Lb
        L1e:
            r2 = 0
            r0 = 4
            goto Lb
        L21:
            r0 = 5
            goto Lb
        L23:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0259Ad.A06():boolean");
    }
}
