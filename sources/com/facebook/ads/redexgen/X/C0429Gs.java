package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.util.Log;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Gs, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0429Gs implements InterfaceC0417Gg {
    public static byte[] A02;
    public static final String A03;
    public C0365Ef A00;
    public C0382Ew A01;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0429Gs.A02
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
            int r0 = r0 + (-35)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0429Gs.A00(int, int, int):java.lang.String");
    }

    public static void A08() {
        A02 = new byte[]{-62, -44, -31, -27, -44, -31, -113, -33, -31, -34, -46, -44, -30, -30, -44, -45, -113, -44, -27, -44, -35, -29, -72, -45, -113, -18, -23, -27, -33, -24, -19, -65, -62, -44, -57, -62, -59, -60, -64, -45, -44, -47, -60, -116, -62, -50, -51, -59, -56, -58, -116, -60, -43, -60, -51, -45, -116, -52, -64, -58, -56, -62, -49, -32, -49, -40, -34, -35, -80, -94, -80, -80, -90, -84, -85, -100, -90, -95, -91, -21, -12, -9, -91, -22, -5, -22, -13, -7, -50, -23, -91, -61, -43, -30, -26, -43, -30, -112, -30, -43, -28, -27, -30, -34, -43, -44, -112, -30, -43, -28, -30, -23, -47, -46, -36, -43, -112, -43, -30, -30, -33, -30, -112, -45, -33, -44, -43, -112, -81, -63, -50, -46, -63, -50, 124, -50, -63, -48, -47, -50, -54, -63, -64, 124, -54, -53, -54, -119, -50, -63, -48, -50, -43, -67, -66, -56, -63, 124, -63, -50, -50, -53, -50, 124, -65, -53, -64, -63, 124, -5, -8, 11, -8, -7, -8, 10, -4, -33, -28, -37, -48, 114, -85, -73, -84, -83, -26, -7, -7, -22, -14, -11, -7, Byte.MAX_VALUE, -104, -117, -116, -106, -113, 74, -98, -103, 74, -102, -117, -100, -99, -113, 74, -99, -113, -100, -96, -113, -100, 74, -100, -113, -99, -102, -103, -104, -99, -113, 74, -117, -98, 74, -102, -103, -99, -109, -98, -109, -103, -104, 74, -35, -10, -23, -22, -12, -19, -88, -4, -9, -88, -8, -23, -6, -5, -19, -88, -19, -2, -19, -10, -4, -88, -23, -4, -88, -85, -52, -45, -52, -37, -52, -53, -121, -52, -35, -52, -43, -37, -38, -121, -52, -33, -54, -52, -52, -53, -52, -53, -121, -39, -52, -37, -39, -32, -121, -45, -48, -44, -48, -37, -107, -121, -86, -42, -36, -43, -37, -95, -121, -115, -90, -103, -102, -92, -99, 88, -84, -89, 88, -88, -103, -86, -85, -99, 88, -100, -99, -102, -83, -97, -124, -89, -97, 125, -82, -99, -90, -84, 88, -103, -84, 88, -14, -17, 2, -17, -4, -9, -13, -19, -10, -25, -15, -20, -36, -50, -36, -36, -46, -40, -41, -56, -35, -46, -42, -50, -51, -2, -19, -10, -4, -88, -4, 1, -8, -19, -88, -8, -6, -9, -21, -19, -5, -5, -19, -20, -88, -22, 1, -88, -4, -16, -19, -88, -5, -19, -6, -2, -19, -6, -62, -88, -120, -90, -77, 108, -71, 101, -87, -86, -79, -86, -71, -86, 101, -90, -71, -71, -86, -78, -75, -71, -72, 101, -86, -67, -88, -86, -86, -87, -86, -87, 101, -86, -69, -86, -77, -71, -72, 115, -4, -9, -76, 7, 9, -9, -9, -7, 7, 7, -6, 9, 0, 0, 13, -62, -67, -78, -74, -82, -13, -14, -18, 1, 2, -1, -14, -20, -16, -4, -5, -13, -10, -12, -94, -67, -59, -56, -63, -64, 124, -48, -53, 124, -52, -67, -50, -49, -63, 124, -67, -54, 124, -63, -46, -63, -54, -48, 124, -59, -54, 124, -63, -46, -63, -54, -48, -49, 124, -67, -50, -50, -67, -43, 124, -62, -53, -50, 124, -64, -59, -49, -52, -67, -48, -65, -60, 124, -62, -67, -59, -56, -47, -50, -63, -118};
    }

    static {
        A08();
        A03 = C0429Gs.class.getSimpleName();
    }

    public C0429Gs(C0365Ef c0365Ef, C0382Ew c0382Ew) {
        this.A00 = c0365Ef;
        this.A01 = c0382Ew;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0117, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.json.JSONArray A01(android.database.Cursor r10) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0429Gs.A01(android.database.Cursor):org.json.JSONArray");
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0101, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.json.JSONArray A02(android.database.Cursor r10) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0429Gs.A02(android.database.Cursor):org.json.JSONArray");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0030, code lost:            return A04(r2, r3, r1);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONArray A03(org.json.JSONArray r2, org.json.JSONArray r3) {
        /*
            r0 = 0
            r1 = 0
            if (r2 == 0) goto L24
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L9;
                case 3: goto L13;
                case 4: goto L1b;
                case 5: goto L26;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            org.json.JSONArray r2 = (org.json.JSONArray) r2
            r1 = 0
            int r0 = r2.length()
            int r1 = r1 + r0
            r0 = 3
            goto L5
        L13:
            org.json.JSONArray r3 = (org.json.JSONArray) r3
            if (r3 == 0) goto L19
            r0 = 4
            goto L5
        L19:
            r0 = 5
            goto L5
        L1b:
            org.json.JSONArray r3 = (org.json.JSONArray) r3
            int r0 = r3.length()
            int r1 = r1 + r0
            r0 = 5
            goto L5
        L24:
            r0 = 3
            goto L5
        L26:
            org.json.JSONArray r2 = (org.json.JSONArray) r2
            org.json.JSONArray r3 = (org.json.JSONArray) r3
            org.json.JSONArray r0 = A04(r2, r3, r1)
            org.json.JSONArray r0 = (org.json.JSONArray) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0429Gs.A03(org.json.JSONArray, org.json.JSONArray):org.json.JSONArray");
    }

    /* JADX WARN: Code restructure failed: missing block: B:199:0x01b9, code lost:            return r13;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONArray A04(org.json.JSONArray r18, org.json.JSONArray r19, int r20) {
        /*
            Method dump skipped, instructions count: 526
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0429Gs.A04(org.json.JSONArray, org.json.JSONArray, int):org.json.JSONArray");
    }

    private JSONObject A05() {
        JSONObject jSONObject;
        JSONArray A032;
        Cursor cursor = null;
        Cursor eventsCursor = null;
        try {
            cursor = this.A01.A0B();
            eventsCursor = this.A01.A0A();
            JSONObject tokens = null;
            JSONArray jSONArray = null;
            if (cursor.getCount() > 0 && eventsCursor.getCount() > 0) {
                tokens = A07(cursor);
                jSONArray = A01(eventsCursor);
            }
            if (C0414Gd.A0O(this.A00) && (A032 = FE.A03(this.A00)) != null && A032.length() > 0) {
                jSONArray = A03(A032, jSONArray);
            }
            jSONObject = null;
            if (jSONArray != null) {
                jSONObject = new JSONObject();
                if (tokens != null) {
                    jSONObject.put(A00(25, 6, 87), tokens);
                }
                jSONObject.put(A00(62, 6, 71), jSONArray);
            }
            if (cursor != null) {
                cursor.close();
            }
            if (eventsCursor != null) {
                eventsCursor.close();
            }
        } catch (JSONException unused) {
            jSONObject = null;
            if (cursor != null) {
                cursor.close();
            }
            if (eventsCursor != null) {
                eventsCursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            if (eventsCursor != null) {
                eventsCursor.close();
            }
            throw th;
        }
        return jSONObject;
    }

    private JSONObject A06(int debugEventLimit) {
        JSONObject jSONObject;
        int A08;
        JSONArray A04;
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            cursor = this.A01.A09();
            cursor2 = this.A01.A0C(debugEventLimit);
            JSONObject jSONObject2 = null;
            JSONArray jSONArray = null;
            if (cursor2.getCount() > 0) {
                jSONObject2 = A07(cursor2);
                jSONArray = A02(cursor2);
            }
            if (C0414Gd.A0O(this.A00) && (A04 = FE.A04(this.A00, (A08 = C0414Gd.A08(this.A00)))) != null && A04.length() > 0) {
                jSONArray = A04(A04, jSONArray, debugEventLimit + A08);
            }
            jSONObject = null;
            if (jSONArray != null) {
                jSONObject = new JSONObject();
                if (jSONObject2 != null) {
                    jSONObject.put(A00(25, 6, 87), jSONObject2);
                }
                jSONObject.put(A00(62, 6, 71), jSONArray);
            }
            if (cursor != null) {
                cursor.close();
            }
            if (cursor2 != null) {
                cursor2.close();
            }
        } catch (JSONException unused) {
            jSONObject = null;
            if (cursor != null) {
                cursor.close();
            }
            if (cursor2 != null) {
                cursor2.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002e, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.json.JSONObject A07(android.database.Cursor r4) throws org.json.JSONException {
        /*
            r3 = this;
            r0 = 0
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L17;
                case 4: goto L2a;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            android.database.Cursor r4 = (android.database.Cursor) r4
            boolean r0 = r4.moveToNext()
            if (r0 == 0) goto L15
            r0 = 3
            goto L7
        L15:
            r0 = 4
            goto L7
        L17:
            android.database.Cursor r4 = (android.database.Cursor) r4
            org.json.JSONObject r2 = (org.json.JSONObject) r2
            r0 = 0
            java.lang.String r1 = r4.getString(r0)
            r0 = 1
            java.lang.String r0 = r4.getString(r0)
            r2.put(r1, r0)
            r0 = 2
            goto L7
        L2a:
            org.json.JSONObject r2 = (org.json.JSONObject) r2
            org.json.JSONObject r2 = (org.json.JSONObject) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0429Gs.A07(android.database.Cursor):org.json.JSONObject");
    }

    @SuppressLint({"CatchGeneralException"})
    private void A09(int i) {
        try {
            int A08 = this.A01.A08(i);
            if (A08 > 0) {
                this.A00.A06().A5W(A00(169, 8, 116), C0512Kc.A0n, new C0514Ke(A00(262, 44, 68) + A08));
            }
        } catch (Exception e) {
            if (BuildConfigApi.isDebug()) {
                Log.e(A03, A00(399, 38, 34), e);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0A(java.lang.String r3) {
        /*
            r2 = this;
            r1 = r2
            boolean r0 = com.facebook.ads.redexgen.X.FE.A0I(r3)
            if (r0 == 0) goto L1e
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L20;
                case 4: goto L13;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            java.lang.String r3 = (java.lang.String) r3
            com.facebook.ads.redexgen.X.FE.A0D(r3)
            r0 = 3
            goto L8
        L13:
            com.facebook.ads.redexgen.X.Gs r1 = (com.facebook.ads.redexgen.X.C0429Gs) r1
            java.lang.String r3 = (java.lang.String) r3
            com.facebook.ads.redexgen.X.Ew r0 = r1.A01
            r0.A0L(r3)
            r0 = 3
            goto L8
        L1e:
            r0 = 4
            goto L8
        L20:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0429Gs.A0A(java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0026, code lost:            return r2;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0417Gg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.json.JSONObject A3l() {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.Ef r0 = r3.A00
            int r1 = com.facebook.ads.redexgen.X.C0414Gd.A0E(r0)
            if (r1 <= 0) goto L20
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L22;
                case 4: goto L18;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            com.facebook.ads.redexgen.X.Gs r3 = (com.facebook.ads.redexgen.X.C0429Gs) r3
            org.json.JSONObject r2 = r3.A06(r1)
            r0 = 3
            goto Lc
        L18:
            com.facebook.ads.redexgen.X.Gs r3 = (com.facebook.ads.redexgen.X.C0429Gs) r3
            org.json.JSONObject r2 = r3.A05()
            r0 = 3
            goto Lc
        L20:
            r0 = 4
            goto Lc
        L22:
            org.json.JSONObject r2 = (org.json.JSONObject) r2
            org.json.JSONObject r2 = (org.json.JSONObject) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0429Gs.A3l():org.json.JSONObject");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0012. Please report as an issue. */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0417Gg
    public final boolean A5F() {
        C0429Gs c0429Gs = this;
        Throwable th = null;
        int i = 0;
        Cursor cursor = null;
        boolean z = true;
        boolean z2 = false;
        int A0E = C0414Gd.A0E(c0429Gs.A00);
        char c = A0E < 1 ? (char) 2 : (char) 3;
        while (true) {
            switch (c) {
                case 2:
                    return z2;
                case 3:
                    cursor = null;
                    c = 4;
                case 4:
                    c0429Gs = c0429Gs;
                    cursor = c0429Gs.A01.A09();
                    c = cursor.moveToFirst() ? '\b' : '\r';
                case '\b':
                    try {
                        cursor = cursor;
                        i = cursor.getInt(0);
                        c = '\n';
                    } catch (Throwable th2) {
                        th = th2;
                        c = cursor != null ? (char) 19 : (char) 20;
                    }
                case '\n':
                    c0429Gs = c0429Gs;
                    c = FE.A00(c0429Gs.A00) + i > A0E ? (char) 15 : (char) 14;
                case '\r':
                    z2 = false;
                    i = 0;
                    c = '\n';
                case 14:
                    z2 = false;
                    z = false;
                    c = 15;
                case 15:
                    cursor = cursor;
                    c = cursor != null ? (char) 16 : (char) 17;
                case 16:
                    cursor = cursor;
                    cursor.close();
                    c = 17;
                case 17:
                    z2 = z;
                    c = 2;
                case 19:
                    cursor.close();
                    c = 20;
                case 20:
                    throw th;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0417Gg
    public final void A69() {
        int A0F = C0414Gd.A0F(this.A00);
        if (A0F > -1) {
            A09(A0F);
        }
        this.A01.A0I();
        this.A01.A0J();
        FE.A0F(this.A00);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0417Gg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A6S(org.json.JSONArray r8) {
        /*
            r7 = this;
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            int r6 = r8.length()
            r5 = 0
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L3f;
                case 3: goto Le;
                case 10: goto L46;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            org.json.JSONArray r8 = (org.json.JSONArray) r8     // Catch: org.json.JSONException -> L25
            org.json.JSONObject r3 = r8.getJSONObject(r5)     // Catch: org.json.JSONException -> L25
            r2 = 437(0x1b5, float:6.12E-43)
            r1 = 2
            r0 = 112(0x70, float:1.57E-43)
            java.lang.String r0 = A00(r2, r1, r0)     // Catch: org.json.JSONException -> L25
            java.lang.String r0 = r3.getString(r0)     // Catch: org.json.JSONException -> L25
            r7.A0A(r0)     // Catch: org.json.JSONException -> L25
            goto L3b
        L25:
            r4 = move-exception
            boolean r0 = com.facebook.ads.internal.api.BuildConfigApi.isDebug()
            if (r0 == 0) goto L3b
            java.lang.String r3 = com.facebook.ads.redexgen.X.C0429Gs.A03
            r2 = 471(0x1d7, float:6.6E-43)
            r1 = 62
            r0 = 57
            java.lang.String r0 = A00(r2, r1, r0)
            android.util.Log.e(r3, r0, r4)
        L3b:
            int r5 = r5 + 1
            r0 = 2
            goto La
        L3f:
            if (r5 >= r6) goto L43
            r0 = 3
            goto La
        L43:
            r0 = 10
            goto La
        L46:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0429Gs.A6S(org.json.JSONArray):void");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0417Gg
    public final boolean A6U(JSONArray jSONArray) {
        boolean z = true;
        boolean A0O = C0414Gd.A0O(this.A00);
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString(A00(437, 2, 112));
                boolean isDebugGKEnabled = A00(36, 26, 60).equals(string);
                if (isDebugGKEnabled) {
                    C0413Gc.A0I(this.A00).A1P(jSONObject.getString(A00(457, 14, 106)));
                    DynamicLoaderFactory.makeLoader(this.A00).getInitApi().maybeAttachCrashListener(this.A00);
                } else {
                    int i2 = jSONObject.getInt(A00(182, 4, 37));
                    if (i2 == 1) {
                        boolean isDebugGKEnabled2 = BuildConfigApi.isDebug();
                        if (isDebugGKEnabled2) {
                            String str = A00(0, 25, 76) + string + A00(439, 14, 113);
                            Cursor A0D = this.A01.A0D(string);
                            boolean isDebugGKEnabled3 = A0D.moveToNext();
                            if (isDebugGKEnabled3 && A0D.getCount() > 0) {
                                String string2 = A0D.getString(A0D.getColumnIndex(C0377Er.A09.A01));
                                StringBuilder sb = new StringBuilder();
                                String eventType = A00(363, 36, 101);
                                sb.append(eventType).append(string2).toString();
                            }
                            if (A0D != null) {
                                A0D.close();
                            }
                        }
                        if (!this.A01.A0K(string) && A0O) {
                            FE.A0C(string);
                        }
                    } else if (i2 >= 1000 && i2 < 2000) {
                        if (BuildConfigApi.isDebug()) {
                            Log.e(A03, A00(91, 37, 77) + i2 + A00(78, 13, 98) + string + A00(181, 1, 33));
                        }
                        A0A(string);
                        z = false;
                    } else if (i2 >= 2000 && i2 < 3000) {
                        if (BuildConfigApi.isDebug()) {
                            Log.e(A03, A00(128, 41, 57) + i2 + A00(78, 13, 98) + string + A00(181, 1, 33));
                        }
                        if (!this.A01.A0K(string) && A0O) {
                            FE.A0C(string);
                        }
                    }
                    this.A00.A01().A5R(this.A00, jSONObject.toString());
                }
            } catch (JSONException e) {
                if (BuildConfigApi.isDebug()) {
                    Log.e(A03, A00(193, 44, 7) + i + A00(181, 1, 33), e);
                }
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0417Gg
    public final void A7M() {
        this.A01.A0H();
        FE.A07(this.A00);
    }
}
