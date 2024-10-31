package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.api.AudienceNetworkActivityApi;
import com.facebook.ads.internal.api.Repairable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.89, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass89 implements AudienceNetworkActivityApi, Repairable {
    public static byte[] A0N;
    public int A00;
    public int A02;
    public long A03;
    public long A04;
    public Intent A05;
    public RelativeLayout A06;
    public C0432Gv A07;
    public IY A08;

    @Nullable
    public InterfaceC0524Ko A09;
    public MZ A0A;
    public NQ A0B;

    @Nullable
    public PU A0C;
    public String A0D;
    public String A0E;

    @Nullable
    public String A0F;
    public boolean A0H;
    public boolean A0I;
    public final AudienceNetworkActivity A0J;
    public final AudienceNetworkActivityApi A0K;
    public final C0362Ec A0L;
    public final List<AnonymousClass86> A0M = new ArrayList();
    public int A01 = -1;
    public boolean A0G = false;

    static {
        A07();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A04(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.AnonymousClass89.A0N
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
            int r0 = r0 + (-51)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass89.A04(int, int, int):java.lang.String");
    }

    public static void A07() {
        A0N = new byte[]{19, 31, 29, -34, 22, 17, 19, 21, 18, 31, 31, 27, -34, 17, 20, 35, -34, 25, 30, 36, 21, 34, 35, 36, 25, 36, 25, 17, 28, -34, 17, 19, 36, 25, 38, 25, 36, 41, 15, 20, 21, 35, 36, 34, 31, 41, 21, 20, -1, 11, 9, -54, 2, -3, -1, 1, -2, 11, 11, 7, -54, -3, 0, 15, -54, 5, 10, 16, 1, 14, 15, 16, 5, 16, 5, -3, 8, -54, 0, 5, 15, 12, 8, -3, 21, 1, 0, 19, 8, 21, 11, 26, 10, 8, 23, 12, -20, -7, -22, -20, -18, -1, -12, 1, -12, -1, 4, -48, -61, -65, -47, -82, -45, -54, -65, -78, -66, -68, 125, -75, -80, -78, -76, -79, -66, -66, -70, 125, -80, -77, -62, 125, -72, -67, -61, -76, -63, -62, -61, -72, -61, -72, -80, -69, 125, -76, -63, -63, -66, -63, -35, -10, -23, -22, -12, -19, -88, -4, -9, -88, -15, -10, -18, -19, -6, -88, -2, -15, -19, -1, -36, 1, -8, -19, -88, -18, -6, -9, -11, -88, -15, -10, -4, -19, -10, -4, -88, -9, -6, -88, -5, -23, -2, -19, -20, -47, -10, -5, -4, -23, -10, -21, -19, -37, -4, -23, -4, -19, -71, -84, -72, -68, -84, -70, -69, -101, -80, -76, -84, -68, -69, -66, -64, -66, -83, -75, -64, 0, -5, -21, -5, -2, -11, -15, -6, 0, -19, 0, -11, -5, -6, -79, -77, -90, -91, -90, -89, -86, -81, -90, -91, -112, -77, -86, -90, -81, -75, -94, -75, -86, -80, -81, -116, -90, -70, -78, -85, -90, -82, -78, -94, -122, -95, 113, -90, -81, -84, -88, -79, -73, -105, -78, -82, -88, -79, -83, -71, -73, 120, -80, -85, -83, -81, -84, -71, -71, -75, 120, -85, -82, -67, 120, -77, -72, -66, -81, -68, -67, -66, -77, -66, -77, -85, -74, 120, -80, -77, -72, -77, -67, -78, -87, -85, -83, -66, -77, -64, -77, -66, -61, -77, -65, -67, 126, -74, -79, -77, -75, -78, -65, -65, -69, 126, -79, -76, -61, 126, -71, -66, -60, -75, -62, -61, -60, -71, -60, -71, -79, -68, 126, -76, -71, -61, -67, -71, -61, -61, -75, -76, -29, 4, 1, 20, 6, 3, 15, 13, -50, 6, 1, 3, 5, 2, 15, 15, 11, -50, 1, 4, 19, -50, 1, 4, 18, 5, 16, 15, 18, 20, 9, 14, 7, -50, -26, -23, -18, -23, -13, -24, -1, -31, -28, -1, -14, -27, -16, -17, -14, -12, -23, -18, -25, -1, -26, -20, -17, -9, -53, -61, -63, -56, -103, -66, -52, -67, -54, -85, -67, -69, -57, -58, -68, -53, -46, -50, -61, -59, -57, -49, -57, -48, -42, -85, -58, -35, -43, -44, -39, -47, -28, -39, -33, -34, -76, -47, -28, -47, -79, -62, -79, -70, -64};
    }

    public AnonymousClass89(AudienceNetworkActivity audienceNetworkActivity, AudienceNetworkActivityApi audienceNetworkActivityApi) {
        this.A0J = audienceNetworkActivity;
        this.A0K = audienceNetworkActivityApi;
        this.A0L = C8N.A01(audienceNetworkActivity);
        this.A0L.A0B(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x00a0, code lost:            return r7;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.facebook.ads.redexgen.X.InterfaceC0524Ko A01(android.content.Intent r9) {
        /*
            r8 = this;
            r3 = r8
            r0 = 0
            r0 = 0
            r7 = 0
            com.facebook.ads.redexgen.X.Ec r0 = r3.A0L
            com.facebook.ads.redexgen.X.Gl r5 = r0.A05()
            com.facebook.ads.redexgen.X.85 r2 = new com.facebook.ads.redexgen.X.85
            com.facebook.ads.redexgen.X.Ec r6 = r3.A0L
            r4 = r9
            r2.<init>(r3, r4, r5, r6, r7)
            com.facebook.ads.redexgen.X.IY r0 = r3.A08
            if (r0 != 0) goto L9b
            r0 = 2
        L17:
            switch(r0) {
                case 2: goto L9e;
                case 3: goto L43;
                case 4: goto L3b;
                case 5: goto L23;
                case 6: goto L1b;
                case 7: goto L82;
                case 8: goto L8a;
                case 9: goto L6e;
                case 10: goto L92;
                case 11: goto L2b;
                case 12: goto L33;
                case 13: goto L76;
                default: goto L1a;
            }
        L1a:
            goto L17
        L1b:
            com.facebook.ads.redexgen.X.85 r2 = (com.facebook.ads.redexgen.X.AnonymousClass85) r2
            com.facebook.ads.redexgen.X.Ko r7 = com.facebook.ads.redexgen.X.AnonymousClass85.A0C(r2)
            r0 = 2
            goto L17
        L23:
            com.facebook.ads.redexgen.X.85 r2 = (com.facebook.ads.redexgen.X.AnonymousClass85) r2
            com.facebook.ads.redexgen.X.Ko r7 = com.facebook.ads.redexgen.X.AnonymousClass85.A0D(r2)
            r0 = 2
            goto L17
        L2b:
            com.facebook.ads.redexgen.X.85 r2 = (com.facebook.ads.redexgen.X.AnonymousClass85) r2
            com.facebook.ads.redexgen.X.Ko r7 = com.facebook.ads.redexgen.X.AnonymousClass85.A0G(r2)
            r0 = 2
            goto L17
        L33:
            com.facebook.ads.redexgen.X.85 r2 = (com.facebook.ads.redexgen.X.AnonymousClass85) r2
            com.facebook.ads.redexgen.X.Ko r7 = com.facebook.ads.redexgen.X.AnonymousClass85.A0F(r2)
            r0 = 2
            goto L17
        L3b:
            com.facebook.ads.redexgen.X.85 r2 = (com.facebook.ads.redexgen.X.AnonymousClass85) r2
            com.facebook.ads.redexgen.X.Ko r7 = com.facebook.ads.redexgen.X.AnonymousClass85.A0E(r2)
            r0 = 2
            goto L17
        L43:
            com.facebook.ads.redexgen.X.89 r3 = (com.facebook.ads.redexgen.X.AnonymousClass89) r3
            int[] r1 = com.facebook.ads.redexgen.X.AnonymousClass80.A00
            com.facebook.ads.redexgen.X.IY r0 = r3.A08
            int r0 = r0.ordinal()
            r0 = r1[r0]
            switch(r0) {
                case 1: goto L54;
                case 2: goto L57;
                case 3: goto L5a;
                case 4: goto L5d;
                case 5: goto L60;
                case 6: goto L63;
                case 7: goto L66;
                case 8: goto L68;
                case 9: goto L6a;
                case 10: goto L6c;
                default: goto L52;
            }
        L52:
            r0 = 2
            goto L17
        L54:
            r0 = 13
            goto L17
        L57:
            r0 = 12
            goto L17
        L5a:
            r0 = 11
            goto L17
        L5d:
            r0 = 10
            goto L17
        L60:
            r0 = 9
            goto L17
        L63:
            r0 = 8
            goto L17
        L66:
            r0 = 7
            goto L17
        L68:
            r0 = 6
            goto L17
        L6a:
            r0 = 5
            goto L17
        L6c:
            r0 = 4
            goto L17
        L6e:
            com.facebook.ads.redexgen.X.85 r2 = (com.facebook.ads.redexgen.X.AnonymousClass85) r2
            com.facebook.ads.redexgen.X.Ko r7 = com.facebook.ads.redexgen.X.AnonymousClass85.A0I(r2)
            r0 = 2
            goto L17
        L76:
            com.facebook.ads.redexgen.X.89 r3 = (com.facebook.ads.redexgen.X.AnonymousClass89) r3
            com.facebook.ads.redexgen.X.85 r2 = (com.facebook.ads.redexgen.X.AnonymousClass85) r2
            android.widget.RelativeLayout r0 = r3.A06
            com.facebook.ads.redexgen.X.Ko r7 = com.facebook.ads.redexgen.X.AnonymousClass85.A0L(r2, r0)
            r0 = 2
            goto L17
        L82:
            com.facebook.ads.redexgen.X.85 r2 = (com.facebook.ads.redexgen.X.AnonymousClass85) r2
            com.facebook.ads.redexgen.X.Ko r7 = com.facebook.ads.redexgen.X.AnonymousClass85.A0K(r2)
            r0 = 2
            goto L17
        L8a:
            com.facebook.ads.redexgen.X.85 r2 = (com.facebook.ads.redexgen.X.AnonymousClass85) r2
            com.facebook.ads.redexgen.X.Ko r7 = com.facebook.ads.redexgen.X.AnonymousClass85.A0J(r2)
            r0 = 2
            goto L17
        L92:
            com.facebook.ads.redexgen.X.85 r2 = (com.facebook.ads.redexgen.X.AnonymousClass85) r2
            com.facebook.ads.redexgen.X.Ko r7 = com.facebook.ads.redexgen.X.AnonymousClass85.A0H(r2)
            r0 = 2
            goto L17
        L9b:
            r0 = 3
            goto L17
        L9e:
            com.facebook.ads.redexgen.X.Ko r7 = (com.facebook.ads.redexgen.X.InterfaceC0524Ko) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass89.A01(android.content.Intent):com.facebook.ads.redexgen.X.Ko");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A05() {
        /*
            r5 = this;
            r4 = r5
            r0 = 0
            r3 = -1
            java.lang.String r0 = r4.A0F
            if (r0 == 0) goto L30
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L20;
                case 4: goto L32;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.89 r4 = (com.facebook.ads.redexgen.X.AnonymousClass89) r4
            com.facebook.ads.redexgen.X.Ec r1 = r4.A0L
            java.lang.String r0 = r4.A0F
            com.facebook.ads.redexgen.X.PU r0 = com.facebook.ads.redexgen.X.PT.A01(r1, r0)
            r4.A0C = r0
            com.facebook.ads.redexgen.X.PU r0 = r4.A0C
            if (r0 == 0) goto L1e
            r0 = 3
            goto L8
        L1e:
            r0 = 4
            goto L8
        L20:
            com.facebook.ads.redexgen.X.89 r4 = (com.facebook.ads.redexgen.X.AnonymousClass89) r4
            android.widget.RelativeLayout$LayoutParams r2 = new android.widget.RelativeLayout$LayoutParams
            r2.<init>(r3, r3)
            android.widget.RelativeLayout r1 = r4.A06
            com.facebook.ads.redexgen.X.PU r0 = r4.A0C
            r1.addView(r0, r2)
            r0 = 4
            goto L8
        L30:
            r0 = 4
            goto L8
        L32:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass89.A05():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x003c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A06() {
        /*
            r4 = this;
            r3 = r4
            boolean r0 = r3.A0H
            if (r0 != 0) goto L3a
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L16;
                case 4: goto L23;
                case 5: goto L3c;
                case 6: goto L2a;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.89 r3 = (com.facebook.ads.redexgen.X.AnonymousClass89) r3
            boolean r0 = r3.A0G()
            if (r0 == 0) goto L14
            r0 = 3
            goto L6
        L14:
            r0 = 6
            goto L6
        L16:
            com.facebook.ads.redexgen.X.89 r3 = (com.facebook.ads.redexgen.X.AnonymousClass89) r3
            com.facebook.ads.redexgen.X.Qc r0 = com.facebook.ads.redexgen.X.EnumC0666Qc.A03
            java.lang.String r0 = r0.A02()
            r3.A0D(r0)
            r0 = 4
            goto L6
        L23:
            com.facebook.ads.redexgen.X.89 r3 = (com.facebook.ads.redexgen.X.AnonymousClass89) r3
            r0 = 1
            r3.A0H = r0
            r0 = 5
            goto L6
        L2a:
            com.facebook.ads.redexgen.X.89 r3 = (com.facebook.ads.redexgen.X.AnonymousClass89) r3
            r2 = 0
            r1 = 48
            r0 = 125(0x7d, float:1.75E-43)
            java.lang.String r0 = A04(r2, r1, r0)
            r3.A0D(r0)
            r0 = 4
            goto L6
        L3a:
            r0 = 5
            goto L6
        L3c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass89.A06():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d3, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A08(android.content.Intent r14) {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass89.A08(android.content.Intent):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x009b, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A09(android.content.Intent r7, @android.support.annotation.Nullable android.os.Bundle r8) {
        /*
            r6 = this;
            r4 = r6
            r0 = 0
            r3 = -1
            if (r8 == 0) goto L98
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L9b;
                case 4: goto L4c;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.89 r4 = (com.facebook.ads.redexgen.X.AnonymousClass89) r4
            android.os.Bundle r8 = (android.os.Bundle) r8
            java.lang.Class<com.facebook.ads.internal.dynamicloading.DynamicLoaderImpl> r0 = com.facebook.ads.internal.dynamicloading.DynamicLoaderImpl.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            android.os.Bundle r5 = com.facebook.ads.redexgen.X.JI.A02(r8, r0)
            r2 = 241(0xf1, float:3.38E-43)
            r1 = 24
            r0 = 14
            java.lang.String r0 = A04(r2, r1, r0)
            int r0 = r5.getInt(r0, r3)
            r4.A01 = r0
            r2 = 265(0x109, float:3.71E-43)
            r1 = 8
            r0 = 10
            java.lang.String r0 = A04(r2, r1, r0)
            java.lang.String r0 = r5.getString(r0)
            r4.A0D = r0
            r2 = 107(0x6b, float:1.5E-43)
            r1 = 8
            r0 = 39
            java.lang.String r0 = A04(r2, r1, r0)
            java.io.Serializable r0 = r5.getSerializable(r0)
            com.facebook.ads.redexgen.X.IY r0 = (com.facebook.ads.redexgen.X.IY) r0
            r4.A08 = r0
            r0 = 3
            goto L6
        L4c:
            com.facebook.ads.redexgen.X.89 r4 = (com.facebook.ads.redexgen.X.AnonymousClass89) r4
            android.content.Intent r7 = (android.content.Intent) r7
            r2 = 241(0xf1, float:3.38E-43)
            r1 = 24
            r0 = 14
            java.lang.String r0 = A04(r2, r1, r0)
            int r0 = r7.getIntExtra(r0, r3)
            r4.A01 = r0
            r2 = 265(0x109, float:3.71E-43)
            r1 = 8
            r0 = 10
            java.lang.String r0 = A04(r2, r1, r0)
            java.lang.String r0 = r7.getStringExtra(r0)
            r4.A0D = r0
            r2 = 107(0x6b, float:1.5E-43)
            r1 = 8
            r0 = 39
            java.lang.String r0 = A04(r2, r1, r0)
            java.io.Serializable r0 = r7.getSerializableExtra(r0)
            com.facebook.ads.redexgen.X.IY r0 = (com.facebook.ads.redexgen.X.IY) r0
            r4.A08 = r0
            r2 = 427(0x1ab, float:5.98E-43)
            r1 = 16
            r0 = 37
            java.lang.String r1 = A04(r2, r1, r0)
            r0 = 0
            int r0 = r7.getIntExtra(r1, r0)
            int r0 = r0 * 1000
            r4.A02 = r0
            r0 = 3
            goto L6
        L98:
            r0 = 4
            goto L6
        L9b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass89.A09(android.content.Intent, android.os.Bundle):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0068, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A0D(java.lang.String r7) {
        /*
            r6 = this;
            r5 = r6
            r2 = 374(0x176, float:5.24E-43)
            r1 = 53
            r0 = 109(0x6d, float:1.53E-43)
            java.lang.String r0 = A04(r2, r1, r0)
            boolean r0 = r0.equals(r7)
            if (r0 != 0) goto L66
            r0 = 2
        L12:
            switch(r0) {
                case 2: goto L16;
                case 3: goto L2c;
                case 4: goto L68;
                case 5: goto L33;
                default: goto L15;
            }
        L15:
            goto L12
        L16:
            java.lang.String r7 = (java.lang.String) r7
            r2 = 285(0x11d, float:4.0E-43)
            r1 = 45
            r0 = 23
            java.lang.String r0 = A04(r2, r1, r0)
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L2a
            r0 = 3
            goto L12
        L2a:
            r0 = 5
            goto L12
        L2c:
            com.facebook.ads.redexgen.X.89 r5 = (com.facebook.ads.redexgen.X.AnonymousClass89) r5
            r5.finish()
            r0 = 4
            goto L12
        L33:
            com.facebook.ads.redexgen.X.89 r5 = (com.facebook.ads.redexgen.X.AnonymousClass89) r5
            java.lang.String r7 = (java.lang.String) r7
            android.content.Intent r4 = new android.content.Intent
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r3 = r0.append(r7)
            r2 = 273(0x111, float:3.83E-43)
            r1 = 1
            r0 = 4
            java.lang.String r0 = A04(r2, r1, r0)
            java.lang.StringBuilder r1 = r3.append(r0)
            java.lang.String r0 = r5.A0D
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            r4.<init>(r0)
            com.facebook.ads.AudienceNetworkActivity r0 = r5.A0J
            com.facebook.ads.redexgen.X.4F r0 = com.facebook.ads.redexgen.X.C4F.A00(r0)
            r0.A07(r4)
            r0 = 4
            goto L12
        L66:
            r0 = 3
            goto L12
        L68:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass89.A0D(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A0E(java.lang.String r11, com.facebook.ads.redexgen.X.C00572c r12) {
        /*
            r10 = this;
            r7 = r12
            r6 = r11
            r3 = r10
            r0 = 0
            r2 = -1
            com.facebook.ads.redexgen.X.Ko r0 = r3.A09
            if (r0 != 0) goto L5a
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L5c;
                case 3: goto Le;
                case 4: goto L18;
                case 5: goto L40;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.89 r3 = (com.facebook.ads.redexgen.X.AnonymousClass89) r3
            com.facebook.ads.redexgen.X.MZ r0 = r3.A0A
            if (r0 != 0) goto L16
            r0 = 4
            goto La
        L16:
            r0 = 5
            goto La
        L18:
            com.facebook.ads.redexgen.X.89 r3 = (com.facebook.ads.redexgen.X.AnonymousClass89) r3
            java.lang.String r6 = (java.lang.String) r6
            com.facebook.ads.redexgen.X.2c r7 = (com.facebook.ads.redexgen.X.C00572c) r7
            com.facebook.ads.redexgen.X.Ec r4 = r3.A0L
            com.facebook.ads.redexgen.X.Ec r0 = r3.A0L
            com.facebook.ads.redexgen.X.Gl r5 = r0.A05()
            com.facebook.ads.redexgen.X.Ko r8 = r3.A09
            com.facebook.ads.redexgen.X.82 r9 = new com.facebook.ads.redexgen.X.82
            r0 = 0
            r9.<init>(r3, r0)
            com.facebook.ads.redexgen.X.MZ r0 = com.facebook.ads.redexgen.X.C0562Ma.A02(r4, r5, r6, r7, r8, r9)
            r3.A0A = r0
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            r1.<init>(r2, r2)
            com.facebook.ads.redexgen.X.MZ r0 = r3.A0A
            r0.setLayoutParams(r1)
            r0 = 5
            goto La
        L40:
            com.facebook.ads.redexgen.X.89 r3 = (com.facebook.ads.redexgen.X.AnonymousClass89) r3
            com.facebook.ads.redexgen.X.MZ r0 = r3.A0A
            com.facebook.ads.redexgen.X.KE.A0L(r0)
            android.widget.RelativeLayout r0 = r3.A06
            com.facebook.ads.redexgen.X.KE.A0U(r0)
            android.widget.RelativeLayout r1 = r3.A06
            com.facebook.ads.redexgen.X.MZ r0 = r3.A0A
            r1.addView(r0)
            com.facebook.ads.redexgen.X.MZ r0 = r3.A0A
            r0.A0J()
            r0 = 2
            goto La
        L5a:
            r0 = 3
            goto La
        L5c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass89.A0E(java.lang.String, com.facebook.ads.redexgen.X.2c):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0F(String str, GX gx) {
        Intent intent = new Intent(str + A04(273, 1, 4) + this.A0D);
        intent.putExtra(A04(467, 5, 25), gx);
        C4F.A00(this.A0J).A07(intent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0021, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0G() {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            com.facebook.ads.redexgen.X.IY r1 = r3.A08
            com.facebook.ads.redexgen.X.IY r0 = com.facebook.ads.redexgen.X.IY.A0B
            if (r1 == r0) goto L1f
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L19;
                case 4: goto L21;
                case 5: goto L1c;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.89 r3 = (com.facebook.ads.redexgen.X.AnonymousClass89) r3
            com.facebook.ads.redexgen.X.IY r1 = r3.A08
            com.facebook.ads.redexgen.X.IY r0 = com.facebook.ads.redexgen.X.IY.A0A
            if (r1 != r0) goto L17
            r0 = 3
            goto L9
        L17:
            r0 = 5
            goto L9
        L19:
            r2 = 1
            r0 = 4
            goto L9
        L1c:
            r2 = 0
            r0 = 4
            goto L9
        L1f:
            r0 = 3
            goto L9
        L21:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass89.A0G():boolean");
    }

    public final AudienceNetworkActivity A0H() {
        return this.A0J;
    }

    public final C0362Ec A0I() {
        return this.A0L;
    }

    public final void A0J(AnonymousClass86 anonymousClass86) {
        this.A0M.add(anonymousClass86);
    }

    public final void A0K(AnonymousClass86 anonymousClass86) {
        this.A0M.remove(anonymousClass86);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0050, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void finish() {
        /*
            r4 = this;
            r3 = r4
            com.facebook.ads.AudienceNetworkActivity r0 = r3.A0J
            boolean r0 = r0.isFinishing()
            if (r0 == 0) goto L4e
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L50;
                case 3: goto L31;
                case 4: goto L1a;
                case 5: goto L24;
                case 6: goto Le;
                case 7: goto L3d;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.89 r3 = (com.facebook.ads.redexgen.X.AnonymousClass89) r3
            r3.A06()
            com.facebook.ads.internal.api.AudienceNetworkActivityApi r0 = r3.A0K
            r0.finish()
            r0 = 2
            goto La
        L1a:
            com.facebook.ads.redexgen.X.89 r3 = (com.facebook.ads.redexgen.X.AnonymousClass89) r3
            boolean r0 = r3.A0G
            if (r0 != 0) goto L22
            r0 = 5
            goto La
        L22:
            r0 = 7
            goto La
        L24:
            com.facebook.ads.redexgen.X.89 r3 = (com.facebook.ads.redexgen.X.AnonymousClass89) r3
            com.facebook.ads.redexgen.X.Qc r0 = com.facebook.ads.redexgen.X.EnumC0666Qc.A05
            java.lang.String r0 = r0.A02()
            r3.A0D(r0)
            r0 = 6
            goto La
        L31:
            com.facebook.ads.redexgen.X.89 r3 = (com.facebook.ads.redexgen.X.AnonymousClass89) r3
            boolean r0 = r3.A0G()
            if (r0 == 0) goto L3b
            r0 = 4
            goto La
        L3b:
            r0 = 7
            goto La
        L3d:
            com.facebook.ads.redexgen.X.89 r3 = (com.facebook.ads.redexgen.X.AnonymousClass89) r3
            r2 = 330(0x14a, float:4.62E-43)
            r1 = 39
            r0 = 29
            java.lang.String r0 = A04(r2, r1, r0)
            r3.A0D(r0)
            r0 = 6
            goto La
        L4e:
            r0 = 3
            goto La
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass89.finish():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0060, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onBackPressed() {
        /*
            r12 = this;
            r6 = r12
            r11 = 0
            r5 = 0
            long r9 = java.lang.System.currentTimeMillis()
            long r7 = r6.A03
            long r2 = r6.A04
            long r0 = r9 - r2
            long r7 = r7 + r0
            r6.A03 = r7
            r6.A04 = r9
            long r3 = r6.A03
            int r0 = r6.A02
            long r1 = (long) r0
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 <= 0) goto L5d
            r0 = 2
        L1c:
            switch(r0) {
                case 2: goto L48;
                case 3: goto L3c;
                case 4: goto L27;
                case 5: goto L39;
                case 6: goto L20;
                case 7: goto L53;
                case 8: goto L60;
                default: goto L1f;
            }
        L1f:
            goto L1c
        L20:
            if (r11 != 0) goto L24
            r0 = 7
            goto L1c
        L24:
            r0 = 8
            goto L1c
        L27:
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r0 = r5.next()
            com.facebook.ads.redexgen.X.86 r0 = (com.facebook.ads.redexgen.X.AnonymousClass86) r0
            boolean r0 = r0.A59()
            if (r0 == 0) goto L37
            r0 = 5
            goto L1c
        L37:
            r0 = 3
            goto L1c
        L39:
            r11 = 1
            r0 = 3
            goto L1c
        L3c:
            java.util.Iterator r5 = (java.util.Iterator) r5
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L46
            r0 = 4
            goto L1c
        L46:
            r0 = 6
            goto L1c
        L48:
            com.facebook.ads.redexgen.X.89 r6 = (com.facebook.ads.redexgen.X.AnonymousClass89) r6
            r11 = 0
            java.util.List<com.facebook.ads.redexgen.X.86> r0 = r6.A0M
            java.util.Iterator r5 = r0.iterator()
            r0 = 3
            goto L1c
        L53:
            com.facebook.ads.redexgen.X.89 r6 = (com.facebook.ads.redexgen.X.AnonymousClass89) r6
            com.facebook.ads.internal.api.AudienceNetworkActivityApi r0 = r6.A0K
            r0.onBackPressed()
            r0 = 8
            goto L1c
        L5d:
            r0 = 8
            goto L1c
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass89.onBackPressed():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0084, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onConfigurationChanged(android.content.res.Configuration r7) {
        /*
            r6 = this;
            r5 = r6
            r4 = 0
            com.facebook.ads.redexgen.X.Ko r0 = r5.A09
            boolean r0 = r0 instanceof com.facebook.ads.redexgen.X.M3
            if (r0 == 0) goto L82
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto L5a;
                case 3: goto L4c;
                case 4: goto L3b;
                case 5: goto L20;
                case 6: goto Ld;
                case 7: goto L84;
                case 8: goto L67;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.89 r5 = (com.facebook.ads.redexgen.X.AnonymousClass89) r5
            android.content.res.Configuration r7 = (android.content.res.Configuration) r7
            java.util.HashMap r4 = (java.util.HashMap) r4
            com.facebook.ads.redexgen.X.Gv r1 = r5.A07
            com.facebook.ads.redexgen.X.Gu r0 = com.facebook.ads.redexgen.X.EnumC0431Gu.A0J
            r1.A02(r0, r4)
            int r0 = r7.orientation
            r5.A00 = r0
            r0 = 7
            goto L9
        L20:
            java.util.HashMap r4 = (java.util.HashMap) r4
            r2 = 227(0xe3, float:3.18E-43)
            r1 = 14
            r0 = 89
            java.lang.String r3 = A04(r2, r1, r0)
            r2 = 219(0xdb, float:3.07E-43)
            r1 = 8
            r0 = 25
            java.lang.String r0 = A04(r2, r1, r0)
            r4.put(r3, r0)
            r0 = 6
            goto L9
        L3b:
            android.content.res.Configuration r7 = (android.content.res.Configuration) r7
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            int r1 = r7.orientation
            r0 = 1
            if (r1 != r0) goto L49
            r0 = 5
            goto L9
        L49:
            r0 = 8
            goto L9
        L4c:
            com.facebook.ads.redexgen.X.89 r5 = (com.facebook.ads.redexgen.X.AnonymousClass89) r5
            android.content.res.Configuration r7 = (android.content.res.Configuration) r7
            int r1 = r5.A00
            int r0 = r7.orientation
            if (r1 == r0) goto L58
            r0 = 4
            goto L9
        L58:
            r0 = 7
            goto L9
        L5a:
            com.facebook.ads.redexgen.X.89 r5 = (com.facebook.ads.redexgen.X.AnonymousClass89) r5
            android.content.res.Configuration r7 = (android.content.res.Configuration) r7
            com.facebook.ads.redexgen.X.Ko r0 = r5.A09
            com.facebook.ads.redexgen.X.M3 r0 = (com.facebook.ads.redexgen.X.M3) r0
            r0.onConfigurationChanged(r7)
            r0 = 3
            goto L9
        L67:
            java.util.HashMap r4 = (java.util.HashMap) r4
            r2 = 227(0xe3, float:3.18E-43)
            r1 = 14
            r0 = 89
            java.lang.String r3 = A04(r2, r1, r0)
            r2 = 87
            r1 = 9
            r0 = 116(0x74, float:1.63E-43)
            java.lang.String r0 = A04(r2, r1, r0)
            r4.put(r3, r0)
            r0 = 6
            goto L9
        L82:
            r0 = 3
            goto L9
        L84:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass89.onConfigurationChanged(android.content.res.Configuration):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0161, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onCreate(@android.support.annotation.Nullable android.os.Bundle r12) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass89.onCreate(android.os.Bundle):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x007d, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onDestroy() {
        /*
            r3 = this;
            r1 = r3
            com.facebook.ads.redexgen.X.Ec r0 = r1.A0L
            com.facebook.ads.redexgen.X.0c r2 = r0.A08()
            com.facebook.ads.AudienceNetworkActivity r0 = r1.A0H()
            int r0 = r0.hashCode()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r2.A2Q(r0)
            r1.A06()
            android.widget.RelativeLayout r0 = r1.A06
            if (r0 == 0) goto L7b
            r0 = 2
        L1e:
            switch(r0) {
                case 2: goto L5c;
                case 3: goto L52;
                case 4: goto L3c;
                case 5: goto L31;
                case 6: goto L22;
                case 7: goto L65;
                case 8: goto L6f;
                case 9: goto L48;
                case 10: goto L7d;
                default: goto L21;
            }
        L21:
            goto L1e
        L22:
            com.facebook.ads.redexgen.X.89 r1 = (com.facebook.ads.redexgen.X.AnonymousClass89) r1
            com.facebook.ads.AudienceNetworkActivity r0 = r1.A0J
            boolean r0 = com.facebook.ads.redexgen.X.C0413Gc.A0d(r0)
            if (r0 == 0) goto L2e
            r0 = 7
            goto L1e
        L2e:
            r0 = 8
            goto L1e
        L31:
            com.facebook.ads.redexgen.X.89 r1 = (com.facebook.ads.redexgen.X.AnonymousClass89) r1
            com.facebook.ads.redexgen.X.NQ r0 = r1.A0B
            if (r0 == 0) goto L39
            r0 = 6
            goto L1e
        L39:
            r0 = 8
            goto L1e
        L3c:
            com.facebook.ads.redexgen.X.89 r1 = (com.facebook.ads.redexgen.X.AnonymousClass89) r1
            com.facebook.ads.redexgen.X.Ko r0 = r1.A09
            r0.onDestroy()
            r0 = 0
            r1.A09 = r0
            r0 = 5
            goto L1e
        L48:
            com.facebook.ads.redexgen.X.89 r1 = (com.facebook.ads.redexgen.X.AnonymousClass89) r1
            com.facebook.ads.redexgen.X.MZ r0 = r1.A0A
            r0.A0I()
            r0 = 10
            goto L1e
        L52:
            com.facebook.ads.redexgen.X.89 r1 = (com.facebook.ads.redexgen.X.AnonymousClass89) r1
            com.facebook.ads.redexgen.X.Ko r0 = r1.A09
            if (r0 == 0) goto L5a
            r0 = 4
            goto L1e
        L5a:
            r0 = 5
            goto L1e
        L5c:
            com.facebook.ads.redexgen.X.89 r1 = (com.facebook.ads.redexgen.X.AnonymousClass89) r1
            android.widget.RelativeLayout r0 = r1.A06
            r0.removeAllViews()
            r0 = 3
            goto L1e
        L65:
            com.facebook.ads.redexgen.X.89 r1 = (com.facebook.ads.redexgen.X.AnonymousClass89) r1
            com.facebook.ads.redexgen.X.NQ r0 = r1.A0B
            r0.A07()
            r0 = 8
            goto L1e
        L6f:
            com.facebook.ads.redexgen.X.89 r1 = (com.facebook.ads.redexgen.X.AnonymousClass89) r1
            com.facebook.ads.redexgen.X.MZ r0 = r1.A0A
            if (r0 == 0) goto L78
            r0 = 9
            goto L1e
        L78:
            r0 = 10
            goto L1e
        L7b:
            r0 = 3
            goto L1e
        L7d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass89.onDestroy():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0050, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onPause() {
        /*
            r7 = this;
            r4 = r7
            com.facebook.ads.redexgen.X.Ec r0 = r4.A0L
            com.facebook.ads.redexgen.X.0c r1 = r0.A08()
            com.facebook.ads.AudienceNetworkActivity r0 = r4.A0H()
            int r0 = r0.hashCode()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1.A2R(r0)
            long r5 = r4.A03
            long r2 = java.lang.System.currentTimeMillis()
            long r0 = r4.A04
            long r2 = r2 - r0
            long r5 = r5 + r2
            r4.A03 = r5
            com.facebook.ads.redexgen.X.Ko r0 = r4.A09
            if (r0 == 0) goto L4e
            r0 = 2
        L27:
            switch(r0) {
                case 2: goto L2b;
                case 3: goto L3f;
                case 4: goto L50;
                default: goto L2a;
            }
        L2a:
            goto L27
        L2b:
            com.facebook.ads.redexgen.X.89 r4 = (com.facebook.ads.redexgen.X.AnonymousClass89) r4
            com.facebook.ads.redexgen.X.Ko r1 = r4.A09
            r0 = 0
            r1.A7F(r0)
            com.facebook.ads.AudienceNetworkActivity r0 = r4.A0J
            boolean r0 = r0.isFinishing()
            if (r0 != 0) goto L3d
            r0 = 3
            goto L27
        L3d:
            r0 = 4
            goto L27
        L3f:
            com.facebook.ads.redexgen.X.89 r4 = (com.facebook.ads.redexgen.X.AnonymousClass89) r4
            com.facebook.ads.redexgen.X.Gv r2 = r4.A07
            com.facebook.ads.redexgen.X.Gu r1 = com.facebook.ads.redexgen.X.EnumC0431Gu.A0D
            r0 = 0
            r2.A02(r1, r0)
            r0 = 1
            r4.A0I = r0
            r0 = 4
            goto L27
        L4e:
            r0 = 4
            goto L27
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass89.onPause():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onResume() {
        /*
            r4 = this;
            r3 = r4
            com.facebook.ads.redexgen.X.Ec r0 = r3.A0L
            com.facebook.ads.redexgen.X.0c r1 = r0.A08()
            com.facebook.ads.AudienceNetworkActivity r0 = r3.A0H()
            int r0 = r0.hashCode()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1.A2S(r0)
            long r0 = java.lang.System.currentTimeMillis()
            r3.A04 = r0
            com.facebook.ads.redexgen.X.Ko r0 = r3.A09
            if (r0 == 0) goto L41
            r0 = 2
        L21:
            switch(r0) {
                case 2: goto L25;
                case 3: goto L35;
                case 4: goto L43;
                default: goto L24;
            }
        L24:
            goto L21
        L25:
            com.facebook.ads.redexgen.X.89 r3 = (com.facebook.ads.redexgen.X.AnonymousClass89) r3
            com.facebook.ads.redexgen.X.Ko r1 = r3.A09
            r0 = 0
            r1.A7O(r0)
            boolean r0 = r3.A0I
            if (r0 == 0) goto L33
            r0 = 3
            goto L21
        L33:
            r0 = 4
            goto L21
        L35:
            com.facebook.ads.redexgen.X.89 r3 = (com.facebook.ads.redexgen.X.AnonymousClass89) r3
            com.facebook.ads.redexgen.X.Gv r2 = r3.A07
            com.facebook.ads.redexgen.X.Gu r1 = com.facebook.ads.redexgen.X.EnumC0431Gu.A0E
            r0 = 0
            r2.A02(r1, r0)
            r0 = 4
            goto L21
        L41:
            r0 = 4
            goto L21
        L43:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass89.onResume():void");
    }

    public final void onSaveInstanceState(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (this.A09 != null) {
            this.A09.A8E(bundle2);
        }
        bundle2.putInt(A04(241, 24, 14), this.A01);
        bundle2.putString(A04(265, 8, 10), this.A0D);
        bundle2.putString(A04(274, 11, 16), this.A0E);
        bundle2.putSerializable(A04(107, 8, 39), this.A08);
        JI.A08(bundle, bundle2);
    }

    public final void onStart() {
        this.A0L.A08().A2T(String.valueOf(A0H().hashCode()));
        if (this.A01 != -1) {
            C0521Kl.A02(this.A0J, this.A01, this.A0L);
        }
    }

    public final void onStop() {
        this.A0L.A08().A2U(String.valueOf(A0H().hashCode()));
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        A0.A02(null, motionEvent);
        return this.A0K.onTouchEvent(motionEvent);
    }

    public final void repair(Throwable th) {
        this.A0J.finish();
    }
}
