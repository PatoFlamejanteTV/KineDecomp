package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.widget.RelativeLayout;

/* renamed from: com.facebook.ads.redexgen.X.85 */
/* loaded from: assets/audience_network.dex */
public class AnonymousClass85 {
    public static byte[] A04;
    public final Intent A00;
    public final AnonymousClass89 A01;
    public final C0362Ec A02;
    public final InterfaceC0422Gl A03;

    static {
        A0N();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A0M(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.AnonymousClass85.A04
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
            r0 = r0 ^ 54
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass85.A0M(int, int, int):java.lang.String");
    }

    public static void A0N() {
        A04 = new byte[]{96, Byte.MAX_VALUE, 114, 115, 121, 73, 98, Byte.MAX_VALUE, 123, 115, 73, 102, 121, 122, 122, Byte.MAX_VALUE, 120, 113, 73, Byte.MAX_VALUE, 120, 98, 115, 100, 96, 119, 122, 0, 23, 5, 19, 0, 22, 23, 22, 36, 27, 22, 23, 29, 51, 22, 54, 19, 6, 19, 48, 7, 28, 22, 30, 23, 84, 81, 106, 81, 84, 65, 84, 106, 87, 64, 91, 81, 89, 80};
    }

    public AnonymousClass85(AnonymousClass89 anonymousClass89, Intent intent, InterfaceC0422Gl interfaceC0422Gl, C0362Ec c0362Ec) {
        this.A01 = anonymousClass89;
        this.A00 = intent;
        this.A03 = interfaceC0422Gl;
        this.A02 = c0362Ec;
    }

    public /* synthetic */ AnonymousClass85(AnonymousClass89 anonymousClass89, Intent intent, InterfaceC0422Gl interfaceC0422Gl, C0362Ec c0362Ec, AnonymousClass80 anonymousClass80) {
        this(anonymousClass89, intent, interfaceC0422Gl, c0362Ec);
    }

    private C2W A00() {
        return (C2W) this.A00.getSerializableExtra(A0M(52, 14, 3));
    }

    public InterfaceC0524Ko A02() {
        return new C0530Ku(this.A01, this.A02, this.A03, new AnonymousClass82(this.A01, null));
    }

    public InterfaceC0524Ko A03() {
        return new C0616Oe(this.A02, this.A03, new AnonymousClass82(this.A01, null), A00(), new MR(), 1);
    }

    public InterfaceC0524Ko A04() {
        return new C0616Oe(this.A02, this.A03, new AnonymousClass82(this.A01, null), (C00622h) this.A00.getSerializableExtra(A0M(27, 25, 68)), new MS(), 0);
    }

    public InterfaceC0524Ko A05() {
        return new PP(this.A02, this.A03, new EV(this.A02), new AnonymousClass82(this.A01, null), A00());
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0054, code lost:            return (com.facebook.ads.redexgen.X.InterfaceC0524Ko) r6;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.facebook.ads.redexgen.X.InterfaceC0524Ko A06() {
        /*
            r13 = this;
            r5 = r13
            r6 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.2W r10 = r5.A00()
            boolean r0 = r10.A0e()
            if (r0 == 0) goto L4e
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L14;
                case 3: goto L50;
                case 4: goto L37;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            com.facebook.ads.redexgen.X.85 r5 = (com.facebook.ads.redexgen.X.AnonymousClass85) r5
            com.facebook.ads.redexgen.X.2W r10 = (com.facebook.ads.redexgen.X.C2W) r10
            r1 = 0
            com.facebook.ads.redexgen.X.Or r6 = new com.facebook.ads.redexgen.X.Or
            com.facebook.ads.redexgen.X.Ec r7 = r5.A02
            com.facebook.ads.redexgen.X.MR r8 = new com.facebook.ads.redexgen.X.MR
            r8.<init>()
            com.facebook.ads.redexgen.X.Gl r9 = r5.A03
            com.facebook.ads.redexgen.X.EV r11 = new com.facebook.ads.redexgen.X.EV
            com.facebook.ads.redexgen.X.Ec r0 = r5.A02
            r11.<init>(r0)
            com.facebook.ads.redexgen.X.82 r12 = new com.facebook.ads.redexgen.X.82
            com.facebook.ads.redexgen.X.89 r0 = r5.A01
            r12.<init>(r0, r1)
            r6.<init>(r7, r8, r9, r10, r11, r12)
            r0 = 3
            goto L10
        L37:
            com.facebook.ads.redexgen.X.85 r5 = (com.facebook.ads.redexgen.X.AnonymousClass85) r5
            com.facebook.ads.redexgen.X.2W r10 = (com.facebook.ads.redexgen.X.C2W) r10
            r4 = 0
            com.facebook.ads.redexgen.X.LD r6 = new com.facebook.ads.redexgen.X.LD
            com.facebook.ads.redexgen.X.Ec r3 = r5.A02
            com.facebook.ads.redexgen.X.Gl r2 = r5.A03
            com.facebook.ads.redexgen.X.82 r1 = new com.facebook.ads.redexgen.X.82
            com.facebook.ads.redexgen.X.89 r0 = r5.A01
            r1.<init>(r0, r4)
            r6.<init>(r3, r10, r2, r1)
            r0 = 3
            goto L10
        L4e:
            r0 = 4
            goto L10
        L50:
            java.lang.Object r6 = (java.lang.Object) r6
            com.facebook.ads.redexgen.X.Ko r6 = (com.facebook.ads.redexgen.X.InterfaceC0524Ko) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass85.A06():com.facebook.ads.redexgen.X.Ko");
    }

    public InterfaceC0524Ko A07() {
        return new C0549Ln(this.A02, this.A03, new AnonymousClass82(this.A01, null), A00(), null, new MR());
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x005e, code lost:            return (com.facebook.ads.redexgen.X.InterfaceC0524Ko) r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.facebook.ads.redexgen.X.InterfaceC0524Ko A08() {
        /*
            r12 = this;
            r2 = r12
            r3 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.2W r9 = r2.A00()
            boolean r0 = r9.A0e()
            if (r0 == 0) goto L58
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L14;
                case 3: goto L5a;
                case 4: goto L38;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            com.facebook.ads.redexgen.X.85 r2 = (com.facebook.ads.redexgen.X.AnonymousClass85) r2
            com.facebook.ads.redexgen.X.2W r9 = (com.facebook.ads.redexgen.X.C2W) r9
            r1 = 0
            com.facebook.ads.redexgen.X.P6 r3 = new com.facebook.ads.redexgen.X.P6
            com.facebook.ads.redexgen.X.Ec r6 = r2.A02
            com.facebook.ads.redexgen.X.MR r7 = new com.facebook.ads.redexgen.X.MR
            r7.<init>()
            com.facebook.ads.redexgen.X.Gl r8 = r2.A03
            com.facebook.ads.redexgen.X.EV r10 = new com.facebook.ads.redexgen.X.EV
            com.facebook.ads.redexgen.X.Ec r0 = r2.A02
            r10.<init>(r0)
            com.facebook.ads.redexgen.X.82 r11 = new com.facebook.ads.redexgen.X.82
            com.facebook.ads.redexgen.X.89 r0 = r2.A01
            r11.<init>(r0, r1)
            r5 = r3
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r0 = 3
            goto L10
        L38:
            com.facebook.ads.redexgen.X.85 r2 = (com.facebook.ads.redexgen.X.AnonymousClass85) r2
            r1 = 0
            com.facebook.ads.redexgen.X.LO r3 = new com.facebook.ads.redexgen.X.LO
            com.facebook.ads.redexgen.X.Ec r4 = r2.A02
            com.facebook.ads.redexgen.X.Gl r5 = r2.A03
            com.facebook.ads.redexgen.X.2W r6 = r2.A00()
            com.facebook.ads.redexgen.X.EV r7 = new com.facebook.ads.redexgen.X.EV
            com.facebook.ads.redexgen.X.Ec r0 = r2.A02
            r7.<init>(r0)
            com.facebook.ads.redexgen.X.82 r8 = new com.facebook.ads.redexgen.X.82
            com.facebook.ads.redexgen.X.89 r0 = r2.A01
            r8.<init>(r0, r1)
            r3.<init>(r4, r5, r6, r7, r8)
            r0 = 3
            goto L10
        L58:
            r0 = 4
            goto L10
        L5a:
            java.lang.Object r3 = (java.lang.Object) r3
            com.facebook.ads.redexgen.X.Ko r3 = (com.facebook.ads.redexgen.X.InterfaceC0524Ko) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass85.A08():com.facebook.ads.redexgen.X.Ko");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x006d, code lost:            return (com.facebook.ads.redexgen.X.InterfaceC0524Ko) r5;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.facebook.ads.redexgen.X.InterfaceC0524Ko A09() {
        /*
            r13 = this;
            r2 = r13
            r5 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            android.content.Intent r4 = r2.A00
            r3 = 27
            r1 = 25
            r0 = 68
            java.lang.String r0 = A0M(r3, r1, r0)
            java.io.Serializable r10 = r4.getSerializableExtra(r0)
            com.facebook.ads.redexgen.X.2h r10 = (com.facebook.ads.redexgen.X.C00622h) r10
            boolean r0 = r10.A0e()
            if (r0 == 0) goto L67
            r0 = 2
        L1e:
            switch(r0) {
                case 2: goto L22;
                case 3: goto L69;
                case 4: goto L49;
                default: goto L21;
            }
        L21:
            goto L1e
        L22:
            com.facebook.ads.redexgen.X.85 r2 = (com.facebook.ads.redexgen.X.AnonymousClass85) r2
            com.facebook.ads.redexgen.X.2h r10 = (com.facebook.ads.redexgen.X.C00622h) r10
            r4 = 0
            com.facebook.ads.redexgen.X.P6 r5 = new com.facebook.ads.redexgen.X.P6
            com.facebook.ads.redexgen.X.Ec r7 = r2.A02
            com.facebook.ads.redexgen.X.MS r8 = new com.facebook.ads.redexgen.X.MS
            r8.<init>()
            com.facebook.ads.redexgen.X.Gl r9 = r2.A03
            com.facebook.ads.redexgen.X.EV r3 = new com.facebook.ads.redexgen.X.EV
            com.facebook.ads.redexgen.X.Ec r0 = r2.A02
            r3.<init>(r0)
            com.facebook.ads.redexgen.X.88 r1 = new com.facebook.ads.redexgen.X.88
            com.facebook.ads.redexgen.X.89 r0 = r2.A01
            r1.<init>(r0)
            r6 = r5
            r10 = r10
            r11 = r3
            r12 = r1
            r6.<init>(r7, r8, r9, r10, r11, r12)
            r0 = 3
            goto L1e
        L49:
            com.facebook.ads.redexgen.X.85 r2 = (com.facebook.ads.redexgen.X.AnonymousClass85) r2
            com.facebook.ads.redexgen.X.2h r10 = (com.facebook.ads.redexgen.X.C00622h) r10
            r1 = 0
            com.facebook.ads.redexgen.X.M3 r5 = new com.facebook.ads.redexgen.X.M3
            com.facebook.ads.redexgen.X.Ec r6 = r2.A02
            com.facebook.ads.redexgen.X.Gl r7 = r2.A03
            com.facebook.ads.redexgen.X.Lb r8 = new com.facebook.ads.redexgen.X.Lb
            com.facebook.ads.redexgen.X.Ec r0 = r2.A02
            r8.<init>(r0)
            com.facebook.ads.redexgen.X.88 r9 = new com.facebook.ads.redexgen.X.88
            com.facebook.ads.redexgen.X.89 r0 = r2.A01
            r9.<init>(r0)
            r5.<init>(r6, r7, r8, r9, r10)
            r0 = 3
            goto L1e
        L67:
            r0 = 4
            goto L1e
        L69:
            java.lang.Object r5 = (java.lang.Object) r5
            com.facebook.ads.redexgen.X.Ko r5 = (com.facebook.ads.redexgen.X.InterfaceC0524Ko) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass85.A09():com.facebook.ads.redexgen.X.Ko");
    }

    public InterfaceC0524Ko A0A() {
        C00622h c00622h = (C00622h) this.A00.getSerializableExtra(A0M(27, 25, 68));
        return new C0549Ln(this.A02, this.A03, new AnonymousClass88(this.A01), c00622h, c00622h.A0U(), new MS());
    }

    public InterfaceC0524Ko A0B(RelativeLayout relativeLayout) {
        ML ml = new ML(this.A02, new AnonymousClass83() { // from class: com.facebook.ads.redexgen.X.84
            @Override // com.facebook.ads.redexgen.X.AnonymousClass83
            public final void A6e() {
                AnonymousClass89 anonymousClass89;
                anonymousClass89 = AnonymousClass85.this.A01;
                anonymousClass89.A0H().finish();
            }
        }, this.A03, new AnonymousClass82(this.A01, null));
        ml.A05(relativeLayout);
        ml.A04(this.A00.getIntExtra(A0M(0, 27, 32), 200));
        KE.A0P(relativeLayout, -16777216);
        return ml;
    }
}
