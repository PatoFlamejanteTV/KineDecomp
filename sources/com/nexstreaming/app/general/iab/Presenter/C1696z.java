package com.nexstreaming.app.general.iab.Presenter;

import com.nexstreaming.app.general.iab.Purchase;
import java.util.Comparator;
import java.util.Date;

/* compiled from: IABWxPresent.kt */
/* renamed from: com.nexstreaming.app.general.iab.Presenter.z */
/* loaded from: classes2.dex */
final class C1696z<T> implements Comparator<Purchase> {

    /* renamed from: a */
    public static final C1696z f19415a = new C1696z();

    C1696z() {
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public final int compare(Purchase purchase, Purchase purchase2) {
        kotlin.jvm.internal.h.a((Object) purchase, "lhs");
        Date g2 = purchase.g();
        kotlin.jvm.internal.h.a((Object) g2, "lhs.purchaseTime");
        long time = g2.getTime();
        kotlin.jvm.internal.h.a((Object) purchase2, "rhs");
        Date g3 = purchase2.g();
        kotlin.jvm.internal.h.a((Object) g3, "rhs.purchaseTime");
        if (time > g3.getTime()) {
            return -1;
        }
        Date g4 = purchase.g();
        kotlin.jvm.internal.h.a((Object) g4, "lhs.purchaseTime");
        long time2 = g4.getTime();
        Date g5 = purchase2.g();
        kotlin.jvm.internal.h.a((Object) g5, "rhs.purchaseTime");
        return time2 > g5.getTime() ? 1 : 0;
    }
}
