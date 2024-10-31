package com.nexstreaming.app.general.iab.Utils;

import android.content.Context;
import c.d.b.m.i;
import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.app.general.iab.PurchaseType;
import com.nexstreaming.app.general.iab.SKUDetails;
import kotlin.jvm.internal.h;
import kotlin.text.v;
import kotlin.text.w;

/* compiled from: IABCommonFun.kt */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f19425a = "IABCommonFun";

    /* JADX WARN: Removed duplicated region for block: B:59:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int e(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.app.general.iab.Utils.a.e(java.lang.String):int");
    }

    private final boolean f(String str) {
        boolean b2;
        if (str == null) {
            return false;
        }
        for (String str2 : IABConstant.o.n()) {
            b2 = v.b(str, str2, false, 2, null);
            if (b2) {
                return true;
            }
        }
        return false;
    }

    public final PurchaseType a(String str) {
        boolean a2;
        boolean a3;
        boolean a4;
        boolean a5;
        PurchaseType purchaseType = PurchaseType.None;
        if (str == null) {
            return purchaseType;
        }
        PurchaseType purchaseType2 = purchaseType;
        for (String str2 : IABConstant.o.g()) {
            a5 = w.a((CharSequence) str, (CharSequence) str2, false, 2, (Object) null);
            if (a5) {
                purchaseType2 = PurchaseType.OneTimeValid;
            } else {
                purchaseType2 = PurchaseType.SubUnknown;
            }
        }
        for (String str3 : IABConstant.o.n()) {
            a2 = w.a((CharSequence) str, (CharSequence) str3, false, 2, (Object) null);
            if (a2) {
                a3 = w.a((CharSequence) str, (CharSequence) IABConstant.o.m(), false, 2, (Object) null);
                if (a3) {
                    purchaseType2 = PurchaseType.SubMonthly;
                } else {
                    a4 = w.a((CharSequence) str, (CharSequence) IABConstant.o.l(), false, 2, (Object) null);
                    if (a4) {
                        purchaseType2 = PurchaseType.SubAnnual;
                    } else {
                        purchaseType2 = PurchaseType.SubUnknown;
                    }
                }
            }
        }
        return purchaseType2;
    }

    public final boolean b(String str) {
        boolean a2;
        if (str == null) {
            return false;
        }
        for (String str2 : IABConstant.o.e()) {
            a2 = w.a((CharSequence) str, (CharSequence) str2, false, 2, (Object) null);
            if (a2) {
                return true;
            }
        }
        return false;
    }

    public final boolean c(String str) {
        boolean a2;
        if (str == null) {
            return false;
        }
        for (String str2 : IABConstant.o.g()) {
            a2 = w.a((CharSequence) str, (CharSequence) str2, false, 2, (Object) null);
            if (a2) {
                return true;
            }
        }
        return false;
    }

    public final boolean d(String str) {
        boolean a2;
        if (str == null) {
            return false;
        }
        for (String str2 : IABConstant.o.n()) {
            a2 = w.a((CharSequence) str, (CharSequence) str2, false, 2, (Object) null);
            if (a2) {
                return true;
            }
        }
        return false;
    }

    public final boolean b(SKUDetails sKUDetails) {
        return sKUDetails != null && f(sKUDetails.g());
    }

    public final boolean c(SKUDetails sKUDetails) {
        boolean b2;
        boolean a2;
        if (b(sKUDetails)) {
            for (String str : IABConstant.o.n()) {
                if (sKUDetails != null) {
                    String g2 = sKUDetails.g();
                    h.a((Object) g2, "skuDetails!!.productId");
                    b2 = v.b(g2, str, false, 2, null);
                    if (b2) {
                        String g3 = sKUDetails.g();
                        h.a((Object) g3, "skuDetails.productId");
                        a2 = w.a((CharSequence) g3, (CharSequence) IABConstant.o.l(), false, 2, (Object) null);
                        if (a2) {
                            return true;
                        }
                    }
                } else {
                    h.a();
                    throw null;
                }
            }
        }
        return false;
    }

    public final boolean d(SKUDetails sKUDetails) {
        boolean b2;
        boolean a2;
        if (b(sKUDetails)) {
            for (String str : IABConstant.o.n()) {
                if (sKUDetails != null) {
                    String g2 = sKUDetails.g();
                    h.a((Object) g2, "skuDetails!!.productId");
                    b2 = v.b(g2, str, false, 2, null);
                    if (b2) {
                        String g3 = sKUDetails.g();
                        h.a((Object) g3, "skuDetails.productId");
                        a2 = w.a((CharSequence) g3, (CharSequence) IABConstant.o.m(), false, 2, (Object) null);
                        if (a2) {
                            return true;
                        }
                    }
                } else {
                    h.a();
                    throw null;
                }
            }
        }
        return false;
    }

    public final boolean b(Purchase purchase) {
        return purchase != null && f(purchase.d());
    }

    public final boolean c(Purchase purchase) {
        boolean b2;
        boolean a2;
        h.b(purchase, "purchase");
        if (b(purchase)) {
            for (String str : IABConstant.o.n()) {
                String d2 = purchase.d();
                h.a((Object) d2, "purchase.productId");
                b2 = v.b(d2, str, false, 2, null);
                if (b2) {
                    String d3 = purchase.d();
                    h.a((Object) d3, "purchase.productId");
                    a2 = w.a((CharSequence) d3, (CharSequence) IABConstant.o.l(), false, 2, (Object) null);
                    if (a2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean d(Purchase purchase) {
        boolean b2;
        boolean a2;
        h.b(purchase, "purchase");
        if (b(purchase)) {
            for (String str : IABConstant.o.n()) {
                String d2 = purchase.d();
                h.a((Object) d2, "purchase.productId");
                b2 = v.b(d2, str, false, 2, null);
                if (b2) {
                    String d3 = purchase.d();
                    h.a((Object) d3, "purchase.productId");
                    a2 = w.a((CharSequence) d3, (CharSequence) IABConstant.o.m(), false, 2, (Object) null);
                    if (a2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final long a(Context context) {
        h.b(context, "ctx");
        return i.b(context);
    }

    public final int a(SKUDetails sKUDetails) {
        if (sKUDetails != null) {
            return e(sKUDetails.g());
        }
        return 0;
    }

    public final int a(Purchase purchase) {
        if (purchase != null) {
            return e(purchase.d());
        }
        return 0;
    }
}
