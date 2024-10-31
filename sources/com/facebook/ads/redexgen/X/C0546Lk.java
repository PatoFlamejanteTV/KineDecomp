package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Lk, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0546Lk implements JV {
    public static final /* synthetic */ boolean A01;
    public final /* synthetic */ C0549Ln A00;

    static {
        A01 = !C0549Ln.class.desiredAssertionStatus();
    }

    public C0546Lk(C0549Ln c0549Ln) {
        this.A00 = c0549Ln;
    }

    public /* synthetic */ C0546Lk(C0549Ln c0549Ln, C0541Lf c0541Lf) {
        this(c0549Ln);
    }

    @Override // com.facebook.ads.redexgen.X.JV
    public final void A6O() {
        C0588Nb c0588Nb;
        this.A00.A0F();
        this.A00.A0I.setToolbarActionMode(0);
        KE.A0V(this.A00, 500);
        c0588Nb = this.A00.A02;
        KE.A0Q(c0588Nb, 0);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0006. Please report as an issue. */
    @Override // com.facebook.ads.redexgen.X.JV
    public final void A7K(float f) {
        C00592e c00592e;
        C00592e c00592e2;
        C0546Lk c0546Lk = this;
        char c = !A01 ? (char) 2 : (char) 4;
        while (true) {
            switch (c) {
                case 2:
                    c0546Lk = c0546Lk;
                    c00592e2 = c0546Lk.A00.A07;
                    c = c00592e2 == null ? (char) 3 : (char) 4;
                case 3:
                    throw new AssertionError();
                case 4:
                    C0546Lk c0546Lk2 = c0546Lk;
                    c00592e = c0546Lk2.A00.A07;
                    c0546Lk2.A00.A0I.setProgress(100.0f * (1.0f - (f / c00592e.A07())));
                    c0546Lk2.A00.A0K((int) f);
                    return;
            }
        }
    }
}
