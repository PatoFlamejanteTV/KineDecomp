package com.facebook.ads.redexgen.X;

import android.view.View;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;

/* renamed from: com.facebook.ads.redexgen.X.82, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class AnonymousClass82 implements AnonymousClass81 {
    public final WeakReference<AnonymousClass89> A00;

    public AnonymousClass82(AnonymousClass89 anonymousClass89) {
        this.A00 = new WeakReference<>(anonymousClass89);
    }

    public /* synthetic */ AnonymousClass82(AnonymousClass89 anonymousClass89, AnonymousClass80 anonymousClass80) {
        this(anonymousClass89);
    }

    private void A00(AnonymousClass89 anonymousClass89) {
        PU pu;
        RelativeLayout relativeLayout;
        pu = anonymousClass89.A0C;
        if (pu == null) {
            return;
        }
        relativeLayout = anonymousClass89.A06;
        relativeLayout.bringChildToFront(pu);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass81
    public final void A38(View view, int i, RelativeLayout.LayoutParams layoutParams) {
        RelativeLayout relativeLayout;
        AnonymousClass89 anonymousClass89 = this.A00.get();
        if (anonymousClass89 == null) {
            return;
        }
        relativeLayout = anonymousClass89.A06;
        relativeLayout.addView(view, i, layoutParams);
        A00(anonymousClass89);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass81
    public final void A39(View view, RelativeLayout.LayoutParams layoutParams) {
        RelativeLayout relativeLayout;
        AnonymousClass89 anonymousClass89 = this.A00.get();
        if (anonymousClass89 == null) {
            return;
        }
        relativeLayout = anonymousClass89.A06;
        relativeLayout.addView(view, layoutParams);
        A00(anonymousClass89);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass81
    public void A3b(String str) {
        if (this.A00.get() == null) {
            return;
        }
        this.A00.get().A0D(str);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass81
    public void A3c(String str, GX gx) {
        if (this.A00.get() == null) {
            return;
        }
        this.A00.get().A0F(str, gx);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass81
    public final void A5I(String str, C00572c c00572c) {
        if (this.A00.get() == null) {
            return;
        }
        this.A00.get().A0E(str, c00572c);
    }
}
