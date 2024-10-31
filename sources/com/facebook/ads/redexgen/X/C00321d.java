package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RelativeLayout;
import com.facebook.ads.AdError;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.EnumSet;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.1d, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C00321d extends AbstractC00311c implements InterfaceC00301b<Bundle> {
    public static byte[] A0F;
    public static final /* synthetic */ boolean A0G;

    @Nullable
    public InterfaceC00481t A00;
    public EV A01;

    @Nullable
    public C0537Lb A02;

    @Nullable
    public Q9 A03;

    @Nullable
    public String A04;

    @Nullable
    public String A05;

    @Nullable
    public JSONObject A06;

    @Nullable
    public C0362Ec A09;

    @Nullable
    public InterfaceC0422Gl A0A;
    public final C1S<QM> A0C = new C1S<QM>() { // from class: com.facebook.ads.redexgen.X.1T
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.facebook.ads.redexgen.X.C1S
        /* renamed from: A00, reason: merged with bridge method [inline-methods] */
        public final void A03(QM qm) {
            InterfaceC00481t interfaceC00481t;
            InterfaceC00481t interfaceC00481t2;
            interfaceC00481t = C00321d.this.A00;
            if (interfaceC00481t == null) {
                return;
            }
            interfaceC00481t2 = C00321d.this.A00;
            interfaceC00481t2.A6n(C00321d.this);
        }

        @Override // com.facebook.ads.redexgen.X.C1S
        public final Class<QM> A01() {
            return QM.class;
        }
    };
    public final C1S<QS> A0E = new C1S<QS>() { // from class: com.facebook.ads.redexgen.X.1U
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.facebook.ads.redexgen.X.C1S
        /* renamed from: A00, reason: merged with bridge method [inline-methods] */
        public final void A03(QS qs) {
            InterfaceC00481t interfaceC00481t;
            InterfaceC00481t interfaceC00481t2;
            C00321d.this.A07 = true;
            interfaceC00481t = C00321d.this.A00;
            if (interfaceC00481t == null) {
                return;
            }
            interfaceC00481t2 = C00321d.this.A00;
            interfaceC00481t2.A6l(C00321d.this);
        }

        @Override // com.facebook.ads.redexgen.X.C1S
        public final Class<QS> A01() {
            return QS.class;
        }
    };
    public final C1S<QN> A0D = new C1S<QN>() { // from class: com.facebook.ads.redexgen.X.1V
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.facebook.ads.redexgen.X.C1S
        /* renamed from: A00, reason: merged with bridge method [inline-methods] */
        public final void A03(QN qn) {
            InterfaceC00481t interfaceC00481t;
            InterfaceC00481t interfaceC00481t2;
            interfaceC00481t = C00321d.this.A00;
            if (interfaceC00481t == null) {
                return;
            }
            interfaceC00481t2 = C00321d.this.A00;
            interfaceC00481t2.A6p(C00321d.this, AdError.internalError(2003));
        }

        @Override // com.facebook.ads.redexgen.X.C1S
        public final Class<QN> A01() {
            return QN.class;
        }
    };
    public final C1S<QL> A0B = new C1S<QL>() { // from class: com.facebook.ads.redexgen.X.1W
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.facebook.ads.redexgen.X.C1S
        /* renamed from: A00, reason: merged with bridge method [inline-methods] */
        public final void A03(QL ql) {
            InterfaceC00481t interfaceC00481t;
            InterfaceC00481t interfaceC00481t2;
            interfaceC00481t = C00321d.this.A00;
            if (interfaceC00481t == null) {
                return;
            }
            interfaceC00481t2 = C00321d.this.A00;
            interfaceC00481t2.A6k(C00321d.this);
        }

        @Override // com.facebook.ads.redexgen.X.C1S
        public final Class<QL> A01() {
            return QL.class;
        }
    };
    public boolean A07 = false;
    public boolean A08 = false;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A06(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C00321d.A0F
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
            int r0 = r0 + (-1)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00321d.A06(int, int, int):java.lang.String");
    }

    public static void A0A() {
        A0F = new byte[]{-40, -53, -58, -57, -47, -63, -42, -53, -49, -57, -63, -46, -47, -50, -50, -53, -48, -55, -63, -53, -48, -42, -57, -44, -40, -61, -50, -46, -59, -64, -63, -53, -92, -96, -79, -82, -88, 124, 111, 123, Byte.MAX_VALUE, 111, 125, 126, 83, 110, -63, -66, -72, -40, -37, -70, -33, -26, -32, -38, -36, -22, -36, -35, -34, -31, -26, -31, -20, -31, -25, -26, -103, -100, -105, -86, -99, -85, -88, -89, -90, -85, -99, -86, -81, -76, -75, -77, -90, -94, -82, -41, -38, -46, -46, -48, -35, -23, -31, -33, -26, -73, -38, -65, -28, -79, -67, -61, -68, -62, -78, -67, -59, -68, -64, -47, -66, -71, -84, -89, -88, -78, -110, -86, -88, -81, 95, Byte.MIN_VALUE, -93, -120, Byte.MIN_VALUE, 126, -123, 86, 121, -32, -34, -19, -34, -33, -26, -23, -26, -15, -26, -30, -16, -67, -75, -77, -70, -116, -65, -66, -66, -71, -72, -105, -120, -101, -105, -88, -71, -64, -55, -52, -57, -69, -50, -52, -65, -70, -69, -59, -85, -88, -94, 113, 110, -127, 110, -70, -78, -80, -73, -73, -88, -87, -77, -84, -102, -84, -86, -74, -75, -85, -70, -94, -70, -72, -65, 111, -112, -77, 111, -72, -67};
    }

    static {
        A0A();
        A0G = !C00321d.class.desiredAssertionStatus();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000b. Please report as an issue. */
    private int A00() {
        C00321d c00321d = this;
        JSONObject skipButtonSetting = null;
        JSONObject jSONObject = null;
        int i = -1;
        char c = !A0G ? (char) 2 : (char) 4;
        while (true) {
            switch (c) {
                case 2:
                    c00321d = c00321d;
                    c = c00321d.A06 == null ? (char) 3 : (char) 4;
                case 3:
                    throw new AssertionError();
                case 4:
                    c00321d = c00321d;
                    jSONObject = c00321d.A06.getJSONObject(A06(131, 12, 124));
                    c = jSONObject.has(A06(143, 10, 73)) ? '\n' : (char) 22;
                case '\n':
                    c = jSONObject.isNull(A06(143, 10, 73)) ? (char) 22 : '\r';
                case '\r':
                    try {
                        skipButtonSetting = jSONObject.getJSONObject(A06(143, 10, 73));
                        c = skipButtonSetting.has(A06(177, 16, 70)) ? (char) 18 : (char) 22;
                    } catch (Exception e) {
                        Log.w(String.valueOf(C00321d.class), I4.A02(2L), e);
                        c = 22;
                    }
                case 18:
                    i = skipButtonSetting.getInt(A06(177, 16, 70));
                    c = 22;
                case 22:
                    return i;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000b. Please report as an issue. */
    @Nullable
    private String A03() {
        C00321d c00321d = this;
        JSONObject jSONObject = null;
        JSONObject jSONObject2 = null;
        String str = null;
        char c = !A0G ? (char) 2 : (char) 4;
        while (true) {
            switch (c) {
                case 2:
                    c00321d = c00321d;
                    JSONObject adChoicesSetting = c00321d.A06;
                    c = adChoicesSetting == null ? (char) 3 : (char) 4;
                case 3:
                    throw new AssertionError();
                case 4:
                    c00321d = c00321d;
                    jSONObject2 = c00321d.A06.getJSONObject(A06(131, 12, 124));
                    c = jSONObject2.has(A06(49, 9, 118)) ? '\n' : (char) 22;
                case '\n':
                    c = jSONObject2.isNull(A06(49, 9, 118)) ? (char) 22 : '\r';
                case '\r':
                    try {
                        jSONObject = jSONObject2.getJSONObject(A06(49, 9, 118));
                        c = jSONObject.has(A06(46, 3, 75)) ? (char) 18 : (char) 22;
                    } catch (Exception e) {
                        Log.w(String.valueOf(C00321d.class), I4.A02(0L), e);
                        c = 22;
                    }
                case 18:
                    str = jSONObject.getString(A06(46, 3, 75));
                    c = 22;
                case 22:
                    return str;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000b. Please report as an issue. */
    private String A04() {
        C00321d c00321d = this;
        JSONObject jSONObject = null;
        JSONObject jSONObject2 = null;
        String str = null;
        char c = !A0G ? (char) 2 : (char) 4;
        while (true) {
            switch (c) {
                case 2:
                    c00321d = c00321d;
                    c = c00321d.A06 == null ? (char) 3 : (char) 4;
                case 3:
                    throw new AssertionError();
                case 4:
                    c00321d = c00321d;
                    jSONObject2 = c00321d.A06.getJSONObject(A06(131, 12, 124));
                    c = jSONObject2.has(A06(101, 9, 77)) ? '\n' : (char) 22;
                case '\n':
                    try {
                        c = jSONObject2.isNull(A06(101, 9, 77)) ? (char) 22 : '\r';
                    } catch (Exception e) {
                        Log.w(String.valueOf(C00321d.class), I4.A02(1L), e);
                        c = 22;
                    }
                case '\r':
                    jSONObject = jSONObject2.getJSONObject(A06(101, 9, 77));
                    c = jSONObject.has(A06(159, 6, 89)) ? (char) 18 : (char) 22;
                case 18:
                    str = jSONObject.optString(A06(159, 6, 89));
                    c = 22;
                case 22:
                    return str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x002d, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String A05() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.EV r0 = r2.A01
            if (r0 == 0) goto L27
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L15;
                case 4: goto L29;
                case 5: goto L21;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.1d r2 = (com.facebook.ads.redexgen.X.C00321d) r2
            java.lang.String r0 = r2.A05
            if (r0 == 0) goto L13
            r0 = 3
            goto L7
        L13:
            r0 = 5
            goto L7
        L15:
            com.facebook.ads.redexgen.X.1d r2 = (com.facebook.ads.redexgen.X.C00321d) r2
            com.facebook.ads.redexgen.X.EV r1 = r2.A01
            java.lang.String r0 = r2.A05
            java.lang.String r1 = r1.A0L(r0)
            r0 = 4
            goto L7
        L21:
            com.facebook.ads.redexgen.X.1d r2 = (com.facebook.ads.redexgen.X.C00321d) r2
            java.lang.String r1 = r2.A05
            r0 = 4
            goto L7
        L27:
            r0 = 5
            goto L7
        L29:
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00321d.A05():java.lang.String");
    }

    private void A08() throws JSONException {
        C0432Gv c0432Gv;
        if (!A0G && this.A09 == null) {
            throw new AssertionError();
        }
        if (!A0G && this.A06 == null) {
            throw new AssertionError();
        }
        JSONObject text = this.A06.optJSONObject(A06(153, 4, 34));
        if (text == null) {
            text = new JSONObject();
        }
        this.A02.A0S(new C0464Ie(this.A09));
        C0362Ec c0362Ec = this.A09;
        if (this.A0A != null) {
            c0432Gv = new C0432Gv(A4V(), this.A0A);
        } else {
            c0432Gv = null;
        }
        ID id = new ID(c0362Ec, c0432Gv);
        this.A02.A0S(id);
        this.A02.A0S(new C0563Mb(id, NA.A03));
        this.A02.A0S(new C0688Qy(this.A09));
        String A04 = A04();
        if (A04 != null) {
            R0 countdownPlugin = new R0(this.A09, A04);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            countdownPlugin.setLayoutParams(layoutParams);
            countdownPlugin.setCountdownTextColor(-1);
            this.A02.A0S(countdownPlugin);
        }
        JSONObject jSONObject = this.A06;
        String countdownFormat = A06(110, 3, 92);
        if (jSONObject.has(countdownFormat)) {
            JSONObject jSONObject2 = this.A06;
            String countdownFormat2 = A06(110, 3, 92);
            if (!jSONObject2.isNull(countdownFormat2)) {
                JSONObject jSONObject3 = this.A06;
                String countdownFormat3 = A06(110, 3, 92);
                JSONObject jSONObject4 = jSONObject3.getJSONObject(countdownFormat3);
                C0362Ec c0362Ec2 = this.A09;
                String countdownFormat4 = A06(46, 3, 75);
                String string = jSONObject4.getString(countdownFormat4);
                InterfaceC0422Gl interfaceC0422Gl = this.A0A;
                String str = this.A04;
                String countdownFormat5 = A06(153, 4, 34);
                MN mn = new MN(c0362Ec2, string, interfaceC0422Gl, str, jSONObject4.getString(countdownFormat5));
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(10);
                layoutParams2.addRule(11);
                mn.setLayoutParams(layoutParams2);
                this.A02.A0S(mn);
            }
        }
        String A03 = A03();
        if (!TextUtils.isEmpty(A03)) {
            this.A02.A0S(new C0674Qk(this.A09, A03, this.A04, new float[]{0.0f, 0.0f, 8.0f, 0.0f}));
        }
        int A00 = A00();
        if (A00 > 0) {
            C0468Ij c0468Ij = new C0468Ij(this.A09, A00, text.optString(A06(93, 8, 117), A06(193, 10, 78)), text.optString(A06(125, 6, 20), A06(118, 7, 62)));
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(12);
            layoutParams3.addRule(11);
            c0468Ij.setLayoutParams(layoutParams3);
            c0468Ij.setPadding(0, 0, 0, 30);
            this.A02.A0S(c0468Ij);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x004e, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A09() {
        /*
            r4 = this;
            r3 = r4
            r1 = 0
            com.facebook.ads.redexgen.X.Gl r0 = r3.A0A
            if (r0 != 0) goto L4c
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto L4e;
                case 3: goto L39;
                case 4: goto L20;
                case 5: goto L15;
                case 6: goto Lb;
                case 7: goto L43;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.1d r3 = (com.facebook.ads.redexgen.X.C00321d) r3
            com.facebook.ads.redexgen.X.1t r0 = r3.A00
            if (r0 == 0) goto L13
            r0 = 7
            goto L7
        L13:
            r0 = 2
            goto L7
        L15:
            com.facebook.ads.redexgen.X.Ec r1 = (com.facebook.ads.redexgen.X.C0362Ec) r1
            com.facebook.ads.redexgen.X.0c r0 = r1.A08()
            r0.A2X()
            r0 = 6
            goto L7
        L20:
            com.facebook.ads.redexgen.X.1d r3 = (com.facebook.ads.redexgen.X.C00321d) r3
            r0 = 1
            r3.A08 = r0
            com.facebook.ads.redexgen.X.Gl r2 = r3.A0A
            java.lang.String r1 = r3.A04
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r2.A5a(r1, r0)
            com.facebook.ads.redexgen.X.Ec r1 = r3.A09
            if (r1 == 0) goto L37
            r0 = 5
            goto L7
        L37:
            r0 = 6
            goto L7
        L39:
            com.facebook.ads.redexgen.X.1d r3 = (com.facebook.ads.redexgen.X.C00321d) r3
            boolean r0 = r3.A08
            if (r0 != 0) goto L41
            r0 = 4
            goto L7
        L41:
            r0 = 2
            goto L7
        L43:
            com.facebook.ads.redexgen.X.1d r3 = (com.facebook.ads.redexgen.X.C00321d) r3
            com.facebook.ads.redexgen.X.1t r0 = r3.A00
            r0.A6m(r3)
            r0 = 2
            goto L7
        L4c:
            r0 = 3
            goto L7
        L4e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00321d.A09():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x01c0, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0C(com.facebook.ads.redexgen.X.C0362Ec r24, com.facebook.ads.redexgen.X.InterfaceC00481t r25, org.json.JSONObject r26, com.facebook.ads.redexgen.X.InterfaceC0422Gl r27, @android.support.annotation.Nullable android.os.Bundle r28, java.util.EnumSet<com.facebook.ads.CacheFlag> r29, int r30) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00321d.A0C(com.facebook.ads.redexgen.X.Ec, com.facebook.ads.redexgen.X.1t, org.json.JSONObject, com.facebook.ads.redexgen.X.Gl, android.os.Bundle, java.util.EnumSet, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0043, code lost:            return r2;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC00311c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0E() {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            boolean r0 = r3.A07
            if (r0 == 0) goto L41
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto L2b;
                case 3: goto L28;
                case 4: goto L43;
                case 5: goto L1a;
                case 6: goto Lb;
                case 7: goto L35;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.1d r3 = (com.facebook.ads.redexgen.X.C00321d) r3
            com.facebook.ads.redexgen.X.Lb r1 = r3.A02
            com.facebook.ads.redexgen.X.Q9 r0 = r3.A03
            int r0 = r0.A0G()
            r1.A0O(r0)
            r0 = 7
            goto L7
        L1a:
            com.facebook.ads.redexgen.X.1d r3 = (com.facebook.ads.redexgen.X.C00321d) r3
            com.facebook.ads.redexgen.X.Q9 r0 = r3.A03
            int r0 = r0.A0G()
            if (r0 <= 0) goto L26
            r0 = 6
            goto L7
        L26:
            r0 = 7
            goto L7
        L28:
            r2 = 0
            r0 = 4
            goto L7
        L2b:
            com.facebook.ads.redexgen.X.1d r3 = (com.facebook.ads.redexgen.X.C00321d) r3
            com.facebook.ads.redexgen.X.Lb r0 = r3.A02
            if (r0 != 0) goto L33
            r0 = 3
            goto L7
        L33:
            r0 = 5
            goto L7
        L35:
            com.facebook.ads.redexgen.X.1d r3 = (com.facebook.ads.redexgen.X.C00321d) r3
            com.facebook.ads.redexgen.X.Lb r1 = r3.A02
            com.facebook.ads.redexgen.X.QH r0 = com.facebook.ads.redexgen.X.QH.A03
            r1.A0Q(r0)
            r2 = 1
            r0 = 4
            goto L7
        L41:
            r0 = 3
            goto L7
        L43:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00321d.A0E():boolean");
    }

    public final void A0F(C0362Ec c0362Ec, InterfaceC00481t interfaceC00481t, InterfaceC0422Gl interfaceC0422Gl, Bundle bundle, EnumSet<CacheFlag> enumSet) {
        try {
            JSONObject jSONObject = new JSONObject(bundle.getString(A06(68, 11, 55)));
            A0C(c0362Ec, interfaceC00481t, jSONObject, interfaceC0422Gl, bundle, enumSet, jSONObject.optInt(A06(0, 27, 97), 200));
        } catch (JSONException e) {
            if (BuildConfigApi.isDebug()) {
                Log.e(C00321d.class.toString(), I4.A02(3L), e);
            }
            interfaceC00481t.A6p(this, AdError.INTERNAL_ERROR);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000d. Please report as an issue. */
    public final void A0G(C0362Ec c0362Ec, InterfaceC00481t interfaceC00481t, Map<String, Object> map, InterfaceC0422Gl interfaceC0422Gl, EnumSet<CacheFlag> enumSet) {
        EnumSet<CacheFlag> enumSet2 = enumSet;
        InterfaceC0422Gl interfaceC0422Gl2 = interfaceC0422Gl;
        C0362Ec c0362Ec2 = c0362Ec;
        InterfaceC00481t interfaceC00481t2 = interfaceC00481t;
        C00321d c00321d = this;
        Throwable e = null;
        JSONObject jSONObject = null;
        C0403Fr c0403Fr = null;
        int i = 0;
        char c = 2;
        while (true) {
            switch (c) {
                case 2:
                    try {
                        jSONObject = (JSONObject) map.get(A06(173, 4, 12));
                        c0403Fr = (C0403Fr) map.get(A06(58, 10, 119));
                        c = c0403Fr == null ? '\t' : '\n';
                    } catch (JSONException e2) {
                        e = e2;
                        c = BuildConfigApi.isDebug() ? (char) 14 : (char) 15;
                    }
                case '\t':
                    i = 200;
                    c = '\f';
                case '\n':
                    c0403Fr = c0403Fr;
                    i = c0403Fr.A06();
                    c = '\f';
                case '\f':
                    c00321d = c00321d;
                    c0362Ec2 = c0362Ec2;
                    interfaceC00481t2 = interfaceC00481t2;
                    interfaceC0422Gl2 = interfaceC0422Gl2;
                    enumSet2 = enumSet2;
                    jSONObject = jSONObject;
                    c00321d.A0C(c0362Ec2, interfaceC00481t2, jSONObject, interfaceC0422Gl2, null, enumSet2, i);
                    return;
                case 14:
                    e = e;
                    Log.e(C00321d.class.toString(), I4.A02(4L), e);
                    c = 15;
                case 15:
                    interfaceC00481t2.A6p(c00321d, AdError.INTERNAL_ERROR);
                    return;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.C1F
    public final String A4V() {
        return this.A04;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0064, code lost:            return r3;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC00301b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Bundle getSaveInstanceState() {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            com.facebook.ads.redexgen.X.Q9 r0 = r4.A03
            if (r0 == 0) goto L60
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto L28;
                case 3: goto L1e;
                case 4: goto Lb;
                case 5: goto L1b;
                case 6: goto L62;
                case 7: goto L32;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.1d r4 = (com.facebook.ads.redexgen.X.C00321d) r4
            com.facebook.ads.redexgen.X.Lb r0 = r4.A02
            com.facebook.ads.redexgen.X.FR r1 = r0.getState()
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A04
            if (r1 != r0) goto L19
            r0 = 5
            goto L7
        L19:
            r0 = 7
            goto L7
        L1b:
            r3 = 0
            r0 = 6
            goto L7
        L1e:
            com.facebook.ads.redexgen.X.1d r4 = (com.facebook.ads.redexgen.X.C00321d) r4
            com.facebook.ads.redexgen.X.Lb r0 = r4.A02
            if (r0 == 0) goto L26
            r0 = 4
            goto L7
        L26:
            r0 = 5
            goto L7
        L28:
            com.facebook.ads.redexgen.X.1d r4 = (com.facebook.ads.redexgen.X.C00321d) r4
            org.json.JSONObject r0 = r4.A06
            if (r0 == 0) goto L30
            r0 = 3
            goto L7
        L30:
            r0 = 5
            goto L7
        L32:
            com.facebook.ads.redexgen.X.1d r4 = (com.facebook.ads.redexgen.X.C00321d) r4
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            r2 = 87
            r1 = 6
            r0 = 106(0x6a, float:1.49E-43)
            java.lang.String r1 = A06(r2, r1, r0)
            com.facebook.ads.redexgen.X.Q9 r0 = r4.A03
            android.os.Bundle r0 = r0.getSaveInstanceState()
            r3.putBundle(r1, r0)
            r2 = 68
            r1 = 11
            r0 = 55
            java.lang.String r1 = A06(r2, r1, r0)
            org.json.JSONObject r0 = r4.A06
            java.lang.String r0 = r0.toString()
            r3.putString(r1, r0)
            r0 = 6
            goto L7
        L60:
            r0 = 5
            goto L7
        L62:
            android.os.Bundle r3 = (android.os.Bundle) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00321d.getSaveInstanceState():android.os.Bundle");
    }

    @Override // com.facebook.ads.redexgen.X.C1F
    public final void onDestroy() {
        if (this.A02 != null) {
            this.A02.A0N();
            this.A02.A0K();
        }
        this.A00 = null;
        this.A0A = null;
        this.A05 = null;
        this.A07 = false;
        this.A04 = null;
        this.A02 = null;
        this.A03 = null;
        this.A06 = null;
        this.A09 = null;
        this.A08 = false;
    }
}
