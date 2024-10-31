package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Km, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC0522Km implements View.OnClickListener {
    public final /* synthetic */ C00572c A00;
    public final /* synthetic */ C0432Gv A01;
    public final /* synthetic */ C0523Kn A02;
    public final /* synthetic */ AnonymousClass81 A03;
    public final /* synthetic */ String A04;

    public ViewOnClickListenerC0522Km(C0523Kn c0523Kn, C0432Gv c0432Gv, AnonymousClass81 anonymousClass81, String str, C00572c c00572c) {
        this.A02 = c0523Kn;
        this.A01 = c0432Gv;
        this.A03 = anonymousClass81;
        this.A04 = str;
        this.A00 = c00572c;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C0362Ec c0362Ec;
        C0362Ec c0362Ec2;
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            this.A01.A02(EnumC0431Gu.A09, null);
            c0362Ec = this.A02.A02;
            if (AnonymousClass43.A0P(c0362Ec.A00(), true)) {
                this.A03.A5I(this.A04, this.A00);
            } else if (!TextUtils.isEmpty(this.A00.A00())) {
                JM jm = new JM();
                c0362Ec2 = this.A02.A02;
                JM.A08(jm, c0362Ec2, Uri.parse(this.A00.A00()), this.A04);
            }
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }
}
