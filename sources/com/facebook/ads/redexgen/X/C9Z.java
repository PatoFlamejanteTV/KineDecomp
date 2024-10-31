package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* renamed from: com.facebook.ads.redexgen.X.9Z, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C9Z implements C9U {
    public static byte[] A03;
    public final InterfaceC01455p A01;
    public Set<InterfaceC02319a> A00 = new HashSet();
    public final List<C9P> A02 = new ArrayList();

    static {
        A02();
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
            byte[] r1 = com.facebook.ads.redexgen.X.C9Z.A03
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
            r0 = r0 ^ 28
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C9Z.A00(int, int, int):java.lang.String");
    }

    public static void A02() {
        A03 = new byte[]{79, 93, 93, 75, 90, 93, 83, 83, 86, 0, 73, 83, 86, 0};
    }

    public C9Z(InterfaceC01234q interfaceC01234q) {
        this.A01 = interfaceC01234q.A3o(EnumC01345d.A09);
        this.A01.A36(new C9X() { // from class: com.facebook.ads.redexgen.X.9Y
            @Override // com.facebook.ads.redexgen.X.C9X
            public final void A3d() {
                C9Z.this.A03();
            }
        });
        A03();
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0061, code lost:            return r0;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Set<com.facebook.ads.redexgen.X.InterfaceC02319a> A01(org.json.JSONObject r7) {
        /*
            r6 = 0
            r5 = 0
            r0 = 0
            r4 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r3 = 0
            r2 = 6
            r1 = 50
            java.lang.String r1 = A00(r3, r2, r1)
            org.json.JSONArray r2 = r7.optJSONArray(r1)
            if (r2 != 0) goto L5d
            r1 = 2
        L1b:
            switch(r1) {
                case 2: goto L46;
                case 3: goto L5f;
                case 4: goto L43;
                case 5: goto L37;
                case 6: goto L1f;
                case 7: goto L49;
                case 8: goto L4c;
                case 9: goto L5a;
                case 10: goto L2c;
                default: goto L1e;
            }
        L1e:
            goto L1b
        L1f:
            org.json.JSONArray r2 = (org.json.JSONArray) r2
            org.json.JSONObject r5 = r2.optJSONObject(r4)
            if (r5 != 0) goto L29
            r1 = 7
            goto L1b
        L29:
            r1 = 8
            goto L1b
        L2c:
            java.util.HashSet r0 = (java.util.HashSet) r0
            com.facebook.ads.redexgen.X.9b r6 = (com.facebook.ads.redexgen.X.C02329b) r6
            r0.add(r6)
            int r4 = r4 + 1
            r1 = 5
            goto L1b
        L37:
            org.json.JSONArray r2 = (org.json.JSONArray) r2
            int r1 = r2.length()
            if (r4 >= r1) goto L41
            r1 = 6
            goto L1b
        L41:
            r1 = 3
            goto L1b
        L43:
            r4 = 0
            r1 = 5
            goto L1b
        L46:
            r0 = 0
            r1 = 3
            goto L1b
        L49:
            r0 = 0
            r1 = 3
            goto L1b
        L4c:
            org.json.JSONObject r5 = (org.json.JSONObject) r5
            com.facebook.ads.redexgen.X.9b r6 = com.facebook.ads.redexgen.X.C02329b.A00(r5)
            if (r6 != 0) goto L57
            r1 = 9
            goto L1b
        L57:
            r1 = 10
            goto L1b
        L5a:
            r0 = 0
            r1 = 3
            goto L1b
        L5d:
            r1 = 4
            goto L1b
        L5f:
            java.util.Set r0 = (java.util.Set) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C9Z.A01(org.json.JSONObject):java.util.Set");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void A03() {
        if (this.A01.A5G()) {
            Set<InterfaceC02319a> A01 = A01(this.A01.A4X());
            if (!this.A00.equals(A01) && A01 != null) {
                this.A00 = A01;
                for (C9P listener : this.A02) {
                    listener.A3D();
                }
            }
            for (InterfaceC02319a interfaceC02319a : this.A00) {
                String.format(Locale.US, A00(6, 8, 111), interfaceC02319a.A51(), interfaceC02319a.getUrl());
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.C9U
    public final void A35(C9P c9p) {
        this.A02.add(c9p);
    }

    @Override // com.facebook.ads.redexgen.X.C9U
    public final synchronized Set<InterfaceC02319a> A4I() {
        return new HashSet(this.A00);
    }
}
