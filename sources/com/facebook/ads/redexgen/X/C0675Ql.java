package com.facebook.ads.redexgen.X;

import android.os.Handler;

/* renamed from: com.facebook.ads.redexgen.X.Ql, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0675Ql extends AbstractC02198o {
    public final /* synthetic */ C0682Qs A00;

    public C0675Ql(C0682Qs c0682Qs) {
        this.A00 = c0682Qs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C1S
    /* renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(QQ qq) {
        Handler handler;
        boolean A0D;
        handler = this.A00.A05;
        handler.removeCallbacksAndMessages(null);
        A0D = this.A00.A0D(EnumC0459Hy.A04);
        if (A0D) {
            this.A00.A03();
            this.A00.A06(true, false);
        }
        this.A00.A03 = true;
    }
}
