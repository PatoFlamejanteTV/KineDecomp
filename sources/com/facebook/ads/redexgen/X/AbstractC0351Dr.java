package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Dr, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0351Dr<T> {
    public static byte[] A04;
    public static final String A05;
    public final long A00;

    @Nullable
    public final E7 A01;
    public final E8 A02;
    public final T A03;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A03(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.AbstractC0351Dr.A04
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
            int r0 = r0 + (-99)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0351Dr.A03(int, int, int):java.lang.String");
    }

    public static void A04() {
        A04 = new byte[]{-3, 14, 18, 7, -32};
    }

    public abstract int A06() throws Exception;

    public abstract JSONObject A08(JSONObject jSONObject) throws JSONException;

    public abstract boolean A0A(AbstractC0351Dr<T> abstractC0351Dr);

    static {
        A04();
        A05 = AbstractC0351Dr.class.getSimpleName();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Dr != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<T> */
    public AbstractC0351Dr(long j, @Nullable E7 e7, T t, E8 e8) {
        this.A00 = j;
        this.A01 = e7;
        this.A03 = t;
        this.A02 = e8;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Dr != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<T> */
    private final long A00() {
        return this.A00;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Dr != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<T> */
    @Nullable
    private final E7 A01() {
        return this.A01;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Dr != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<T> */
    private final E8 A02() {
        return this.A02;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:            return r2;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Dr != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<T> */
    @android.annotation.SuppressLint({"CatchGeneralException"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A05() {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            r1 = 0
            com.facebook.ads.redexgen.X.E7 r0 = r3.A01()
            if (r0 == 0) goto L37
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L26;
                case 3: goto L22;
                case 4: goto Le;
                case 5: goto L11;
                case 6: goto Ld;
                case 7: goto Ld;
                case 8: goto L39;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            r1 = 0
            r0 = 3
            goto La
        L11:
            com.facebook.ads.redexgen.X.Dr r3 = (com.facebook.ads.redexgen.X.AbstractC0351Dr) r3     // Catch: java.lang.Exception -> L1b
            int r0 = r3.A06()     // Catch: java.lang.Exception -> L1b
            int r2 = r2 + r0
            r0 = 8
            goto La
        L1b:
            r0 = move-exception
            com.facebook.ads.redexgen.X.AK.A03(r0)
            r0 = 8
            goto La
        L22:
            int r2 = r1 + 8
            r0 = 5
            goto La
        L26:
            com.facebook.ads.redexgen.X.Dr r3 = (com.facebook.ads.redexgen.X.AbstractC0351Dr) r3
            com.facebook.ads.redexgen.X.E7 r0 = r3.A01()
            java.lang.String r0 = r0.A02()
            byte[] r0 = r0.getBytes()
            int r1 = r0.length
            r0 = 3
            goto La
        L37:
            r0 = 4
            goto La
        L39:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0351Dr.A05():int");
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Dr != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<T> */
    public final T A07() {
        return this.A03;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Dr != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<T> */
    @SuppressLint({"BadMethodUse-android.util.Log.e", "CatchGeneralException"})
    public final JSONObject A09(boolean z) {
        JSONObject jSONObject = new JSONObject();
        if (z) {
            try {
                jSONObject.put(A03(4, 1, 9), ((float) this.A00) / 1000.0f);
            } catch (Throwable th) {
                AK.A03(th);
            }
        }
        if (this.A01 != null && z) {
            jSONObject.put(A03(0, 3, 55), this.A01.A03());
        }
        if (this.A02 != E8.A04 && A07() != null) {
            A08(jSONObject);
        } else if (this.A02 == E8.A04) {
            jSONObject.put(A03(3, 1, 63), ((E6) this.A03).A08());
        } else if (this.A03 == null) {
            jSONObject.put(A03(3, 1, 63), new E6(E5.A06).A08());
        }
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:146:0x0136, code lost:            return r5;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Dr != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<T> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0B(@javax.annotation.Nullable com.facebook.ads.redexgen.X.AbstractC0351Dr<T> r12, java.util.EnumSet<com.facebook.ads.redexgen.X.EnumC0349Dp> r13) {
        /*
            Method dump skipped, instructions count: 362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0351Dr.A0B(com.facebook.ads.redexgen.X.Dr, java.util.EnumSet):boolean");
    }
}
