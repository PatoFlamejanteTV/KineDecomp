package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.12, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass12 {
    public static byte[] A00;
    public static final String A01;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.AnonymousClass12.A00
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
            r0 = r0 ^ 14
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass12.A02(int, int, int):java.lang.String");
    }

    public static void A03() {
        A00 = new byte[]{88, 71, 74, 75, 65, 113, 91, 92, 66, 80, 65, 83, 83, 84, 72, 82, 79, 85, 71, 72, 3, 28, 9, 2, 51, 0, 5, 2, 7, 66, 69, 94, 67, 84, 53, 48, 37, 48, 13, 54, 57, 58, 52, 61, 120, 44, 55, 120, 40, 57, 42, 43, 61, 120, 50, 43, 55, 54, 120, 60, 57, 44, 57, 120, 49, 54, 120, 25, 60, 25, 59, 44, 49, 55, 54, 30, 57, 59, 44, 55, 42, 33, 118};
    }

    static {
        A03();
        A01 = AnonymousClass12.class.getSimpleName();
    }

    @Nullable
    public static AnonymousClass11 A00(C0362Ec c0362Ec, InterfaceC0422Gl interfaceC0422Gl, String str, Uri uri, Map<String, String> extraData) {
        return A01(c0362Ec, interfaceC0422Gl, str, uri, extraData, true, false);
    }

    @Nullable
    public static AnonymousClass11 A01(final C0362Ec c0362Ec, final InterfaceC0422Gl interfaceC0422Gl, final String str, final Uri uri, final Map<String, String> map, final boolean z, boolean z2) {
        if (uri == null || uri.getAuthority() == null) {
            return null;
        }
        String authority = uri.getAuthority();
        String action = A02(0, 9, 32);
        String dataJson = uri.getQueryParameter(action);
        String videoURL = A02(34, 4, 95);
        if (!TextUtils.isEmpty(uri.getQueryParameter(videoURL))) {
            try {
                String videoURL2 = A02(34, 4, 95);
                JSONObject jSONObject = new JSONObject(uri.getQueryParameter(videoURL2));
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String key = keys.next();
                    map.put(key, jSONObject.getString(key));
                }
            } catch (JSONException e) {
                Log.w(A01, A02(38, 45, 86), e);
            }
        }
        final C1E A002 = C1E.A00(interfaceC0422Gl, JJ.A00());
        char c = 65535;
        switch (authority.hashCode()) {
            case -1458789996:
                if (authority.equals(A02(9, 11, 46))) {
                    c = 2;
                    break;
                }
                break;
            case 109770977:
                if (authority.equals(A02(29, 5, 63))) {
                    c = 0;
                    break;
                }
                break;
            case 1546100943:
                if (authority.equals(A02(20, 9, 98))) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (dataJson == null) {
                    return new AnonymousClass16(c0362Ec, interfaceC0422Gl, str, uri, map, A002, z) { // from class: com.facebook.ads.redexgen.X.17
                        public static byte[] A02;
                        public static final String A03;
                        public final Uri A00;
                        public final Map<String, String> A01;

                        /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public static java.lang.String A04(int r2, int r3, int r4) {
                            /*
                                r0 = 0
                                r0 = 0
                                byte[] r1 = com.facebook.ads.redexgen.X.AnonymousClass17.A02
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
                                int r0 = r0 + (-83)
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
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass17.A04(int, int, int):java.lang.String");
                        }

                        public static void A07() {
                            A02 = new byte[]{-8, -7, -18, -9, -18, -19, -24, -19, -18, -18, -7, -11, -14, -9, -12, -59, -57, 59, 47, 64, 57, 51, 66, 8, -3, -3, 50, 51, 66, 47, 55, 58, 65, 13, 55, 50, 11, -13, 65, -59, -46, -56, -42, -45, -51, -56, 25, 38, 28, 42, 39, 33, 28, -26, 33, 38, 44, 29, 38, 44, -26, 25, 27, 44, 33, 39, 38, -26, -5, -7, 4, 4, 63, 64, 59, 62, 49, 43, 65, 62, 56, -36, -51, -44, -94, 19, 20, 15, 18, 5, -1, 21, 18, 12, -1, 23, 5, 2, -1, 6, 1, 12, 12, 2, 1, 3, 11, -49, -64, -57, -53, -51, -54, -56, -53, -49, -107, -18, -17, -28, -19, -28, -29, -34, -14, -13, -18, -15, -28, -34, -27, -32, -21, -21, -31, -32, -30, -22, -34, -12, -15, -21, -66, -39, -31, -28, -35, -36, -104, -20, -25, -104, -25, -24, -35, -26, -104, -27, -39, -22, -29, -35, -20, -104, -19, -22, -28, -78, -104, -11, 4, 4, 7, -3, 8, -7, -13, -8, -11, 8, -11, 1, 46, 46, 43, 46, -36, 44, 29, 46, 47, 37, 42, 35, -36, 29, 44, 44, 47, 37, 48, 33, 27, 32, 29, 48, 29, 30, 43, 33, 47, 44, 38, 33, -21, 38, 43, 49, 34, 43, 49, -21, 30, 32, 49, 38, 44, 43, -21, 19, 6, 2, 20, 34, 35, 30, 33, 20, 14, 24, 19, -20, -19, -30, -21, -30, -31, -36, -16, -15, -20, -17, -30, -36, -14, -17, -23};
                        }

                        static {
                            A07();
                            A03 = AnonymousClass17.class.getSimpleName();
                        }

                        {
                            this.A00 = uri;
                            this.A01 = map;
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:129:0x015d, code lost:            return r6;     */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        private android.content.Intent A01(com.facebook.ads.redexgen.X.AnonymousClass18 r11) {
                            /*
                                Method dump skipped, instructions count: 392
                                To view this dump change 'Code comments level' option to 'DEBUG'
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass17.A01(com.facebook.ads.redexgen.X.18):android.content.Intent");
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:33:0x0071, code lost:            return r3;     */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        private android.content.Intent A02(com.facebook.ads.redexgen.X.AnonymousClass18 r5) {
                            /*
                                r4 = this;
                                r0 = 0
                                android.content.Intent r3 = new android.content.Intent
                                r2 = 207(0xcf, float:2.9E-43)
                                r1 = 26
                                r0 = 106(0x6a, float:1.49E-43)
                                java.lang.String r0 = A04(r2, r1, r0)
                                r3.<init>(r0)
                                r0 = 268435456(0x10000000, float:2.524355E-29)
                                r3.addFlags(r0)
                                java.lang.String r0 = r5.A05()
                                boolean r0 = android.text.TextUtils.isEmpty(r0)
                                if (r0 != 0) goto L6b
                                r0 = 2
                            L20:
                                switch(r0) {
                                    case 2: goto L24;
                                    case 3: goto L45;
                                    case 4: goto L5b;
                                    case 5: goto L34;
                                    case 6: goto L6d;
                                    default: goto L23;
                                }
                            L23:
                                goto L20
                            L24:
                                com.facebook.ads.redexgen.X.18 r5 = (com.facebook.ads.redexgen.X.AnonymousClass18) r5
                                java.lang.String r0 = r5.A04()
                                boolean r0 = android.text.TextUtils.isEmpty(r0)
                                if (r0 != 0) goto L32
                                r0 = 3
                                goto L20
                            L32:
                                r0 = 4
                                goto L20
                            L34:
                                com.facebook.ads.redexgen.X.18 r5 = (com.facebook.ads.redexgen.X.AnonymousClass18) r5
                                android.content.Intent r3 = (android.content.Intent) r3
                                java.lang.String r0 = r5.A03()
                                android.net.Uri r0 = android.net.Uri.parse(r0)
                                r3.setData(r0)
                                r0 = 6
                                goto L20
                            L45:
                                com.facebook.ads.redexgen.X.18 r5 = (com.facebook.ads.redexgen.X.AnonymousClass18) r5
                                android.content.Intent r3 = (android.content.Intent) r3
                                android.content.ComponentName r2 = new android.content.ComponentName
                                java.lang.String r1 = r5.A05()
                                java.lang.String r0 = r5.A04()
                                r2.<init>(r1, r0)
                                r3.setComponent(r2)
                                r0 = 4
                                goto L20
                            L5b:
                                com.facebook.ads.redexgen.X.18 r5 = (com.facebook.ads.redexgen.X.AnonymousClass18) r5
                                java.lang.String r0 = r5.A03()
                                boolean r0 = android.text.TextUtils.isEmpty(r0)
                                if (r0 != 0) goto L69
                                r0 = 5
                                goto L20
                            L69:
                                r0 = 6
                                goto L20
                            L6b:
                                r0 = 4
                                goto L20
                            L6d:
                                android.content.Intent r3 = (android.content.Intent) r3
                                android.content.Intent r3 = (android.content.Intent) r3
                                return r3
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass17.A02(com.facebook.ads.redexgen.X.18):android.content.Intent");
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:15:0x005a, code lost:            return r4;     */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        private final android.net.Uri A03() {
                            /*
                                r7 = this;
                                r6 = r7
                                r0 = 0
                                r4 = 0
                                android.net.Uri r3 = r6.A00
                                r2 = 72
                                r1 = 9
                                r0 = 121(0x79, float:1.7E-43)
                                java.lang.String r0 = A04(r2, r1, r0)
                                java.lang.String r5 = r3.getQueryParameter(r0)
                                boolean r0 = android.text.TextUtils.isEmpty(r5)
                                if (r0 != 0) goto L54
                                r0 = 2
                            L1a:
                                switch(r0) {
                                    case 2: goto L1e;
                                    case 3: goto L56;
                                    case 4: goto L26;
                                    default: goto L1d;
                                }
                            L1d:
                                goto L1a
                            L1e:
                                java.lang.String r5 = (java.lang.String) r5
                                android.net.Uri r4 = android.net.Uri.parse(r5)
                                r0 = 3
                                goto L1a
                            L26:
                                com.facebook.ads.redexgen.X.17 r6 = (com.facebook.ads.redexgen.X.AnonymousClass17) r6
                                android.net.Uri r3 = r6.A00
                                r2 = 233(0xe9, float:3.27E-43)
                                r1 = 8
                                r0 = 92
                                java.lang.String r0 = A04(r2, r1, r0)
                                java.lang.String r4 = r3.getQueryParameter(r0)
                                java.util.Locale r3 = java.util.Locale.US
                                r2 = 17
                                r1 = 22
                                r0 = 123(0x7b, float:1.72E-43)
                                java.lang.String r2 = A04(r2, r1, r0)
                                r0 = 1
                                java.lang.Object[] r1 = new java.lang.Object[r0]
                                r0 = 0
                                r1[r0] = r4
                                java.lang.String r0 = java.lang.String.format(r3, r2, r1)
                                android.net.Uri r4 = android.net.Uri.parse(r0)
                                r0 = 3
                                goto L1a
                            L54:
                                r0 = 4
                                goto L1a
                            L56:
                                android.net.Uri r4 = (android.net.Uri) r4
                                android.net.Uri r4 = (android.net.Uri) r4
                                return r4
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass17.A03():android.net.Uri");
                        }

                        private List<AnonymousClass18> A05() {
                            String queryParameter = this.A00.getQueryParameter(A04(169, 12, 65));
                            if (TextUtils.isEmpty(queryParameter) || A04(15, 2, 23).equals(queryParameter)) {
                                return null;
                            }
                            ArrayList arrayList = new ArrayList();
                            try {
                                JSONArray appsiteDataArray = new JSONObject(queryParameter).optJSONArray(A04(39, 7, 17));
                                if (appsiteDataArray == null) {
                                    return arrayList;
                                }
                                for (int i = 0; i < appsiteDataArray.length(); i++) {
                                    JSONObject dataObject = appsiteDataArray.optJSONObject(i);
                                    AnonymousClass18 A003 = AnonymousClass18.A00(dataObject);
                                    if (A003 != null) {
                                        arrayList.add(A003);
                                    }
                                }
                                return arrayList;
                            } catch (JSONException e2) {
                                Log.w(A03, A04(181, 26, 105), e2);
                                return arrayList;
                            }
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:33:0x004c, code lost:            return r1;     */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        private final java.util.List<android.content.Intent> A06() {
                            /*
                                r6 = this;
                                r5 = r6
                                r0 = 0
                                r4 = 0
                                r0 = 0
                                r3 = 0
                                java.util.List r2 = r5.A05()
                                java.util.ArrayList r1 = new java.util.ArrayList
                                r1.<init>()
                                if (r2 == 0) goto L46
                                r0 = 2
                            L11:
                                switch(r0) {
                                    case 2: goto L15;
                                    case 3: goto L1d;
                                    case 4: goto L29;
                                    case 5: goto L3d;
                                    case 6: goto L48;
                                    default: goto L14;
                                }
                            L14:
                                goto L11
                            L15:
                                java.util.List r2 = (java.util.List) r2
                                java.util.Iterator r3 = r2.iterator()
                                r0 = 3
                                goto L11
                            L1d:
                                java.util.Iterator r3 = (java.util.Iterator) r3
                                boolean r0 = r3.hasNext()
                                if (r0 == 0) goto L27
                                r0 = 4
                                goto L11
                            L27:
                                r0 = 6
                                goto L11
                            L29:
                                com.facebook.ads.redexgen.X.17 r5 = (com.facebook.ads.redexgen.X.AnonymousClass17) r5
                                java.util.Iterator r3 = (java.util.Iterator) r3
                                java.lang.Object r0 = r3.next()
                                com.facebook.ads.redexgen.X.18 r0 = (com.facebook.ads.redexgen.X.AnonymousClass18) r0
                                android.content.Intent r4 = r5.A01(r0)
                                if (r4 == 0) goto L3b
                                r0 = 5
                                goto L11
                            L3b:
                                r0 = 3
                                goto L11
                            L3d:
                                java.util.ArrayList r1 = (java.util.ArrayList) r1
                                android.content.Intent r4 = (android.content.Intent) r4
                                r1.add(r4)
                                r0 = 3
                                goto L11
                            L46:
                                r0 = 6
                                goto L11
                            L48:
                                java.util.ArrayList r1 = (java.util.ArrayList) r1
                                java.util.List r1 = (java.util.List) r1
                                return r1
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass17.A06():java.util.List");
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:26:0x0037, code lost:            return r2;     */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        private boolean A08() {
                            /*
                                r6 = this;
                                r5 = r6
                                r4 = 0
                                r3 = 0
                                r0 = 0
                                r0 = 0
                                r2 = 0
                                java.util.List r1 = r5.A06()
                                if (r1 != 0) goto L35
                                r0 = 2
                            Ld:
                                switch(r0) {
                                    case 2: goto L37;
                                    case 3: goto L25;
                                    case 4: goto L10;
                                    case 5: goto L11;
                                    case 6: goto L1b;
                                    default: goto L10;
                                }
                            L10:
                                goto Ld
                            L11:
                                java.util.Iterator r3 = (java.util.Iterator) r3
                                java.lang.Object r4 = r3.next()
                                android.content.Intent r4 = (android.content.Intent) r4
                                r0 = 6
                                goto Ld
                            L1b:
                                com.facebook.ads.redexgen.X.17 r5 = (com.facebook.ads.redexgen.X.AnonymousClass17) r5     // Catch: java.lang.Exception -> L2b
                                com.facebook.ads.redexgen.X.Ec r0 = r5.A00     // Catch: java.lang.Exception -> L2b
                                r0.startActivity(r4)     // Catch: java.lang.Exception -> L2b
                                r2 = 1
                                r0 = 2
                                goto Ld
                            L25:
                                java.util.List r1 = (java.util.List) r1
                                java.util.Iterator r3 = r1.iterator()
                            L2b:
                                boolean r0 = r3.hasNext()
                                if (r0 == 0) goto L33
                                r0 = 5
                                goto Ld
                            L33:
                                r0 = 2
                                goto Ld
                            L35:
                                r0 = 3
                                goto Ld
                            L37:
                                return r2
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass17.A08():boolean");
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:32:0x007e, code lost:            return r6;     */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        private boolean A09() {
                            /*
                                r7 = this;
                                r5 = r7
                                r6 = 0
                                r3 = 0
                                r0 = 0
                                r0 = 0
                                r0 = 0
                                com.facebook.ads.redexgen.X.JM r4 = new com.facebook.ads.redexgen.X.JM
                                r4.<init>()
                                r0 = 2
                            Lc:
                                switch(r0) {
                                    case 2: goto L10;
                                    case 3: goto Lf;
                                    case 4: goto Lf;
                                    case 5: goto Lf;
                                    case 6: goto Lf;
                                    case 7: goto L58;
                                    case 8: goto L6a;
                                    case 9: goto L66;
                                    case 10: goto Lf;
                                    case 11: goto L7e;
                                    default: goto Lf;
                                }
                            Lf:
                                goto Lc
                            L10:
                                com.facebook.ads.redexgen.X.17 r5 = (com.facebook.ads.redexgen.X.AnonymousClass17) r5     // Catch: java.lang.Exception -> L21
                                com.facebook.ads.redexgen.X.Ec r2 = r5.A00     // Catch: java.lang.Exception -> L21
                                android.net.Uri r1 = r5.A03()     // Catch: java.lang.Exception -> L21
                                java.lang.String r0 = r5.A02     // Catch: java.lang.Exception -> L21
                                com.facebook.ads.redexgen.X.JM.A08(r4, r2, r1, r0)     // Catch: java.lang.Exception -> L21
                                r6 = 1
                                r0 = 11
                                goto Lc
                            L21:
                                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                                r3.<init>()
                                r2 = 142(0x8e, float:1.99E-43)
                                r1 = 27
                                r0 = 37
                                java.lang.String r0 = A04(r2, r1, r0)
                                java.lang.StringBuilder r1 = r3.append(r0)
                                android.net.Uri r0 = r5.A00
                                java.lang.String r0 = r0.toString()
                                java.lang.StringBuilder r0 = r1.append(r0)
                                r0.toString()
                                android.net.Uri r3 = r5.A00
                                r2 = 85
                                r1 = 22
                                r0 = 77
                                java.lang.String r0 = A04(r2, r1, r0)
                                java.lang.String r3 = r3.getQueryParameter(r0)
                                if (r3 == 0) goto L55
                                r0 = 7
                                goto Lc
                            L55:
                                r0 = 9
                                goto Lc
                            L58:
                                java.lang.String r3 = (java.lang.String) r3
                                int r0 = r3.length()
                                if (r0 <= 0) goto L63
                                r0 = 8
                                goto Lc
                            L63:
                                r0 = 9
                                goto Lc
                            L66:
                                r6 = 0
                                r0 = 11
                                goto Lc
                            L6a:
                                com.facebook.ads.redexgen.X.17 r5 = (com.facebook.ads.redexgen.X.AnonymousClass17) r5
                                com.facebook.ads.redexgen.X.JM r4 = (com.facebook.ads.redexgen.X.JM) r4
                                java.lang.String r3 = (java.lang.String) r3
                                com.facebook.ads.redexgen.X.Ec r2 = r5.A00
                                android.net.Uri r1 = android.net.Uri.parse(r3)
                                java.lang.String r0 = r5.A02
                                com.facebook.ads.redexgen.X.JM.A08(r4, r2, r1, r0)
                                r0 = 9
                                goto Lc
                            L7e:
                                return r6
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass17.A09():boolean");
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:26:0x0046, code lost:            r5.A01.put(r3, java.lang.String.valueOf(true));     */
                        /* JADX WARN: Code restructure failed: missing block: B:27:0x0056, code lost:            return r4;     */
                        @Override // com.facebook.ads.redexgen.X.AnonymousClass11
                        @android.support.annotation.Nullable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final com.facebook.ads.redexgen.X.AnonymousClass10 A0A() {
                            /*
                                r6 = this;
                                r5 = r6
                                r0 = 0
                                r0 = 0
                                r4 = 0
                                r2 = 0
                                r1 = 15
                                r0 = 54
                                java.lang.String r3 = A04(r2, r1, r0)
                                boolean r0 = r5.A08()
                                if (r0 != 0) goto L43
                                r0 = 2
                            L14:
                                switch(r0) {
                                    case 2: goto L32;
                                    case 3: goto L17;
                                    case 4: goto L25;
                                    case 5: goto L17;
                                    case 6: goto L18;
                                    case 7: goto L17;
                                    case 8: goto L17;
                                    case 9: goto L46;
                                    default: goto L17;
                                }
                            L17:
                                goto L14
                            L18:
                                r2 = 117(0x75, float:1.64E-43)
                                r1 = 25
                                r0 = 44
                                java.lang.String r3 = A04(r2, r1, r0)     // Catch: java.lang.Exception -> L3e
                                r0 = 9
                                goto L14
                            L25:
                                r2 = 241(0xf1, float:3.38E-43)
                                r1 = 16
                                r0 = 42
                                java.lang.String r3 = A04(r2, r1, r0)     // Catch: java.lang.Exception -> L3e
                                r0 = 9
                                goto L14
                            L32:
                                com.facebook.ads.redexgen.X.17 r5 = (com.facebook.ads.redexgen.X.AnonymousClass17) r5     // Catch: java.lang.Exception -> L3e
                                boolean r0 = r5.A09()     // Catch: java.lang.Exception -> L3e
                                if (r0 == 0) goto L3c
                                r0 = 4
                                goto L14
                            L3c:
                                r0 = 6
                                goto L14
                            L3e:
                                com.facebook.ads.redexgen.X.10 r4 = com.facebook.ads.redexgen.X.AnonymousClass10.A02
                                r0 = 9
                                goto L14
                            L43:
                                r0 = 9
                                goto L14
                            L46:
                                com.facebook.ads.redexgen.X.17 r5 = (com.facebook.ads.redexgen.X.AnonymousClass17) r5
                                java.lang.String r3 = (java.lang.String) r3
                                java.util.Map<java.lang.String, java.lang.String> r1 = r5.A01
                                r0 = 1
                                java.lang.String r0 = java.lang.String.valueOf(r0)
                                r1.put(r3, r0)
                                com.facebook.ads.redexgen.X.10 r4 = (com.facebook.ads.redexgen.X.AnonymousClass10) r4
                                return r4
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass17.A0A():com.facebook.ads.redexgen.X.10");
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:            r5 = r5;        r5.A0C(r5.A01, r4);     */
                        /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:            return;     */
                        @Override // com.facebook.ads.redexgen.X.AnonymousClass16
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final void A0B() {
                            /*
                                r6 = this;
                                r5 = r6
                                r0 = 0
                                r4 = 0
                                boolean r0 = r5.A01
                                if (r0 == 0) goto L2c
                                r0 = 2
                            L8:
                                switch(r0) {
                                    case 2: goto Lc;
                                    case 3: goto L2e;
                                    case 4: goto L14;
                                    default: goto Lb;
                                }
                            Lb:
                                goto L8
                            Lc:
                                com.facebook.ads.redexgen.X.17 r5 = (com.facebook.ads.redexgen.X.AnonymousClass17) r5
                                com.facebook.ads.redexgen.X.10 r4 = r5.A0A()
                                r0 = 3
                                goto L8
                            L14:
                                com.facebook.ads.redexgen.X.17 r5 = (com.facebook.ads.redexgen.X.AnonymousClass17) r5
                                java.util.Map<java.lang.String, java.lang.String> r3 = r5.A01
                                r2 = 241(0xf1, float:3.38E-43)
                                r1 = 16
                                r0 = 42
                                java.lang.String r1 = A04(r2, r1, r0)
                                r0 = 1
                                java.lang.String r0 = java.lang.String.valueOf(r0)
                                r3.put(r1, r0)
                                r0 = 3
                                goto L8
                            L2c:
                                r0 = 4
                                goto L8
                            L2e:
                                com.facebook.ads.redexgen.X.17 r5 = (com.facebook.ads.redexgen.X.AnonymousClass17) r5
                                java.util.Map<java.lang.String, java.lang.String> r0 = r5.A01
                                r5.A0C(r0, r4)
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass17.A0B():void");
                        }
                    };
                }
                return null;
            case 1:
                return z2 ? new AnonymousClass19(c0362Ec, interfaceC0422Gl, str, uri, map) : new AnonymousClass16(c0362Ec, interfaceC0422Gl, str, uri, map, A002, z) { // from class: com.facebook.ads.redexgen.X.1A
                    public static byte[] A02;
                    public static final String A03;
                    public final Uri A00;
                    public final Map<String, String> A01;

                    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public static java.lang.String A01(int r2, int r3, int r4) {
                        /*
                            r0 = 0
                            r0 = 0
                            byte[] r1 = com.facebook.ads.redexgen.X.C1A.A02
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
                            r0 = r0 ^ 56
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1A.A01(int, int, int):java.lang.String");
                    }

                    public static void A02() {
                        A02 = new byte[]{Byte.MAX_VALUE, 88, 80, 85, 92, 93, 25, 77, 86, 25, 86, 73, 92, 87, 25, 85, 80, 87, 82, 25, 76, 75, 85, 3, 25, 89, 92, 91, 94};
                    }

                    static {
                        A02();
                        A03 = C1A.class.getSimpleName();
                    }

                    {
                        this.A00 = uri;
                        this.A01 = map;
                    }

                    @Override // com.facebook.ads.redexgen.X.AnonymousClass11
                    @Nullable
                    public final AnonymousClass10 A0A() {
                        try {
                            JM.A08(new JM(), ((AnonymousClass11) this).A00, Uri.parse(this.A00.getQueryParameter(A01(25, 4, 13))), this.A02);
                            return null;
                        } catch (Exception unused) {
                            String str2 = A01(0, 25, 1) + this.A00.toString();
                            return AnonymousClass10.A02;
                        }
                    }

                    @Override // com.facebook.ads.redexgen.X.AnonymousClass16
                    public final void A0B() {
                        AnonymousClass10 anonymousClass10 = null;
                        if (((AnonymousClass16) this).A01) {
                            anonymousClass10 = A0A();
                        }
                        A0C(this.A01, anonymousClass10);
                    }
                };
            case 2:
                return new AnonymousClass11(c0362Ec, interfaceC0422Gl, str, uri, map) { // from class: com.facebook.ads.redexgen.X.1B
                    public static byte[] A02;
                    public static final String A03;
                    public final Uri A00;
                    public final Map<String, String> A01;

                    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public static java.lang.String A00(int r2, int r3, int r4) {
                        /*
                            r0 = 0
                            r0 = 0
                            byte[] r1 = com.facebook.ads.redexgen.X.C1B.A02
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
                            r0 = r0 ^ 88
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1B.A00(int, int, int):java.lang.String");
                    }

                    public static void A01() {
                        A02 = new byte[]{38, 43, 34, 55, 23, 21, 14, 8, 21, 14, 19, 30};
                    }

                    static {
                        A01();
                        A03 = C1B.class.getSimpleName();
                    }

                    {
                        this.A00 = uri;
                        this.A01 = map;
                    }

                    @Override // com.facebook.ads.redexgen.X.AnonymousClass11
                    public final void A03() {
                        EnumC0426Gp enumC0426Gp = EnumC0426Gp.A04;
                        String queryParameter = this.A00.getQueryParameter(A00(4, 8, 63));
                        if (!TextUtils.isEmpty(queryParameter)) {
                            try {
                                enumC0426Gp = EnumC0426Gp.values()[Integer.valueOf(queryParameter).intValue()];
                            } catch (Exception unused) {
                            }
                        }
                        super.A01.A5g(this.A02, this.A01, this.A00.getQueryParameter(A00(0, 4, 10)), enumC0426Gp);
                    }
                };
            default:
                return new AnonymousClass11(c0362Ec, interfaceC0422Gl, str, uri) { // from class: com.facebook.ads.redexgen.X.1C
                    public static byte[] A01;
                    public static final String A02;
                    public final Uri A00;

                    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public static java.lang.String A00(int r2, int r3, int r4) {
                        /*
                            r0 = 0
                            r0 = 0
                            byte[] r1 = com.facebook.ads.redexgen.X.C1C.A01
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
                            int r0 = r0 + (-8)
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1C.A00(int, int, int):java.lang.String");
                    }

                    public static void A01() {
                        A01 = new byte[]{-55, -28, -20, -17, -24, -25, -93, -9, -14, -93, -14, -13, -24, -15, -93, -17, -20, -15, -18, -93, -8, -11, -17, -67, -93, 122, 109, 108, 113, 122, 109, 107, 124, 105, 107, 124, 113, 119, 118, 98, 72};
                    }

                    static {
                        A01();
                        A02 = C1C.class.getSimpleName();
                    }

                    {
                        this.A00 = uri;
                    }

                    @Override // com.facebook.ads.redexgen.X.AnonymousClass11
                    public final void A03() {
                        try {
                            Log.w(A00(25, 16, 32), this.A00.toString());
                            JM.A08(new JM(), super.A00, this.A00, this.A02);
                        } catch (Exception unused) {
                            String str2 = A00(0, 25, 123) + this.A00.toString();
                        }
                    }
                };
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0033, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A04(java.lang.String r4) {
        /*
            r3 = 0
            r2 = 29
            r1 = 5
            r0 = 63
            java.lang.String r0 = A02(r2, r1, r0)
            boolean r0 = r0.equalsIgnoreCase(r4)
            if (r0 != 0) goto L31
            r0 = 2
        L11:
            switch(r0) {
                case 2: goto L15;
                case 3: goto L2b;
                case 4: goto L33;
                case 5: goto L2e;
                default: goto L14;
            }
        L14:
            goto L11
        L15:
            java.lang.String r4 = (java.lang.String) r4
            r2 = 20
            r1 = 9
            r0 = 98
            java.lang.String r0 = A02(r2, r1, r0)
            boolean r0 = r0.equalsIgnoreCase(r4)
            if (r0 == 0) goto L29
            r0 = 3
            goto L11
        L29:
            r0 = 5
            goto L11
        L2b:
            r3 = 1
            r0 = 4
            goto L11
        L2e:
            r3 = 0
            r0 = 4
            goto L11
        L31:
            r0 = 3
            goto L11
        L33:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass12.A04(java.lang.String):boolean");
    }
}
