package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.Nc, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class ViewOnClickListenerC0589Nc extends C0588Nb implements View.OnClickListener {

    @Nullable
    public String A00;

    @Nullable
    public String A01;
    public final C0587Na A02;
    public final Map<String, String> A03;

    public ViewOnClickListenerC0589Nc(C0362Ec c0362Ec, String str, C2T c2t, InterfaceC0422Gl interfaceC0422Gl, AnonymousClass81 anonymousClass81, FP fp, K5 k5) {
        super(c0362Ec, c2t);
        this.A03 = new HashMap();
        this.A02 = new C0587Na(c0362Ec, str, fp, k5, interfaceC0422Gl, anonymousClass81);
        setOnClickListener(this);
        KE.A0I(1001, this);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            if (TextUtils.isEmpty(this.A00) || TextUtils.isEmpty(this.A01)) {
                return;
            }
            this.A02.A08(this.A00, this.A01, this.A03);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }

    public void setCta(C2U c2u, String str, Map<String, String> map) {
        setCta(c2u, str, map, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0045, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setCta(com.facebook.ads.redexgen.X.C2U r4, java.lang.String r5, java.util.Map<java.lang.String, java.lang.String> r6, @android.support.annotation.Nullable com.facebook.ads.redexgen.X.NZ r7) {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            r2.A00 = r5
            java.lang.String r0 = r4.A04()
            r2.A01 = r0
            java.util.Map<java.lang.String, java.lang.String> r0 = r2.A03
            r0.putAll(r6)
            com.facebook.ads.redexgen.X.Na r0 = r2.A02
            r0.A07(r7)
            java.lang.String r1 = r4.A03()
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 != 0) goto L43
            r0 = 2
        L1f:
            switch(r0) {
                case 2: goto L23;
                case 3: goto L31;
                case 4: goto L45;
                case 5: goto L3a;
                default: goto L22;
            }
        L22:
            goto L1f
        L23:
            com.facebook.ads.redexgen.X.Nc r2 = (com.facebook.ads.redexgen.X.ViewOnClickListenerC0589Nc) r2
            java.lang.String r0 = r2.A01
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L2f
            r0 = 3
            goto L1f
        L2f:
            r0 = 5
            goto L1f
        L31:
            com.facebook.ads.redexgen.X.Nc r2 = (com.facebook.ads.redexgen.X.ViewOnClickListenerC0589Nc) r2
            r0 = 8
            r2.setVisibility(r0)
            r0 = 4
            goto L1f
        L3a:
            com.facebook.ads.redexgen.X.Nc r2 = (com.facebook.ads.redexgen.X.ViewOnClickListenerC0589Nc) r2
            java.lang.String r1 = (java.lang.String) r1
            r2.setText(r1)
            r0 = 4
            goto L1f
        L43:
            r0 = 3
            goto L1f
        L45:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ViewOnClickListenerC0589Nc.setCta(com.facebook.ads.redexgen.X.2U, java.lang.String, java.util.Map, com.facebook.ads.redexgen.X.NZ):void");
    }

    public void setIsInAppBrowser(boolean z) {
        this.A02.A09(z);
    }
}
