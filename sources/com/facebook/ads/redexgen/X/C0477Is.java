package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Is, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0477Is {
    public static final ThreadLocal<C0477Is> A01 = new ThreadLocal<>();
    public final C0463Id A00 = new C0463Id();

    public static C0463Id A00() {
        return A02().A00;
    }

    public static C0463Id A01(C0476Ir c0476Ir) {
        C0463Id c0463Id = new C0463Id(A00());
        c0463Id.add(c0476Ir);
        return c0463Id;
    }

    public static C0477Is A02() {
        C0477Is c0477Is = A01.get();
        if (c0477Is == null) {
            C0477Is c0477Is2 = new C0477Is();
            A01.set(c0477Is2);
            return c0477Is2;
        }
        return c0477Is;
    }

    public static void A03(AbstractRunnableC00351g abstractRunnableC00351g) {
        C0463Id createRunnableAsyncStackTrace = abstractRunnableC00351g.A04();
        if (createRunnableAsyncStackTrace != null) {
            A02().A00.addAll(createRunnableAsyncStackTrace);
        }
    }

    public static void A04(AbstractRunnableC00351g abstractRunnableC00351g) {
        C0463Id createRunnableAsyncStackTrace = abstractRunnableC00351g.A04();
        if (createRunnableAsyncStackTrace != null) {
            A02().A00.removeAll(createRunnableAsyncStackTrace);
        }
    }
}
