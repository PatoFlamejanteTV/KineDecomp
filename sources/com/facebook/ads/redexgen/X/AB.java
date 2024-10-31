package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.ThreadSafe;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ThreadSafe
@SuppressLint({"StaticFieldLeak"})
/* loaded from: assets/audience_network.dex */
public final class AB {
    public static EnumC0346Dm A06;
    public static byte[] A07;
    public static final AtomicReference<AB> A08;
    public AD A00;
    public C0259Ad A01;
    public final Context A02;
    public final AA A03;
    public final AtomicReference<AO> A04 = new AtomicReference<>();
    public final AtomicReference<AF> A05 = new AtomicReference<>();

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.AB.A07
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
            int r0 = r0 + (-84)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AB.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A07 = new byte[]{-30, -28, -38, -33, -40, -47, -43, -2, 0, 20, 15};
    }

    static {
        A01();
        A08 = new AtomicReference<>();
    }

    public AB(Context context, AA aa, EnumC0346Dm enumC0346Dm) {
        this.A02 = context;
        this.A03 = aa;
        this.A01 = new C0259Ad(this.A02, this.A03);
        if (this.A04.get() == null && EJ.A0E(enumC0346Dm)) {
            A02(enumC0346Dm);
        }
    }

    private synchronized void A02(EnumC0346Dm enumC0346Dm) {
        if (this.A04.get() == null) {
            AK.A02(this.A03.A0Z());
            AF af = new AF(this.A03, this.A01);
            this.A05.set(af);
            this.A00 = new AD();
            this.A00.A00(af);
            if (this.A01.A06() && EJ.A0E(enumC0346Dm)) {
                af.A05(enumC0346Dm);
            }
            A06 = enumC0346Dm;
            this.A00.A01(enumC0346Dm);
            this.A04.set(AO.A00(this.A02, this.A03));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0047, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A03(com.facebook.ads.redexgen.X.EnumC0346Dm r4) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = com.facebook.ads.redexgen.X.EJ.A0E(r4)
            if (r0 == 0) goto L45
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto L39;
                case 3: goto L2b;
                case 4: goto L1c;
                case 5: goto L47;
                case 6: goto Ld;
                case 7: goto L1f;
                case 8: goto L42;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.AB r2 = (com.facebook.ads.redexgen.X.AB) r2
            com.facebook.ads.redexgen.X.Dm r4 = (com.facebook.ads.redexgen.X.EnumC0346Dm) r4
            com.facebook.ads.redexgen.X.AB.A06 = r4
            com.facebook.ads.redexgen.X.AD r0 = r2.A00
            if (r0 == 0) goto L19
            r0 = 7
            goto L9
        L19:
            r0 = 8
            goto L9
        L1c:
            r1 = 0
            r0 = 5
            goto L9
        L1f:
            com.facebook.ads.redexgen.X.AB r2 = (com.facebook.ads.redexgen.X.AB) r2
            com.facebook.ads.redexgen.X.Dm r4 = (com.facebook.ads.redexgen.X.EnumC0346Dm) r4
            com.facebook.ads.redexgen.X.AD r0 = r2.A00
            r0.A01(r4)
            r0 = 8
            goto L9
        L2b:
            com.facebook.ads.redexgen.X.Dm r4 = (com.facebook.ads.redexgen.X.EnumC0346Dm) r4
            com.facebook.ads.redexgen.X.Dm r0 = com.facebook.ads.redexgen.X.AB.A06
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L37
            r0 = 4
            goto L9
        L37:
            r0 = 6
            goto L9
        L39:
            com.facebook.ads.redexgen.X.AB r2 = (com.facebook.ads.redexgen.X.AB) r2
            com.facebook.ads.redexgen.X.Dm r4 = (com.facebook.ads.redexgen.X.EnumC0346Dm) r4
            r2.A02(r4)
            r0 = 3
            goto L9
        L42:
            r1 = 1
            r0 = 5
            goto L9
        L45:
            r0 = 3
            goto L9
        L47:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AB.A03(com.facebook.ads.redexgen.X.Dm):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0040, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A04(java.lang.String r6, com.facebook.ads.redexgen.X.EnumC0350Dq r7) {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            com.facebook.ads.redexgen.X.Dm r0 = com.facebook.ads.redexgen.X.AB.A06
            boolean r0 = com.facebook.ads.redexgen.X.EJ.A0E(r0)
            if (r0 == 0) goto L3e
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto L2d;
                case 3: goto L2a;
                case 4: goto L40;
                case 5: goto L20;
                case 6: goto Lf;
                case 7: goto L3b;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.AB r4 = (com.facebook.ads.redexgen.X.AB) r4
            java.lang.String r6 = (java.lang.String) r6
            com.facebook.ads.redexgen.X.Dq r7 = (com.facebook.ads.redexgen.X.EnumC0350Dq) r7
            com.facebook.ads.redexgen.X.Ad r2 = r4.A01
            com.facebook.ads.redexgen.X.Do r1 = com.facebook.ads.redexgen.X.EnumC0348Do.A02
            com.facebook.ads.redexgen.X.Dm r0 = com.facebook.ads.redexgen.X.AB.A06
            r2.A05(r1, r0, r6, r7)
            r0 = 7
            goto Lb
        L20:
            com.facebook.ads.redexgen.X.AB r4 = (com.facebook.ads.redexgen.X.AB) r4
            com.facebook.ads.redexgen.X.Ad r0 = r4.A01
            if (r0 == 0) goto L28
            r0 = 6
            goto Lb
        L28:
            r0 = 7
            goto Lb
        L2a:
            r3 = 0
            r0 = 4
            goto Lb
        L2d:
            com.facebook.ads.redexgen.X.AB r4 = (com.facebook.ads.redexgen.X.AB) r4
            java.util.concurrent.atomic.AtomicReference<com.facebook.ads.redexgen.X.AO> r0 = r4.A04
            java.lang.Object r0 = r0.get()
            if (r0 != 0) goto L39
            r0 = 3
            goto Lb
        L39:
            r0 = 5
            goto Lb
        L3b:
            r3 = 1
            r0 = 4
            goto Lb
        L3e:
            r0 = 3
            goto Lb
        L40:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AB.A04(java.lang.String, com.facebook.ads.redexgen.X.Dq):boolean");
    }

    @SuppressLint({"CatchGeneralException"})
    public final void A05(MotionEvent motionEvent) {
        try {
            if (this.A04.get() != null) {
                this.A04.get().A05(motionEvent);
            }
        } catch (Throwable th) {
            AK.A03(th);
        }
    }

    @SuppressLint({"CatchGeneralException"})
    public final synchronized boolean A06(String str) {
        JSONObject jSONObject;
        String string;
        boolean z = false;
        synchronized (this) {
            if (str != null) {
                if (!str.isEmpty()) {
                    try {
                        jSONObject = new JSONObject(str).getJSONObject(A00(7, 2, 72));
                    } catch (JSONException unused) {
                    } catch (Throwable t) {
                        AK.A03(t);
                    }
                    if (jSONObject != null) {
                        bdResponseHandled = jSONObject.has(A00(0, 2, 28)) ? false | A03(EnumC0346Dm.A00(jSONObject.getInt(A00(0, 2, 28)))) : false;
                        JSONArray jSONArray = jSONObject.getJSONArray(A00(2, 2, 35));
                        EnumC0350Dq A00 = jSONObject.has(A00(4, 3, 17)) ? EnumC0350Dq.A00(jSONObject.getInt(A00(4, 3, 17))) : EnumC0350Dq.A04;
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            if (jSONObject2.has(A00(9, 2, 87)) && (string = jSONObject2.getString(A00(9, 2, 87))) != null && !string.isEmpty()) {
                                EJ.A0B(this.A03, AI.A04.A02(), string);
                                bdResponseHandled |= A04(string, A00);
                            }
                        }
                        z = bdResponseHandled;
                    }
                }
            }
        }
        return z;
    }
}
