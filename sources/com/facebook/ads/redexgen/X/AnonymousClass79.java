package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.facebook.ads.redexgen.X.79, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass79 extends AsyncTask<String, Void, C01646j> {
    public static byte[] A05;
    public static final String A06;
    public static final Set<String> A07;
    public C0361Eb A00;
    public JA A01;
    public InterfaceC0645Ph A02;
    public Map<String, String> A03;
    public Map<String, String> A04;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.AnonymousClass79.A05
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
            int r0 = r0 + (-2)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass79.A01(int, int, int):java.lang.String");
    }

    public static void A04() {
        A05 = new byte[]{78, 90, -87, 102, 115, 102, 113, 116, 108, -75, -68, -77, -77, 85, -126, -126, Byte.MAX_VALUE, -126, 48, Byte.MAX_VALUE, Byte.MIN_VALUE, 117, 126, 121, 126, 119, 48, -123, -126, 124, 74, 48, -123};
    }

    static {
        A04();
        A06 = AnonymousClass79.class.getSimpleName();
        A07 = new HashSet();
        A07.add(A01(1, 1, 53));
        A07.add(A01(9, 4, 69));
    }

    public AnonymousClass79(C0361Eb c0361Eb) {
        this(c0361Eb, null, null);
    }

    public AnonymousClass79(C0361Eb c0361Eb, Map<String, String> map) {
        this(c0361Eb, map, null);
    }

    public AnonymousClass79(C0361Eb c0361Eb, Map<String, String> map, Map<String, String> map2) {
        this.A00 = c0361Eb;
        Map<String, String> postData = map != null ? new HashMap<>(map) : null;
        this.A03 = postData;
        Map<String, String> extraData = map2 != null ? new HashMap<>(map2) : null;
        this.A04 = extraData;
    }

    private final C01646j A00(String... strArr) {
        if (C0466Ig.A02(this)) {
            return null;
        }
        try {
            String str = strArr[0];
            if (!TextUtils.isEmpty(str) && !A07.contains(str)) {
                String A02 = A02(str);
                if (this.A03 != null && !this.A03.isEmpty()) {
                    for (Map.Entry<String, String> entry : this.A03.entrySet()) {
                        String key = entry.getKey();
                        String url = entry.getValue();
                        A02 = A03(A02, key, url);
                    }
                }
                int i = 1;
                while (true) {
                    int i2 = i + 1;
                    if (i > 2) {
                        return null;
                    }
                    if (A06(A02)) {
                        return new C01646j(this.A01);
                    }
                    i = i2;
                }
            }
            return null;
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
            return null;
        }
    }

    private String A02(String str) {
        try {
            return A03(str, A01(3, 6, 3), C0490Jf.A01(this.A00.A02().A4H()));
        } catch (Exception unused) {
            return str;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0087, code lost:            return r6;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String A03(java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
            r5 = this;
            r4 = 0
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto L81
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto L38;
                case 3: goto L2c;
                case 4: goto L83;
                case 5: goto L17;
                case 6: goto Lc;
                case 7: goto L44;
                case 8: goto L77;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            r2 = 32
            r1 = 1
            r0 = 93
            java.lang.String r4 = A01(r2, r1, r0)
            r0 = 7
            goto L8
        L17:
            java.lang.String r6 = (java.lang.String) r6
            r2 = 2
            r1 = 1
            r0 = 104(0x68, float:1.46E-43)
            java.lang.String r0 = A01(r2, r1, r0)
            boolean r0 = r6.contains(r0)
            if (r0 == 0) goto L29
            r0 = 6
            goto L8
        L29:
            r0 = 8
            goto L8
        L2c:
            java.lang.String r8 = (java.lang.String) r8
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 == 0) goto L36
            r0 = 4
            goto L8
        L36:
            r0 = 5
            goto L8
        L38:
            java.lang.String r7 = (java.lang.String) r7
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 != 0) goto L42
            r0 = 3
            goto L8
        L42:
            r0 = 4
            goto L8
        L44:
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r4 = (java.lang.String) r4
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r0 = r0.append(r6)
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.StringBuilder r3 = r0.append(r7)
            r2 = 0
            r1 = 1
            r0 = 15
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.StringBuilder r1 = r3.append(r0)
            java.lang.String r0 = java.net.URLEncoder.encode(r8)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r6 = r0.toString()
            r0 = 4
            goto L8
        L77:
            r2 = 2
            r1 = 1
            r0 = 104(0x68, float:1.46E-43)
            java.lang.String r4 = A01(r2, r1, r0)
            r0 = 7
            goto L8
        L81:
            r0 = 4
            goto L8
        L83:
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r6 = (java.lang.String) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass79.A03(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    private final void A05(C01646j c01646j) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            if (this.A02 == null) {
                return;
            }
            this.A02.A7v(c01646j);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    @SuppressLint({"CatchGeneralException"})
    private boolean A06(String str) {
        FN A7l;
        if (C0413Gc.A0h(this.A00)) {
            FM A04 = C7A.A04(this.A00);
            try {
                if (this.A04 == null || this.A04.size() == 0) {
                    A7l = A04.A7l(str, new C7V());
                } else {
                    JC jc = new JC();
                    jc.A05(this.A04);
                    A7l = A04.A7m(str, jc.A08());
                }
                this.A01 = new JA(A7l);
            } catch (Exception e) {
                Log.e(A06, A01(13, 19, 14) + str, e);
            }
        } else {
            C0483Iy A00 = C7A.A00(this.A00);
            try {
                if (this.A04 == null || this.A04.size() == 0) {
                    this.A01 = A00.A0K(str, null);
                } else {
                    JC jc2 = new JC();
                    jc2.A05(this.A04);
                    this.A01 = A00.A0L(str, jc2);
                }
            } catch (Exception e2) {
                Log.e(A06, A01(13, 19, 14) + str, e2);
            }
        }
        return this.A01 != null && this.A01.A00() == 200;
    }

    public final void A07(InterfaceC0645Ph interfaceC0645Ph) {
        this.A02 = interfaceC0645Ph;
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ C01646j doInBackground(String[] strArr) {
        C01646j c01646j = null;
        if (C0466Ig.A02(this)) {
            return null;
        }
        try {
            c01646j = A00(strArr);
            return c01646j;
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
            return c01646j;
        }
    }

    @Override // android.os.AsyncTask
    public final void onCancelled() {
        if (this.A02 != null) {
            this.A02.A7t();
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(C01646j c01646j) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            A05(c01646j);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }
}
